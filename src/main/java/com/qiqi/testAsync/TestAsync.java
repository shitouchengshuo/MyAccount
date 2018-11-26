package com.qiqi.testAsync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;

/**
 * Created by ZhaoQiqi on 2018/11/13.
 * Spring为任务调度与异步方法执行提供了注解支持。通过在方法上设置@Async注解，可使得方法被异步调用。
 * 也就是说调用者会在调用时立即返回，而被调用方法的实际执行是交给Spring的TaskExecutor来完成。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
public class TestAsync {
    @Autowired
    private TestAsyncBean testAsyncBean;
    @Test
    public void test_sayHello3() throws InterruptedException, ExecutionException {
        System.out.println("你不爱我了么?");
        testAsyncBean.sayHello3();
        System.out.println("你竟无话可说, 我们分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
    }
}
