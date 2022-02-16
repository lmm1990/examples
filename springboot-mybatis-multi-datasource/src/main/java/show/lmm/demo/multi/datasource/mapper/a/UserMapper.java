package show.lmm.demo.multi.datasource.mapper.a;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户 mapper
 *
 * @author 刘明明
 * @date 2022-02-16 15:18
 */
@Mapper
public interface UserMapper {

    /**
     * 获得用户年龄
     *
     * @param name: 用户名
     * @return java.lang.Integer
     * @since 刘明明/2022-02-16 15:20:18
     **/
    @Select("select age from `user` where `name` = #{name} limit 1")
    Integer getAge(@Param("name") String name);
}
