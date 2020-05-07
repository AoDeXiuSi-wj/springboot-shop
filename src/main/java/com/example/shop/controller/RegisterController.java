package com.example.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String register(){
        return "thymeleaf/register";
    }

    @RequestMapping("/chkregister")
    @ResponseBody
    public String chkregister(){
        JSONObject jsonObject=new JSONObject(true);
        jsonObject.put("status",-1);
        jsonObject.put("masg","保存失败");
        return jsonObject.toJSONString();
    }

}
