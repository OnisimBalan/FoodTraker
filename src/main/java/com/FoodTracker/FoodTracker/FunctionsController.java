package com.FoodTracker.FoodTracker;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/")
public class FunctionsController {
    Utilizator utilizator =  new Utilizator();
    @PostMapping(path = "/post")
    public String postData(@RequestBody @Validated Utilizator utilizator1){
        utilizator = utilizator1;
        String feedback = "Success!";
        System.out.println(utilizator1);
        return feedback;
    }
    @PostMapping(path ="/adaugaUtilizator")
    public String adaugaUtilizator(@RequestBody @Validated String utilizator1){

        System.out.println(utilizator1);

        String feedback = "Success!";
        return feedback;
    }

    @GetMapping(path ="/getUser")
    public Utilizator GetData(){
        return utilizator;
    }
}