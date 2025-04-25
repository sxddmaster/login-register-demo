package com.sxd.exception;

import com.sxd.result.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException ex) {
        ApiResponse response = ApiResponse.error()
                .code(400)
                .message(ex.getMessage());

        // 返回 ResponseEntity，设置状态码
        return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
    }
}