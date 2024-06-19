package top.singi.springboot3_scaffold.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.singi.springboot3_scaffold.dto.TokenDTO;

@SpringBootTest
class JwtTokenProviderTest {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    void generateToken() {

    }

    @Test
    void getUsername() {
        TokenDTO tokenDto = jwtTokenProvider.generateToken("1");
        System.out.println("tokenDto = " + tokenDto);
        System.out.println(jwtTokenProvider.getUsername(tokenDto.getToken()));
    }

    @Test
    void validateToken() {
    }
}