package com.example.shop.service.impl;


import com.example.shop.ShopApplication;
import com.example.shop.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class PermissionServiceImplTest {
    private final org.slf4j.Logger log= LoggerFactory.getLogger("PermissionServiceImplTest");
    @Autowired
    private PermissionService permissionService;
    @Test
    public void selectByRole() {
        System.out.println(permissionService.selectByRole("superadmin").toString());
    }
}