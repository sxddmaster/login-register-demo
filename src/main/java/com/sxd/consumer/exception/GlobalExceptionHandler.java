package com.sxd.consumer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // 或根据code返回不同状态码
                .body(new ErrorResponse(ex.getCode(), ex.getMessage()));
    }

//    @ExceptionHandler({VerificationCodeException.class, PasswordMismatchException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Map<String, Object> handleBadRequest(RuntimeException ex) {
//        return Map.of("code", 400, "message", ex.getMessage());
//    }

    @Data
    @AllArgsConstructor
    private static class ErrorResponse {
        private int code;
        private String message;
    }
}