package com.qiqi.account.service;

import com.alibaba.fastjson.JSON;
import com.qiqi.account.dao.AccountVerifyCodeMapper;
import com.qiqi.account.exception.GetVerificationCodeFaliureException;
import com.qiqi.account.exception.ParameterErrorException;
import com.qiqi.account.exception.VerificationCodeRequestTooFastException;
import com.qiqi.account.exception.VerificationCodeRequestTooMuchException;
import com.qiqi.account.model.TbAccountVerifyCode;
import com.qiqi.account.utils.TimeUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import java.util.Date;


/**
 * Created by ZhaoQiqi on 2018/11/26.
 */
@Service
public class TestService {

    private static final Logger logger = Logger.getLogger(TestService.class);
    private final static int verificationCodeKeepSecond = 60; //验证码超时时间60秒
    private final static int verificationCodeExpireSecond = 1800;//验证码过期时间半小时
//    @Autowired
//    private AccountVerifyCodeMapper accountVerifyCodeMapper;


    /**
      测试
    @RequiresRoles({"admin"})  //表示当前Subject需要角色admin
    public void testMethod(){
        System.out.println("testMethod,time:"
                +new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));

        //Shiro的Session能在Service层获取数据
        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("test");

        System.out.println("Service SessionVal: "+val);
    }
     *
     */
}
