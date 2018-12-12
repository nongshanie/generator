package com.nongshanie.generator.task;

import cn.hutool.cron.task.Task;
import org.springframework.stereotype.Component;

@Component
public class PrintTask implements Task {
    @Override
    public void execute() {
        System.out.println("com.nongshanie.generator.task.PrintTask");
    }
}
