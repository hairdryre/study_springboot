package com.zhoutianyu.learnspringboot.param;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Department {

    @Value("${define.department.name}")
    private String name;
}
