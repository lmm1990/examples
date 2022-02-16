package show.lmm.demo.multi.datasource.service.a;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import show.lmm.demo.multi.datasource.mapper.a.UserMapper;

/**
 * 用户 service
 *
 * @author 刘明明
 * @date 2022-02-16 15:21
 */
@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获得用户年龄
     *
     * @param name:
     * @return java.lang.Integer
     * @since 刘明明/2022-02-16 15:20:18
     **/
    public int getAge(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return 0;
        }
        Integer age = userMapper.getAge(name);
        if (age == null) {
            return 0;
        }
        return age.intValue();
    }
}
