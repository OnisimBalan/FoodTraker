package com.FoodTracker.FoodTracker.controller;

import com.FoodTracker.FoodTracker.FoodTrackerUtils;
import com.FoodTracker.FoodTracker.controller.models.CreateUserModel;
import jakarta.xml.bind.DatatypeConverter;
import models.UserModel;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import java.security.MessageDigest;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @PostMapping(path = "/create")
    public boolean CreateNewUser(@RequestBody CreateUserModel data) {
        data.Password = FoodTrackerUtils.HashPassword(data.Password);
        if (data.Password == null)
            return false;

        UserRepository repo = new UserRepository();
        return repo.CreateUser(data.Password, data);
    }
}
