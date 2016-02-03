package com.arp.webview.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.arp.webview.bd.Contrato;

/**
 * Created by Alex on 02/02/2016.
 */
public class Dia implements Parcelable {
    private long id;
    private int dia,saliente,entrante,total;

    public Dia() {
    }

    public Dia(long id, int dia, int saliente, int entrante, int total) {
        this.id =  id;
        this.dia = dia;
        this.saliente = saliente;
        this.entrante = entrante;
        this.total = total;
    }

    protected Dia(Parcel in) {
        id = in.readLong();
        dia = in.readInt();
        saliente = in.readInt();
        entrante = in.readInt();
        total = in.readInt();
    }

    public static final Creator<Dia> CREATOR = new Creator<Dia>() {
        @Override
        public Dia createFromParcel(Parcel in) {
            return new Dia(in);
        }

        @Override
        public Dia[] newArray(int size) {
            return new Dia[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getSaliente() {
        return saliente;
    }

    public void setSaliente(int saliente) {
        this.saliente = saliente;
    }

    public int getEntrante() {
        return entrante;
    }

    public void setEntrante(int entrante) {
        this.entrante = entrante;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ContentValues getContentValues(){
        ContentValues cv=new ContentValues();
        cv.put(Contrato.TablaLlamada.ENTRANTE,entrante);
        cv.put(Contrato.TablaLlamada.SALIENTE,saliente);
        cv.put(Contrato.TablaLlamada.TOTAL,total);
        cv.put(Contrato.TablaLlamada.DIA,dia);
        return cv;
    }

    public void set(Cursor c){
        this.id=c.getLong(c.getColumnIndex(Contrato.TablaLlamada._ID));
        this.entrante=c.getInt(c.getColumnIndex(Contrato.TablaLlamada.ENTRANTE));
        this.saliente=c.getInt(c.getColumnIndex(Contrato.TablaLlamada.SALIENTE));
        this.total=c.getInt(c.getColumnIndex(Contrato.TablaLlamada.TOTAL));
        this.dia=c.getInt(c.getColumnIndex(Contrato.TablaLlamada.DIA));
    }

    @Override
    public String toString() {
        return "Dia{" +
                "id=" + id +
                ", dia=" + dia +
                ", saliente=" + saliente +
                ", entrante=" + entrante +
                ", total=" + total +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(dia);
        dest.writeInt(saliente);
        dest.writeInt(entrante);
        dest.writeInt(total);
    }
}
