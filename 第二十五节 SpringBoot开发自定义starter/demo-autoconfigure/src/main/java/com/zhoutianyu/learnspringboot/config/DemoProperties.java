package com.zhoutianyu.learnspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhoutianyu
 * @date 2020/7/3
 */
@ConfigurationProperties(prefix = "demo")
@Data
public class DemoProperties {

    private String message;

}
