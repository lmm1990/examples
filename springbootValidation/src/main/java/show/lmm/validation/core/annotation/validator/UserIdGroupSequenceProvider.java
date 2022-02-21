package show.lmm.validation.core.annotation.validator;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import show.lmm.validation.core.view.request.user.AddEditUserInfoRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户分组序列提供者
 *
 * @author 刘明明
 * @since 2022-02-18 15:27
 */
public class UserIdGroupSequenceProvider implements DefaultGroupSequenceProvider<AddEditUserInfoRequest> {
    @Override
    public List<Class<?>> getValidationGroups(AddEditUserInfoRequest bean) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        // 这一步不能省,否则Default分组都不会执行了，会抛错的
        defaultGroupSequence.add(AddEditUserInfoRequest.class);
        if (bean == null) {
            return defaultGroupSequence;
        }
        if (bean.getUserId() < 1) {
            defaultGroupSequence.add(AddEditUserInfoRequest.AddGroup.class);
        } else {
            defaultGroupSequence.add(AddEditUserInfoRequest.EditGroup.class);
        }
        return defaultGroupSequence;
    }
}
