package com.arp.webview.bd;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Alex on 31/01/2016.
 */
public class Contrato {
    public Contrato() {
    }

    public static abstract class TablaLlamada implements BaseColumns {
        public static final String TABLA = "llamada";
        public static final String ENTRANTE = "entrante";
        public static final String SALIENTE = "saliente";
        public static final String TOTAL = "total";
        public static final String DIA = "dia";

    }
}
