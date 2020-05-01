package com.example.shop.controller;

import com.example.shop.entity.User;
import com.example.shop.exception.MyException;
import com.example.shop.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        return "thymeleaf/test/test";
    }
    @RequiresPermissions("delete")
    @RequestMapping("/shirotest")
    public String shirotest(){
        Subject subject= SecurityUtils.getSubject();
        System.out.println("是否有删除权限："+subject.isPermitted("delete"));
        return "thymeleaf/test/shirotest";
    }

    @RequestMapping("/exceptiontest")
    public String myException() throws MyException {
        throw new MyException("错误捕捉测试");
    }
}