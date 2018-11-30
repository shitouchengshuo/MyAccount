package com.qiqi.account.shiro.model;

import lombok.Data;

/**
 * Created by ZhaoQiqi on 2018/11/29.
 */
@Data
public class User {
    private String username;
    private String password;
    private boolean Locked;
    public User(String username, String password, boolean locked) {
        super();
        this.username = username;
        this.password = password;
        Locked = locked;
    }

}
