package com.zhoutianyu.learnspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoutianyu
 * @date 2020/7/1
 */
@RequestMapping(value = "/hello")
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/get")
    public String function(String paramType) {
        LOGGER.info("paramType is {}", paramType);
        return paramType;
    }
}
