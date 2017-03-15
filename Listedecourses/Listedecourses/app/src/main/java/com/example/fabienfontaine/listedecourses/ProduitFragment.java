package com.example.fabienfontaine.listedecourses;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import static com.example.fabienfontaine.listedecourses.R.id.quantite;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProduitFragment extends Fragment {


    private ListView mListView;



    public ProduitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vue = inflater.inflate(R.layout.content_produits, container, false);

        mListView = (ListView) vue.findViewById(R.id.listView);


        Bdd obj = new Bdd(getContext());
        List<Prods> prods = obj.createProds();

        ProdAdapter adapter = new ProdAdapter(getContext(), prods);

       mListView.setAdapter(adapter);



        return vue;
    }

}
