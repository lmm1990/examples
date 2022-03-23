package show.lmm.demo.defaultAdvisorAutoProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 默认Advisor自动代理配置
 *
 * @author lmm
 * @date 2022-03-23
 */
@Configuration
@ComponentScan("show.lmm.demo.defaultAdvisorAutoProxy")
public class DefaultAdvisorAutoProxyConfig {

    /**
     * 默认切点advisor
     *
     * @return
     */
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.addMethodName("test");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(nameMatchMethodPointcut);
        defaultPointcutAdvisor.setAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("before");
                return invocation.proceed();
            }
        });
        return defaultPointcutAdvisor;
    }

    /**
     * 默认Advisor自动代理
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
