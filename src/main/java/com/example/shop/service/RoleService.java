package com.example.shop.service;

import com.example.shop.dao.UserRoleExample;
import com.example.shop.entity.UserRole;

import java.util.List;

public interface RoleService {
    List<UserRole> selectByExample(String uname);

}