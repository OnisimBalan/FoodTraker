package com.FoodTracker.FoodTracker;

import java.util.List;

public class Meniu extends Restaurant{
    List<String> preparate;
    public Meniu(String preparat,int rId, String name, String address, String descriere) {
        super(rId, name, address, descriere);
            this.preparate.add(preparat);
    }
}
