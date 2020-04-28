package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@Controller
@RequestMapping("/html")
public class loginConctroller {
    @RequestMapping("/login")
    public String login(){

        return "thymeleaf/login";
    }
    @RequestMapping("/loginout")
    public String loginout(){
        System.out.println("退出");
        return "thymeleaf/login";
    }
}
