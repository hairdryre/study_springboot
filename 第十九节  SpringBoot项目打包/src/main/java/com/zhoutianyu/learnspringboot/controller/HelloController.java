package com.zhoutianyu.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoutianyu
 * @date 2020/7/2
 */
@RestController
@PropertySource(value = "classpath:abc.properties")
public class HelloController {


    @Value("${abc}")
    private String abc;

    @GetMapping(value = "/get")
    public String function() {
        return "hello world" + abc;
    }
}
