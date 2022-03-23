package show.lmm.demo.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 测试Introduction
 *
 * @author lmm
 * @date 2022-03-23
 */
@SpringBootApplication
public class IntroductionTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IntroductionTest.class, args);
        ExtendInterface extendInterface = context.getBean("userService", ExtendInterface.class);
        UserService userService = context.getBean("userService", UserService.class);
        extendInterface.run();
        userService.test();
    }
}
