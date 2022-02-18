package show.lmm.demo.dynamic.schedule.core.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 动态任务
 *
 * @author 刘明明
 * @since 2022-02-17 18:04:03
 */
@Component
public class DynamicSchedule {

    private int executeCount = 0;

    final private Map<Integer, String> crons = new HashMap<>() {{
        // 每秒执行一次
        put(1, "0/1 * * * * ? ");
        // 每5秒执行一次
        put(2, "0/5 * * * * ? ");
    }};

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private Map<Integer, ScheduledFuture<?>> taskMap = new HashMap<>();

    private ReentrantLock lock = new ReentrantLock();

    /**
     * 添加任务
     *
     * @param syncTaskCronId: 同步任务执行信息id
     **/
    public void addSchedule(int syncTaskCronId) {
        ScheduledFuture<?> taskInfo = taskMap.get(syncTaskCronId);
        if (taskInfo != null) {
            editSchedule(syncTaskCronId);
            return;
        }
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(() -> System.out.println(String.format("method：addSchedule，time：%s，threadName：%s", new Date().toLocaleString(),
                Thread.currentThread().getName())), getTrigger());
        taskMap.put(syncTaskCronId, schedule);
    }

    /**
     * 修改任务
     *
     * @param syncTaskCronId: 同步任务执行信息id
     **/
    public void editSchedule(int syncTaskCronId) {
        deleteSchedule(syncTaskCronId);
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(() -> System.out.println(String.format("method：editSchedule，time：%s，threadName：%s", new Date().toLocaleString(),
                Thread.currentThread().getName())), getTrigger());
        taskMap.put(syncTaskCronId, schedule);
    }

    /**
     * 删除任务
     *
     * @param syncTaskCronId: 同步任务执行信息id
     **/
    public void deleteSchedule(int syncTaskCronId) {
        ScheduledFuture<?> taskInfo = taskMap.get(syncTaskCronId);
        if (taskInfo != null) {
            deleteSchedule(taskInfo, syncTaskCronId);
        }
    }

    /**
     * 删除任务
     *
     * @param taskInfo:       任务信息
     * @param syncTaskCronId: 同步任务执行信息id
     **/
    private void deleteSchedule(ScheduledFuture<?> taskInfo, int syncTaskCronId) {
        taskInfo.cancel(true);
        taskMap.remove(syncTaskCronId);
    }

    /**
     * 获得触发器
     *
     * @return org.springframework.scheduling.Trigger
     **/
    private Trigger getTrigger() {
        return triggerContext -> {
            try {
                lock.lock();
                executeCount++;
                if (executeCount > 2) {
                    executeCount = 1;
                }
            } finally {
                lock.unlock();
            }
            System.out.println(String.format("getTrigger %s", crons.get(executeCount)));
            CronTrigger trigger1 = new CronTrigger(crons.get(executeCount));
            return trigger1.nextExecutionTime(triggerContext);
        };
    }
}
