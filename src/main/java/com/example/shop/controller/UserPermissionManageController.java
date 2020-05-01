package com.example.shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import static com.alibaba.fastjson.serializer.SerializeConfig.globalInstance;

/*
 * 用户管理、用户权限管理控制层
 * */
@Controller
@RequestMapping("/user")
public class UserPermissionManageController {
    @Resource
    private UserService userService;
    //用户管理页面
    @RequestMapping("/um")
    @ResponseBody
    public String userMange(
            @RequestParam("pageIdx")Integer pageIdx
            ,@RequestParam("pageNum")Integer pageNum
            ){
        System.out.println("pageIdx:"+pageIdx);
        System.out.println("pageNum:"+pageNum);
        UserExample userExample=new UserExample();
        userExample.setOrderByClause("uid asc limit "+(pageIdx*pageNum-pageNum > 0 ? pageIdx*pageNum-pageNum:0)+","+(pageIdx*pageNum));
        UserExample.Criteria userCriteria=userExample.createCriteria();

        long count=userService.countByExample(userExample);
        ArrayList<User> users= (ArrayList<User>) userService.selectByExample(userExample);
        LinkedList<JSONObject> dataList = new LinkedList<JSONObject>();

        JSONObject json= new JSONObject(true);
        if (users ==null || users.size()==0){
//            json.put("code",-1);
//            json.put("msg","尚未保存任何数据！");
//            json.put("count",0);
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
    //用户权限页面
    @RequestMapping("/up")
    public String userPermissionManage(){
        return "thymeleaf/user/permissionManage";
    }
}