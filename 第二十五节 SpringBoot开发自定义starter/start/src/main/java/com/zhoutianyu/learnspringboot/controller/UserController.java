package com.zhoutianyu.learnspringboot.controller;

import com.zhoutianyu.learnspringboot.config.DemoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final DemoProperties properties;

    @GetMapping(value = "/get")
    public String function() {

        return properties.getMessage();
    }
}
