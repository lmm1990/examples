package show.lmm.demo.permission.verification.core.permission.controller;

import show.lmm.demo.permission.verification.core.permission.NeedLogin;

import java.lang.annotation.*;

/**
 * 注解：添加/修改方法权限
 *
 * @author 刘明明
 * @since 2022-02-17 10:36:17
 */
@NeedLogin
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddEditActionPermission {

    /**
     * 字段名称
     */
    String fieldName() default "id";
}
