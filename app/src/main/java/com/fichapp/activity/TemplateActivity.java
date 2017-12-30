package com.fichapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fichapp.R;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

/**
 * Created by Rodrigo Costa on 29/12/2017.
 */

public class TemplateActivity extends AppCompatActivity{

    protected ProfissionalModel profissionalModel;
    protected TextView nomeBarTV;
    protected TextView cboBarTV;
    protected TextView hospitalBarTV;

    protected void atualizarRodape() {

        if (!Utilitario.isEmpty(getIntent().getSerializableExtra("profissional"))) {
            this.profissionalModel = (ProfissionalModel) getIntent().getSerializableExtra("profissional");
            this.nomeBarTV = (TextView) findViewById(R.id.tv_nome_bar);
            this.cboBarTV = (TextView) findViewById(R.id.tv_cbo_bar);
            this.hospitalBarTV = (TextView) findViewById(R.id.tv_hospital_bar);
            this.nomeBarTV.setText(profissionalModel.getNome());
            this.cboBarTV.setText(profissionalModel.getCbo());
            this.hospitalBarTV.setText(profissionalModel.getCnesModel().getCodigo());
        }

    }

}
