package com.FoodTracker.FoodTracker;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.security.Principal;

@RestController
@RequestMapping(path = "/")
public class FunctionsController {
    //    Utilizator utilizator = new Utilizator("asd", "", "a", "asd4", "asd5");
//
    @PostMapping(path = "/newUser")
    public String postData(Model model) {
//        model.addAttribute("newUser", utilizator);
//        System.out.println(utilizator.nume);
//        return utilizator.nume;

        return "asdasdasd";
    }
//
//    @PostMapping(path = "/addUser")
//    public Integer adaugaUtilizator(Model model, Principal principal) {
//
//        int response = 0;
//        model.addAttribute("user", utilizator);
//
//        if (utilizator.email.equals("asd2@gmail.com")) {
//            response = 1;
//        }
//        return response;
//    }
//
//    @PostMapping(path = "/getUser")
//    public Integer GetData(Model model) {
//        Utilizator utilizator1 = new Utilizator();
//        model.addAttribute("loginUser", utilizator1);
//        int response = 0;
//        if (utilizator.email.length() == utilizator1.email.length()) {
//            response = 1;
//        }
//        return response;
//    }
}