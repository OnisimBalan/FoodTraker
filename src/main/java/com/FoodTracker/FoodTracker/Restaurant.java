package com.FoodTracker.FoodTracker;

import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    int rId;
    String name,address, descriere, meniu;

    public Restaurant(){
        this.rId = 0;
        this.name =" ";
        this.address =" ";
        this.descriere = " ";
        this.meniu = " ";
    }
    public Restaurant(int rId, String name, String address, String descriere, String meniu){
        this.rId = rId;
        this.name = name;
        this.address = address;
        this.descriere = descriere;
        this.meniu = meniu;

    }

    public boolean PreluareComanda(){
        return true;
    }
    public boolean PreparareComanda(){
        return true;
    }
    public boolean TrimiteComanda(){
        return false;
    }
    public boolean StergeComanda(){
        return false;
    }
}
