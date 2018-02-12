package com.normandiecosplay.normandiecosplayapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutEvenement extends Activity {

    private Button btnValider;
    private EditText texte;
    private String nomNewEvenement;
    public static final String PARAM_SOURCE= "LI";
    public static final String PARAM_REPONSE= "CORNE";
    public static final int CODE_REQUETE = 666;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ajout_evenement);

        btnValider = (Button) findViewById(R.id.button3);

        texte = (EditText) findViewById(R.id.nomEve);


        btnValider.setOnClickListener(new View.OnClickListener() {


                                          public void onClick(View view) {
                                              nomNewEvenement=(texte.getText()).toString();

                                              if(!nomNewEvenement.isEmpty()){

                                                  Intent retour = new Intent(AjoutEvenement.this, ListeEvenement.class);
                                                  retour.putExtra(PARAM_SOURCE, texte.getText().toString());
                                                  setResult(Activity.RESULT_OK,retour);
                                                  finish();
                                              }
                                              else{
                                                  Toast.makeText(getApplicationContext(), "Marty, il faut remplir le champ!",Toast.LENGTH_LONG).show();
                                              }



                                          }


                                      }
        );


    }
}
