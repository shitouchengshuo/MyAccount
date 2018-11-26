package com.qiqi.juint.test.service.impl;

import com.qiqi.juint.test.dao.UserMapper;
import com.qiqi.juint.test.model.User;
import com.qiqi.juint.test.model.vo.UserVO;
import com.qiqi.juint.test.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    public List<UserVO> getUserInfo(Integer age) {

        logger.info("调用方法getUserInfo(Integer age)");
        return userMapper.getUserInfo(age);
    }

    public void insertUser(User user) {
        userMapper.inserUser(user);
    }

    @Test
    public void test(){

        boolean exist = userMapper.exist(12);
        System.out.println("exist:  "+exist);

        int userNumbers = userMapper.getUserNumbers(12);
        System.out.println("userNumbers: "+userNumbers);

        List<UserVO> list = userMapper.getUserInfo(12);
        list.forEach(user-> System.out.println(user));

        boolean existAge100 = userMapper.exist(100);
        System.out.println("existAge100:  "+existAge100);
    }
}
