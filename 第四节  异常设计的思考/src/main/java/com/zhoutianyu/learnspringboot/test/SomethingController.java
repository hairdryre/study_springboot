package com.zhoutianyu.learnspringboot.test;


import com.zhoutianyu.learnspringboot.exception.FieldInvalidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomethingController {

    @GetMapping(value = "/exception/test")
    public void function(String paramType) {
        throw new FieldInvalidException("paramType is null");
    }
}
