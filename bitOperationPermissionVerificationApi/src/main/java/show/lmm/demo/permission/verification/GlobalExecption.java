package show.lmm.demo.permission.verification;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import show.lmm.demo.permission.verification.core.ResponseHandler;

/**
 * 全局异常
 *
 * @author 刘明明
 */
@Log4j2
@RestControllerAdvice
public class GlobalExecption {

    /**
     * 请求方式异常
     */
    @ExceptionHandler({RuntimeException.class})
    public ResponseHandler<Boolean> exception(Exception exception) {
        exception.printStackTrace();
        return ResponseHandler.error(exception.getMessage());
    }
}
