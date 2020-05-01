package com.example.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.exception.MyException;
import com.example.shop.util.VerificationCodeTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/login")
public class LoginConctroller {
    private final Logger logger= LoggerFactory.getLogger(LoginConctroller.class);
    /****
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "thymeleaf/user/login";
    }
    /****
     * 登出
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(){
        Subject subject= SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "thymeleaf/user/login";
    }
    /***
     * 验证登录
     * @param session
     * @param uname 用户名
     * @param upwsd 密码
     * @param imgcode 验证码结果
     * @return
     */
    @RequestMapping("/chklogin")
    @ResponseBody
    public String  cheklogin(HttpSession session
            ,@RequestParam("uname") String uname
            ,@RequestParam("upswd") String upwsd
            ,@RequestParam String imgcode) throws MyException {
        int status=0;
        String errMsg="";
        String captcha = (String) session.getAttribute("code");
        JSONObject json=new JSONObject();
//        if (!captcha.equals(imgcode)){
//            json.put("status", -1);
//            json.put("errMsg", "验证码错误！");
//            return json.toJSONString();
//        }
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(uname,upwsd);
            subject.login(token);
        session.removeAttribute("code");
        if(subject.isAuthenticated()){
            status=1;
            session.setAttribute("user",subject.getPrincipal().toString());
            System.out.println("用户"+subject.getPrincipal().toString()+"已登录！");
        }else {
            status=-1;
        }

        json.put("status", status);
        json.put("errMsg", errMsg);
        return json.toJSONString();
    }
    @RequestMapping("/changeimglogin")
    public void changeimg(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
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
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", outputStream);
        outputStream.close();
        // System.out.println("刷新验证码");
    }


}
