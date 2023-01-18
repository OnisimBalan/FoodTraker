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
public class CustomerController {
    @PostMapping("/newUser")
    public boolean CreateNewUser(@RequestBody UserModel data) {
        UserModel user = new UserModel();
        user.FirstName =  data.FirstName;
        user.LastName = data.LastName;
        user.Email = data.Email;
        user.PhoneNumber = data.PhoneNumber;
        user.Address = data.Address;
        user.Password = FoodTrackerUtils.HashPassword(data.Password);
        UserRepository repo = new UserRepository();

        repo.CreateUser(user);
        return true;
    }
}
