package com.example.fabienfontaine.listedecourses;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.fabienfontaine.listedecourses.R.id.quantite;

//vue
public class ProdAdapter extends ArrayAdapter<Prods> implements View.OnClickListener {


    protected SQLiteDatabase listeCourse = null;
    protected Bdd mHandler = null;

    //prods est la liste des models à afficher
    public ProdAdapter(Context context, List<Prods> prods) {
        super(context, 0, prods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_produit,parent, false);
        }

        ProdsViewHolder viewHolder = (ProdsViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProdsViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.emplacement = (TextView) convertView.findViewById(R.id.emplacement);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.photo= (ImageView) convertView.findViewById(R.id.photo);
            viewHolder.prix= (TextView) convertView.findViewById(R.id.prix);
            viewHolder.codeBarre= (TextView) convertView.findViewById(R.id.codeBarre);
            viewHolder.magasin= (TextView) convertView.findViewById(R.id.magasin);
            viewHolder.quantite= (TextView) convertView.findViewById(R.id.quantite);
            viewHolder.promotion= (TextView) convertView.findViewById(R.id.promotion);
            viewHolder.categorie= (TextView) convertView.findViewById(R.id.categorie);

            //pour insertion dans la liste de course de l'user
            viewHolder.ajout = (Button) convertView.findViewById(R.id.ajouter_produit);
            viewHolder.ajout.setOnClickListener(this);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        Prods prod = getItem(position);

        //remplie notre vue
        viewHolder.nom.setText(prod.getNom());
        viewHolder.emplacement.setText(prod.getEmplacement());
        viewHolder.description.setText(prod.getDescription());
        viewHolder.photo.setImageDrawable(new ColorDrawable(prod.getColor()));
        viewHolder.prix.setText(prod.getPrix());
        viewHolder.codeBarre.setText(prod.getCodeBarre());
        viewHolder.magasin.setText(prod.getMagasin());
        viewHolder.quantite.setText(prod.getQuantite());
        viewHolder.promotion.setText(prod.getPromotion());
        viewHolder.categorie.setText(prod.getCategorie());

        //pour insertion dans la liste de course de l'user
        viewHolder.ajout.setEnabled(! prod.getQuantite().equals("Rupture de stock"));
        viewHolder.numProduit = prod.getNumProduit();
        viewHolder.idMagasin = prod.getIdMagasin();
        viewHolder.idListe = prod.getIdMagasin();


        viewHolder.ajout.setTag(viewHolder);
        return convertView;
    }

    //pour insertion dans la liste de course de l'user
    public void onClick(View v) {

        mHandler = new Bdd(this.getContext());
        listeCourse = mHandler.getWritableDatabase();

        //récupérer valeur du produit
        ProdsViewHolder holder = ((ProdsViewHolder) v.getTag());

        //insérer ces valeurs dans la base
        ContentValues cv = new  ContentValues();
        //cv.put("id_liste",3); //numListe
        cv.put("id_liste",holder.idListe); //numListe
        //problème : ajout dans 1 nouvelle liste

        cv.put("id_produit",holder.numProduit); //numProduit
        //cv.put("id_produit",1); //numProduit
        cv.put("id_magasin",holder.idMagasin); //numMagasin

        //TextView quantiteText = holder.quantite; //valeur de l'id du xml
        //cv.put("quantite",Integer.valueOf(quantiteText.getText().toString())); //quantite   que veut l'utilisateur
        cv.put("quantite",1);
        cv.put("achete",0); //achete
        listeCourse.insert("Listes", null, cv);
        ////final String Insert_Liste_User="INSERT INTO Listes (id_liste,id_produit,id_magasin,quantite,achete) VALUES(1,1,1,1,0)";
    }

    private class ProdsViewHolder{
        public TextView emplacement;
        public TextView description;
        public ImageView photo;
        public TextView nom;
        public TextView prix;
        public TextView codeBarre;
        public TextView magasin;
        public TextView quantite;
        public TextView promotion;
        public TextView categorie;

        //pour insertion dans la liste de course de l'user
        public Button ajout;
        public int numProduit;
        public int idMagasin;
        public int idListe;
    }
}
