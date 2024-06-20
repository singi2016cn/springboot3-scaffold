package top.singi.springboot3_scaffold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

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
        return success(HttpStatus.OK.value(), HttpStatus.OK.name(), data);
    }

    public static ResultDTO success(Integer code, String msg, Object data) {
        return new ResultDTO(code, msg, data);
    }

    public static ResultDTO fail(Integer code, String msg, Object data) {
        return new ResultDTO(code, msg, data);
    }

    public static ResultDTO fail(Integer code, String msg) {
        return fail(code, msg, null);
    }

    public static ResultDTO fail(String msg) {
        return fail(HttpStatus.BAD_REQUEST.value(), msg, null);
    }

    public static ResultDTO fail400(String msg) {
        return fail(HttpStatus.BAD_REQUEST.value(), msg, null);
    }

    public static ResultDTO fail401(String msg) {
        return fail(HttpStatus.UNAUTHORIZED.value(), msg, null);
    }

    public static ResultDTO fail500(String msg) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }
}
