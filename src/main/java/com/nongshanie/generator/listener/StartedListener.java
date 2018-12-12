package com.nongshanie.generator.listener;


import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.nongshanie.generator.utils.SpringUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *     应用启动完成后所执行的方法
 * </pre>
 *
 * @author : RYAN0UP
 * @date : 2018/12/5
 */
@Configuration
public class StartedListener implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        //启动定时任务
        CronUtil.schedule("2","*/2 * * * * *", (Task) SpringUtil.getBean("postSyncTask"));
        CronUtil.schedule("1","*/2 * * * * *", (Task) SpringUtil.getBean("printTask"));
        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();

    }

}
