package com.zhoutianyu.learnspringboot.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zhoutianyu.learnspringboot.interceptor.MyInterceptor;
import com.zhoutianyu.learnspringboot.interceptor.PageHelperInterceptor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class CustomWebConfigure implements WebMvcConfigurer {

    @Resource
    private MyInterceptor interceptor;

    @Resource
    private PageHelperInterceptor pageHelperInterceptor;

    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageHelperInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
//    }
}
