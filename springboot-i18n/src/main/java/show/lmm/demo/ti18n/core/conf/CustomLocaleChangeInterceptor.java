package show.lmm.demo.ti18n.core.conf;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义国际化拦截器
 * @author 刘明明
 * @since  2022-02-16 17:29:05
 */
public class CustomLocaleChangeInterceptor implements HandlerInterceptor {

    /**
     * 语言默认参数名
     */
    public static final String DEFAULT_PARAM_NAME = "locale";

    private String paramName = DEFAULT_PARAM_NAME;

    @Nullable
    private String[] httpMethods;

    private boolean ignoreInvalidLocale = false;

    /**
     * 设置语言参数名
     *
     * @param paramName: 参数名
     **/
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * 获得语言参数名
     *
     * @return java.lang.String
     **/
    public String getParamName() {
        return this.paramName;
    }

    /**
     * 设置支持的请求方法
     *
     * @param httpMethods: 请求方法列表
     **/
    public void setHttpMethods(@Nullable String... httpMethods) {
        this.httpMethods = httpMethods;
    }

    /**
     * 获得支持的请求方法
     *
     * @return java.lang.String[]
     **/
    @Nullable
    public String[] getHttpMethods() {
        return this.httpMethods;
    }

    /**
     * 设置是否忽略无效语言
     *
     * @param ignoreInvalidLocale: 是否忽略无效语言
     **/
    public void setIgnoreInvalidLocale(boolean ignoreInvalidLocale) {
        this.ignoreInvalidLocale = ignoreInvalidLocale;
    }

    /**
     * 获得是否忽略无效语言
     *
     * @return boolean
     **/
    public boolean isIgnoreInvalidLocale() {
        return this.ignoreInvalidLocale;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!checkHttpMethod(request.getMethod())) {
            return true;
        }
        String newLocale = request.getParameter(getParamName());
        if (newLocale == null) {
            setLocale(request, response, request.getLocale());
            return true;
        }
        setLocale(request, response, StringUtils.parseLocale(newLocale));
        // Proceed in any case.
        return true;
    }

    /**
     * 设置语言
     *
     * @param request: 请求对象
     * @param response: 返回对象
     * @param locale:  语言
     * @modify 刘明明/2021-11-22 10:31:25
     **/
    private void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException(
                    "No LocaleResolver found: not in a DispatcherServlet request?");
        }
        try {
            localeResolver.setLocale(request, response, locale);
        } catch (IllegalArgumentException ex) {
            if (isIgnoreInvalidLocale()) {
                System.out.println("Ignoring invalid locale value [" + locale.toString() + "]: " + ex.getMessage());
            } else {
                throw ex;
            }
        }
    }

    /**
     * 检查http请求
     *
     * @param currentMethod:当前请求
     * @return boolean
     * @modify 刘明明/2021-11-22 10:31:57
     **/
    private boolean checkHttpMethod(String currentMethod) {
        String[] configuredMethods = getHttpMethods();
        if (ObjectUtils.isEmpty(configuredMethods)) {
            return true;
        }
        for (String configuredMethod : configuredMethods) {
            if (configuredMethod.equalsIgnoreCase(currentMethod)) {
                return true;
            }
        }
        return false;
    }
}
