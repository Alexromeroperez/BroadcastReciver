package com.arp.webview.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 02/02/2016.
 */
public class GestorLlamadas {
    private Ayudante abd;
    private SQLiteDatabase bd;

    public GestorLlamadas(Context c){
        abd = new Ayudante(c);
    }

    public void open() {
        bd = abd.getWritableDatabase();
    }

    public void openRead() {
        bd = abd.getReadableDatabase();
    }

    public void close() {
        abd.close();
    }

    public long insert(Dia d) {
        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaLlamada.SALIENTE, d.getSaliente());
        valores.put(Contrato.TablaLlamada.ENTRANTE, d.getEntrante());
        valores.put(Contrato.TablaLlamada.TOTAL, d.getTotal());
        valores.put(Contrato.TablaLlamada.DIA, d.getDia());
        long id = bd.insert(Contrato.TablaLlamada.TABLA, null, valores);
        return id;
    }

    public int delete(long id){
        String condicion = Contrato.TablaLlamada._ID + " = ?";
        String[] argumentos = {id + ""};
        int cuenta = bd.delete(
                Contrato.TablaLlamada.TABLA, condicion, argumentos);
        return cuenta;
    }

    public int update(Dia d){
        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaLlamada.SALIENTE, d.getSaliente());
        valores.put(Contrato.TablaLlamada.ENTRANTE, d.getEntrante());
        valores.put(Contrato.TablaLlamada.TOTAL, d.getTotal());
        String condicion = Contrato.TablaLlamada._ID + " = ?";
        String[] argumentos = { d.getId() + "" };
        int cuenta = bd.update(Contrato.TablaLlamada.TABLA, valores,
                condicion, argumentos);
        return cuenta;
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = bd.query(
                Contrato.TablaLlamada.TABLA, null, condicion, parametros, null,
                null, null);
        return cursor;
    }

    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public List<Dia> select(String condicion, String[] parametros) {
        List<Dia> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, parametros);
        Dia d;
        while (cursor.moveToNext()) {
            d = getRow(cursor);
            la.add(d);
        }
        cursor.close();
        return la;
    }

    public List<Dia> select() {
        return select(null, null);
    }

    public Dia getRow(Cursor c) {
        Dia d = new Dia();
        d.setId(c.getLong(c.getColumnIndex(Contrato.TablaLlamada._ID)));
        d.setSaliente(c.getInt(c.getColumnIndex(Contrato.TablaLlamada.SALIENTE)));
        d.setEntrante(c.getInt(c.getColumnIndex(Contrato.TablaLlamada.ENTRANTE)));
        d.setTotal(c.getInt(c.getColumnIndex(Contrato.TablaLlamada.TOTAL)));
        d.setDia(c.getInt(c.getColumnIndex(Contrato.TablaLlamada.DIA)));
        return d;
    }
}
