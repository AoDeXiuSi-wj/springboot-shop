package com.example.shop.dao;

import com.example.shop.dao.VUserRolePermissionExample;
import com.example.shop.entity.VUserRolePermission;
import com.example.shop.entity.VUserRolePermissionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VUserRolePermissionMapper {
    long countByExample(VUserRolePermissionExample example);

    int deleteByExample(VUserRolePermissionExample example);

    int insert(VUserRolePermissionWithBLOBs record);

    int insertSelective(VUserRolePermissionWithBLOBs record);

    List<VUserRolePermissionWithBLOBs> selectByExampleWithBLOBs(VUserRolePermissionExample example);

    List<VUserRolePermission> selectByExample(VUserRolePermissionExample example);

    int updateByExampleSelective(@Param("record") VUserRolePermissionWithBLOBs record, @Param("example") VUserRolePermissionExample example);

    int updateByExampleWithBLOBs(@Param("record") VUserRolePermissionWithBLOBs record, @Param("example") VUserRolePermissionExample example);

    int updateByExample(@Param("record") VUserRolePermission record, @Param("example") VUserRolePermissionExample example);
}