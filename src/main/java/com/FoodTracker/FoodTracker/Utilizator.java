package com.FoodTracker.FoodTracker;

public class Utilizator extends OnlineFoodTrackSystem{
        private Long id;
         String nume, email,parola, adresa, telefon;
    public Utilizator(){
        nume = " ";
        email = " ";
        parola = " ";
        adresa = " ";
        telefon = " ";
    }
    public Utilizator( String nume, String email, String parola, String adresa, String telefon) {
        this.nume = nume;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
        this.telefon = telefon;
    }
public boolean Verificare(){
        return true;
}

    public Long getId() {
        return id;
    }
}
