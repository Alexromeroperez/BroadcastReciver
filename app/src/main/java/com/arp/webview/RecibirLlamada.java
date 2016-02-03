package com.arp.webview;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.arp.webview.bd.Contrato;
import com.arp.webview.bd.Dia;
import com.arp.webview.bd.GestorLlamadas;

import java.util.Calendar;

/**
 * Created by Alex on 27/01/2016.
 */
public class RecibirLlamada extends BroadcastReceiver {
    private GestorLlamadas gl;
    private int dia;
    @Override
    public void onReceive(final Context context, Intent intent) {
        final Context c = context;
        gl=new GestorLlamadas(context);
        gl.open();
        Calendar semana = Calendar.getInstance();
        dia=semana.get(Calendar.DAY_OF_WEEK);

        TelephonyManager tm = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(new PhoneStateListener(){
            public void onCallStateChanged(int state,String incomingNumber) {
                Cursor c=gl.getCursor("dia=?", new String[]{dia + ""});
                c.moveToFirst();
                if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                        Log.v("Llamada", "Estoy llamando");
                    Dia d=new Dia();
                    d.set(c);
                    d.setSaliente(d.getSaliente()+1);
                    d.setTotal(d.getEntrante()+d.getSaliente());
                    gl.update(d);

                }else if(state==TelephonyManager.CALL_STATE_RINGING){
                    Log.v("Llamada", "ME estan llamando");
                        Dia d=new Dia();
                        d.set(c);
                        d.setEntrante(d.getEntrante()+1);
                        d.setTotal(d.getEntrante()+d.getSaliente());
                        gl.update(d);
                    }
                }
            },PhoneStateListener.LISTEN_CALL_STATE);

        }
}
