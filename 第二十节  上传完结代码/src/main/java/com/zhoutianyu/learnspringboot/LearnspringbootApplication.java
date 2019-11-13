package com.zhoutianyu.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800 * 2 )
public class LearnspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnspringbootApplication.class, args);
    }

}
