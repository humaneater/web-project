package com.example;

import com.example.dao.UserModelMapper;
import com.example.pojo.UserModel;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.dao")
class WebprojectApplicationTests {
    @Autowired
    UserModelMapper userModelMapper;

    @Test
    void contextLoads() {
//        int i = userModelMapper.add(new UserModel("hhaha","asdf",12,0));
//        userModelMapper.add(new UserModel("aa","asdf",12,0));
//        userModelMapper.add(new UserModel("hhaaaaha","asdf",12,0));
//        userModelMapper.add(new UserModel("haaahaha","asdf",12,0));
//        userModelMapper.add(new UserModel("haaahaha","asdf",12,0));
//        int i = userModelMapper.delete(4);
//          int i = userModelMapper.update(new UserModel("233","jwsts",12,0),5);
        List<UserModel> selectDemo = userModelMapper.selectAll();
        for (UserModel user:selectDemo
             ) {
            System.out.println(user.getName());
        };

    }

}
