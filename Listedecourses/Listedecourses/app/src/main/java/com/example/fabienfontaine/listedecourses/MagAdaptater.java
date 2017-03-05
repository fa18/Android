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
public class MagAdaptater extends ArrayAdapter<Magasins> {

    //prods est la liste des models à afficher
    public MagAdaptater(Context context, List<Magasins> magasins) {
        super(context, 0, magasins);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_magasins,parent, false);
        }

        MagViewHolder viewHolder = (MagViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new MagViewHolder();
            viewHolder.nomMagasin = (TextView) convertView.findViewById(R.id.nomMagasin);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List
        Magasins magasins = getItem(position);

        //remplie notre vue
        viewHolder.nomMagasin.setText(magasins.getNomMagasin());

        return convertView;
    }

    private class MagViewHolder{
        public TextView nomMagasin;

    }
}
