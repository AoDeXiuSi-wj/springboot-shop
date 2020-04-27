package com.example.shop.service.impl;

import com.example.shop.dao.UserMapper;
import com.example.shop.entity.User;
import com.example.shop.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("loginService")
public class loginServiceImpl implements loginService {
    @Autowired
    private UserMapper mapper;
    @Override
    public User login(String uname, String upswd) {
        User user=mapper.selectLoginUser(uname);
        if(user!=null&&user.getUpswd().equals(upswd)){
            return user;
        }
        return null;
    }
}
