package com.example.serializable.service.impl;

import com.example.serializable.model.UserNotSerializable;
import com.example.serializable.service.RedisUserNotSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisJacksonUserNotSerService implements RedisUserNotSerService {

    @Autowired
    @Qualifier("JacksonRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public void saveUserNotSerializable(UserNotSerializable userNotSerializable) {
        redisTemplate.opsForValue().set(String.valueOf(userNotSerializable.getId()), userNotSerializable);
    }

    public UserNotSerializable getUserNotSerializable(long id) {
        return (UserNotSerializable) redisTemplate.opsForValue().get(String.valueOf(id));
    }
}

