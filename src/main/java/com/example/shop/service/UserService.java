package com.example.shop.service;

import com.example.shop.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User selectByPrimaryKey(int uid);
}