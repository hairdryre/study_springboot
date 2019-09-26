package com.zhoutianyu.learnspringboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter2 implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter2.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String param = httpServletRequest.getParameter("param");
        LOGGER.error("自定义过滤器2工作，参数param是:{}", param);

        //放行
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
