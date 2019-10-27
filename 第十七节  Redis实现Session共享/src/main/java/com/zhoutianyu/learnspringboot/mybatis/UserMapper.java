package com.zhoutianyu.learnspringboot.mybatis;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserById(Long id);

    List<User> getUsers(PageRowBounds pageRowBounds);
}