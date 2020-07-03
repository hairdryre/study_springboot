package com.zhoutianyu.learnspringboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SystemInit.class)
public class MyConfig {

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    public SystemInit systemInit() {
        return new SystemInit();
    }
}
