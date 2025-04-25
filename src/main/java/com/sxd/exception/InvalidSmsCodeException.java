package com.sxd.exception;

public class InvalidSmsCodeException extends BusinessException {
    public InvalidSmsCodeException() {
        super(10003, "验证码错误");
    }
}