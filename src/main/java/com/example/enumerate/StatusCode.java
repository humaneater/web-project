package com.example.enumerate;

/**
 * @author : lqy
 * @Date : 2021/2/23 17:24
 */
public enum StatusCode {
    NOT_FOUND(404,"404 not found"),
    SUCCESS(200,"success"),
    FAILED(500,"FAILED");

    private int code;
    private  String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
