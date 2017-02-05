package com.example.fabienfontaine.listedecourses;

//modele
public class Prods {
    private int color;
    private String emplacement;
    private String description;


    Prods(int color, String emplacement, String description) {
        this.color = color;
        this.emplacement = emplacement;
        this.description = description;
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
}
