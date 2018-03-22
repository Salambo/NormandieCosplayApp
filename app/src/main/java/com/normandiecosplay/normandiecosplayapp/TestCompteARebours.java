package com.normandiecosplay.normandiecosplayapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TestCompteARebours extends AppCompatActivity {

    public class Messager extends Handler {


        public void handleMessage(Message msg) {
            Log.d("Bonne annee", "recu " + msg.what + "_" + msg.arg1);
            text.setText((String)msg.obj);
        }

    }

    private CompteARebours.Liaison serve;
    private ServiceConnection connexion = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serve = (CompteARebours.Liaison) service;
            text.setText(serve.getCompteARebours());
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            serve = null;
        }
    };
    public void onBindTestBindingServiceClick(View view) {
        bindService(new Intent(this, CompteARebours.class), connexion,
                BIND_AUTO_CREATE);
    }
    public void onUnbindClick(View view) {
        unbindService(connexion);
    }

    private Messenger mailbox = new Messenger(new Messager());
    private TextView text;
    private Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_compte_arebours);
        text = (TextView) findViewById(R.id.textView5);
        bouton = findViewById(R.id.button404);

        Intent intent = new Intent(TestCompteARebours.this, CompteARebours.class);
        intent.putExtra("msg", mailbox);
        startService(intent);

        bouton.setOnClickListener(new View.OnClickListener() {


                                                  public void onClick(View view) {


                                                  }


                                              }
        );
    }

        //stopService(new Intent(TestCompteARebours.this, CompteARebours.class));


    }

