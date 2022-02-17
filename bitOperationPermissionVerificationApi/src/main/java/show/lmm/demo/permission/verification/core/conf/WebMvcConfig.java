package show.lmm.demo.permission.verification.core.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import show.lmm.demo.permission.verification.core.interceptor.AuthInterceptor;

/**
 * mvc配置
 *
 * @author 刘明明
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private AuthInterceptor authInterceptor;

    public WebMvcConfig(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器
        registry.addInterceptor(authInterceptor);
    }
}
