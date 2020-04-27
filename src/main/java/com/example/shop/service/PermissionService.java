package com.example.shop.service;

import com.example.shop.dao.RolePermissionExample;
import com.example.shop.entity.RolePermission;

import java.util.List;

public interface PermissionService {
    List<RolePermission> selectByExample(String role);
}