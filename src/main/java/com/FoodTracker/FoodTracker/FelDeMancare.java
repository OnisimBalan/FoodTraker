package com.FoodTracker.FoodTracker;

public class FelDeMancare extends Restaurant{
    int id;
    String nume, ingrediente;
    double cantitate, pret;
    public FelDeMancare(){
        super();
        nume  = " ";
        ingrediente  = " ";
        cantitate = 0;
        pret = 0;
    }
    public FelDeMancare(String nume, String ingrediente, double cantitate,double pret,int id, String name, String address, String descriere, String meniu){
        super(id,name,address,descriere,meniu);
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.cantitate = cantitate;
        this.pret = pret;
    }
}
