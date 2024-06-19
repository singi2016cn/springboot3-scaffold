package top.singi.springboot3_scaffold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@AllArgsConstructor
@Data
public class ResultDTO {
    Integer code;
    String msg;
    Object data;

    public static ResultDTO success() {
        return success(null);
    }

    public static ResultDTO success(Object data) {
        return new ResultDTO(HttpStatus.OK.value(), HttpStatus.OK.name(), data);
    }

    public static ResultDTO fail(Optional<String> msg) {
        return new ResultDTO(HttpStatus.BAD_REQUEST.value(), msg.orElse(HttpStatus.BAD_REQUEST.getReasonPhrase()), null);
    }

    public static ResultDTO fail401(Optional<String> msg) {
        return new ResultDTO(HttpStatus.UNAUTHORIZED.value(), msg.orElse(HttpStatus.UNAUTHORIZED.getReasonPhrase()), null);
    }

    public static ResultDTO fail500(Optional<String> msg) {
        return new ResultDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg.orElse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()), null);
    }
}
