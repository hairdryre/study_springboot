package com.zhoutianyu.learnspringboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "redis")
public class RedisTestController {

    private final RedisService redisService;

    @Autowired
    public RedisTestController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping(value = "/getKey")
    public String getKey(String key) {
        return redisService.get(key);
    }


    @GetMapping(value = "/setKey")
    public void setKey(String key, String value) {
        redisService.set(key, value);
    }

    @GetMapping(value = "/setBean")
    public void setBean(Long id, String username, String password) {
        UserBean userBean = new UserBean(id, username, password);
        redisService.set(String.valueOf(id), userBean);
    }

    @GetMapping(value = "/getBeanById")
    public Object getBean(String key) {
        return redisService.get(key);
    }

    @GetMapping(value = "/setEx")
    public void setEx(String key, String value, Long seconds) {
        redisService.setEx(key, value, seconds);
    }

    @GetMapping(value = "/flushDB")
    public void flushDB() {
        redisService.flushDB();
    }

    @GetMapping(value = "/ping")
    public String ping() {
        return redisService.ping();
    }
}
