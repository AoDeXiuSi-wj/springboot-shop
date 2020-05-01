package com.example.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlContorller {
    @RequestMapping("/control")
    public String controlJsp(@RequestParam(value = "param",required=true,defaultValue = "/home")String _url){
        return _url;
    }
}