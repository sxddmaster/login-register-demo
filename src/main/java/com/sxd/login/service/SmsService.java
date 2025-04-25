package com.sxd.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SmsService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String VERIFICATION_CODE_PREFIX = "sms:code:";

    public String generateVerificationCode() {
        return String.valueOf((int) (Math.random() * 1000000));
    }

    public void sendSms(String phone, String verificationCode) {
        // 发送短信逻辑
    }

    public boolean verifyCode(String phone, String code) {
        String redisKey = VERIFICATION_CODE_PREFIX + phone;
        String storedCode = redisTemplate.opsForValue().get(redisKey);
        return code.equals(storedCode);
    }

    public void storeVerificationCode(String phone, String code) {
        String redisKey = VERIFICATION_CODE_PREFIX + phone;
        redisTemplate.opsForValue().set(redisKey, code, 1, TimeUnit.MINUTES);
    }
}