package com.FoodTracker.FoodTracker;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api/functions")
public class FunctionsController {
    public String data;
    @GetMapping(path = "/index.html")
    public String Hello0(){
        return "Working0";
    }
     @GetMapping(path = "/")
    public String StartPage(){
        return "index.html";
    }
    @PostMapping(path = "/post")
    public String postData(@RequestBody @Validated String data1){
        data = data1;
        String feedback = "Success!";
        return feedback;
    }
    @GetMapping(path ="/get")
    public String GetData(){
        return data;
    }
}
