package com.sxd.login.service;

import com.sxd.exception.InvalidSmsCodeException;
import com.sxd.exception.PasswordIncorrectException;
import com.sxd.exception.UserNotFoundException;
import com.sxd.login.mapper.UserMapper;
import com.sxd.login.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmsService smsService;

    @Transactional
    public Integer register(String phone, String verificationCode, String password) {
        Optional<User> existingUser = userMapper.findByPhone(phone);
        if (existingUser.isPresent()) {
            throw new RuntimeException("手机号已被注册");
        }

        if (!smsService.verifyCode(phone, verificationCode)) {
            throw new RuntimeException("验证码错误");
        }

        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        return userMapper.save(user);
    }

    public User login(String phone, String passwordOrCode, boolean isPasswordLogin) {

        User user = userMapper.findByPhone(phone)
                .orElseThrow(UserNotFoundException::new);

        if (isPasswordLogin) {
            if (!passwordOrCode.equals(user.getPassword())) {
                throw new PasswordIncorrectException();
            }
        } else {
            if (!smsService.verifyCode(phone, passwordOrCode)) {
                throw new InvalidSmsCodeException();
            }
        }

        return user;
    }

    public void sendVerificationCode(String phone) {
        String verificationCode = smsService.generateVerificationCode();
        smsService.sendSms(phone, verificationCode);
        smsService.storeVerificationCode(phone, verificationCode);
    }
}
