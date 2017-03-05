package com.example.fabienfontaine.listedecourses;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Magasins extends AppCompatActivity {

    ListView mListViewMag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magasins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(view.getContext(),AjoutMagasin.class),90);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //
        mListViewMag = (ListView) findViewById(R.id.listViewMag);
        Bdd obj = new Bdd(getBaseContext(),"listeCourse.db", null, 28);
        List<Prods> magasins = obj.createProds();
        ProdAdapter adapter = new ProdAdapter(Magasins.this, magasins);
        mListViewMag.setAdapter(adapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 90:
                if (resultCode == RESULT_OK) {
                    String res = data.getStringExtra("NOM_MAGASIN");

                    Toast t = Toast.makeText(this, res, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER,0,-100);
                    t.show();
                }
                break;
        }
    }
}
