package com.example.serializable.controller.failure;

import com.example.serializable.model.UserNotSerializable;
import com.example.serializable.service.impl.RedisJdkUserNotSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/failure/redis")
public class FailureRedisUserNotSerController {

    @Autowired
    @Qualifier("redisJdkUserNotSerService")
    private RedisJdkUserNotSerService redisJdkUserNotSerService;

    @PostMapping("/save")
    public String saveUserNotSerializable(@RequestBody UserNotSerializable userNotSerializable) {
        redisJdkUserNotSerService.saveUserNotSerializable(userNotSerializable);
        return "User saved to Redis!";
    }

    @GetMapping("/get/{id}")
    public UserNotSerializable getUserNotSerializable(@PathVariable long id) {
        return redisJdkUserNotSerService.getUserNotSerializable(id);
    }
}

