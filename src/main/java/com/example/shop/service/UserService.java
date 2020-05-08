package com.example.shop.service;

import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;

import java.util.List;


public interface UserService {
    long countByExample(UserExample example);

    User selectByPrimaryKey(int uid);

    User selectByName(UserExample example);

    List<User> selectByExample(UserExample example);

    int insert(User record);

}