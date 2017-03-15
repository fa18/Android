package com.example.fabienfontaine.listedecourses;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by fabien.fontaine on 15/02/2017.
 */

public class Bdd extends SQLiteOpenHelper {

    //Table Magasin
    private static final String TABLE_MAGASIN = "Magasin";
    private static final String COL_ID_MAGASIN = "id_magasin";
    private static final String COL_NOM_MAGASIN = "nom_magasin";


    private static final String CREATE_TABLE_MAGASIN = "CREATE TABLE " + TABLE_MAGASIN + " ("
            + COL_ID_MAGASIN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_MAGASIN + " TEXT );";

        //insertion
        final String Insert_Magasin="INSERT INTO Magasin (nom_magasin) VALUES('Carrefour')";
        final String Insert_Leclerc="INSERT INTO Magasin (nom_magasin) VALUES('Leclerc')";

    //Table Produit
    private static final String TABLE_PRODUIT = "Produit";
    private static final String COL_ID_PRODUIT = "id_produit";
    private static final String COL_CATEGORIE = "categorie";
    private static final String COL_NOM_PRODUIT = "nom_produit";
    private static final String COL_DESCRIPTION_PRODUIT = "description_produit";
    private static final String COL_CODE = "code";
    private static final String COL_IMAGE = "image_produit";

    private static final String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT + " ("
            + COL_ID_PRODUIT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_CATEGORIE + " INTEGER, "
            + COL_NOM_PRODUIT + " TEXT NOT NULL, "
            + COL_DESCRIPTION_PRODUIT + " TEXT, "
            + COL_CODE + " TEXT, "
            + COL_IMAGE + " TEXT );";

    //Insertion Produit
    final String Insert_Produit="INSERT INTO Produit (categorie,nom_produit,description_produit,code,image_produit) VALUES('bricolage','marteau','pour enfoncer des clous','||| || |||| || |','Color.BLUE')";
    final String Insert_Produit2="INSERT INTO Produit (categorie,nom_produit,description_produit,code) VALUES('bricolage','perceuse','pour faire des trous','|||||||||')";
    final String Insert_Produit3="INSERT INTO Produit (categorie,nom_produit,description_produit,code) VALUES('bricolage','clou','35 mm','||| || || ')";



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

        //Insertion
        final String Insert_Vend="INSERT INTO Vendeur (id_produit,id_magasin,prix,unite,rayon,promotion) VALUES(1,1,'5','30','Brico','5')";
        final String Insert_Vend_perceuse="INSERT INTO Vendeur (id_produit,id_magasin,prix,unite,rayon,promotion) VALUES(2,2,'35','30','Brico','10')";
        final String Insert_Vend_clou="INSERT INTO Vendeur (id_produit,id_magasin,prix,unite,rayon,promotion) VALUES(3,1,'1','0','Brico','0')";

    //Table Liste
    private static final String TABLE_LISTE = "Listes";
    private static final String COL_ID_LISTE = "id_liste";
    private static final String COL_QUANTITE = "quantite";
    private static final String COL_ACHETE = "achete";

    private static final String CREATE_TABLE_LISTE = "CREATE TABLE " + TABLE_LISTE + " ("
            + COL_ID_LISTE + " INTEGER , "
            + COL_ID_PRODUIT + " INTEGER, "
            + COL_ID_MAGASIN + " INTEGER, "
            + COL_QUANTITE + " FLOAT, "
            + COL_ACHETE +" FLOAT, "
            + " PRIMARY KEY('id_liste','id_magasin','id_produit')"
            + " FOREIGN KEY("+COL_ID_PRODUIT+") REFERENCES "+TABLE_VEND+"("+COL_ID_PRODUIT+"), "
            + " FOREIGN KEY("+COL_ID_MAGASIN+") REFERENCES "+TABLE_VEND+"("+COL_ID_MAGASIN+") "
            +" );";

    //Insertion
    final String Insert_Liste_User="INSERT INTO Listes (id_liste,id_produit,id_magasin,quantite,achete) VALUES(1,1,1,1,0)";


    private static final int VERSION = 32;

    public Bdd(Context context) {
        super(context, "listeCourse.db", null, VERSION);
    }
/*
    public Bdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
*/


    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLE_PRODUIT);
        db.execSQL(CREATE_TABLE_MAGASIN);
        db.execSQL(CREATE_TABLE_VEND);
        db.execSQL(CREATE_TABLE_LISTE);
        db.execSQL(Insert_Produit);
        db.execSQL(Insert_Produit2);
        db.execSQL(Insert_Produit3);
        db.execSQL(Insert_Vend);
        db.execSQL(Insert_Magasin);
        db.execSQL(Insert_Vend_perceuse);
        db.execSQL(Insert_Leclerc);
        db.execSQL(Insert_Vend_clou);
        db.execSQL(Insert_Liste_User);


    }

    //attention faire plutot update table quand l'utilisateur aura rentré des données
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_MAGASIN + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_VEND + ";");
        db.execSQL("DROP TABLE " + TABLE_LISTE + ";");
        onCreate(db);
    }

    // private final String MY_QUERY = "SELECT nom_produit, description_produit, code, prix, unite, rayon, promotion FROM Produit prod INNER JOIN Vendeur vend ON prod.id_produit=vend.id_produit INNER JOIN Magasin mag on mag.id_magasin=vend.id_magasin ";
    private final String MY_QUERY = "SELECT categorie, nom_produit, description_produit, code, prix, unite, rayon, promotion, nom_magasin, id_produit FROM Produit join Vendeur using(id_produit) join Magasin using(id_magasin)";
    public List<Prods> createProds() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Prods> liste = new LinkedList<>();

        //Cursor res = db.query(TABLE_PRODUIT /*+ " INNER JOIN "+ TABLE_VEND + " INNER JOIN "+ TABLE_MAGASIN*/, null, null, null, null, null, null); // select * from TABLE_PRODUITY;
        Cursor res = db.rawQuery(MY_QUERY, new String[]{});
        res.moveToFirst(); // haut de la liste de résultats
        while (! res.isAfterLast()) {// tant que pas fin
            Prods p = new Prods();
            p.setCategorie("Catégorie : "+res.getString(0)); //categorie
            p.setNom(res.getString(1)); // nom
            p.setDescription(res.getString(2)); // description
            p.setCodeBarre(res.getString(3)); //code
            p.setColor(Color.BLUE); //couleur : reste à récuperer dans la base
            p.setID(res.getInt(9));

            if(!res.getString(5).equals("0")) {
                p.setQuantite(res.getFloat(5));
                //p.setQuantite("En stock : " + res.getString(5) + " unités"); //unite
                p.setEmplacement("au rayon : "+res.getString(6)); //rayon
                p.setMagasin("Disponible chez : "+res.getString(8)); //magasin
                p.setPrix(res.getString(4)+" €"); //prix

                if(!res.getString(7).equals("0"))  {
                    p.setPromotion("Promotion de : " + res.getString(7) + " %"); //promotion
                }

            }
            else{
                p.setPrix("Rupture de stock ");
            }

            liste.add(p);
            res.moveToNext();
        }

        return liste;
    }

    private final String MY_QUERY_MAG = "SELECT nom_magasin FROM  Magasin ";
    public List<Magasins> generateMagasins() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Magasins> listeMagasin = new LinkedList<>();


        Cursor res = db.rawQuery(MY_QUERY_MAG, new String[]{});
        res.moveToFirst(); // haut de la liste de résultats
        while (! res.isAfterLast()) {// tant que pas fin
            Magasins m = new Magasins();

            m.setNomMagasin(res.getString(0)); // nom


            listeMagasin.add(m);
            res.moveToNext();
        }

        return listeMagasin;
    }

    //recupere les produits dans la liste de l'utilisateur
    private final String MY_QUERY_USER_LISTE = "SELECT categorie, nom_produit, description_produit, code, prix, unite, rayon, promotion, nom_magasin FROM Produit join Vendeur using(id_produit) join Magasin using(id_magasin) join Listes using(id_produit,id_magasin) "; //join Listes using(id_produit,id_magasin)
    public List<Prods> userProds() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Prods> liste = new LinkedList<>();

        //Cursor res = db.query(TABLE_PRODUIT /*+ " INNER JOIN "+ TABLE_VEND + " INNER JOIN "+ TABLE_MAGASIN*/, null, null, null, null, null, null); // select * from TABLE_PRODUITY;
        Cursor res = db.rawQuery(MY_QUERY_USER_LISTE, new String[]{});
        res.moveToFirst(); // haut de la liste de résultats
        while (! res.isAfterLast()) {// tant que pas fin
            Prods p = new Prods();
            p.setCategorie("Catégorie : "+res.getString(0)); //categorie
            p.setNom(res.getString(1)); // nom
            p.setDescription(res.getString(2)); // description
            p.setCodeBarre(res.getString(3)); //code
            p.setColor(Color.BLUE); //couleur : reste à récuperer dans la base

            if(!res.getString(5).equals("0")) {
                p.setQuantite(res.getFloat(5)); //unite
                p.setEmplacement("au rayon : "+res.getString(6)); //rayon
                p.setMagasin("Disponible chez : "+res.getString(8)); //magasin
                p.setPrix(res.getString(4)+" €"); //prix

                if(!res.getString(7).equals("0"))  {
                    p.setPromotion("Promotion de : " + res.getString(7) + " %"); //promotion
                }

            }
            else{
                p.setPrix("Rupture de stock ");
            }

            liste.add(p);
            res.moveToNext();
        }

        return liste;
    }

}