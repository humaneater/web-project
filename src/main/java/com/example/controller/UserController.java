package com.example.controller;

import com.example.enumerate.StatusCode;
import com.example.pojo.UserModel;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 14:14
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public Object login(@RequestBody UserModel userModel) {
        if (checkUser(userModel)) {
            return userService.login(userModel);
        }else {
            return new Object(){
                String message = StatusCode.FAILED.toString();
            };
        }
    }

    private Boolean checkUser(UserModel userModel) {
        if (Objects.isNull(userModel.getId())
                || Objects.isNull(userModel.getName())
                || Objects.isNull(userModel.getPassword())) {
            return false;
        }
        return true;
    }
}
