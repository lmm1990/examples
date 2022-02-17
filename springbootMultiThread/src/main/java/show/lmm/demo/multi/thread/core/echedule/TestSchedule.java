package show.lmm.demo.multi.thread.core.echedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * 测试定时任务
 *
 * @author 刘明明
 * @since 2022-02-17 17:17
 */
@Component
public class TestSchedule {

    /**
     * 每5秒执行一次
     *
     * @since 刘明明/2022-02-17 17:18:18
     **/
    @Scheduled(cron = "0/5 * * * * ? ")
    public void testA(){
        System.out.println(String.format("method：testA，time：%s，threadName：%s", new Date().toLocaleString(),
                Thread.currentThread().getName()));
        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
    }

    /**
     * 每5秒执行一次
     *
     * @since 刘明明/2022-02-17 17:18:18
     **/
    @Scheduled(cron = "0/5 * * * * ? ")
    public void testB(){
        System.out.println(String.format("method：testB，time：%s，threadName：%s", new Date().toLocaleString(),
                Thread.currentThread().getName()));
    }
}
