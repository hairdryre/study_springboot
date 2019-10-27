package com.zhoutianyu.learnspringboot.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "session")
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(value = "/setSession")
    public String setSession(HttpServletRequest request) {
        request.getSession().setAttribute("key", "第十七节 通过Redis实现Session共享");
        return "8081端口设值成功";
    }

    @RequestMapping(value = "/getSession")
    public Object getSession(HttpServletRequest request) {
        return request.getSession().getAttribute("key");
    }
}
