package show.lmm.demo.web.demoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import show.lmm.demo.starter.core.conf.TestConfig;

/**
 * 启动后运行
 *
 * @author 刘明明
 * @since 2022-02-23 17:27
 */
@Component
public class StartRunner implements CommandLineRunner {

    @Autowired
    private TestConfig testConfig;

    @Override
    public void run(String... args) {
        System.out.println(testConfig.getDbName());
    }
}
