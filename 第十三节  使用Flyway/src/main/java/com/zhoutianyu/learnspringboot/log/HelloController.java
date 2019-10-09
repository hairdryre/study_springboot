package com.zhoutianyu.learnspringboot.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/log/test")
    public String function(String paramType) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("debug级别日志");
        }
        LOGGER.info("info级别日志");
        LOGGER.error("error级别日志");
        return paramType;
    }
}
