package com.zhoutianyu.learnspringboot.valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoutianyu <tyzhou@wisedu.com>
 * @version 1.0.0
 * @date 2019/9/9 16:11
 */
@RestController
public class PhoneController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneController.class);

    @GetMapping(value = "/phone/test")
    public Phone buyPhone(@Valid Phone phone, BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, Object> errorMap = new HashMap<>(10);
        fieldErrors.forEach(error -> {
                    LOGGER.error("字段:{}校验失败, Message:{} \n", error.getField(), error.getDefaultMessage());
                    errorMap.put(error.getField(), error.getDefaultMessage());
                }
        );
        return phone;
    }
}
