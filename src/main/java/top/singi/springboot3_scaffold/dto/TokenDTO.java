package top.singi.springboot3_scaffold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.singi.springboot3_scaffold.util.Util;

import java.util.Date;

@AllArgsConstructor
@Data
public class TokenDTO {
    String token;
    String expired_at;

    public static TokenDTO of(String token, Date expiredAt) {
        return new TokenDTO(token, Util.datetime(expiredAt));
    }
}
