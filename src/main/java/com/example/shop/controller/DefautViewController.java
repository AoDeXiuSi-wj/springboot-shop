package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DefautViewController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}