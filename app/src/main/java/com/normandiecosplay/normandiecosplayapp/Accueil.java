package com.normandiecosplay.normandiecosplayapp;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Accueil extends Activity {

    private Button btnevenements;

    private Button btnlisteCosplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        btnevenements=(Button)findViewById(R.id.button);
        btnevenements.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                startActivity(new Intent(Accueil.this, ListeEvenement.class));

            }


        }
        );

        btnlisteCosplay=(Button)findViewById(R.id.button2);
        btnlisteCosplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Marty, ça marche!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
