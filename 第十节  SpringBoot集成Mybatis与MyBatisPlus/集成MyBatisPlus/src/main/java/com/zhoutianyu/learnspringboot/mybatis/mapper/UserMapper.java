package com.zhoutianyu.learnspringboot.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhoutianyu.learnspringboot.mybatis.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
