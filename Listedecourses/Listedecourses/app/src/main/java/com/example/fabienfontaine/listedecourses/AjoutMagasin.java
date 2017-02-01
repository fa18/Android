package com.example.fabienfontaine.listedecourses;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import static com.example.fabienfontaine.listedecourses.R.array.magasins;

public class AjoutMagasin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_magasin);




        /*magasins.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//...
                    }});*/

    }


    public void onValiderAjoutMagasin(View view) {
        Intent retour = new Intent();
        TextView champ= (TextView) findViewById(R.id.champ);
        retour.putExtra("NOM_MAGASIN", champ.getText().toString());
        setResult(Activity.RESULT_OK, retour);
        finish();
    }
}
