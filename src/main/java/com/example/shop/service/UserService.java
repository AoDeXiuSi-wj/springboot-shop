package com.example.shop.service;

import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User selectByPrimaryKey(int uid);

    User selectByName(UserExample example);

    List<User> selectByExample(UserExample example);
}