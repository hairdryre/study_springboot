package com.zhoutianyu.learnspringboot.response;

import lombok.Getter;

/**
 * @author zhoutianyu <tyzhou@wisedu.com>
 * @version 1.0.0
 * @date 2019/9/9 17:48
 */
@Getter
public enum StatusCode {

    SUCCESS(200, "SUCCESS"), ERROR(500, "Business Exception"), INVALID(-1, "Illegal Argument");

    private int code;

    private String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
