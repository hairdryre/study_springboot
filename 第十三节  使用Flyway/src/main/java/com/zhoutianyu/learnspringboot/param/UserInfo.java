package com.zhoutianyu.learnspringboot.param;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "define.userinfo")
@Component
@Data
public class UserInfo {

    private String username;

    private int age;

    private String position;

}
