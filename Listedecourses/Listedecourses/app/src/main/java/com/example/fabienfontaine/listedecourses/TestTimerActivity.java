package com.example.fabienfontaine.listedecourses;

import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import java.net.URL;

public class TestTimerActivity extends AppCompatActivity {

    public TestTimerActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_timer2);
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



        //Button pour tester le service "timer" (provoque un affichage dans la consoole)
        Button button;
        final Messenger mailbox = new Messenger(new RecvMsg());
        button = (Button)this.findViewById(R.id.buttonTestTimer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MyIntentService.class);
                intent.putExtra("msg", mailbox);
                startService(intent);
                }
            }
        );

        button = (Button)this.findViewById(R.id.buttonLiaison);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                      }
                                  }
        );
    }



}
