package com.zhoutianyu.learnspringboot.param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private Department department;

    @Autowired
    private Database database;

    @Autowired
    private DatabaseCopy databaseCopy;

    @GetMapping(value = "/param/test")
    public UserInfo userInfo() {
        return userInfo;
    }

    @GetMapping(value = "/param/test2")
    public String departmentName() {
        return department.getName();
    }

    @GetMapping(value = "/param/test3")
    public Database dataBase() {
        return database;
    }

    @GetMapping(value = "/param/test4")
    public DatabaseCopy dataBaseCopy() {
        return databaseCopy;
    }
}
