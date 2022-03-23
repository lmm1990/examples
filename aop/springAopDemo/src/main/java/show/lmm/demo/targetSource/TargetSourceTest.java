package show.lmm.demo.targetSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试TargetSource
 *
 * @author lmm
 * @date 2022-03-23
 */
public class TargetSourceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TargetSourceConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();
    }
}
