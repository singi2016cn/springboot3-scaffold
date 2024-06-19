package top.singi.springboot3_scaffold.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.singi.springboot3_scaffold.dto.TokenDTO;

import java.util.Date;
import javax.crypto.SecretKey;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    // 生成 JWT token
    public TokenDTO generateToken(String subject) {
        Date expireDate = new Date(new Date().getTime() + jwtExpirationDate);
        var token = Jwts.builder()
                .subject(subject)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact();

        return TokenDTO.of(token, expireDate);
    }

    private SecretKey key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret));
    }

    // 从 Jwt token 获取用户名
    public String getUsername(String token) {
        return Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // 验证 Jwt token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}