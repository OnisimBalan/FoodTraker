package com.FoodTracker.FoodTracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    int rId;
    String name,address, descriere;
    Meniu meniu;

    public Restaurant(){
        this.rId = 0;
        this.name =" ";
        this.address =" ";
        this.descriere = " ";
    }
    public Restaurant(int rId, String name, String address, String descriere){
        this.rId = rId;
        this.name = name;
        this.address = address;
        this.descriere = descriere;;

    }
    public boolean TrimiteComanda(){
        return false;
    }
    public boolean StergeComanda(){
        return false;
    }
}
