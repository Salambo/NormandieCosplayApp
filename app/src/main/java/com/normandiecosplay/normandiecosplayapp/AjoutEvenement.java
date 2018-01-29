package com.normandiecosplay.normandiecosplayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AjoutEvenement extends AppCompatActivity {

    private Button btnValider;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ajout_evenement);

        btnValider=(Button)findViewById(R.id.button);



        btnValider.setOnClickListener(new View.OnClickListener() {


                                             public void onClick(View view) {
                                                /* Intent retour = new Intent();
                                                 retour.putExtra(NOM_MAGASIN, champ.getText().toString());
                                                 setResult(Activity.RESULT_OK, retour);
                                                 finish();*/
                                                 Toast.makeText(getApplicationContext(), "Wolololo!",Toast.LENGTH_LONG).show();

                                             }


                                         }
        );


    }
}
