package com.example.shop.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Component
public class User implements Serializable {
    /**
     * 唯一标识
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String upswd;

    /**
     * 电话
     */
    private String utel;

    /**
     * 邮箱
     */
    private String ueml;

    /**
     * 1男，2女，3保密
     */
    private Integer usex;

    private static final long serialVersionUID = 1L;

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

    public String getUpswd() {
        return upswd;
    }

    public void setUpswd(String upswd) {
        this.upswd = upswd;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUeml() {
        return ueml;
    }

    public void setUeml(String ueml) {
        this.ueml = ueml;
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upswd='" + upswd + '\'' +
                ", utel='" + utel + '\'' +
                ", ueml='" + ueml + '\'' +
                ", usex=" + usex +
                '}';
    }
}