package show.lmm.demo.defaultAdvisorAutoProxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 默认Advisor自动代理测试
 *
 * @author lmm
 * @date 2022-03-23
 */
public class DefaultAdvisorAutoProxyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DefaultAdvisorAutoProxyConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();
        System.out.println("------------------------");
        userService.run();
    }
}
