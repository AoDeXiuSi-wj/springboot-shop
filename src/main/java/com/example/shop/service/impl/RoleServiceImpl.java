package com.example.shop.service.impl;

import com.example.shop.dao.UserRoleExample;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.entity.UserRole;
import com.example.shop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public List<UserRole> selectRolesByUserName(String username) {
        UserRoleExample userRoleExample=new UserRoleExample();
        userRoleExample.setOrderByClause("rid asc");
        UserRoleExample.Criteria criteria=userRoleExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userRoleMapper.selectByExample(userRoleExample);
    }

    @Override
    public List<UserRole> selectByExample(UserRoleExample example) {
        return userRoleMapper.selectByExample(example);
    }

    @Override
    public int insertList(List<UserRole> userList) {
        return userRoleMapper.insertList(userList);
    }

    @Override
    public int deleteByExample(UserRoleExample example) {
        return userRoleMapper.deleteByExample(example);
    }


}