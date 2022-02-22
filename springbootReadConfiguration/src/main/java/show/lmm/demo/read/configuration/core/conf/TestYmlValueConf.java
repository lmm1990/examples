package show.lmm.demo.read.configuration.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 测试@Value配置
 *
 * @author 刘明明
 * @since 2022-02-21 16:53
 */
@Data
@Configuration
public class TestYmlValueConf {

    @Value("${server.port}")
    private int port;

    /**
     * 应用名称，默认为：testApp
     */
    @Value("${appName:testApp}")
    private String appName;
}
