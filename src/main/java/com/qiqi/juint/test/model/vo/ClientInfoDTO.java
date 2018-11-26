package com.qiqi.juint.test.model.vo;

import java.util.HashMap;

/**
 * Created by ZhaoQiqi on 2018/11/16.
 */
public class ClientInfoDTO extends HashMap<String, String> {

    // app id  客户端标识
    public static final String appIdKey = "appId";
    // app type 客户端是否需要支持多终端登录
    public static final String appTypeKey = "app_type";

    public static final String groupIdKey = "group";

    public String getAppid() {
        return this.get(appIdKey);
    }

    public void setAppid(String appid) {
        this.put(appIdKey, appid);
    }

    public String getApp_type() {
        return this.get(appTypeKey);
    }

    public void setApp_type(String app_type) {
        this.put(appTypeKey, app_type);
    }

    public ClientInfoDTO() {
        super();
    }

    public ClientInfoDTO(String appid, String app_type, String group) {
        this.put(appIdKey, appid);
        this.put(appTypeKey, app_type);
        this.put(groupIdKey, group);
    }
}