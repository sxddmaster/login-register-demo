package com.sxd.exception;

public class PasswordIncorrectException extends BusinessException {
    public PasswordIncorrectException() {
        super(10003, "密码错误");
    }
}