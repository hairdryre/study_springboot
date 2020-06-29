package com.zhoutianyu.learnspringboot.test;

import com.zhoutianyu.learnspringboot.response.BaseResponse;
import com.zhoutianyu.learnspringboot.response.StatusCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomethingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SomethingController.class);

    @GetMapping(value = "/response/test")
    public BaseResponse buy(String param) {
        LOGGER.info("paramType is {}", param);
        return new BaseResponse<>(StatusCodeEnum.SUCCESS, param);
    }

    @GetMapping(value = "/response/test/string")
    public String buyTwo(String param) {
        LOGGER.info("paramType is {}", param);
        return param;
    }

}
