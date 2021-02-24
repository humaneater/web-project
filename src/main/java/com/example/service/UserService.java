package com.example.service;

import com.example.dao.UserModelMapper;
import com.example.enumerate.GenderEnum;
import com.example.enumerate.StatusCode;
import com.example.exception.BizException;
import com.example.pojo.UserModel;
import com.example.request.UserRequest;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 11:59
 */
@Service
public class UserService {
    @Autowired
    UserModelMapper userModelMapper;
    public Object login(UserModel userModel) {
        UserModel user = userModelMapper.selectOne(userModel.getId());
        if (Objects.isNull(user)) {
            try {
                throw new BizException("用户不存在，登录失败");
            } catch (BizException e) {
                e.printStackTrace();
            }
            return StatusCode.FAILED;
        }
        if (Objects.equals(user.getPassword(), userModel.getPassword())
                && Objects.equals(user.getName(), userModel.getName())) {
            return new Object(){
                String username = userModel.getName();
                Integer age = userModel.getAge();
                String gender = GenderEnum.getGender(userModel.getGender());
            };
        }else {
            try {
                throw new BizException("账号或密码错误，请重试");
            } catch (BizException e) {
                e.printStackTrace();
                return StatusCode.FAILED;
            }
        }

    }
    public void updateToken(UserRequest userRequest, String token) {
        RedisUtil.put(userRequest.getId().toString(),token);
    }

//    public StatusCode logout() {
//
//    }
//
//    public StatusCode register() {
//
//    }
}
