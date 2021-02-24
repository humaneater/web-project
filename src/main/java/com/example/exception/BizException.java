package com.example.exception;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 14:02
 */
public class BizException extends Exception{

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
