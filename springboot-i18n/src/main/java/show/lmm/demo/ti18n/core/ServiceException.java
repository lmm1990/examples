package show.lmm.demo.ti18n.core;

import org.springframework.context.MessageSource;
import show.lmm.demo.ti18n.utils.MessageUtils;

/**
 * 自定义异常
 *
 * @author 刘明明
 * @since 2022-02-16 17:47
 */
public class ServiceException extends RuntimeException {

    private int code;
    private String message;
    private static final String MESSAGE_START_WITH = "{";
    private static final String MESSAGE_END_WITH = "}";
    private static MessageUtils messageUtils;

    /**
     * 初始化国际化配置
     *
     * @param messageSource: 国际化消息
     * @since 刘明明/2022-02-16 17:48:57
     **/
    public static void initI18n(MessageSource messageSource) {
        messageUtils = new MessageUtils(messageSource);
    }

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = parseMessage(message);
    }

    public ServiceException(String message, Object... args) {
        this.code = 502;
        this.message = parseMessage(message, args);
    }

    /**
     * 格式化消息
     *
     * @param message: 消息
     * @param args:    参数
     * @return java.lang.String
     * @modify 刘明明/2021-11-23 17:34:04
     **/
    private String parseMessage(final String message, Object... args) {
        if (message.startsWith(MESSAGE_START_WITH) && message.endsWith(MESSAGE_END_WITH)) {
            final String msgKey = message.substring(1, message.length() - 1);
            return messageUtils.get(msgKey, args);
        }
        return String.format(message, args);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
