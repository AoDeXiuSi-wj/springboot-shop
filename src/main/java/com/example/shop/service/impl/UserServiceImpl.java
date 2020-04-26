package com.example.shop.service.impl;

import com.example.shop.dao.UserMapper;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(int uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}