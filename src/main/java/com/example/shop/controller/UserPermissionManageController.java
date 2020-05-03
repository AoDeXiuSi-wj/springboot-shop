package com.example.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.dao.UserExample;
import com.example.shop.dao.VUserRolePermissionExample;
import com.example.shop.entity.User;
import com.example.shop.entity.VUserRolePermissionWithBLOBs;
import com.example.shop.service.UserService;
import com.example.shop.service.VUserRolePermissionWithBLOBsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 用户管理、用户权限管理控制层
 * */
@Controller
@RequestMapping("/user")
public class UserPermissionManageController {
    @Resource
    private UserService userService;

    @Resource
    private VUserRolePermissionWithBLOBsService vsService;

    //private VUserRolePermissionWithBLOBsService vurpService;
    //用户管理页面
    @RequestMapping("um")
    public String userMange(){
        return "thymeleaf/user/userManage";
    }
    @RequestMapping("/um/data")
    @ResponseBody
    public String userMangeData(
            @RequestParam(value = "page",defaultValue = "1")Integer pageIdx
            ,@RequestParam(value = "limit",defaultValue = "15")Integer pageNum
            ){
        UserExample userExample=new UserExample();
        userExample.setOrderByClause("uid asc limit "+(pageIdx*pageNum-pageNum > 0 ? pageIdx*pageNum-pageNum:0)+","+(pageIdx*pageNum));
        UserExample.Criteria userCriteria=userExample.createCriteria();

        long count= userService.countByExample(userExample);
        ArrayList<User> users= (ArrayList<User>) userService.selectByExample(userExample);
        LinkedList<JSONObject> dataList = new LinkedList<JSONObject>();

        JSONObject json= new JSONObject(true);
        if (users ==null || users.size()==0){
            json.put("code",-1);
            json.put("msg","尚未保存任何数据！");
            json.put("count",0);
        }else {
            json.put("code",0);
            json.put("msg","查询成功！");
            json.put("count",count);
            for (User u : users) {
                //去掉密码
                u.setUpswd(" ");
                //将javabean转换为JSONObject，用数组接收
                dataList.add((JSONObject) JSONObject.toJSON(u));
            }
        }
        json.put("data",dataList);
        return json.toJSONString();
    }

    //添加用户
    @RequestMapping("/au")
    public String addUser(){
        return "thymeleaf/user/add";
    }
    //权限管理页面
    @RequestMapping("/up")
    public String userPermissionManage(){
        return "thymeleaf/user/permissionManage";
    }
    @RequestMapping("/up/data")
    @ResponseBody
    public String userPermissionManageData(@RequestParam(value = "page",defaultValue = "1")Integer pageIdx
            ,@RequestParam(value = "limit",defaultValue = "15")Integer pageNum
    ){
        VUserRolePermissionExample vurpExample=new VUserRolePermissionExample();
        vurpExample.setOrderByClause("uid asc");
        VUserRolePermissionExample.Criteria vsCriteria = vurpExample.createCriteria();

        long count=vsService.countByExample(vurpExample);
        List<VUserRolePermissionWithBLOBs> vurpList=vsService.selectByExampleWithBLOBs(vurpExample);
        LinkedList<JSONObject> dataList = new LinkedList<JSONObject>();

        JSONObject json= new JSONObject(true);
        if (vurpList ==null || vurpList.size()==0){
            json.put("code",-1);
            json.put("msg","尚未保存任何数据！");
            json.put("count",0);
        }else {
            json.put("code",0);
            json.put("msg","查询成功！");
            json.put("count",count);
            for (VUserRolePermissionWithBLOBs vsp : vurpList) {
                //将javabean转换为JSONObject，用数组接收
                dataList.add((JSONObject) JSONObject.toJSON(vsp));
            }
        }
        json.put("data",dataList);
        return json.toJSONString();
    }
}