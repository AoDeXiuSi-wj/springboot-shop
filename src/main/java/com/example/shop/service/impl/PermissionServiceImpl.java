package com.example.shop.service.impl;

import com.example.shop.dao.RolePermissionExample;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.entity.RolePermission;
import com.example.shop.service.PermissionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermission> selectByRole(String role) {
        RolePermissionExample rolePermissionExample=new RolePermissionExample();
        rolePermissionExample.setDistinct(false);
        rolePermissionExample.setOrderByClause("pid asc");
        RolePermissionExample.Criteria criteria=rolePermissionExample.createCriteria();
        criteria.andRolenameEqualTo(role);
        return rolePermissionMapper.selectByExample(rolePermissionExample);
    }

    @Override
    public List<RolePermission> selectByExample(RolePermissionExample example) {
        return rolePermissionMapper.selectByExample(example);
    }
}