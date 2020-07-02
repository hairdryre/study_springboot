package com.zhoutianyu.learnspringboot.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfigure implements WebMvcConfigurer {


    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }

}
