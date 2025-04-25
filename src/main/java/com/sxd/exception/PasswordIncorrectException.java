package com.sxd.exception;

public class PasswordIncorrectException extends BusinessException {
    public PasswordIncorrectException() {
        super(10002, "密码错误");
    }
}