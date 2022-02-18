package show.lmm.demo.dynamic.schedule.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import show.lmm.demo.dynamic.schedule.core.schedule.DynamicSchedule;

/**
 * 项目启动后执行
 */
@Component
public class SetupRunner implements CommandLineRunner {

    private DynamicSchedule dynamicSchedule;

    public SetupRunner(DynamicSchedule dynamicSchedule) {
        this.dynamicSchedule = dynamicSchedule;
    }

    @Override
    public void run(String... args) {
        // 新增定时任务
        dynamicSchedule.addSchedule(1);
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 修改定时任务
        System.out.println("begin editSchedule");
        dynamicSchedule.editSchedule(1);
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 删除定时任务
        System.out.println("begin deleteSchedule");
        dynamicSchedule.deleteSchedule(1);
    }
}
