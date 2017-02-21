package com.example.fabienfontaine.listedecourses;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//Main
public class Produits extends AppCompatActivity {

    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.listView);
        //List<Prods> prods = genererProds();

        Bdd obj = new Bdd(getBaseContext(),"listeCourse.db", null, 27);
        List<Prods> prods = obj.createProds();

        ProdAdapter adapter = new ProdAdapter(Produits.this, prods);


        mListView.setAdapter(adapter);

    }

    private List<Prods> genererProds(){
        List<Prods> prods = new ArrayList<Prods>();
        prods.add(new Prods(Color.BLUE,"Pack d'eau","Eau de source naturelle", "3.3", "Carrefour","Rayon Eau", "| || ||| ||| |","35","",""));
        prods.add(new Prods("Baguette",Color.YELLOW, "Boulangerie", "Baguette tradition moulée","0.9"));
        prods.add(new Prods("Tagliatelle",Color.YELLOW, "Rayon féculent", "Pattes italienne ","2"));
        prods.add(new Prods("Steak",Color.RED, "Rayon Boucherie", "steak 100% pur boeuf origine france","2"));
        prods.add(new Prods("Activia",Color.GREEN, "Rayon frais", "0% de matières grasses","1.5"));
        return prods;
    }








}

