package show.lmm.demo.read.configuration.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

/**
 * properties测试 controller
 *
 * @author 刘明明
 * @since 2022-02-21 15:07
 */
@RestController
@RequestMapping("/")
public class PropertiesTestController {

    /**
     * 测试Properties key
     * @return
     */
    @GetMapping("/test_key")
    public String testKey() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("test.properties"));
        return "hasBankCodeKey："+properties.containsKey("bank code")+" <br />\r\n hasIdNumberKey："+properties.containsKey("id number");
    }
}
