package com.example.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.shop.dao.RolePermissionExample;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.dao.UserRoleExample;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.entity.RolePermission;
import com.example.shop.entity.UserRole;
import com.example.shop.exception.MyException;
import com.example.shop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    DataSourceTransactionManager dataSourceTransactionManager;

    @Resource
    TransactionDefinition transactionDefinition;

    @Override
    public List<UserRole> selectRolesByUserName(String username) {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.setOrderByClause("rid asc");
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userRoleMapper.selectByExample(userRoleExample);
    }

    @Override
    public List<UserRole> selectByExample(UserRoleExample example) {
        return userRoleMapper.selectByExample(example);
    }

    @Override
    public int insertList(String username, String[] addList) {
        List<UserRole> addArr = new ArrayList<UserRole>();
        for (int i = 0; i < addList.length; i++) {
            UserRole ur = new UserRole();
            ur.setRid(i);
            ur.setUsername(username);
            ur.setRolename(addList[i]);
            addArr.add(ur);
        }
        int statius = 0;
        int count = userRoleMapper.insertList(addArr);
        //手动开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        if (count != addArr.size()) {
            statius = -1;
            try {
                throw new MyException("角色信息添加失败！");
            } catch (MyException e) {
                //手动回滚事务
                //最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            //用于全局异常捕捉
            throw new MyException("角色信息添加失败！ClassName:RoleServiceImpl.insertList()");
        } else {
            statius = 1;
            //手动提交事务
            dataSourceTransactionManager.commit(transactionStatus);
        }

        return statius;
    }

    @Override
    public int deleteByExample(String username, String[] delList) {
        UserRoleExample urExample = new UserRoleExample();
        UserRoleExample.Criteria urCriteria = urExample.createCriteria();
        for (int j = 0; j < delList.length; j++) {
            urExample.or().andUsernameEqualTo(username).andRolenameEqualTo(delList[j]);
        }
        int statius = 0;
        //手动开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        int count = userRoleMapper.deleteByExample(urExample);
        if (count != delList.length) {
            statius = -1;
            try {
                throw new MyException("角色信息删除错误！");
            } catch (MyException e) {
                //手动回滚事务
                //最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
                dataSourceTransactionManager.rollback(transactionStatus);
            }
            //用于全局异常捕捉
            throw new MyException("角色信息删除错误！ClassName:RoleServiceImpl.deleteByExample()");
        } else {
            statius = 1;
            //手动提交事务
            dataSourceTransactionManager.commit(transactionStatus);
        }
        return statius;
    }


}