package com.qiqi.juint.test.model.common;

import lombok.Data;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */

@Data
public class Response<T> {

    private int status;
    private String description;
    private T data;

    public Response() {

    }
    public Response(int status, String description, T data) {
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public String toString(){
        return "status:"+status+"  "+"description:"+description+"  "+"data："+data;
    }
}
