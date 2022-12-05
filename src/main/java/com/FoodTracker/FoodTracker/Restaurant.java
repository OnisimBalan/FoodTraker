package com.FoodTracker.FoodTracker;

public class Restaurant {
    int id;
    String name,address, descriere, meniu;

    public Restaurant(){
        this.id = 0;
        this.name =" ";
        this.address =" ";
        this.descriere = " ";
        this.meniu = " ";
    }
    public Restaurant(int id, String name, String address, String descriere, String meniu){
        this.id = id;
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
