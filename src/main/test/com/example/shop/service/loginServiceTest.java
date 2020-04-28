package com.example.shop.service;



import com.example.shop.ShopApplication;
import com.example.shop.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public  class loginServiceTest {
@Autowired
private loginService service;
    @Test
 public  void login() {
        User user=service.login("管理员","admin");
        if(user!=null){
            System.out.println(user.toString());
        }

    }
}