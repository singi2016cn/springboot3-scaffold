package top.singi.springboot3_scaffold.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.singi.springboot3_scaffold.enums.CustomExceptionEnum;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomException extends RuntimeException {
    Integer code;
    String message;

    public CustomException(CustomExceptionEnum cee) {
        code = cee.getCode();
        message = cee.getMessage();
    }
}
