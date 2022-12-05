package com.FoodTracker.FoodTracker;

public class Utilizator extends OnlineFoodTrackSystem{
         int id;
         String nume, prenume, email,parola, adresa, telefon;
    public Utilizator(){
        super();
        id = 0;
        nume = " ";
        prenume = " ";
        email = " ";
        parola = " ";
        adresa = " ";
        telefon = " ";
    }
    public Utilizator(int id, String nume, String prenume, String email, String parola, String adresa, String telefon,String user,String pass) {
       super(user, pass);
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
        this.telefon = telefon;
    }
public boolean Verificare(){
        return true;
}

}
