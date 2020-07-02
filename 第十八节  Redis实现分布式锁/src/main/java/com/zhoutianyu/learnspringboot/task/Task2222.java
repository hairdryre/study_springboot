package com.zhoutianyu.learnspringboot.task;

import com.zhoutianyu.learnspringboot.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Task2222 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task2222.class);

    @Autowired
    private RedisService redisService;

    private static final String TASK_ID = "1";
    private static final String VALUE = "value";
    private static final Long TIME_OUT = 60L;

    //each 30s execute
    @Scheduled(cron = "*/30 * * * * ?")
    public void schedule() {
        final byte[] key = TASK_ID.getBytes();
        try {
            Boolean isExist = redisService.exists(key);
            if (isExist) {
                LOGGER.error("已经存在任务，放弃执行");
                return;
            }
            //add lock , time:60s
            redisService.setEx(key, VALUE, TIME_OUT);

            System.out.println("定时任务执行");

            //release lock
            redisService.del(key);
        } catch (Exception e) {
            redisService.del(key);
        }
    }
}
