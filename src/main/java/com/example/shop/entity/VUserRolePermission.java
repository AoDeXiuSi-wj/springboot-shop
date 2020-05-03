package com.example.shop.entity;

import java.io.Serializable;

/**
 * v_user_role_permission
 * @author 
 */
public class VUserRolePermission implements Serializable {
    /**
     * 唯一标识
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String uname;

    private static final long serialVersionUID = 1L;

    public VUserRolePermission(Integer uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}