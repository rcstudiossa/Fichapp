package com.fichapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;

import com.fichapp.Model.CNESModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;

public class CNESActivity extends AppCompatActivity {

    private CNESModel cnesModel;
    private CNESBS cnesbs;
    private AutoCompleteTextView mCodigo;
    private AutoCompleteTextView mNome;
    private CheckBox mFlagAtivo;

    public CNESActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnes);

        getSupportActionBar().setTitle("Cadastro de Hospital");

        Button btnGravar = (Button) findViewById(R.id.btnGravar);
        mCodigo = (AutoCompleteTextView) findViewById(R.id.codigo);
        mNome = (AutoCompleteTextView) findViewById(R.id.tv_nome);
        mFlagAtivo = (CheckBox) findViewById(R.id.flag_ativo);

        cnesbs = new CNESBS(getApplicationContext());

        this.instanciarCNESModel();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gravar();

            }
        });

    }

    private void instanciarCNESModel() {

        this.cnesModel = (CNESModel) getIntent().getSerializableExtra("cnes");

        if (this.cnesModel == null) {
            this.cnesModel = new CNESModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            mCodigo.setText(this.cnesModel.getCodigo());
            mNome.setText(this.cnesModel.getNome());
            mFlagAtivo.setChecked(this.cnesModel.getFlagAtivo());
        }

    }

    private void gravar() {

        this.cnesModel.setCodigo(mCodigo.getText().toString());
        this.cnesModel.setNome(mNome.getText().toString());
        this.cnesModel.setFlagAtivo(mFlagAtivo.isChecked());

        cnesbs.gravar(this.cnesModel);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Fragment", "CNESFragment");
        startActivity(intent);


    }
}
