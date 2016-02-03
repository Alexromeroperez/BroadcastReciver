package com.arp.webview;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.arp.webview.bd.Contrato;
import com.arp.webview.bd.Dia;
import com.arp.webview.bd.GestorLlamadas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Dia> dias;
    private GestorLlamadas gl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gl=new GestorLlamadas(this);
        gl.open();
        dias= (ArrayList<Dia>) gl.select();
    }

    @Override
    protected void onResume() {
        gl.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        gl.close();
        super.onPause();
    }

    public void entrantes(View v){
        Intent i=new Intent(this,Entrante.class);
        Bundle b=new Bundle();
        b.putParcelableArrayList("llamadas", (ArrayList<? extends Parcelable>) dias);
        b.putInt("consulta", 0);
        i.putExtras(b);
        startActivity(i);
    }

    public void salientes(View v){
        Intent i=new Intent(this,Entrante.class);
        Bundle b=new Bundle();
        b.putParcelableArrayList("llamadas", (ArrayList<? extends Parcelable>) dias);
        b.putInt("consulta",1);
        i.putExtras(b);
        startActivity(i);
    }

    public void total(View v){
        Intent i=new Intent(this,Entrante.class);
        Bundle b=new Bundle();
        b.putParcelableArrayList("llamadas", (ArrayList<? extends Parcelable>) dias);
        b.putInt("consulta", 2);
        i.putExtras(b);
        startActivity(i);
    }

}
