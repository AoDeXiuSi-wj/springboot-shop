package com.example.shop.service;

import com.example.shop.dao.VUserRolePermissionExample;
import com.example.shop.entity.VUserRolePermissionWithBLOBs;

import java.util.List;

public interface VUserRolePermissionWithBLOBsService {
    long countByExample(VUserRolePermissionExample example);

    List<VUserRolePermissionWithBLOBs> selectByExampleWithBLOBs(VUserRolePermissionExample example);
}