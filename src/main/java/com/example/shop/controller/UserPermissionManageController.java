package com.example.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.dao.UserExample;
import com.example.shop.dao.UserRoleExample;
import com.example.shop.dao.VUserRolePermissionExample;
import com.example.shop.entity.User;
import com.example.shop.entity.UserRole;
import com.example.shop.entity.VUserRolePermissionWithBLOBs;
import com.example.shop.service.RoleService;
import com.example.shop.service.UserService;
import com.example.shop.service.VUserRolePermissionWithBLOBsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/*
 * 用户管理、用户权限管理控制层
 * */
@Controller
@RequestMapping("/user")
public class UserPermissionManageController {
    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private VUserRolePermissionWithBLOBsService vsService;

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
    public String userPermissionManageData(
            @RequestParam(value = "page",defaultValue = "1")Integer pageIdx
            ,@RequestParam(value = "limit",defaultValue = "15")Integer pageNum
    ){
        VUserRolePermissionExample vurpExample=new VUserRolePermissionExample();
        vurpExample.setOrderByClause("uid asc limit "+(pageIdx*pageNum-pageNum > 0 ? pageIdx*pageNum-pageNum:0)+","+(pageIdx*pageNum));
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

    //修改用户角色页面
    @RequestMapping("/er")
    @ResponseBody
    public ModelAndView editRole(@RequestParam(value = "username")String username){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("thymeleaf/user/editRole");
        mv.addObject("username",username);
        return mv;
    }

    //查询所有角色
    @RequestMapping("/qar")
    @ResponseBody
    public String queryAllRole(@RequestParam(value = "username")String username){
        UserRoleExample urExample=new UserRoleExample();
        urExample.setOrderByClause("rid asc");

        //全部角色信息
        List<UserRole> roleList= roleService.selectByExample(urExample);
        //登录账户拥有的角色信息
        List<UserRole> roleListExist= roleService.selectRolesByUserName(username);
        List<String> tempList = new ArrayList<>();
        for(UserRole ur:roleListExist){
            tempList.add(ur.getRolename());
        }

        LinkedList<JSONObject> dataList = new LinkedList<JSONObject>();
        JSONObject data= new JSONObject(true);
        String exist="";
        //记录已经添加过的数据
        List<String> temp=new ArrayList<>();
        for (int i=0;i< roleList.size();i++) {
            UserRole ur=roleList.get(i);
            JSONObject json = new JSONObject(true);
            json.put("value", ur.getRid());
            json.put("title", ur.getRolename());
            if(!temp.contains(ur.getRolename())) {//temp中没有的数据才能放入dataList
                if("superadmin".equals(ur.getRolename())){
                    json.put("disabled",true);
                }
                dataList.add((JSONObject) JSONObject.toJSON(json));
                temp.add(ur.getRolename());
                if(tempList.contains(ur.getRolename())){
                    exist += ur.getRid() + ",";
                }
            }
        }
        data.put("exist",exist);
        data.put("data",dataList);
        return data.toString();
    }

    @RequestMapping("/editRole")
    @ResponseBody
    public int editRole(
             @RequestParam("username")String username
            ,@RequestParam("roles")String roles){
        String[] roleArr = roles.split(",");
        List<UserRole> roleList = new ArrayList<>();
        for (int i=0;i<roleArr.length;i++){
            UserRole ur = new UserRole();
            ur.setRid(i);
            ur.setUsername(username);
            ur.setRolename(roleArr[i]);
            roleList.add(ur);
        }
        int count=roleService.insertList(roleList);
        System.out.println("isOk:"+count);
        return count;
    }
}