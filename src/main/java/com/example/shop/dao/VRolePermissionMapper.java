package com.example.shop.dao;

import com.example.shop.dao.VRolePermissionExample;
import com.example.shop.entity.VRolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VRolePermissionMapper {
    long countByExample(VRolePermissionExample example);

    int deleteByExample(VRolePermissionExample example);

    int insert(VRolePermission record);

    int insertSelective(VRolePermission record);

    List<VRolePermission> selectByExampleWithBLOBs(VRolePermissionExample example);

    List<VRolePermission> selectByExample(VRolePermissionExample example);

    int updateByExampleSelective(@Param("record") VRolePermission record, @Param("example") VRolePermissionExample example);

    int updateByExampleWithBLOBs(@Param("record") VRolePermission record, @Param("example") VRolePermissionExample example);

    int updateByExample(@Param("record") VRolePermission record, @Param("example") VRolePermissionExample example);
}