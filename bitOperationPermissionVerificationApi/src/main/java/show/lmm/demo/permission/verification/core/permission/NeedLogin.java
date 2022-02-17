package show.lmm.demo.permission.verification.core.permission;

import java.lang.annotation.*;

/**
 * 注解：需要登录
 * @author 刘明明
 * @since 2022-02-17 10:35:31
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLogin {
}
