package com.normandiecosplay.normandiecosplayapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static com.normandiecosplay.normandiecosplayapp.AjoutEvenement.PARAM_SOURCE;

public class TestServeur extends AppCompatActivity {

    private Button btnVal;
    private String Texttext;
    private EditText texte;
    private WebView webtext;
    private URL url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_serveur);

        btnVal = (Button) findViewById(R.id.button36);

        texte = (EditText) findViewById(R.id.editText22);

        webtext = (WebView) findViewById(R.id.textView69);


        btnVal.setOnClickListener(new View.OnClickListener() {


                                          public void onClick(View view) {
                                              Texttext=(texte.getText()).toString();

                                              if(!Texttext.isEmpty()){
                                                  try {
                                                      url = new URL("http://www.unicaen.fr");

                                                      URLConnection conn = null;

                                                      OutputStream flux =
                                                              conn.getOutputStream();
                                                      conn = url.openConnection();

                                                      conn.connect();

                                                      conn.getHeaderField("Content-type");

                                                      Object tmp=conn.getContent();

                                                      conn.getInputStream();

                                                  } catch (IOException e) {
                                                      e.printStackTrace();
                                                  }


                                              }
                                              else{

                                              }



                                          }


                                      }
        );
    }
}
