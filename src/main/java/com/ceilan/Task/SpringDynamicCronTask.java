package com.ceilan.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.Task;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * Spring动态周期定时任务<br>
 * 在不停应用的情况下更改任务执行周期
 *
 * @Param
 * @return
 * @Author cfa  2018-07-25
 **/
@Lazy(false)
@Component
//@EnableScheduling
public class SpringDynamicCronTask implements SchedulingConfigurer {
    /**
     * Callback allowing a {@link TaskScheduler
     * TaskScheduler} and specific {@link Task Task}
     * instances to be registered against the given the {@link ScheduledTaskRegistrar}
     *
     * @param taskRegistrar the registrar to be configured.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }

  /*  private static final Logger LOGGER = LoggerFactory.getLogger(SpringDynamicCronTask.class);

    private static String cron;
    private static String cron1;
    private static int aaa=0;
    private static int bbb=0;

    public SpringDynamicCronTask() {
        cron = "0/5 * * * * ?";
        cron1 = "0/5 * * * * ?";

        // 开启新线程模拟外部更改了任务执行周期
        new Thread(() -> {
            try {
                Thread.sleep(15 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cron = "0/10 * * * * ?";
            System.err.println("cron change to: " + cron);
        }).start();

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
            taskRegistrar.addTriggerTask(() -> {
                // 任务逻辑
                LOGGER.debug("AAA is running-------"+aaa);
                aaa++;
            }, triggerContext -> {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                return trigger.nextExecutionTime(triggerContext);
            });
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
                LOGGER.debug("BBB is running-------"+bbb);
                bbb++;
                if(aaa>5){
                    System.out.println(taskRegistrar.getTriggerTaskList()+"------------------task List");
                    taskRegistrar.destroy();
                }
            }
        }, triggerContext -> {
            // 任务触发，可修改任务的执行周期
            CronTrigger trigger = new CronTrigger(cron1);
            return trigger.nextExecutionTime(triggerContext);
        });
    }
*/
}
