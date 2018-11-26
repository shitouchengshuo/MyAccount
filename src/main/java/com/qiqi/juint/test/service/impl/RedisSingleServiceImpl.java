package com.qiqi.juint.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.qiqi.testJava8.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //声明一个ApplicationContext集成测试加载WebApplicationContext，作用是模拟ServletContext
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
@Service
public class RedisSingleServiceImpl {

    private static final Logger logger = Logger.getLogger(RedisSingleServiceImpl.class);

    @Test
    public void JedisTestMain() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-application.xml");
        JedisPool jedisPool = (JedisPool) context.getBean("redisClient");
        Jedis jedis = jedisPool.getResource();
        jedis.set("key1", "1121222");
        jedis.set("key1", "1111");
        jedis.set("key1", "1111");
        jedis.set("key1", "1111");

        User user = new User("滴滴",12);
        jedis.set("key1", JSON.toJSONString(user));
        String str = jedis.get("key1");
        System.out.println("--:" + str);
        jedis.close();
        jedisPool.close();
        }
}
