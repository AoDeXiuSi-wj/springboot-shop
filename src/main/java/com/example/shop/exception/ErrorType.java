package com.example.shop.exception;

import org.junit.Test;

public enum ErrorType {
    ERROR_TYPE_UNKNOWN("未知错误",-1)
    ,ERROR_TYPE_OK("请求成功",200)
    ,ERROR_TYPE_400("服务器不能解析请求",400)
    ,ERROR_TYPE_403("禁止访问所请求的页面",403)
    ,ERROR_TYPE_404("服务器无法找到所请求的页面",404)
    ,ERROR_TYPE_500("未完成的请求。服务器遇到了一个意外的情况",500)
    ,ERROR_TYPE_SHIRO_10001("IncorrectCredentialsException：密码不正确",10001)
    ,ERROR_TYPE_SHIRO_10002("ExpiredCredentialsException：密码已过期",10002)
    ,ERROR_TYPE_SHIRO_10003("UnknownAccountException：账号不存在",10003)
    ,ERROR_TYPE_SHIRO_10004("LockedAccountException：账号被锁定",10004)
    ,ERROR_TYPE_SHIRO_10005("DisabledAccountException：账号被禁用",10005)
    ,ERROR_TYPE_SHIRO_10006("ExcessiveAttemptsException：登录失败次数超过限制",10006)
    ,ERROR_TYPE_SHIRO_10007("ConcurrentAccessException：其他人正在登录改账号",10007)
    ,ERROR_TYPE_SHIRO_10008("UnauthorizedException：不允许访问请求的资源",10008)
    ,ERROR_TYPE_SHIRO_10009("UnanthenticatedException：身份尚未认证，不能授权",10007);

    private String errMsg;
    private int stat;

    ErrorType(String errMsg, int stat) {
        this.errMsg = errMsg;
        this.stat = stat;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public int getStat() {
        return stat;
    }

    public static ErrorType getErrorType(int stat){
        switch (stat){
            case  200: return ERROR_TYPE_OK;
            case  400: return ERROR_TYPE_400;
            case  403: return ERROR_TYPE_403;
            case  404: return ERROR_TYPE_404;
            case  500: return ERROR_TYPE_500;
            case  10001: return ERROR_TYPE_SHIRO_10001;
            case  10002: return ERROR_TYPE_SHIRO_10002;
            case  10003: return ERROR_TYPE_SHIRO_10003;
            case  10004: return ERROR_TYPE_SHIRO_10004;
            case  10005: return ERROR_TYPE_SHIRO_10005;
            case  10006: return ERROR_TYPE_SHIRO_10006;
            case  10007: return ERROR_TYPE_SHIRO_10007;
            case  10008: return ERROR_TYPE_SHIRO_10008;
            case  10009: return ERROR_TYPE_SHIRO_10009;
            default: return ERROR_TYPE_UNKNOWN;
        }
    }

    public static ErrorType getErrorType(String name){
        switch (name){
            case  "400": return ERROR_TYPE_400;
            case  "403": return ERROR_TYPE_403;
            case  "404": return ERROR_TYPE_404;
            case  "500": return ERROR_TYPE_500;
            case  "IncorrectCredentialsException": return ERROR_TYPE_SHIRO_10001;
            case  "ExpiredCredentialsException": return ERROR_TYPE_SHIRO_10002;
            case  "UnknownAccountException": return ERROR_TYPE_SHIRO_10003;
            case  "LockedAccountException": return ERROR_TYPE_SHIRO_10004;
            case  "DisabledAccountException": return ERROR_TYPE_SHIRO_10005;
            case  "ExcessiveAttemptsException": return ERROR_TYPE_SHIRO_10006;
            case  "ConcurrentAccessException": return ERROR_TYPE_SHIRO_10007;
            case  "UnauthorizedException": return ERROR_TYPE_SHIRO_10008;
            case  "UnanthenticatedException": return ERROR_TYPE_SHIRO_10009;
            default: return ERROR_TYPE_UNKNOWN;
        }
    }
}