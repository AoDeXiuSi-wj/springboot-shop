package com.example.shop.service.impl;

import com.example.shop.ShopApplication;
import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class UserServiceImplTest {
    private final Logger log= LoggerFactory.getLogger("UserServiceImplTest");
    @Autowired
    private UserService userService;
    @Test
    public void selectByPrimaryKey() {
        System.out.println("test:"+userService.selectByPrimaryKey(1).toString());
    }

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

    @Test
    public  void  test(){
        Md5Hash md5Hash=new Md5Hash();
       /* md5Hash.setSalt("shop2020");
        md5Hash.
        md5Hash.setIterations(1);*/
    }

    @Test
    public void selectByName() {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        userExample.or().andUnameEqualTo("管理员");
        userExample.or().andUtelEqualTo("管理员");
        userExample.or().andUemlEqualTo("管理员");
        User user=userService.selectByName(userExample);
        System.out.println("==="+user.toString());
    }
}