package show.lmm.demo.permission.verification.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import show.lmm.demo.permission.verification.core.ResponseHandler;
import show.lmm.demo.permission.verification.core.permission.controller.ControllerPermission;
import show.lmm.demo.permission.verification.core.utils.AuthUtils;

/**
 * 拦截controller方法返回值，增加页面权限
 *
 * @author 刘明明
 * @since 2022-02-17 10:39:34
 */
@Component
@Aspect
public class ControllerPermissionAspectJAdvice {

    /**
     * action返回值，增加权限值
     *
     * @param point:       切点
     * @param returnValue: 返回值
     * @since 刘明明/2022-02-17 11:25:35
     **/
    @AfterReturning(pointcut = "execution(public * show.lmm.demo..*.*Controller.*(..))", returning = "returnValue")
    public void addControllerPermissionValue(JoinPoint point, Object returnValue) {
        ControllerPermission controllerPermission = point.getTarget().getClass().getAnnotation(ControllerPermission.class);
        if (returnValue instanceof ResponseHandler<?> responseData && controllerPermission != null) {
            int pageId = controllerPermission.value();
            if (pageId > 0) {
                int pagePermissionValue = AuthUtils.getPagePermissionValue(pageId);
                responseData.setPagePermissionValue(pagePermissionValue);
            }
        }
    }
}
