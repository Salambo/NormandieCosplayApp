package com.normandiecosplay.normandiecosplayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestCompteARebours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_compte_arebours);
        startService(new Intent(TestCompteARebours.this, CompteARebours.class));

        stopService(new Intent(TestCompteARebours.this, CompteARebours.class));
    }
}
