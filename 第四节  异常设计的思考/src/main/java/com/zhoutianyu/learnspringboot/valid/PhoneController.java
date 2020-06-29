package com.zhoutianyu.learnspringboot.valid;

import com.zhoutianyu.learnspringboot.exception.FieldInvalidException;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @GetMapping(value = "/exception/test2")
    public Computer function(@Valid Computer computer, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            StringBuilder stringBuilder = new StringBuilder();
            fieldErrors.forEach(error -> {

                        stringBuilder.append("字段:").append(error.getField()).
                                append("，原因:").append(error.getDefaultMessage()).append(";");
                    }
            );
            throw new FieldInvalidException(stringBuilder.toString());
        }

        return computer;
    }
}

@Data
class Computer {

    @NotBlank(message = "CPU不能为空")
    @Length(max = 5, message = "CPU不能超过{max}个字符")
    private String cpu;

    @NotNull(message = "内存大小不能为空")
    private Long memory;
}