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

    //tweets est la liste des models à afficher
    public ProdAdapter(Context context, List<Prods> prods) {
        super(context, 0, prods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_produit,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.emplacement = (TextView) convertView.findViewById(R.id.emplacement);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.photo= (ImageView) convertView.findViewById(R.id.photo);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Prods prod = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(prod.getNom());
        viewHolder.emplacement.setText(prod.getEmplacement());
        viewHolder.description.setText(prod.getDescription());
        viewHolder.photo.setImageDrawable(new ColorDrawable(prod.getColor()));

        return convertView;
    }

    private class TweetViewHolder{
        public TextView emplacement;
        public TextView description;
        public ImageView photo;
        public TextView nom;
    }
}
