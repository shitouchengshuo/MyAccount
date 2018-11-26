package com.qiqi.juint.test.controller;

import com.qiqi.juint.test.model.User;
import com.qiqi.juint.test.model.vo.UserVO;
import com.qiqi.juint.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "jsp1",method = RequestMethod.GET)
    public String getJsp( ){
        return "test";
    }


    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getUserInfo(@RequestParam Integer age){
        return userService.getUserInfo(age);
    }

    @RequestMapping(value = "insertUser", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
}
