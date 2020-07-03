package com.zhoutianyu.learnspringboot.aop;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhoutianyu
 * @date 2020/7/3
 */
public class WebUtils {

    public static HttpServletRequest getRequest() {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)
                    RequestContextHolder.currentRequestAttributes();
            //子线程共享同一个Request(在进入线程池之前，要先调用一次本方法，让程序执行到这步)
            RequestContextHolder.setRequestAttributes(requestAttributes, true);
            return requestAttributes.getRequest();

        } catch (IllegalStateException e) {
            return null;
        }
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response;
        try {
            response = ((ServletRequestAttributes)
                    RequestContextHolder.currentRequestAttributes()).getResponse();
        } catch (Exception e) {
            return null;
        }
        return response;
    }

}
