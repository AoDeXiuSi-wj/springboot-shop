package com.example.shop.entity;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    /**
     * å”¯ä¸€æ ‡è¯†
     */
    private Integer uid;

    /**
     * ç”¨æˆ·å��
     */
    private String uname;

    /**
     * å¯†ç �
     */
    private String upswd;

    /**
     * ç”µè¯�
     */
    private String utel;

    /**
     * é‚®ç®±
     */
    private String ueml;

    /**
     * 1ç”·ï¼Œ2å¥³ï¼Œ3ä¿�å¯†
     */
    private Integer usex;

    /**
     * æ��è¿°
     */
    private String utext;

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

    public String getUtext() {
        return utext;
    }

    public void setUtext(String utext) {
        this.utext = utext;
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
                ", utext='" + utext + '\'' +
                '}';
    }
}