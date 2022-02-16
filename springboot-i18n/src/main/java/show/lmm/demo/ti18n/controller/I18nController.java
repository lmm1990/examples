package show.lmm.demo.ti18n.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import show.lmm.demo.ti18n.core.ServiceException;
import show.lmm.demo.ti18n.utils.MessageUtils;

/**
 * 国际化i18n
 *
 * @author 刘明明
 * @date 2022-02-16 17:32:21
 */
@RestController
@RequestMapping("/i18n/")
public class I18nController {

    /**
     * 国际化测试
     *
     * @return java.lang.String
     * @since 刘明明/2022-02-16 17:32:48
     **/
    @RequestMapping(value = "/message")
    public String message() {
        return MessageUtils.get("service.i18nDemo", new Object[]{"哈哈哈"});
    }

    /**
     * 国际化测试
     *
     * @return java.lang.String
     * @since 刘明明/2022-02-16 17:32:48
     **/
    @RequestMapping(value = "/throw_execption")
    public String throwExecption() {
        if(true){
            throw new ServiceException("{service.customExecption}","测试参数");
        }
        return "ok";
    }
}
