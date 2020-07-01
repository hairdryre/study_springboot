package com.zhoutianyu.learnspringboot.mybatis;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {
    private Long id;
    private String username;
    private Integer age;
}