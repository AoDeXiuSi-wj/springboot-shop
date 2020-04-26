package com.example.shop.service.impl;

import com.example.shop.ShopApplication;
import com.example.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    public void selectByPrimaryKey() {
        System.out.println("test:"+userService.selectByPrimaryKey(1).toString());
    }
}