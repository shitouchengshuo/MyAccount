package com.qiqi.account.utils;

import com.qiqi.account.shiro.model.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import java.util.Iterator;

/**
 * 以userName作为盐值对密码进行MD5加密，返回加密后的密码
 */
public class SaltAndMD5Util {
    public final static Object SaltAndMD5(String userName,String password) {
        try {
            String hashAlgorithmName = "MD5";//加密方式
            ByteSource salt = ByteSource.Util.bytes(userName);//以账号作为盐值
            int hashIterations = 1024;//加密1024次
            Object result = new SimpleHash(hashAlgorithmName,password,salt,hashIterations);
            System.out.println(userName+":"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(SaltAndMD5Util.SaltAndMD5("77","123456"));
    }
}