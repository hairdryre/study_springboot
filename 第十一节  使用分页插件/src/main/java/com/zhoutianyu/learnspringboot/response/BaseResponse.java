package com.zhoutianyu.learnspringboot.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private int code;

    private String message;

    private T data;
    private Long total;


    public BaseResponse(StatusCodeEnum statusCodeEnum, T data) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMessage();
        this.data = data;
    }
}
