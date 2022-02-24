package show.lmm.demo.starter.core.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试配置
 *
 * @author 刘明明
 * @since 2022-02-23 17:07
 */
@Data
@Component
@ConfigurationProperties(prefix = "show.lmm.demo")
public class TestProperties {

    /**
     * 数据库名称
     */
    private String dbName;
}
