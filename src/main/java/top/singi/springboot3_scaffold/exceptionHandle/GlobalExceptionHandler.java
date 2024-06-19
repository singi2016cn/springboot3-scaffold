package top.singi.springboot3_scaffold.exceptionHandle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.singi.springboot3_scaffold.dto.ResultDTO;
import top.singi.springboot3_scaffold.exception.DataNotFoundException;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public ResultDTO handleNullPointerException(Exception e) {
        return ResultDTO.fail500(Optional.of(e.getMessage()));
    }

    /**
     * 处理算术异常
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResultDTO handleArithmeticException(Exception e) {
        return ResultDTO.fail500(Optional.of(e.getMessage()));
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    public ResultDTO handleOtherException(Exception e) {
        log.error(Arrays.toString(e.getStackTrace()));
        return ResultDTO.fail500(Optional.of(e.getMessage()));
    }

    /*
    * 数据找不到
    * */
    @ExceptionHandler(DataNotFoundException.class)
    public ResultDTO handleDataNotFoundException(DataNotFoundException e) {
        return ResultDTO.fail500(Optional.of(e.getMassage()));
    }
}
