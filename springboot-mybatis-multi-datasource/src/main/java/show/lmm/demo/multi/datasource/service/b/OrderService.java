package show.lmm.demo.multi.datasource.service.b;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import show.lmm.demo.multi.datasource.mapper.b.OrderMapper;

/**
 * 用户 service
 *
 * @author 刘明明
 * @date 2022-02-16 15:21
 */
@Service
public class OrderService {

    private OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 获得用户年龄
     *
     * @param orderNumber: 订单编号
     * @return java.lang.Integer
     * @since 刘明明/2022-02-16 15:45:24
     **/
    public float getOrderPrice(String orderNumber) {
        if (ObjectUtils.isEmpty(orderNumber)) {
            return 0;
        }
        Float orderPrice = orderMapper.getOrderPrice(orderNumber);
        if (orderPrice == null) {
            return 0;
        }
        return orderPrice.floatValue();
    }
}
