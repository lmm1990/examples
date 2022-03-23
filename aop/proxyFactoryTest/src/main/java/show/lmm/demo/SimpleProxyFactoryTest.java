package show.lmm.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * ProxyFactory测试类
 *
 * @author lmm
 * @date 2022-03-23
 */
public class SimpleProxyFactoryTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new UserService());
        proxyFactory.addAdvice((MethodInterceptor) invocation -> {
            System.out.println("before");
            Object value = invocation.proceed();
            System.out.println("after");
            return value;
        });

        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
    }
}
