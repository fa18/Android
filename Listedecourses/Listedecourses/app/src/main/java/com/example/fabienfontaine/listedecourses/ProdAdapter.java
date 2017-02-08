package com.example.fabienfontaine.listedecourses;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//vue
public class ProdAdapter extends ArrayAdapter<Prods> {

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


            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        Prods prod = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(prod.getNom());
        viewHolder.emplacement.setText(prod.getEmplacement());
        viewHolder.description.setText(prod.getDescription());
        viewHolder.photo.setImageDrawable(new ColorDrawable(prod.getColor()));
        viewHolder.prix.setText(prod.getPrix());
        viewHolder.codeBarre.setText(prod.getCodeBarre());
        viewHolder.magasin.setText(prod.getMagasin());
        viewHolder.quantite.setText(prod.getQuantite());
        viewHolder.promotion.setText(prod.getPromotion());

        return convertView;
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
    }
}
