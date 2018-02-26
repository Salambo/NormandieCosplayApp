package com.normandiecosplay.normandiecosplayapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 21601387 on 22/02/18.
 */

public class Base extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "base.sqlite";
    private static final int VERSION = 3;
    public Base(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("Create table Evenement " +
                    "(" +
                    "id_eve INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nom_eve TEXT," +
                    "lieu_eve TEXT," +
                    "ville_eve TEXT," +
                    "dateD TEXT," +
                    "dateF TEXT," +
                    "CC INTEGER );");
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("insert into Evenement (nom_eve) values ('Sommergeeks'),('Geek Days');");
    }
}
