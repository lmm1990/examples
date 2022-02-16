package show.lmm.demo.multi.datasource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import show.lmm.demo.multi.datasource.service.a.UserService;
import show.lmm.demo.multi.datasource.service.b.OrderService;

/**
 * 首页
 *
 * @author 刘明明
 * @date 2022-02-16 14:53
 */
@RestController
@RequestMapping("/")
public class IndexController {

    private UserService userService;
    private OrderService orderService;

    public IndexController(UserService userService,OrderService orderService){
        this.userService = userService;
        this.orderService = orderService;
    }

    /**
     * 查询管理菜单列表
     *
     * @return 管理菜单列表
     * @modify 刘明明/2021-11-24 16:56:24
     **/
    @GetMapping(value = "/test/datasource_a")
    public int getDataSourceAData() {
        return userService.getAge("admin");
    }

    /**
     * 查询管理菜单列表
     *
     * @return 管理菜单列表
     * @modify 刘明明/2021-11-24 16:56:24
     **/
    @GetMapping(value = "/test/datasource_b")
    public float getDataSourceBData() {
        return orderService.getOrderPrice("20180210001");
    }
}
