package com.example.serializable.controller.failure;

import com.example.serializable.model.UserNotSerializable;
import com.example.serializable.service.UserNotSerializableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@RestController
@RequestMapping("/api/failure/user")
public class FailureUserNotSerController {

    @Autowired
    private UserNotSerializableService userService;


    @PostMapping("/save")
    public String saveUser(@RequestBody UserNotSerializable userNotSerializable) throws Exception {

        // Although the saveUser() call appears first in code, the associated @Before aspect executes before the actual method body.
        // This happens because Spring uses a proxy to intercept method calls and invoke aspect logic (like logging) beforehand.
        // As a result, the console will first display the @Before log, followed by the actual service logic and controller log.
        userService.saveUserNotSerializable(userNotSerializable);
        System.out.println("→ Service: running");


        FileOutputStream fileOut = new FileOutputStream("user.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(userNotSerializable);
        out.close();
        fileOut.close();
        return "User serialized and saved successfully!";
    }

    @GetMapping("/load")
    public UserNotSerializable loadUser() throws Exception {
        FileInputStream fileIn = new FileInputStream("user.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        UserNotSerializable userNotSerializable = (UserNotSerializable) in.readObject();
        in.close();
        fileIn.close();
        return userNotSerializable;
    }
}