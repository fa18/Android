package com.example.fabienfontaine.listedecourses;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fabien.fontaine on 15/02/2017.
 */

public class Bdd extends SQLiteOpenHelper {

    //Table Magasin
    private static final String TABLE_MAGASIN = "Magasin";
    private static final String COL_ID_MAGASIN = "id_magasin";
    private static final String COL_NOM_MAGASIN = "nom";


    private static final String CREATE_TABLE_MAGASIN = "CREATE TABLE " + TABLE_MAGASIN + " ("
            + COL_ID_MAGASIN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_MAGASIN + " TEXT );";

    //Table Produit
    private static final String TABLE_PRODUIT = "Produit";
    private static final String COL_ID_PRODUIT = "id_produit";
    private static final String COL_CATEGORIE = "categorie";
    private static final String COL_NOM_PRODUIT = "nom_produit";
    private static final String COL_DESCRIPTION_PRODUIT = "description_produit";
    private static final String COL_CODE = "code";

    private static final String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT + " ("
            + COL_ID_PRODUIT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_CATEGORIE + " INTEGER, "
            + COL_NOM_PRODUIT + " TEXT NOT NULL, "
            + COL_DESCRIPTION_PRODUIT + " TEXT, "
            + COL_CODE + " TEXT );";

        //Insertion Produit
        final String Insert_Produit="INSERT INTO Produit (categorie,nom_produit,description_produit) VALUES('bricolage','marteau','pour enfoncer des clous')";

    //Table Vend
    private static final String TABLE_VEND = "Vendeur";
    private static final String COL_PRIX = "prix";
    private static final String COL_UNITE = "unite";
    private static final String COL_RAYON = "rayon";
    private static final String COL_PROMOTION = "promotion";

    private static final String CREATE_TABLE_VEND = "CREATE TABLE " + TABLE_VEND + " ("
            + COL_ID_PRODUIT + " INTEGER, "
            + COL_ID_MAGASIN + " INTEGER, "
            + COL_PRIX + " FLOAT, "
            + COL_UNITE +" TEXT NOT NULL, "
            + COL_RAYON +" TEXT, "
            + COL_PROMOTION +" TEXT "
            + ", PRIMARY KEY('id_magasin','id_produit')"
            + " FOREIGN KEY("+COL_ID_PRODUIT+") REFERENCES "+TABLE_PRODUIT+"("+COL_ID_PRODUIT+"), "
            + " FOREIGN KEY("+COL_ID_MAGASIN+") REFERENCES "+TABLE_MAGASIN+"("+COL_ID_MAGASIN+") "
            +" );";

    //Table Liste
    private static final String TABLE_LISTE = "Listes";
    private static final String COL_ID_LISTE = "_id";
    private static final String COL_QUANTITE = "quantite";
    private static final String COL_ACHETE = "achete";

    private static final String CREATE_TABLE_LISTE = "CREATE TABLE " + TABLE_LISTE + " ("
            + COL_ID_LISTE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_PRODUIT + " INTEGER, "
            + COL_ID_MAGASIN + " INTEGER, "
            + COL_QUANTITE + " FLOAT, "
            + COL_ACHETE +" FLOAT"
            + ", PRIMARY KEY(`id_magasin`,`id_produit`)"
            + " FOREIGN KEY("+COL_ID_PRODUIT+") REFERENCES "+TABLE_VEND+"("+COL_ID_PRODUIT+"), "
            + " FOREIGN KEY("+COL_ID_MAGASIN+") REFERENCES "+TABLE_VEND+"("+COL_ID_MAGASIN+") "
            +" );";


    public Bdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "listeCourse.db", null, 1);

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
        db.execSQL(Insert_Produit);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_MAGASIN + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_VEND + ";");
        db.execSQL("DROP TABLE " + TABLE_LISTE + ";");
        onCreate(db);
    }

   // private final String MY_QUERY = "SELECT nom_produit, description_produit, code, prix, unite, rayon, promotion FROM Produit prod INNER JOIN Vendeur vend ON prod.id_produit=vend.id_produit INNER JOIN Magasin mag on mag.id_magasin=vend.id_magasin ";
    public List<Prods> createProds() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Prods> liste = new LinkedList<>();

        Cursor res = db.query(TABLE_PRODUIT /*+ " INNER JOIN "+ TABLE_VEND + " INNER JOIN "+ TABLE_MAGASIN*/, null, null, null, null, null, null); // select * from TABLE_PRODUITY;
        //Cursor res1 = db.rawQuery(MY_QUERY, new String[]{});
        res.moveToFirst(); // haut de la liste de résultats
        while (! res.isAfterLast()) {// tant que pas fin
            Prods p = new Prods();

            p.setNom(res.getString(2)); // 3° colonne : nom
            p.setDescription(res.getString(3)); // description
            p.setCodeBarre(res.getString(4)); //code
            /* p.setPrix(res.getString(5)); //prix
            p.setQuantite(res.getString(6)); //unite
            p.setEmplacement(res.getString(7)); //rayon
            p.setPromotion(res.getString(8)); //promotion
            p.setMagasin(res.getString(10)); //magasin
        */
            liste.add(p);
            res.moveToNext();
        }


        return liste;
    }

}
