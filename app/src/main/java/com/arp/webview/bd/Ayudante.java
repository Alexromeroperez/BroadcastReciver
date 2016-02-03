package com.arp.webview.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.arp.webview.bd.Contrato;

/**
 * Created by Alex on 31/01/2016.
 */
public class Ayudante extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="llamadas.sqlite";
    public static final int DATABASE_VERSION=1;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+ Contrato.TablaLlamada.TABLA+
                " ("+ Contrato.TablaLlamada._ID+" integer primary key autoincrement, "+
                Contrato.TablaLlamada.SALIENTE+" integer, "+
                Contrato.TablaLlamada.ENTRANTE+" interger, "+
                Contrato.TablaLlamada.TOTAL+" interger, "+
                Contrato.TablaLlamada.DIA+" integer )";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (1,0,0,0,1)";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (2,0,0,0,2)";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (3,0,0,0,3)";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (4,0,0,0,4)";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (5,0,0,0,5)";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (6,0,0,0,6)";
        db.execSQL(sql);
        sql="insert into "+Contrato.TablaLlamada.TABLA+" values (7,0,0,0,7)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }
}
