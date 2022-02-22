package show.lmm.demo.read.configuration.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 测试@PropertySource + @ConfigurationProperties
 *
 * @author 刘明明
 * @since 2022-02-21 16:53
 */
@Data
@Configuration
@PropertySource("classpath:test.yml")
@ConfigurationProperties(prefix = "server")
public class TestPropertySourceYmlConf {

    @Value("${name}")
    private String name;
}
