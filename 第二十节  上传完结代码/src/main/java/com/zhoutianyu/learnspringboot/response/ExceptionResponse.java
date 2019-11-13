package com.zhoutianyu.learnspringboot.response;

import com.zhoutianyu.learnspringboot.exception.AbstractBusinessException;
import lombok.Data;

@Data
public class ExceptionResponse {

    private int code;
    private String message;

    public ExceptionResponse(Exception exception) {

        if (exception instanceof AbstractBusinessException) {
            this.code = ((AbstractBusinessException) exception).getCode();
            this.message = exception.getMessage();
            return;
        }

        //todo:add other abstract exception type

        //here is default code and message
        this.code = 500;
        this.message = "Server internal error";
    }
}
