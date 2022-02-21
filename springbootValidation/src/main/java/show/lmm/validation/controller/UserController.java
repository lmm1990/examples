package show.lmm.validation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import show.lmm.validation.core.view.request.user.AddEditUserInfoRequest;

/**
 * 用户 controller
 *
 * @author 刘明明
 * @since 2022-02-18 11:09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 添加/修改用户信息
     *
     * @param info 用户信息
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("/add_edit")
    public String index(@RequestBody @Validated AddEditUserInfoRequest info) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(info);
    }
}