package com.zhoutianyu.learnspringboot.exception;

import com.zhoutianyu.learnspringboot.response.ExceptionResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有异常
     *
     * @param exception 异常对象
     * @return 异常标准响应 {code : XX , message : XXX}
     * @see ExceptionResponse 主要处理逻辑在ExceptionResponse中
     */
    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse handlerException(Exception exception) {
        return new ExceptionResponse(exception);
    }
}
