package com.qiqi.testAsync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by ZhaoQiqi on 2018/11/13.
 */
@Component
public class TestAsyncBean {
    @Async
    public void sayHello3() throws InterruptedException {
        Thread.sleep(2 * 1000);//网络连接中 。。。消息发送中。。。
        System.out.println("我爱你啊!");
    }
}
