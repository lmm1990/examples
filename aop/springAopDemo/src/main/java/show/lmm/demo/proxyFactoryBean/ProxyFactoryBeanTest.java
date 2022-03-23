package show.lmm.demo.proxyFactoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ProxyFactoryBean测试
 *
 * @author lmm
 * @date 2022-03-23
 */
public class ProxyFactoryBeanTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxyFactoryBeanConfig.class);
        UserService userService = context.getBean("userServiceProxy",UserService.class);
        userService.test();
    }
}
