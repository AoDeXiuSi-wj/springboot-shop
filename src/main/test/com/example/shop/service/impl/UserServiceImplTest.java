package com.example.shop.service.impl;

import com.example.shop.ShopApplication;
<<<<<<< Updated upstream
import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.example.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
>>>>>>> Stashed changes
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
<<<<<<< Updated upstream
import java.util.List;
=======
>>>>>>> Stashed changes

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class UserServiceImplTest {
<<<<<<< Updated upstream
    private final Logger log= LoggerFactory.getLogger("UserServiceImplTest");
    @Autowired
=======
    @Resource
>>>>>>> Stashed changes
    private UserService userService;
    @Test
    public void selectByPrimaryKey() {
        System.out.println("test:"+userService.selectByPrimaryKey(1).toString());
    }
<<<<<<< Updated upstream

    @Test
    public void selectTest(){
        UserExample userExample=new UserExample();
        userExample.setDistinct(false);
        userExample.setOrderByClause("uid asc");
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo("管理员");
        List<User> users=userService.selectByExample(userExample);
        System.out.println(users);
    }
=======
>>>>>>> Stashed changes
}