package com.example.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.entity.User;
import com.example.shop.service.loginService;
import com.example.shop.util.VerificationCodeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
public class loginConctroller {
    @Autowired
    private loginService service;

    /****
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/to_login")
    public String to_login(HttpSession session){
        session.setAttribute("User",null);
        return "redirect:/login";
    }

    /****
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "thymeleaf/login";
    }
    /***
     * 验证登录
     * @param session
     * @param uname 用户名
     * @param upwsd 密码
     * @param imgcode 验证码结果
     * @return
     */
    @RequestMapping("/cheklogin")
    @ResponseBody
    public String  cheklogin(HttpSession session, @RequestParam("uname") String uname,@RequestParam("upswd") String upwsd,@RequestParam String imgcode){
        String captcha = (String) session.getAttribute("code");
        //System.out.println("实际结果："+captcha);
        //System.out.println("输入结果:"+imgcode);
        session.removeAttribute("code");
        User user=service.login(uname,upwsd);
        if(user==null || !imgcode.equals(captcha)){
           //return "redirect:/login";
        }
        session.setAttribute("User",user);
        System.out.println(user.toString());
        JSONObject json=new JSONObject();
        json.put("msg","登录成功");
        json.put("status",1);
        return json.toJSONString();
    }
    @RequestMapping("/changeimglogin")
    public void changeimg(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        VerificationCodeTool verificationCode = new VerificationCodeTool();
        // 生成验证码
        BufferedImage buffImg = verificationCode.drawVerificationCodeImage();
        // 将验证码保存到session中
        session.setAttribute("code", verificationCode.getXyresult()+ "");
        //System.out.println("rs:"+verificationCode.getXyresult());
        //设置浏览器不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(buffImg, "jpeg", outputStream);
            outputStream.close();
            // System.out.println("刷新验证码");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
