package com.example.shop.service.impl;

import com.example.shop.ShopApplication;
import com.example.shop.entity.UserRole;
import com.example.shop.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class RoleServiceImplTest {
    @Resource
    private RoleService roleService;
    @Test
    public void selectRolesByName() {
        System.out.println(roleService.selectRolesByUserName("wj").toString());
    }
}