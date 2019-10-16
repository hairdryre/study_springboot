package com.zhoutianyu.learnspringboot.lock.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalLockController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalLockController.class);

    @GetMapping(value = "/localLock")
    @LocalLock(key = "LocalLockController.function")
    public String function(String paramType) {
        LOGGER.info("paramType is {}", paramType);
        return paramType;
    }
}
