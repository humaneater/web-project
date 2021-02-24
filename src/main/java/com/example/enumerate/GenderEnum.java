package com.example.enumerate;

import java.util.Objects;

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

    public static String getGender(int code) {
        for (GenderEnum value : GenderEnum.values()) {
            if (Objects.equals(value.getCode(),code)) {
                return value.gender;
            }
        }
        return null;
    }
}
