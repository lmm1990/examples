package show.lmm.demo.dynamic.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootDynamicScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamicScheduleApplication.class, args);
    }

}
