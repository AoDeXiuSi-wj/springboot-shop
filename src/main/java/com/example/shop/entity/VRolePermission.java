package com.example.shop.entity;

import java.io.Serializable;

/**
 * v_role_permission
 * @author 
 */
public class VRolePermission implements Serializable {
    /**
     * 唯一标识符
     */
    private Integer rid;

    /**
     * 角色名称
     */
    private String rolename;

    private String permissions;

    private static final long serialVersionUID = 1L;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}