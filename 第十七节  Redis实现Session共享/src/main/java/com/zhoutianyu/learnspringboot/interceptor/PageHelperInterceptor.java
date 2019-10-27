package com.zhoutianyu.learnspringboot.interceptor;


import com.github.pagehelper.PageRowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PageHelperInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageHelperInterceptor.class);

    private static final String PAGE = "page";
    private static final String LIMIT = "limit";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        int page = Integer.valueOf(request.getParameter(PAGE));
        int limit = Integer.valueOf(request.getParameter(LIMIT));
        int start = (page - 1) * limit;

        LOGGER.info("分页资源预处理");
        LOGGER.info("从第{}条记录开始查询，共查询{}条记录", start + 1, limit);

        //generate an page object and put it into threadLocal
        PageRowBounds pageRowBounds = new PageRowBounds(start, limit);
        PageHelperThreadLocal.setPageInfo(pageRowBounds);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //when the business process has been completed,
        //removing page object which is in the threadLocal
        PageHelperThreadLocal.clean();
    }

}
