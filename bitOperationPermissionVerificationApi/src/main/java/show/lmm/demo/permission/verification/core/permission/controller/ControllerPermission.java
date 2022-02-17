package show.lmm.demo.permission.verification.core.permission.controller;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * 注解：控制器权限
 * @author 刘明明
 * @since 2022-02-17 10:36:44
 */
@RestController
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerPermission {

    /**
     * 菜单id
     */
    int value();
}
