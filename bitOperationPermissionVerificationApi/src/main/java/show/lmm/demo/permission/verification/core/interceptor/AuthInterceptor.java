package show.lmm.demo.permission.verification.core.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import show.lmm.demo.permission.verification.core.DataHandler;
import show.lmm.demo.permission.verification.core.TokenProvider;
import show.lmm.demo.permission.verification.core.constant.AuthConstant;
import show.lmm.demo.permission.verification.core.model.PermissionEnum;
import show.lmm.demo.permission.verification.core.permission.NeedLogin;
import show.lmm.demo.permission.verification.core.permission.NotNeedLogin;
import show.lmm.demo.permission.verification.core.permission.controller.ActionPermission;
import show.lmm.demo.permission.verification.core.permission.controller.AddEditActionPermission;
import show.lmm.demo.permission.verification.core.permission.controller.ControllerPermission;
import show.lmm.demo.permission.verification.core.utils.AuthUtils;
import show.lmm.demo.permission.verification.core.utils.PermissionUtils;
import show.lmm.demo.permission.verification.core.utils.TypeConvertUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限拦截器
 *
 * @author 刘明明
 * @since 2022-02-17 11:27:10
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        TokenProvider.initAuthData(request);
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        response.setContentType("application/json; charset=utf-8");
        // 验证权限
        if (!this.hasPermission(request, response, handler)) {
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        DataHandler.authThreadLocal.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 验证权限
     */
    private boolean hasPermission(HttpServletRequest request, HttpServletResponse response, Object handler) throws RuntimeException {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        if(declaringClass.isAnnotationPresent(NotNeedLogin.class)){
            return true;
        }

        final long userId = DataHandler.getAuthUserId();
        // 如果注解为null, 说明不需要拦截, 直接放过
        if (userId < 1 && isNeedLogin(method)) {
            sendloginExpireMsg();
            return true;
        }
        //token自动续期
        response.addHeader(AuthConstant.AUTHORIZATION, TokenProvider.createToken(userId));

        ControllerPermission controllerPermission = declaringClass.getAnnotation(ControllerPermission.class);
        if (controllerPermission != null) {
            int pageInfoId = controllerPermission.value();
            return hasControllerPermission(pageInfoId, method, request);
        }
        return true;
    }

    /**
     * 是否需要登录
     *
     * @param method: 方法
     * @return boolean 是否需要登录
     **/
    private boolean isNeedLogin(Method method) {
        NeedLogin needLoginAnnotation = method.getAnnotation(NeedLogin.class);
        if (needLoginAnnotation != null) {
            return true;
        }
        ActionPermission actionPermission = method.getAnnotation(ActionPermission.class);
        if (actionPermission != null) {
            return true;
        }
        AddEditActionPermission addEditActionPermission = method.getAnnotation(AddEditActionPermission.class);
        return addEditActionPermission != null;
    }

    /**
     * 验证controller权限
     *
     * @param pageInfoId: 页面id
     * @param method:     action方法
     * @param request:    request请求对象
     * @return boolean
     **/
    private boolean hasControllerPermission(int pageInfoId, Method method, HttpServletRequest request) {
        // 获取方法上的注解
        ActionPermission actionPermission = method.getAnnotation(ActionPermission.class);
        if (actionPermission != null) {
            if (pageInfoId < 1) {
                throw new RuntimeException("无权限");
            }
            PermissionEnum permission = actionPermission.permissionType();
            //校验权限
            if (!hasPermission(pageInfoId, permission)) {
                throw new RuntimeException("无权限");
            }
            return true;
        }
        // 添加、修改方法注解
        AddEditActionPermission addEditActionPermission = method.getAnnotation(AddEditActionPermission.class);
        if (addEditActionPermission != null) {
            if (pageInfoId < 1) {
                throw new RuntimeException("无权限");
            }
            long primaryKey = TypeConvertUtils.toLong(request.getParameter(addEditActionPermission.fieldName()));
            PermissionEnum permission = primaryKey < 1 ? PermissionEnum.ADD : PermissionEnum.EDIT;
            //校验权限
            if (hasPermission(pageInfoId, permission)) {
                return true;
            }
            throw new RuntimeException("无权限");
        }
        return true;
    }

    /**
     * 验证是否有权限
     *
     * @param pageId:     页面id
     * @param permission: 权限类型id @see com.dataxgroup.nex.core.model.Permission
     * @return boolean
     **/
    public static boolean hasPermission(int pageId, PermissionEnum permission) {
        int pagePermissionValue = AuthUtils.getPagePermissionValue(pageId);
        if (pagePermissionValue < 1) {
            return false;
        }
        return PermissionUtils.hasPermission(pagePermissionValue, permission);
    }


    /**
     * 发送登录过期消息
     **/
    private void sendloginExpireMsg() {
        throw new RuntimeException("登录身份过期，请重新登录");
    }
}
