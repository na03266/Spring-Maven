package com.example.demo.dao;

import com.example.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {
    void insertUser(UserModel user);

    UserModel selectUser(@Param("userId") String userId);
}
