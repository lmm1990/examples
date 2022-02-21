package show.lmm.validation;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常
 */
@RestControllerAdvice
public class GlobalExecption {

    /**
     * 参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return allErrors.stream().map(s -> s.getDefaultMessage()).collect(Collectors.joining("\r\n"));
    }
}
