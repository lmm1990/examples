package show.lmm.demo.read.configuration.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import show.lmm.demo.read.configuration.core.conf.TestPropertySourceYmlConf;
import show.lmm.demo.read.configuration.core.conf.TestYmlValueConf;

import javax.annotation.Resource;

/**
 * properties测试 controller
 *
 * @author 刘明明
 * @since 2022-02-21 15:07
 */
@RestController
@RequestMapping("/yml")
public class YmlTestController {

    @Resource
    private TestPropertySourceYmlConf testPropertySourceYmlConf;
    @Resource
    private TestYmlValueConf testYmlValueConf;
    @Resource
    private Environment env;

    /**
     * 测试@Value
     *
     * @return
     */
    @GetMapping("/test_value")
    public String testValue() {
        return String.format("port：%s，appName：%s",testYmlValueConf.getPort(),testYmlValueConf.getAppName());
    }

    /**
     * 测试@PropertySource + @ConfigurationProperties + @Value
     *
     * @return
     */
    @GetMapping("/test_property_source")
    public String testPropertySource() {
        return testPropertySourceYmlConf.getName();
    }


    /**
     * 测试 Environment
     *
     * @return
     */
    @GetMapping("/test_environment")
    public String testEnvironment() {
        return env.getProperty("server.port");
    }
}
