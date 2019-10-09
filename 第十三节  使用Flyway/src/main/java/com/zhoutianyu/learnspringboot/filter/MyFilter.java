package com.zhoutianyu.learnspringboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        LOGGER.info("自定义过滤器工作,当前请求URL：{}", httpServletRequest.getRequestURL());
        LOGGER.info("自定义过滤器工作,当前请求URI：{}", httpServletRequest.getRequestURI());

        //放行
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
