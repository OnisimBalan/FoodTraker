package com.FoodTracker.FoodTracker.controller;

import com.FoodTracker.FoodTracker.FoodTrackerUtils;
import com.FoodTracker.FoodTracker.controller.models.LoginData;
import models.UserModel;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

@RestController
@RequestMapping(path = "/")
public class AuthController {
    @PostMapping(path = "/authenticate")
    public boolean Login(@RequestBody LoginData data) {
        data.Password = FoodTrackerUtils.HashPassword(data.Password);
        if (data.Password == null)
            return false;

        UserRepository repo = new UserRepository();
        UserModel user = repo.FindUserByEmailAndPassword(data.Email, data.Password);
        if (user != null) {
            //auth success
        } else {
            // auth fail
        }
        return user != null;
    }
}
