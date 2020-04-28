package com.example.shop.service.impl;


import com.example.shop.ShopApplication;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class PermissionServiceImplTest {
    private final org.slf4j.Logger log= LoggerFactory.getLogger("PermissionServiceImplTest");
    @Resource
    private PermissionService permissionService;

    @Test
    public void selectPermissionsByUserName() {
        System.out.println(permissionService.selectPermissionsByUserName("wj"));
    }

    @Test
    public void selectPermissionsByRoleName() {
        System.out.println(permissionService.selectPermissionsByRoleName("admin"));
    }

    @Test
    public void selectPermissionsByExample() {
    }
}