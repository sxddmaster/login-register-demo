package com.sxd.consumer.controller;

import com.sxd.consumer.mapper.UserMapper;
import com.sxd.consumer.model.entity.User;
import com.sxd.consumer.service.SmsService;
import com.sxd.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping("register")
    public String register(@RequestParam String phone,
                           @RequestParam String verificationCode,
                           @RequestParam String password){
        userService.register(phone, verificationCode, password);
        return "注册成功";
    }

    /**
     * 登陆
     * @param phone 手机号
     * @param passwordOrCode 获取验证码
     * @param isPasswordLogin 是否是密码登陆
     * @return
     */
    @GetMapping("login")
    public String login(@RequestParam String phone,
                           @RequestParam String passwordOrCode,
                           @RequestParam boolean isPasswordLogin){
        userService.login(phone, passwordOrCode, isPasswordLogin);
        return "登陆成功";
    }

    /**
     * 发送验证码
     * URL: POST /auth/sendCode?phone=13800000000
     */
    @PostMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestParam String phone) {

        userService.sendVerificationCode(phone);
        Map<String, String> resp = new HashMap<>();
        resp.put("message", "验证码已发送");
        return ResponseEntity.ok(resp);

    }
}
