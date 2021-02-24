package com.example.pojo;

import com.example.enumerate.GenderEnum;
import com.example.enumerate.StatusCode;

import java.io.Serializable;

/**
 * @author : lqy
 * @Date : 2021/2/23 17:13
 */
public class UserModel implements Serializable{
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private Integer gender;

    public UserModel() {
    }

    public UserModel( String name, String password, Integer age, Integer gender) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
