package com.example.fabienfontaine.listedecourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    }

    public void onMagasins(View view) {
        startActivity(new Intent(this, Magasins.class));
    }

    public void onProduits(View view) {
    }

    public void onCourses(View view) {
    }
}
