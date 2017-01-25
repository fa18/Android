package com.example.fabienfontaine.listedecourses;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AjoutMagasin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_magasin);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Intent retour = new Intent();
        //retour.putExtra(data.getStringExtra(clé), champ.getText().toString());
        setResult(Activity.RESULT_OK, retour);
        finish();
    }
}
