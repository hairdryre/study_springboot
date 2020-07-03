package com.zhoutianyu.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zhoutianyu")
public class LearnspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnspringbootApplication.class, args);
    }

}
