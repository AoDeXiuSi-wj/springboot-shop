package com.example.shop.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5util {
    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String password) {
        String hashAlgorithName = "MD5";
        int hashIterations = 1;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes("shop2020");//加盐
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        return obj.toString();
    }

    public static void main(String[] args) {
        System.out.println(md5("111111"));
    }
}

