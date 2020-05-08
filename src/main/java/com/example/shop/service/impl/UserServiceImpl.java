package com.example.shop.service.impl;
import com.example.shop.dao.UserExample;

import com.example.shop.dao.UserMapper;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public User selectByPrimaryKey(int uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public User selectByName(UserExample example) {
        return userMapper.selectByName(example);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }
}