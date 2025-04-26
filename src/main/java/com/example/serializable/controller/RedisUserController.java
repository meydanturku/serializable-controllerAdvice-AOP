package com.example.serializable.controller;

import com.example.serializable.model.User;
import com.example.serializable.service.impl.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis/user")
public class RedisUserController {

    @Autowired
    private RedisUserService redisUserService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        redisUserService.saveUser(user);
        return "User saved to Redis!";
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        return redisUserService.getUser(id);
    }
}

