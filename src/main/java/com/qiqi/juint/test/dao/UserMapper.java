package com.qiqi.juint.test.dao;

import com.qiqi.juint.test.model.User;
import com.qiqi.juint.test.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */
@Repository
public interface UserMapper {

    List<UserVO> getUserInfo(@Param("age") Integer age);

    void inserUser(@Param("user") User user);

    boolean exist(@Param("age") Integer age);

    int getUserNumbers(@Param("age") Integer age);
}
