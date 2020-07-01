package com.zhoutianyu.learnspringboot.response;

import lombok.Getter;

@Getter
public enum StatusCodeEnum {
    /**
     *
     */
    SUCCESS(200, "SUCCESS"), ERROR(500, "Business Exception"), INVALID(-1, "Illegal Argument");

    private int code;

    private String message;

    StatusCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
