package show.lmm.demo.permission.verification.core.model.view.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 查询用户信息response
 *
 * @author 刘明明
 * @since 2022-02-17 12:10
 */
@Data
public class GetUserInfoResponse {

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
