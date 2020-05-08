package com.example.shop.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import com.example.shop.shiro.Customrealm;
import com.example.shop.util.MD5util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private UserService service;
    @RequestMapping("/register")
    public String register(){
        return "thymeleaf/register";
    }

    @RequestMapping("/chkregister")
    @ResponseBody
    public String chkregister(@RequestParam String nickname,
                              @RequestParam String password,
                              @RequestParam String cellphone,
                              @RequestParam String email
                              ){
        int status=-1;
        String msg="保存失败，重新提交！";
        String isuser=null;
        Customrealm customrealm=new Customrealm();
        UserExample userExample=new UserExample();
        userExample.or().andUnameEqualTo(nickname.trim());
        User users=service.selectByName(userExample);
        if(users!=null){
            status=0;
            msg="该用户名已存在！";
        }else{
            User user=new User();
            MD5util md5util=new MD5util();
            user.setUname(nickname.trim());
            password=md5util.md5(password);
            user.setUpswd(password.trim());
            user.setUtel(cellphone.trim());
            user.setUeml(email.trim());
            user.setUsex(3);
            status=service.insert(user);
            if(status == 1) {
                msg = "注册成功";
            }
        }

        JSONObject jsonObject=new JSONObject(true);
        jsonObject.put("status",status);
        jsonObject.put("msg",msg);
        return jsonObject.toJSONString();
    }

}
