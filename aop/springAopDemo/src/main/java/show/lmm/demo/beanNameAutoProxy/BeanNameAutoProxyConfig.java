package show.lmm.demo.beanNameAutoProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean名称代理配置
 *
 * @author lmm
 * @date 2022-03-23
 */
@Configuration
@ComponentScan("show.lmm.demo.beanNameAutoProxy")
public class BeanNameAutoProxyConfig {

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

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("user*");
        beanNameAutoProxyCreator.setInterceptorNames("beforeAdvice");
        return beanNameAutoProxyCreator;
    }
}
