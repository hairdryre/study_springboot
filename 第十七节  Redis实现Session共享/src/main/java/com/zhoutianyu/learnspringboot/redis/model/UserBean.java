package com.zhoutianyu.learnspringboot.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {

    private Long id;

    private String username;

    private String password;
}
