package com.example.shop.service.impl;

import com.example.shop.dao.RolePermissionExample;
import com.example.shop.dao.RolePermissionMapper;
import com.example.shop.dao.UserRoleExample;
import com.example.shop.dao.UserRoleMapper;
import com.example.shop.entity.RolePermission;
import com.example.shop.entity.UserRole;
import com.example.shop.service.PermissionService;
import com.example.shop.service.RoleService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private UserRoleMapper roleMapper;

    @Resource
    private RolePermissionMapper permissionMapper;


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
}