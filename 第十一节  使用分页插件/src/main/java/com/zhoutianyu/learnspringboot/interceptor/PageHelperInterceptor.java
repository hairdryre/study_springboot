package com.zhoutianyu.learnspringboot.interceptor;


import com.github.pagehelper.PageRowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PageHelperInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageHelperInterceptor.class);

    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final int DEFAULT_PAGE_INDEX = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //原生的int类型可能会有空指针异常，无法将null赋值给基本数据类型
        Integer page = ServletRequestUtils.getIntParameter(request, PAGE);
        Integer limit = ServletRequestUtils.getIntParameter(request, LIMIT);
        if (null == page || page < 1) {
            page = DEFAULT_PAGE_INDEX;
        } else {
            page = page - 1;
        }
        if (null == limit || limit < 0) {
            limit = DEFAULT_PAGE_SIZE;
        }
        int start = page * limit;

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
