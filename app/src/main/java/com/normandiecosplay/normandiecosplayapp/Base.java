package com.normandiecosplay.normandiecosplayapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 21601387 on 22/02/18.
 */

public class Base extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "base.sqlite";
    private static final int VERSION = 1;
    public Base(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Evenement " +
                "(" +
                "id_eve int," +
                "nom_eve varchar2," +
                "lieu_eve varchar2," +
                "ville_eve varchar2," +
                "dateD date," +
                "dateF date," +
                "CC int );");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
    }
}
