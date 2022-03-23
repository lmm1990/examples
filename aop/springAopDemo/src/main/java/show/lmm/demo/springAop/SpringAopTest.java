package show.lmm.demo.springAop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * spring aop测试
 */
@SpringBootApplication
public class SpringAopTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAopTest.class, args);
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();
        System.out.println("------------------------");
        userService.run();
    }
}
