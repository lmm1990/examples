package show.lmm.demo.multi.datasource.mapper.b;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 订单 mapper
 *
 * @author 刘明明
 * @date 2022-02-16 15:18
 */
@Mapper
public interface OrderMapper {

    /**
     * 获得用户年龄
     *
     * @param orderNumber: 订单编号
     * @return java.lang.Integer
     * @since 刘明明/2022-02-16 15:45:24
     **/
    @Select("select price from t_order where order_no = #{orderNumber} limit 1")
    Float getOrderPrice(@Param("orderNumber") String orderNumber);
}
