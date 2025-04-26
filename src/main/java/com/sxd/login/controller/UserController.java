package com.sxd.login.controller;

import com.sxd.login.service.UserService;
import com.sxd.result.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {


    @Resource
    UserService userService;


    /**
     * 注册
     * @param phone 手机号
     * @param verificationCode 验证码
     * @param password 密码
     * @return 统一返回结果
     */
    @GetMapping("register")
    public ApiResponse<String> register(@RequestParam String phone,
                           @RequestParam String verificationCode,
                           @RequestParam String password){
        userService.register(phone, verificationCode, password);

        return ApiResponse.ok("注册成功，请重新登陆！---跳转页面");

    }

    /**
     * 登陆
     * @param phone 手机号
     * @param passwordOrCode 获取验证码
     * @param isPasswordLogin 是否是密码登陆
     * @return 统一返回结果
     */
    @GetMapping("login")
    public ApiResponse<String> login(@RequestParam String phone,
                           @RequestParam String passwordOrCode,
                           @RequestParam boolean isPasswordLogin){
        userService.login(phone, passwordOrCode, isPasswordLogin);
        return ApiResponse.ok("登陆成功");
    }

    /**
     * 发送验证码
     * @param phone 手机号
     * @return 统一返回结果
     */
    @PostMapping("/sendCode")
    public ApiResponse<String> sendCode(@RequestParam String phone) {

        userService.sendVerificationCode(phone);
        return ApiResponse.ok("验证码发送成功");

    }

}
