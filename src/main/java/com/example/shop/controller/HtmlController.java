package com.example.shop.controller;

import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/test")
    public String test(){
        User user=userService.selectByPrimaryKey(1);
        System.out.println("==========/n"+user.toString());
        return "thymeleaf/test";
    }

    @RequestMapping("/control")
    public String controlJsp(@RequestParam(value = "param",required=true,defaultValue = "/home")String _url){
        return _url;
    }
}
