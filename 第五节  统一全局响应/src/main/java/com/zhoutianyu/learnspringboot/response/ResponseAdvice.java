package com.zhoutianyu.learnspringboot.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (isResponseType(data)) {
            return data;
        }

        return new BaseResponse<>(StatusCodeEnum.SUCCESS, data);
    }

    private boolean isResponseType(Object data) {
        return data instanceof BaseResponse || data instanceof ExceptionResponse;
    }
}
