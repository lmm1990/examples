package show.lmm.demo.permission.verification.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import show.lmm.demo.permission.verification.core.ResponseHandler;
import show.lmm.demo.permission.verification.core.TokenProvider;
import show.lmm.demo.permission.verification.core.model.PermissionEnum;
import show.lmm.demo.permission.verification.core.model.view.request.AddEditUserInfoRequest;
import show.lmm.demo.permission.verification.core.model.view.request.GetUserInfoRequest;
import show.lmm.demo.permission.verification.core.model.view.request.UserLoginRequest;
import show.lmm.demo.permission.verification.core.model.view.response.GetUserInfoResponse;
import show.lmm.demo.permission.verification.core.model.view.response.UserLoginResponse;
import show.lmm.demo.permission.verification.core.permission.NotNeedLogin;
import show.lmm.demo.permission.verification.core.permission.controller.ActionPermission;
import show.lmm.demo.permission.verification.core.permission.controller.AddEditActionPermission;
import show.lmm.demo.permission.verification.core.permission.controller.ControllerPermission;

/**
 * 用户controller
 *
 * @author 刘明明
 */

@ControllerPermission(1)
@RestController
@RequestMapping(value = "/system/user")
public class UserInfoController {

    /**
     * 登录
     *
     * @param info:  登录信息
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<show.lmm.demo.permission.verification.core.model.view.response.UserLoginResponse>
     * @since 刘明明/2022-02-17 12:12:08
     **/
    @NotNeedLogin
    @PostMapping(value = "/login")
    public ResponseHandler<UserLoginResponse> login(@RequestBody @Validated UserLoginRequest info) {
        if (!"admin".equals(info.getUserName()) || !"123456".equals(info.getPassword())) {
            throw new RuntimeException("登录失败，请稍后再试");
        }
        final int userId = 1;
        return ResponseHandler.success(new UserLoginResponse() {{
            setToken(TokenProvider.createToken(userId));
        }});
    }

    /**
     * 添加/修改用户信息
     */
    @AddEditActionPermission(fieldName = "userId")
    @PostMapping(value = "/add_edit")
    public ResponseHandler<String> addEdit(@RequestBody @Validated AddEditUserInfoRequest info) {
        final String msg = String.format("%s用户：%s 成功", info.getUserId() < 1 ? "添加" : "修改", info.getUserName());
        return ResponseHandler.success(msg);
    }

    /**
     * 查询系统用户信息
     */
    @ActionPermission(permissionType = PermissionEnum.VIEW)
    @PostMapping(value = "/get")
    public ResponseHandler<GetUserInfoResponse> getUserInfo(@RequestBody @Validated GetUserInfoRequest info) {
        return ResponseHandler.success(new GetUserInfoResponse(){{
            setUserId(info.getUserId());
            setUserName("张三");
        }});
    }
}