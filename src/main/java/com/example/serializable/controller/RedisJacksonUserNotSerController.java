package com.example.serializable.controller;

import com.example.serializable.model.UserNotSerializable;
import com.example.serializable.service.RedisUserNotSerService;
import com.example.serializable.service.impl.RedisJdkUserNotSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis/jackson")
public class RedisJacksonUserNotSerController {


    @Autowired
    @Qualifier("redisJacksonUserNotSerService")
    private RedisUserNotSerService redisUserNotSerService;

    @PostMapping("/save")
    public String saveUserNotSerializable(@RequestBody UserNotSerializable userNotSerializable) {
        redisUserNotSerService.saveUserNotSerializable(userNotSerializable);
        return "User saved to Redis!";
    }

    @GetMapping("/get/{id}")
    public UserNotSerializable getUserNotSerializable(@PathVariable long id) {
        return redisUserNotSerService.getUserNotSerializable(id);
    }
}

