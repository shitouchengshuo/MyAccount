package com.qiqi.testJava8;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by ZhaoQiqi on 2018/11/10.
 */
public class a {
    //自定义一个test方法
    public static void test(int value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }
    public static void main(String[] args) {
        //List

        //这里，Consumer消费型函数式接口代表了接受一个输入参数并且无返回的操作
        //(x) -> System.out.println(x * 2)代表接受一个输入参数x，这里 x=3
        //可以使用lambda表达式，输出结果为6
        test(3, (x) -> System.out.println(x * 2));
    }
}
