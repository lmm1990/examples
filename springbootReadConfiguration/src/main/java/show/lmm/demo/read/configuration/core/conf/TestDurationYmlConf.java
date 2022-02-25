package show.lmm.demo.read.configuration.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;
import java.time.Period;

/**
 * 测试时间周期配置
 *
 * @author 刘明明
 * @since 2022-02-21 16:53
 */
@Data
@Configuration
@PropertySource("classpath:test-duration.yml")
@ConfigurationProperties(prefix = "custom.config")
public class TestDurationYmlConf {

    /**
     * 时间周期-纳秒
     */
    @Value("${duration-ns}")
    private Duration durationNs;

    /**
     * 时间周期-微秒
     */
    @Value("${duration-us}")
    private Duration durationUs;

    /**
     * 时间周期-毫秒
     */
    @Value("${duration-ms}")
    private Duration durationMs;

    /**
     * 时间周期-秒
     */
    @Value("${duration-s}")
    private Duration durationS;

    /**
     * 时间周期-分钟
     */
    @Value("${duration-m}")
    private Duration durationM;

    /**
     * 时间周期-小时
     */
    @Value("${duration-h}")
    private Duration durationH;

    /**
     * 时间周期-天
     */
    @Value("${duration-d}")
    private Duration durationD;

    /**
     * 转换期间-年
     */
    @Value("${duration-period-y}")
    private Period durationPeriodY;

    /**
     * 转换期间-月
     */
    @Value("${duration-period-m}")
    private Period durationPeriodM;

    /**
     * 转换期间-周
     */
    @Value("${duration-period-w}")
    private Period durationPeriodW;

    /**
     * 转换期间-天
     */
    @Value("${duration-period-d}")
    private Period durationPeriodD;
}
