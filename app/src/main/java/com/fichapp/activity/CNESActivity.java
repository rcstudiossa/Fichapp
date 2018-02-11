package com.fichapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.fichapp.model.CNESModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.util.Utilitario;

public class CNESActivity extends TemplateActivity {

    private CNESModel cnesModel;
    private CNESBS cnesbs;
    private EditText cnesET;
    private EditText nomeET;
    private CheckBox mFlagAtivo;
    private Button gravarBT;
    private Toolbar toolbar;
    private Integer qtdNome = 1;
    private Integer qtdCnes = 7;

    public CNESActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_cnes);

        super.onCreate(savedInstanceState);

        this.definirComponentes();

        this.configToolbar();

        this.cnesbs = new CNESBS(getApplicationContext());

        this.instanciarCNESModel();

        this.gravarBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

        //this.leitorCampos();

    }

    private void definirComponentes() {

        this.gravarBT = (Button) findViewById(R.id.bt_gravar);
        this.cnesET = (EditText) findViewById(R.id.codigo);
        this.nomeET = (EditText) findViewById(R.id.et_nome_completo);
        this.mFlagAtivo = (CheckBox) findViewById(R.id.flag_ativo);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    private void configToolbar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cadastro de UBS");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CNESActivity.this, MainActivity.class);
                intent.putExtra("fragment", "CNESFragment");
                startActivity(intent);
                finish();
            }
        });

    }

    private void instanciarCNESModel() {

        this.cnesModel = (CNESModel) getIntent().getSerializableExtra("cnes");

        if (this.cnesModel == null) {
            this.cnesModel = new CNESModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            cnesET.setText(this.cnesModel.getCodigo());
            nomeET.setText(this.cnesModel.getNome());
            mFlagAtivo.setChecked(this.cnesModel.getFlagAtivo());
        }

    }

    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        if (Utilitario.isEmpty(nomeET.getText().toString())) {
            aviso = Utilitario.addAviso("O nome do hospital está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(cnesET.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNES está vazio", aviso);
            valido = false;
        }

        if (!aviso.isEmpty()) {
            Utilitario.alertar(CNESActivity.this, aviso);
        }

        return valido;
    }

    private void gravar() {

        if (!validaCampos()) {
            return;
        }

        this.cnesModel.setCodigo(cnesET.getText().toString());
        this.cnesModel.setNome(nomeET.getText().toString());
        this.cnesModel.setFlagAtivo(mFlagAtivo.isChecked());

        cnesbs.gravar(this.cnesModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "CNESFragment");
        startActivity(intent);

        finish();

    }

    private void leitorCampos() {

        qtdNome = 0;
        qtdCnes = 0;

        gravarBT.setEnabled(false);

        nomeET.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                qtdNome = s.length();
                validadorBotao();
            }
        });

        cnesET.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                qtdCnes = s.length();
                validadorBotao();
            }
        });

    }

    private void validadorBotao() {

        gravarBT.setEnabled(false);

        if (qtdNome == 0 || qtdCnes != 6) {
            gravarBT.setEnabled(false);
        } else {
            gravarBT.setEnabled(true);
        }

    }

}
