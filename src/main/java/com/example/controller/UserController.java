package com.example.controller;

import com.example.enumerate.GenderEnum;
import com.example.enumerate.StatusCode;
import com.example.pojo.UserModel;
import com.example.request.UserRequest;
import com.example.service.UserService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 14:14
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody UserRequest userRequest, HttpServletResponse response) {
        if (verifyToken(userRequest)){
            String token = JwtUtil.createToken(userRequest.getId());
            userService.updateToken(userRequest, token);
            response.setHeader("token", token);

        }else {
            if (Objects.nonNull(userRequest.getId())){
                String token = JwtUtil.createToken(userRequest.getId());
                userService.updateToken(userRequest, token);
            }
        }
            if (checkUser(userRequest)) {
                return userService.login(userRequest);
            } else {
                return new Object() {
                    String message = StatusCode.FAILED.toString();
                };
            }
    }

    private Boolean verifyToken(UserRequest userRequest) {

        if (Objects.isNull(userRequest.getToken())) {
            return false;
        }
        return JwtUtil.verifyToken(userRequest.getToken(), userRequest.getId().toString());


    }

    private Boolean checkUser(UserRequest userRequest) {

        if (Objects.isNull(userRequest.getName()) || Objects.isNull(userRequest.getPassword())) {
            return false;
        }

        return true;
    }

}
