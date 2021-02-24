package com.example.enumerate;

/**
 * @author : lqy
 * @Date : 2021/2/23 17:17
 */
public enum GenderEnum {
    man(1,"男"),
    woman(0,"女");

    private int code;
    private String gender;

    GenderEnum(int code, String gender) {
        this.code = code;
        this.gender = gender;
    }

    public int getCode() {
        return code;
    }

    public String getGender() {
        return gender;
    }
}
