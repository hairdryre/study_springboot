package com.zhoutianyu.learnspringboot.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private int code;

    private String message;

    private T data;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMessage();
        this.data = null;
    }

    public BaseResponse(StatusCodeEnum statusCodeEnum, T data) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMessage();
        this.data = data;
    }
}
