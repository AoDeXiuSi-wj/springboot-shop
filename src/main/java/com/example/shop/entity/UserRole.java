package com.example.shop.entity;

import java.io.Serializable;

/**
 * user_role
 * @author 
 */
public class UserRole implements Serializable {
    /**
     * 唯一标识符
     */
    private Integer rid;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 角色名称
     */
    private String rolename;

    private static final long serialVersionUID = 1L;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}