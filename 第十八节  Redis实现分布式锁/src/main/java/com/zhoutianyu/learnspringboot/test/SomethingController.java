package com.zhoutianyu.learnspringboot.test;

import com.zhoutianyu.learnspringboot.exception.FieldInvalidException;
import com.zhoutianyu.learnspringboot.response.BaseResponse;
import com.zhoutianyu.learnspringboot.response.StatusCodeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @GetMapping(value = "/exception/test")
    public void function(String paramType) {
        throw new FieldInvalidException("paramType is null");
    }

    @GetMapping(value = "/exception/test2")
    public Computer function(@Valid Computer computer, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            StringBuilder stringBuilder = new StringBuilder();
            fieldErrors.forEach(error -> {
                        LOGGER.error("字段:{}，原因:{} \n", error.getField(), error.getDefaultMessage());
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
