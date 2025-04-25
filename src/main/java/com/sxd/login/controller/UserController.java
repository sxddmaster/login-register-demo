package com.sxd.login.controller;

import com.sxd.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    UserService userService;


    /**
     * 注册
     * @param phone
     * @param verificationCode
     * @param password
     * @return
     */
    @GetMapping("register")
    public String register(@RequestParam String phone,
                           @RequestParam String verificationCode,
                           @RequestParam String password){
        userService.register(phone, verificationCode, password);
        ResponseEntity.ok().body("<UNK>");
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
     * @param phone
     * @return
     */
    @PostMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestParam String phone) {

        userService.sendVerificationCode(phone);
        Map<String, String> resp = new HashMap<>();
        resp.put("message", "验证码已发送");
        return ResponseEntity.ok(resp);

    }
}
