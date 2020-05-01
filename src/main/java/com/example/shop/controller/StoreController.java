package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {
    @RequestMapping("/shop")
    public String shop(){
        return "thymeleaf/store/shop";
    }

    @RequestMapping("/home")
    public String home(){
        return "thymeleaf/store/home";
    }
}