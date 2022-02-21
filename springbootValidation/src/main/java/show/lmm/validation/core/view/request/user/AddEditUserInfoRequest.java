package show.lmm.validation.core.view.request.user;

import lombok.Data;
import org.hibernate.validator.group.GroupSequenceProvider;
import show.lmm.validation.core.annotation.validator.UserIdGroupSequenceProvider;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户信息
 *
 * @author 刘明明
 * @since 2022-02-18 14:23
 */
@Data
@GroupSequenceProvider(UserIdGroupSequenceProvider.class)
public class AddEditUserInfoRequest {

    public interface AddGroup{

    }

    public interface EditGroup{

    }

    private int userId;

    @NotNull(message = "用户名不能为null")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 性别：1、男，2、女
     */
    @NotNull(message = "性别不能小于为null",groups = { AddGroup.class })
    @Min(value = 1,message = "性别不能小于1",groups = { AddGroup.class })
    @Max(value = 2,message = "性别不能大于2",groups = { AddGroup.class })
    private Integer sex;

    @NotNull(message = "个人简介不能为null",groups = { EditGroup.class })
    @NotBlank(message = "个人简介不能为空",groups = { EditGroup.class })
    private String profileInfo;
}
