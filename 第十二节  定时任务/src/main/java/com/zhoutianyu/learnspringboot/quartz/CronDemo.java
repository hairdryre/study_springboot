package com.zhoutianyu.learnspringboot.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
@EnableScheduling
@EnableAsync
public class CronDemo {

    @Async
    @Scheduled(cron = "${define.quartz.cron}")
    public void schedule() {
        System.out.println(Thread.currentThread().hashCode());
    }

    @Async
    @Scheduled(cron = "${define.quartz.cron}")
    public void schedule2() {
        System.out.println(Thread.currentThread().hashCode());
    }
}
