package com.example.dao;

import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 15:31
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    void context() {
        User user = new User();
        user.setName("hhaaaaha");
        List<User> users = userMapper.selectByName(user);
        for (User user1 : users) {
            System.out.println(user1.getId());
        }
    }
}
