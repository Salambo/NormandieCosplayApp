package com.normandiecosplay.normandiecosplayapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListeEvenement extends Activity {

    private Button btnajoutevenements;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case(AjoutEvenement.CODE_REQUETE):
                // result recu
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenement);



        btnajoutevenements=(Button)findViewById(R.id.button4);
        btnajoutevenements.setOnClickListener(new View.OnClickListener() {


                                             public void onClick(View view) {
                                                 startActivityForResult(new Intent(ListeEvenement.this, AjoutEvenement.class), 666);

                                             }


                                         }
        );
    }
}
