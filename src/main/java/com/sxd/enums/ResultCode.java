package com.sxd.enums;

public enum ResultCode {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问");

    private final int code;
    private final String message;

    // 构造函数
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 获取状态码
    public int getCode() {
        return code;
    }

    // 获取消息
    public String getMessage() {
        return message;
    }
}
