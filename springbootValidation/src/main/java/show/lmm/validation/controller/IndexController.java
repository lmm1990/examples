package show.lmm.validation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import show.lmm.validation.core.view.request.CustomValidatedRequest;
import show.lmm.validation.core.view.request.GetIndexInfoRequest;

/**
 * 首页 controller
 *
 * @author 刘明明
 * @since 2022-02-18 11:09
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @PostMapping("/index")
    public String index(@RequestBody @Validated GetIndexInfoRequest info) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(info);
    }

    @PostMapping("/custom_validated")
    public String customValidated(@RequestBody @Validated CustomValidatedRequest info) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(info);
    }
}