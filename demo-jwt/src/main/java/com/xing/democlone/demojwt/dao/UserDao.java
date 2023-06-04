package com.xing.democlone.demojwt.dao;

import com.xing.democlone.demojwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User login(User user);
}
