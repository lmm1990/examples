package show.lmm.demo.starter.core.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 测试自动配置
 *
 * @author 刘明明
 * @since 2022-02-23 17:22
 */
@EnableConfigurationProperties(TestProperties.class)
@ConditionalOnClass(TestConfig.class)
@ConditionalOnProperty(prefix = "show.lmm.demo",value = "db-name")
public class TestAutoConfiguration {

    @Autowired
    private TestProperties testProperties;

    @Bean
    @ConditionalOnMissingBean(TestConfig.class)
    public TestConfig testConfig(){
        return new TestConfig(){{
           setDbName(testProperties.getDbName());
        }};
    }
}
