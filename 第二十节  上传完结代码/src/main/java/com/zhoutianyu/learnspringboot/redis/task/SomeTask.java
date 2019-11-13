package com.zhoutianyu.learnspringboot.redis.task;

import com.zhoutianyu.learnspringboot.redis.RedisService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@EnableScheduling
//@Component
public class SomeTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeTask.class);

    @Autowired
    private RedisService redisService;

    private static final String TASK_ID = "1";

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
            String value = randomString();
            redisService.setEx(key, value, 60L);

            System.out.println("定时任务执行");
            //模拟40s的业务时间
            Thread.sleep(40);

            //release lock
            if (value.equals(redisService.get(key))) {
                redisService.del(key);
            }

        } catch (Exception e) {
            redisService.del(key);
        }
    }

    private String randomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}

