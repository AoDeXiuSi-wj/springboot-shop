package com.example.shop.service;

import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;

import java.util.List;


public interface UserService {
    int insert(User record);
    
    User selectByPrimaryKey(int uid);

    User selectByName(UserExample example);

    List<User> selectByExample(UserExample example);

}