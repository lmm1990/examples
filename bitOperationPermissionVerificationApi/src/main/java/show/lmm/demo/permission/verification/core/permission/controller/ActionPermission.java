package show.lmm.demo.permission.verification.core.permission.controller;


import show.lmm.demo.permission.verification.core.model.PermissionEnum;
import show.lmm.demo.permission.verification.core.permission.NeedLogin;

import java.lang.annotation.*;

/**
 * 注解：方法权限
 * @author 刘明明
 * @since 2022-02-17 10:35:44
 */
@NeedLogin
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActionPermission {

    /**
     * 权限类型
     * */
    PermissionEnum permissionType();
}
