package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@Controller
@RequestMapping("/html")
public class loginConctroller {
            @RequestMapping("/to_login")
            public String to_login(){
                System.out.println("退出");
                return "thymeleaf/login";
            }
}
