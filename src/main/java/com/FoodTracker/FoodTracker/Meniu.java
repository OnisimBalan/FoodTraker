package com.FoodTracker.FoodTracker;

public class Meniu extends Restaurant{
    String dish;
    int timp;
    public Meniu(String dish, int timp,int id, String name, String address, String descriere, String meniu){
        super(id,name,address,descriere,meniu);
        this.dish = dish;
        this.timp = timp;
    }

    public boolean Preparare() {
    return false;
    }
}
