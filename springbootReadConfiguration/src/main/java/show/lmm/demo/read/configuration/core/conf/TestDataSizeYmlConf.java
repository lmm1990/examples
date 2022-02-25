package show.lmm.demo.read.configuration.core.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;

/**
 * 测试文件大小配置
 *
 * @author 刘明明
 * @since 2022-02-24 15:49:59
 */
@Data
@Configuration
@PropertySource("classpath:test-data-size.yml")
@ConfigurationProperties(prefix = "upload")
public class TestDataSizeYmlConf {

    /**
     * 文件大小-字节
     */
    @Value("${file-size-b}")
    private DataSize fileSizeB;

    /**
     * 文件大小-k
     */
    @Value("${file-size-kb}")
    private DataSize fileSizeKB;

    /**
     * 文件大小-MB
     */
    @Value("${file-size-mb}")
    private DataSize fileSizeMB;

    /**
     * 文件大小-GB
     */
    @Value("${file-size-gb}")
    private DataSize fileSizeGB;

    /**
     * 文件大小-TB
     */
    @Value("${file-size-tb}")
    private DataSize fileSizeTB;
}
