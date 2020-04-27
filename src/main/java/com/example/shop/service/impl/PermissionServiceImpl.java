package com.example.shop.service.impl;

import com.example.shop.dao.RolePermissionExample;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.entity.RolePermission;
import com.example.shop.service.PermissionService;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermission> selectByExample(String role) {
        RolePermissionExample rolePermissionExample=new RolePermissionExample();
        rolePermissionExample.setDistinct(false);
        rolePermissionExample.setOrderByClause("pid asc");
        RolePermissionExample.Criteria criteria=rolePermissionExample.createCriteria();
        criteria.andRolenameEqualTo(role);
        return rolePermissionMapper.selectByExample(rolePermissionExample);
    }
}