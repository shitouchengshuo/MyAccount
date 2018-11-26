package com.qiqi.testJava8;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ZhaoQiqi on 2018/11/9.
 */
@Data
public class User {

    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //自定义的静态的比较方法(用于 7.自定义静态的比较方法来排序)
    public static int compareByAgeThenName(User user1, User user2) {
        if (user1.age.equals(user2.age)) {
            return user1.name.compareTo(user2.name);
        } else {
            return user1.age.compareTo(user2.age);
        }
    }
    @Override
    public String toString() {
        return "++++++++++"+"age"+age+":"+name+"++++++++++";
    }
}
