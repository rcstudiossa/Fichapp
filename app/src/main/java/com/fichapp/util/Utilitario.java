package com.fichapp.util;

import android.content.Context;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rodrigo Costa on 25/12/2017.
 */

public final class Utilitario {

    public static boolean isEmpty(String s) {
        return (s == null || s.trim().length() == 0);
    }

    public static boolean isEmpty(Object object) {
        return (object == null);
    }

    public static boolean isCNSValido(String s) {
        if (s.matches("[1-2]\\d{10}00[0-1]\\d") || s.matches("[7-9]\\d{14}")) {
            return somaPonderada(s) % 11 == 0;
        }
        return false;
    }

    private static int somaPonderada(String s) {
        char[] cs = s.toCharArray();
        int soma = 0;
        for (int i = 0; i < cs.length; i++) {
            soma += Character.digit(cs[i], 10) * (15 - i);
        }
        return soma;
    }

    public static String addAviso(String texto, String aviso) {

        if (isEmpty(aviso)) {
            aviso = texto;
        } else {
            aviso = aviso + "\n" + texto;
        }

        return aviso;

    }

    public static String getDataFormatada(Date data) {

        return new SimpleDateFormat("dd/MM/yyyy").format(data);

    }

    public static Date getDate(String data) {

        try {
            //SimpleDateFormat formato = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void avisoSucesso(Context context) {

        Toast.makeText(context, "Operação realizada com sucesso", Toast.LENGTH_SHORT).show();

    }
}
