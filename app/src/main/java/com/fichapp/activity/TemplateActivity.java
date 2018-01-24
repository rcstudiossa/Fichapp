package com.fichapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fichapp.R;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

/**
 * Created by Rodrigo Costa on 29/12/2017.
 */

public class TemplateActivity extends AppCompatActivity {

    protected ProfissionalModel profissionalModel;
    protected TextView nomeBarTV;
    protected TextView cboBarTV;
    protected TextView hospitalBarTV;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        this.nomeBarTV = (TextView) findViewById(R.id.tv_nome_bar);
        this.cboBarTV = (TextView) findViewById(R.id.tv_cbo_bar);
        this.hospitalBarTV = (TextView) findViewById(R.id.tv_hospital_bar);

        atualizarRodape();

    }



    protected void atualizarRodape() {

        this.nomeBarTV.setText(prefs.getString("nome", ""));
        this.cboBarTV.setText(prefs.getString("cbo", ""));
        this.hospitalBarTV.setText(prefs.getString("cnes", ""));

    }

}
