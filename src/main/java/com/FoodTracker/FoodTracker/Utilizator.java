package com.FoodTracker.FoodTracker;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Utilizator extends OnlineFoodTrackSystem{
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "customer_sequence",
            strategy = GenerationType.SEQUENCE
    )
        private Long id;
         String nume, prenume, email,parola, adresa, telefon;
    public Utilizator(){
        super();
        nume = " ";
        prenume = " ";
        email = " ";
        parola = " ";
        adresa = " ";
        telefon = " ";
    }
    public Utilizator( String nume, String prenume, String email, String parola, String adresa, String telefon,String user,String pass) {
       super(user, pass);
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

    public Long getId() {
        return id;
    }
}
