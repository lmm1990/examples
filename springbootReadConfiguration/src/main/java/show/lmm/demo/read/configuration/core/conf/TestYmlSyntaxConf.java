package show.lmm.demo.read.configuration.core.conf;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 测试yml语法
 *
 * @author 刘明明
 * @since 2022-02-22 10:12
 */
@Data
@Configuration
public class TestYmlSyntaxConf {

    /**
     * 姓名
     */
    @Value("${name}")
    private String name;

    /**
     * 年龄
     */
    @Value("${age}")
    private int age;

    /**
     * 是否饥饿
     */
    @Value("${hungry}")
    private boolean hungry;

    @Override
    public String toString() {
        return String.format("TestYmlSyntaxConf %s", JSONObject.toJSONString(this));
    }
}
