package com.xing.demojwt.dao;

import com.xing.demojwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User login(User user);
}
