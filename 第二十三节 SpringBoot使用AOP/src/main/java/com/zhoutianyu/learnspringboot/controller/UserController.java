package com.zhoutianyu.learnspringboot.controller;


import com.zhoutianyu.learnspringboot.aop.LogHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @GetMapping(value = "/get")
    @LogHandler
    public String function(String paramType) {
        LOGGER.info("paramType is {}", paramType);
        return paramType;
    }
}
