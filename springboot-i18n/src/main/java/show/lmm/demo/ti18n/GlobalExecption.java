package show.lmm.demo.ti18n;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import show.lmm.demo.ti18n.core.ServiceException;

/**
 * 全局异常
 *
 * @since 刘明明/2022-02-16 17:50:09
 **/
@RestControllerAdvice
public class GlobalExecption {

    /**
     * 请求方式异常
     */
    @ExceptionHandler({ServiceException.class})
    public String exception(ServiceException exception) {
        exception.printStackTrace();
        return String.format("错误码：%d，错误内容：%s",exception.getCode(),exception.getMessage());
    }
}
