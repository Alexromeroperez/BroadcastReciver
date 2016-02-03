package com.arp.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.arp.webview.bd.Dia;

import java.util.ArrayList;

public class Entrante extends AppCompatActivity {

    private int consulta;
    private WebView web;
    private ArrayList<Dia>dias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrante);

        Bundle b=getIntent().getExtras();
        dias= (ArrayList<Dia>) b.get("llamadas");
        consulta=b.getInt("consulta");

        web=(WebView)findViewById(R.id.webView2);
        web.loadUrl("file:///android_asset/index.html");
        WebSettings webS=web.getSettings();
        webS.setJavaScriptEnabled(true);
        web.addJavascriptInterface(this, "InterfazAndroid");
    }
    @JavascriptInterface
    public int getDia(int indice){
        if(consulta==0){
            return dias.get(indice).getEntrante();
        }else if(consulta==1){
            return dias.get(indice).getSaliente();
        }else return dias.get(indice).getTotal();
    }
}
