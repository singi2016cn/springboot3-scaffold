package top.singi.springboot3_scaffold.exceptionHandle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import top.singi.springboot3_scaffold.dto.ResultDTO;
import top.singi.springboot3_scaffold.exception.CustomException;

import java.util.Optional;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 基本异常
     */
    @ExceptionHandler(Exception.class)
    public ResultDTO handleException(Exception e) {
        return ResultDTO.fail500(e.getMessage());
    }

    /**
     * 权鉴和授权异常
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResultDTO handleAuthenticationException(AuthenticationException e) {
        return ResultDTO.fail401("权鉴失败");
    }

    /**
     * 请求参数验证异常
     */
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResultDTO handleValidationException(HandlerMethodValidationException e) {
        return ResultDTO.fail400(Optional.of(e.getMessage()).orElse("请求参数错误"));
    }

    /**
     * 请求参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultDTO handleValidationException(MethodArgumentNotValidException e) {
        return ResultDTO.fail400(Optional.ofNullable(e.getAllErrors().get(0).getDefaultMessage()).orElse("请求参数错误"));
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public ResultDTO handleCustomException(CustomException e) {
        return ResultDTO.fail(
                Optional.of(e.getCode()).orElse(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                Optional.of(e.getMessage()).orElse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
        );
    }
}
