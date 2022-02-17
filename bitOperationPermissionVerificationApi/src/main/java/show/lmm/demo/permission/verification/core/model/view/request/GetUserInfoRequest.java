package show.lmm.demo.permission.verification.core.model.view.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 查询用户信息request
 *
 * @author 刘明明
 */
@Data
public class GetUserInfoRequest {

    /**
     * 用户id
     */
    @JsonProperty("userId")
    private int userId;
}
