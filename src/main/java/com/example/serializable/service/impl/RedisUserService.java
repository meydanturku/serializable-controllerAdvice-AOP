package com.example.serializable.service.impl;

import com.example.serializable.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUserService {

    @Autowired
    @Qualifier("jdkRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(String.valueOf(user.getId()), user);
    }

    public User getUser(long id) {
        return (User) redisTemplate.opsForValue().get(String.valueOf(id));
    }
}

