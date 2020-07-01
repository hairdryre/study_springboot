package com.zhoutianyu.learnspringboot.quartz;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class BaseQuartZ {

//    @Scheduled(cron = "${define.quartz.cron}")
//    public void schedule() {
//        System.out.println(Thread.currentThread().hashCode());
//    }

}
