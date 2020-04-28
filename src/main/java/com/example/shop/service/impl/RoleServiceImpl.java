package com.example.shop.service.impl;

import com.example.shop.dao.UserRoleExample;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.entity.UserRole;
import com.example.shop.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private UserRoleMapper userRoleMapper;
    @Override
    public List<UserRole> selectByName(String uname) {
        UserRoleExample userRoleExample=new UserRoleExample();
        userRoleExample.setDistinct(false);
        userRoleExample.setOrderByClause("rid asc");
        UserRoleExample.Criteria criteria=userRoleExample.createCriteria();
        criteria.andUsernameEqualTo(uname);
        return userRoleMapper.selectByExample(userRoleExample);
    }
}