package com.example.shop.service.impl;


import com.example.shop.ShopApplication;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.service.PermissionService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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

    //明文转密文的代码:
    @Test
    public void MD5Test(){
        String hashAlgorithName = "MD5";
        String password = "jw";//输入密码
        int hashIterations = 1;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes("shop2020");//加盐
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj.toString());
    }
}