package show.lmm.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * 简单测试Advisor
 *
 * @author lmm
 * @date 2022-03-23
 */
public class SimpleAdvisorTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new UserService());
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return "test".equals(method.getName());
                    }
                };
            }

            @Override
            public Advice getAdvice() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        System.out.println("before");
                        return invocation.proceed();
                    }
                };
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });

        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
        System.out.println("------------------");
        userService.run();
    }
}
