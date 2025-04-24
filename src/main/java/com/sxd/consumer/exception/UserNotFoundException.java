package com.sxd.consumer.exception;

// 具体业务异常
public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(10001, "用户不存在");
    }
}
