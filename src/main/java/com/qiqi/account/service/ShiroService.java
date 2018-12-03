package com.qiqi.account.service;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhaoQiqi on 2018/11/26.
 */
@Service
public class ShiroService {

    private static final Logger logger = Logger.getLogger(ShiroService.class);

    @RequiresRoles({"admin"})  //表示当前Subject需要角色admin
    public void testMethod(){
        System.out.println("testMethod,time:"
                +new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));

        //Shiro的Session能在Service层获取数据
        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("test");

        System.out.println("Service SessionVal: "+val);
    }

}
