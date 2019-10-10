package com.zhoutianyu.learnspringboot.param;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = "classpath:config/db.properties")
@ConfigurationProperties(prefix = "database")
@Component
@Data
public class Database {

    private String name;

    private String version;
}
