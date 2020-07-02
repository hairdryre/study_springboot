package com.zhoutianyu.learnspringboot.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Task1111 {

    @Scheduled(cron = "*/5 * * * * ?")
    public void schedule() {

        //System.out.println("定时任务执行");
    }
}
