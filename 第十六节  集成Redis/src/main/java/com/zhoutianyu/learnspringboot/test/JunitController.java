package com.zhoutianyu.learnspringboot.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JunitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JunitController.class);

    @GetMapping(value = "/get_test")
    public Address getRequest(Address address) {
        LOGGER.info("paramType is {}", address);
        return address;
    }

    @PostMapping(value = "/post_test")
    public Address postRequest(@RequestBody Address address) {
        LOGGER.info("paramType is {}", address);
        return address;
    }
}

