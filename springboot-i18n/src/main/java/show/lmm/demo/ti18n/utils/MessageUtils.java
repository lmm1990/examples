package show.lmm.demo.ti18n.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化工具类
 *
 * @author 刘明明
 * @since 2022-02-16 17:30:46
 */
@Component
public class MessageUtils {

    private static MessageSource messageSource;

    public MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    /**
     * 获取单个国际化翻译值
     *
     * @param msgKey: 键
     * @param args:   参数
     * @return java.lang.String
     * @since 刘明明/2022-02-16 17:31:03
     **/
    public static String get(String msgKey, Object[] args) {
        try {
            return messageSource.getMessage(msgKey, args, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            e.printStackTrace();
            return msgKey;
        }
    }
}
