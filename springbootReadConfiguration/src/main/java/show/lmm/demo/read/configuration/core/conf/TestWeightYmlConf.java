package show.lmm.demo.read.configuration.core.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import show.lmm.demo.read.configuration.core.model.Weight;

/**
 * 测试重量配置
 *
 * @author 刘明明
 * @since 2022-02-24 17:54:28
 */
@Data
@Configuration
@EnableConfigurationProperties(TestWeightYmlConf.class)
@ConfigurationProperties(prefix = "custom")
public class TestWeightYmlConf {

    /**
     * 重量-吨
     */
    private Weight weightT;

    /**
     * 重量-千克
     */
    private Weight weightKg;

    /**
     * 重量-克
     */
    private Weight weightG;

    /**
     * 重量-毫克
     */
    private Weight weightMG;
}
