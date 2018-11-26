package com.qiqi.testAsync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;

/**
 * Created by ZhaoQiqi on 2018/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
public class TestNoAsync {
    @Test
    public void test_sayHello4() throws InterruptedException, ExecutionException {
        System.out.println("你不爱我了么?");

        new TestnNoAsyncBean().sayHello4();
        System.out.println("回的这么慢, 你肯定不爱我了, 我们还是分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
    }
}
