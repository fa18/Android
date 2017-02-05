package com.example.fabienfontaine.listedecourses;

//modele
public class Prods {
    private int color;
    private String emplacement;
    private String description;
    private String nom;


    Prods(int color, String emplacement, String description) {
        this.color = color;
        this.emplacement = emplacement;
        this.description = description;
    }

    Prods(String nom,int color, String emplacement, String description) {
        this.color = color;
        this.emplacement = emplacement;
        this.description = description;
        this.nom=nom;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
