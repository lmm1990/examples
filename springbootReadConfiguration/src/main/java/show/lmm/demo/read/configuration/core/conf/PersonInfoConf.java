package show.lmm.demo.read.configuration.core.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 人员信息
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonInfoConf {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 水果列表
     */
    private String[] fruits;

    @DeprecatedConfigurationProperty(reason = "fruits已废弃", replacement = "暂无替代")
    public String[] getFruits() {
        return fruits;
    }
}