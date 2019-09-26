package com.zhoutianyu.learnspringboot.mybatis;

import com.zhoutianyu.learnspringboot.interceptor.PageHelperThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper mapper;

    @GetMapping(value = "mybatis/getUserById")
    public User function(Long id) {
        LOGGER.info("the id is：{}", id);
        return mapper.getUserById(id);
    }

    @GetMapping(value = "mybatis/getUsers")
    public List<User> getUsers() {
        return mapper.getUsers(PageHelperThreadLocal.getPageInfo());
    }
}
