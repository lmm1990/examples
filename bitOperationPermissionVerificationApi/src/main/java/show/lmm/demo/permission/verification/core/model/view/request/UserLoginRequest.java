package show.lmm.demo.permission.verification.core.model.view.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 用户登录request
 *
 * @author 刘明明
 */
@Data
public class UserLoginRequest {

    /**
     * 用户名
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * 密码
     */
    @JsonProperty("password")
    private String password;
}
