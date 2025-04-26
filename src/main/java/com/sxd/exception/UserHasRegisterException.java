package com.sxd.exception;

// 具体业务异常
public class UserHasRegisterException extends BusinessException {
    public UserHasRegisterException() {
        super(10002, "用户已经注册");
    }
}
