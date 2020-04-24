package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/html")
public class HtmlController {
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
        return "thymeleaf/test";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        return "hello world!";
    }

    @RequestMapping("/control")
    public String controlJsp(@RequestParam(value = "param",required=true,defaultValue = "/home")String _url){
        return _url;
    }
}
