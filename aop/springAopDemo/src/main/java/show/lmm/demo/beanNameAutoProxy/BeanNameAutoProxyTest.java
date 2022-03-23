package show.lmm.demo.beanNameAutoProxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean名称代理测试
 *
 * @author lmm
 * @date 2022-03-23
 */
public class BeanNameAutoProxyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanNameAutoProxyConfig.class);
        UserService userService = context.getBean("userService",UserService.class);
        userService.test();
    }
}
