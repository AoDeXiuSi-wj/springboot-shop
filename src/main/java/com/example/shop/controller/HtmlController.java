package com.example.shop.controller;

import com.example.shop.entity.User;
import com.example.shop.exception.MyException;
import com.example.shop.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;

@Controller
@RequestMapping("/html")
public class HtmlController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/shop")
    public String shop(){
        return "thymeleaf/shop";
    }

    @RequestMapping("/home")
    public String home(){
        return "thymeleaf/home";
    }

    @RequestMapping("/error")
    public String error(){
        return "thymeleaf/error";
    }

    @RequestMapping("/test")
    public String test(){
        User user=userService.selectByPrimaryKey(1);
        System.out.println("==========/n"+user.toString());
        return "thymeleaf/test";
    }
    @RequiresPermissions("delete")
    @RequestMapping("/shirotest")
    public String shirotest(){
        Subject subject= SecurityUtils.getSubject();
        System.out.println("是否有删除权限："+subject.isPermitted("delete"));
        return "thymeleaf/shirotest";
    }

    @RequestMapping("/exceptiontest")
    public String myException() throws MyException {
        throw new MyException("错误捕捉测试");
    }

    @RequestMapping("/control")
    public String controlJsp(@RequestParam(value = "param",required=true,defaultValue = "/home")String _url){
        return _url;
    }
}
