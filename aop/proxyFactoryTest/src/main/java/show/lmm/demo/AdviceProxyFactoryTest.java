package show.lmm.demo;

import org.springframework.aop.framework.ProxyFactory;
import show.lmm.demo.advice.CustomAfterReturningAdvice;
import show.lmm.demo.advice.CustomAfterThrowingAdvice;
import show.lmm.demo.advice.CustomAroundAdvice;
import show.lmm.demo.advice.CustomBeforeAdvice;

/**
 * 测试advice
 *
 * @author lmm
 * @date 2022-03-23
 */
public class AdviceProxyFactoryTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new UserService());
        proxyFactory.addAdvice(new CustomAroundAdvice());
        proxyFactory.addAdvice(new CustomBeforeAdvice());
        proxyFactory.addAdvice(new CustomAfterReturningAdvice());
        proxyFactory.addAdvice(new CustomAfterThrowingAdvice());
        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
        System.out.println("-----------------------");
        userService.testThrowing();
    }
}
