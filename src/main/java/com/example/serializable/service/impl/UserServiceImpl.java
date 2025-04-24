package com.example.serializable.service.impl;

import com.example.serializable.model.User;
import com.example.serializable.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public void saveUser(User user) {
        System.out.println("Saving user: " + user);
    }
}

