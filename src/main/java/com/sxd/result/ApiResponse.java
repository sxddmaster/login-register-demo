package com.sxd.result;

import com.sxd.enums.ResultCode;
import lombok.Data;

@Data
public class ApiResponse<T> { // 统一响应类，支持泛型
    private Integer code;     // 状态码
    private String message;   // 返回信息
    private T body;           // 返回数据，使用 T 直接返回实体对象

    private ApiResponse() {} // 私有构造方法，只能通过静态方法构建

    // 成功但不带数据的静态方法
    public static <T> ApiResponse<T> ok() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setMessage(ResultCode.SUCCESS.getMessage());
        return response;
    }

    // 成功并带数据的静态方法
    public static <T> ApiResponse<T> ok(T body) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setMessage(ResultCode.SUCCESS.getMessage());
        response.setBody(body);  // 直接设置返回数据
        return response;
    }

    // 失败但不带数据的静态方法
    public static <T> ApiResponse<T> error() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(ResultCode.ERROR.getCode());
        response.setMessage(ResultCode.ERROR.getMessage());
        return response;
    }


    // 链式编程方法
    public ApiResponse<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public ApiResponse<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ApiResponse<T> body(T body) {
        this.setBody(body);
        return this;
    }

}
