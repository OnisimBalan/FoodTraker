package com.FoodTracker.FoodTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class HomeController {
    @GetMapping(path = "/home")
    public String Home() {
        return "/WEB-INF/jsp/home.jsp";
    }
}
