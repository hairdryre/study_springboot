package com.zhoutianyu.learnspringboot.mybatis;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private Integer age;
    private Date currentTime;
}