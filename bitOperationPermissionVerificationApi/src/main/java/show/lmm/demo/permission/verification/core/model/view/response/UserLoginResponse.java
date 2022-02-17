package show.lmm.demo.permission.verification.core.model.view.response;

import lombok.Data;

/**
 * 用户登录response
 *
 * @author 刘明明
 */
@Data
public class UserLoginResponse {

    /**
     * 用户身份标识
     */
    private String token;
}
