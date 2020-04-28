package com.example.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.entity.User;
import com.example.shop.service.loginService;
import com.example.shop.util.VerificationCodeTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
public class loginConctroller {
    @Resource
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
    /****
     * 登出
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
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
    @RequestMapping("/chklogin")
    @ResponseBody
    public String  cheklogin(HttpSession session
            ,@RequestParam("uname") String uname
            ,@RequestParam("upswd") String upwsd
            ,@RequestParam String imgcode){
        int status=0;
        String errMsg="";
        String captcha = (String) session.getAttribute("code");
        JSONObject json=new JSONObject();
        if (!captcha.equals(imgcode)){
            json.put("status", -1);
            json.put("errMsg", "验证码错误！");
            return json.toJSONString();
        }
        System.out.println("实际结果："+captcha);
        System.out.println("输入结果:"+imgcode);
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(uname,upwsd);
        try {
            //token.setRememberMe("1".equals(_remenberme));
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            errMsg="用户名或密码错误！";
        } catch (LockedAccountException e) {
            errMsg="帐号已被锁定";
        } catch (DisabledAccountException e) {
            errMsg="帐号已被禁用";
        } catch (ExpiredCredentialsException e) {
            errMsg="帐号已过期";
        } catch (UnknownAccountException e) {
            errMsg="用户不存在";
        } catch (UnauthorizedException e) {
            errMsg="您没有得到相应的授权";
        }
        session.removeAttribute("code");
        if(subject.isAuthenticated()){
            status=1;
            System.out.println("已登录！");
        }else {
            status=-1;
        }

        json.put("status", status);
        json.put("errMsg", errMsg);
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
