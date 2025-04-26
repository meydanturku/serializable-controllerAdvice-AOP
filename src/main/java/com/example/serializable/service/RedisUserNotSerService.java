package com.example.serializable.service;

import com.example.serializable.model.UserNotSerializable;

public interface RedisUserNotSerService {
    void saveUserNotSerializable(UserNotSerializable userNotSerializable);

    UserNotSerializable getUserNotSerializable(long id);
}
