package com.example.shop.entity;

import java.io.Serializable;

/**
 * role_permission
 * @author 
 */
public class RolePermission implements Serializable {
    /**
     * 唯一标识符
     */
    private Integer pid;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 权限
     */
    private String permission;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}