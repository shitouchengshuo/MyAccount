package com.qiqi.juint.test.model.vo;

import lombok.Data;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */

@Data
public class UserVO {

    private Long id;
    private Integer age;
    private String name;

    public UserVO(Long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:"+id+"  "+"age:"+age+"  "+"name:"+name;
    }
}
