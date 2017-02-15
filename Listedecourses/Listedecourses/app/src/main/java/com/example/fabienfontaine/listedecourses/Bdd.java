package com.example.fabienfontaine.listedecourses;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fabien.fontaine on 15/02/2017.
 */

public class Bdd extends SQLiteOpenHelper {

    //Table Magasin
    private static final String TABLE_MAGASIN = "Magasins";
    private static final String COL_ID_MAGASIN = "_id";
    private static final String COL_NOM_MAGASIN = "nom";


    private static final String CREATE_TABLE_MAGASIN = "CREATE TABLE " + TABLE_MAGASIN + " ("
            + COL_ID_MAGASIN + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_MAGASIN + "TEXT );";

    //Table Produit
    private static final String TABLE_PRODUIT = "Produits";
    private static final String COL_ID_PRODUIT = "id_produit";
    private static final String COL_CATEGORIE = "categorie";
    private static final String COL_NOM_PRODUIT = "nom";
    private static final String COL_CODE = "code";

    private static final String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT + " ("
            + COL_ID_PRODUIT + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_CATEGORIE + "INTEGER, "
            + COL_NOM_PRODUIT + "TEXT NOT NULL, "
            + COL_CODE + "TEXT );";

    //Table Vendeur
    private static final String TABLE_VEND = "Vendeur";
    private static final String COL_PRIX = "prix";
    private static final String COL_UNITE = "unite";
    private static final String COL_RAYON = "rayon";
    private static final String COL_PROMOTION = "promotion";

    private static final String CREATE_TABLE_VEND = "CREATE TABLE " + TABLE_VEND + " ("
            + COL_ID_PRODUIT + "INTEGER PRIMARY KEY, "
            + COL_ID_MAGASIN + "INTEGER PRIMARY KEY, "
            + COL_PRIX + "FLOAT, "
            + COL_UNITE +"TEXT NOT NULL, "
            + COL_RAYON +"TEXT, "
            + COL_PROMOTION +"TEXT "
            + "FOREIGN KEY("+COL_ID_PRODUIT+") REFERENCES "+TABLE_PRODUIT+"("+COL_ID_PRODUIT+"), "
            + "FOREIGN KEY("+COL_ID_MAGASIN+") REFERENCES "+TABLE_MAGASIN+"("+COL_ID_MAGASIN+") "
            +" );";

    //Table Liste
    private static final String TABLE_LISTE = "Listes";
    private static final String COL_ID_LISTE = "_id";
    private static final String COL_QUANTITE = "quantite";
    private static final String COL_ACHETE = "achete";

    private static final String CREATE_TABLE_LISTE = "CREATE TABLE " + TABLE_LISTE + " ("
            + COL_ID_LISTE + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_PRODUIT + "INTEGER PRIMARY KEY, "
            + COL_ID_MAGASIN + "INTEGER PRIMARY KEY, "
            + COL_QUANTITE + "FLOAT, "
            + COL_ACHETE +"FLOAT"
            + "FOREIGN KEY("+COL_ID_PRODUIT+") REFERENCES "+TABLE_VEND+"("+COL_ID_PRODUIT+"), "
            + "FOREIGN KEY("+COL_ID_MAGASIN+") REFERENCES "+TABLE_VEND+"("+COL_ID_MAGASIN+") "
            +" );";
    

    public Bdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public Bdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLE_PRODUIT);
        db.execSQL(CREATE_TABLE_MAGASIN);
        db.execSQL(CREATE_TABLE_VEND);
        db.execSQL(CREATE_TABLE_LISTE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
