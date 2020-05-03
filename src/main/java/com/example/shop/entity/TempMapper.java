package com.example.shop.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class TempMapper {
    /**
     * 唯一标识
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String uname;

    private String rolenames;

    private String permissions;

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

    public String getRolenames() {
        return rolenames;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "TempMapper{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", rolenames='" + rolenames + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }
}