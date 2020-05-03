package com.example.shop.service;

import com.example.shop.entity.UserRole;

import java.util.List;

public interface RoleService {
    List<UserRole> selectRolesByUserName(String username);
}