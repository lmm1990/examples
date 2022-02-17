package show.lmm.demo.permission.verification.core.model.view.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 添加/修改用户信息request
 *
 * @author 刘明明
 */
@Data
public class AddEditUserInfoRequest {

    /**
     * 用户id
     */
    @JsonProperty("userId")
    private int userId;

    /**
     * 用户名
     */
    @JsonProperty("userName")
    private String userName;
}
