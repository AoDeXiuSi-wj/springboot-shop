package com.example.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.dao.RolePermissionExample;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.dao.UserRoleExample;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.entity.RolePermission;
import com.example.shop.entity.UserRole;
import com.example.shop.exception.MyException;
import com.example.shop.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    private final Logger logger= LoggerFactory.getLogger("PermissionServiceImpl");

    @Resource
    private UserRoleMapper roleMapper;

    @Resource
    private RolePermissionMapper permissionMapper;

    @Resource
    DataSourceTransactionManager dataSourceTransactionManager;

    @Resource
    TransactionDefinition transactionDefinition;

    @Override
    public List<RolePermission> selectPermissionsByUserName(String username) {
        UserRoleExample roleExample=new UserRoleExample();
        UserRoleExample.Criteria roleCriteria = roleExample.createCriteria();
        roleCriteria.andUsernameEqualTo(username);
        List<UserRole> roleList=roleMapper.selectByExample(roleExample);

        RolePermissionExample permissionExample = new RolePermissionExample();
        for(UserRole userRole : roleList){
            permissionExample.or().andRolenameEqualTo(userRole.getRolename());
        }
        return permissionMapper.selectByExample(permissionExample);
    }

    @Override
    public List<RolePermission> selectPermissionsByRoleName(String rolename) {
        RolePermissionExample permissionExample=new RolePermissionExample();
        RolePermissionExample.Criteria criteria=permissionExample.createCriteria();
        criteria.andRolenameEqualTo(rolename);
        return permissionMapper.selectByExample(permissionExample);
    }

    @Override
    public List<RolePermission> selectPermissionsByExample(RolePermissionExample example) {
        return permissionMapper.selectByExample(example);
    }

    @Override
    public String selectPermissionsByExample(String rolename) {
        RolePermissionExample rpExample=new RolePermissionExample();
        rpExample.setOrderByClause("pid asc");
        RolePermissionExample.Criteria rpCriteria=rpExample.createCriteria();
        rpCriteria.andRolenameIsNull();
        //全部权限信息
        List<RolePermission> permissionList= permissionMapper.selectByExample(rpExample);
        RolePermissionExample rpExample2=new RolePermissionExample();
        rpExample2.setOrderByClause("pid asc");
        RolePermissionExample.Criteria rpCriteria2=rpExample2.createCriteria();
        rpCriteria2.andRolenameEqualTo(rolename);
        //参数角色的权限信息
        List<RolePermission> permissionListExist= permissionMapper.selectByExample(rpExample2);
        List<String> tempList = new ArrayList<>();
        for(RolePermission rp:permissionListExist){
            tempList.add(rp.getPermission());
        }

        LinkedList<JSONObject> dataList = new LinkedList<JSONObject>();
        JSONObject data= new JSONObject(true);
        //已拥有的权限
        String exist="";
        //记录已经添加过的数据
        List<String> temp=new ArrayList<>();
        for (int i=0;i< permissionList.size();i++) {
            RolePermission rp=permissionList.get(i);
            JSONObject json = new JSONObject(true);
            json.put("value", rp.getPid());
            json.put("title", rp.getPermission());
            if(!temp.contains(rp.getPermission())) {//temp中没有的数据才能放入dataList
//                if("查询用户".equals(rp.getPermission())){
//                    json.put("disabled",true);
//                }
                dataList.add((JSONObject) JSONObject.toJSON(json));
                temp.add(rp.getPermission());
                if(tempList.contains(rp.getPermission())){
                    exist += rp.getPid() + ",";
                }
            }
        }
        data.put("exist",exist);
        data.put("data",dataList);
        return data.toString();
    }

    @Override
    public int insertList(String rolename,String[] addList) {
        List<RolePermission> addArr = new ArrayList<RolePermission>();
        for (int i = 0; i < addList.length; i++) {
            RolePermission rp = new RolePermission();
            rp.setPid(i);
            rp.setRolename(rolename);
            rp.setPermission(addList[i]);
            addArr.add(rp);
        }
        int statius = 0;
        int count = permissionMapper.insertList(addArr);
        //手动开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        if (count != addArr.size()) {
            statius = -1;
            try {
                throw new MyException("权限信息添加失败！");
            } catch (MyException e) {
                //手动回滚事务
                //最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            //用于全局异常捕捉
            throw new MyException("权限信息添加失败！ClassName:PermissionServiceImpl.insertList()");
        } else {
            statius = 1;
            //手动提交事务
            dataSourceTransactionManager.commit(transactionStatus);
        }

        return statius;
    }

    @Override
    public int deleteByExample(String rolename, String[] delList) {
        RolePermissionExample rpExample = new RolePermissionExample();
        RolePermissionExample.Criteria rpCriteria = rpExample.createCriteria();
        for (int j = 0; j < delList.length; j++) {
            rpExample.or().andRolenameEqualTo(rolename).andPermissionEqualTo(delList[j]);
        }
        int statius = 0;
        //手动开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        int count = permissionMapper.deleteByExample(rpExample);
        if (count != delList.length) {
            statius = -1;
            try {
                throw new MyException("权限信息删除错误！");
            } catch (MyException e) {
                //手动回滚事务
                //最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            //用于全局异常捕捉
            throw new MyException("权限信息删除错误！ClassName:PermissionServiceImpl.deleteByExample()");
        } else {
            statius = 1;
            //手动提交事务
            dataSourceTransactionManager.commit(transactionStatus);
        }
        return statius;
    }
}