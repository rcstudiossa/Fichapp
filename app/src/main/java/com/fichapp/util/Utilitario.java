package com.fichapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fichapp.BuildConfig;
import com.fichapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
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

    public final static boolean isEmailValido(String txtEmail) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches();
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

        texto = "" + texto;

        if (isEmpty(aviso)) {
            aviso = texto;
        } else {
            aviso = aviso + "\n" + texto;
        }

        return aviso;

    }

    public static String getDataHojeFormatada() {

        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());

    }

    public static String getDataFormatada(Date data) {

        if (Utilitario.isEmpty(data)) {
            return null;
        }

        return new SimpleDateFormat("dd/MM/yyyy").format(data);

    }

    public static Date getDate(String data) {

        if (Utilitario.isEmpty(data)) {
            return null;
        }

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

    public static void alertar(Activity activity, String texto) {

        ViewDialog alert = new ViewDialog();
        alert.showDialog(activity, texto);

    }

    public static boolean dataValida(String data) {

        Date dataValida;
        SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");

        try {
            padrao.setLenient(false);
            dataValida = padrao.parse(data);

            Calendar dataCadastro = Calendar.getInstance();
            dataCadastro.setTime(dataValida);

            Calendar hoje = Calendar.getInstance();

            if (dataCadastro.after(hoje)) {
                return false;
            }

            int meses = (hoje.get(Calendar.YEAR) * 12 + hoje.get(Calendar.MONTH)) - (dataCadastro.get(Calendar.YEAR) * 12 + dataCadastro.get(Calendar.MONTH));

            if (Math.abs(meses) > (130 * 12)) {
                return false;
            }


        } catch (ParseException e) {
            return false;
        }

        return true;

    }

    public static void exibirErro(View view, String msg) {

        if (view instanceof TextView) {
            ((TextView) view).setText(msg);
            ((TextView) view).setTextSize(13);
            ((TextView) view).setTextColor(Color.parseColor("#D50000"));

            view.setFocusable(true);
            view.requestFocus();
        } else if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setError(msg);
            (view).requestFocus();
        }

    }

    public static void limparErros(View view) {

        View componente;

        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

            componente = ((ViewGroup) view).getChildAt(i);

            if (componente instanceof ViewGroup) {
                limparErros(componente);
            }

            if (componente instanceof TextView) {
                if (((TextView) componente).getCurrentTextColor() == Color.parseColor("#D60000")) {
                    ((TextView) componente).setTextColor(ContextCompat.getColor(view.getContext(), R.color.colorPrimaryDark));
                }
            } else if (componente instanceof TextInputLayout) {
                if (((TextInputLayout) componente).getError() != null) {
                    ((TextInputLayout) componente).setError(null);
                    ((TextInputLayout) componente).setErrorEnabled(false);
                    componente.clearFocus();
                }
            }
        }
    }

    public static String getVersao() {
        String versionName = BuildConfig.VERSION_NAME;
        return versionName;
    }

}
