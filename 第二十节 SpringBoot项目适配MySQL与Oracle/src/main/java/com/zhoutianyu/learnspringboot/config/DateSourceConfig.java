package com.zhoutianyu.learnspringboot.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhoutianyu
 * @date 2020/7/2
 */
@Configuration
public class DateSourceConfig {

    /**
     * 自动识别使用的数据库类型
     * 在mapper.xml中databaseId的值就是跟这里对应，
     * 如果没有databaseId选择则说明该sql适用所有数据库
     */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();

        properties.setProperty("Oracle", "oracle");
        properties.setProperty("MySQL", "mysql");
        databaseIdProvider.setProperties(properties);

        return databaseIdProvider;
    }

}
