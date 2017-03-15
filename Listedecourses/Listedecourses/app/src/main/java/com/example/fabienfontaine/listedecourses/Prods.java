package com.example.fabienfontaine.listedecourses;

//modele
public class Prods {
    private int color;
    private String emplacement;
    private String description;
    private String nom;
    private String prix;
    private String codeBarre;
    private String magasin;
    private float quantite;
    private String promotion;
    private String categorie;

    //pour insertion
    int numProduit;
    int idMagasin;



    public Prods() {

    }


    public Prods(int color, String nom, String description, String prix, String magasin, String emplacement, String codeBarre, float quantite, String categorie ,String promotion) {
        this.description = description;
        this.color = color;
        this.emplacement = emplacement;
        this.nom = nom;
        this.prix = prix +" €";
        this.codeBarre = codeBarre;
        this.magasin = magasin;
        this.quantite = quantite;
        this.categorie= categorie;
        this.promotion = promotion;
    }




    Prods(String nom,int color, String emplacement, String description,String prix) {
        this.color = color;
        this.emplacement = emplacement;
        this.description = description;
        this.nom=nom;
        this.prix=prix+" €";
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


    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public String getQuantite() {
        if (quantite == 0)
            return "Rupture de stock";
        else
            return "En stock : " + quantite + " unités";
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNumProduit() {
        return numProduit;
    }

    public void setNumProduit(int numProduit) {
        this.numProduit = numProduit;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }
}
