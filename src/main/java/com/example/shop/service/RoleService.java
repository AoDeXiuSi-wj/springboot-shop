package com.example.shop.service;

import com.example.shop.dao.UserRoleExample;
import com.example.shop.entity.UserRole;

import java.util.List;

public interface RoleService {
    List<UserRole> selectRolesByUserName(String username);

    List<UserRole> selectByExample(UserRoleExample example);

    int insertList(List<UserRole> userList);

    int deleteByExample(UserRoleExample example);
}