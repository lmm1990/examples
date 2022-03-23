package show.lmm.demo.proxyFactoryBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ProxyFactoryBean配置
 *
 * @author lmm
 * @date 2022-03-23
 */
@Configuration
public class ProxyFactoryBeanConfig {

    /**
     * 方法执行前执行
     * @return
     */
    @Bean
    public MethodInterceptor beforeAdvice(){
        return new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("before");
                return invocation.proceed();
            }
        };
    }

    /**
     * 用户service代理对象
     * @return
     */
    @Bean
    public ProxyFactoryBean userServiceProxy(){
        UserService userService = new UserService();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(userService);
        proxyFactoryBean.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object value = invocation.proceed();
                System.out.println("after");
                return value;
            }
        });
        proxyFactoryBean.setInterceptorNames("beforeAdvice");
        return proxyFactoryBean;
    }
}
