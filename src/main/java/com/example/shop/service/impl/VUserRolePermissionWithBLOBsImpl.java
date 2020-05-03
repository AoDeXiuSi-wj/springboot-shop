package com.example.shop.service.impl;

import com.example.shop.dao.VUserRolePermissionExample;
import com.example.shop.dao.VUserRolePermissionMapper;
import com.example.shop.entity.VUserRolePermissionWithBLOBs;
import com.example.shop.service.VUserRolePermissionWithBLOBsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VUserRolePermissionWithBLOBsImpl implements VUserRolePermissionWithBLOBsService {
    @Resource
    private VUserRolePermissionMapper vsMapper;

    @Override
    public long countByExample(VUserRolePermissionExample example) {
        return vsMapper.countByExample(example);
    }

    @Override
    public List<VUserRolePermissionWithBLOBs> selectByExampleWithBLOBs(VUserRolePermissionExample example) {
        return vsMapper.selectByExampleWithBLOBs(example);
    }
}