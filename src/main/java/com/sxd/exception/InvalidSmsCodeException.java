package com.sxd.exception;

public class InvalidSmsCodeException extends BusinessException {
    public InvalidSmsCodeException() {
        super(10004, "验证码错误");
    }
}