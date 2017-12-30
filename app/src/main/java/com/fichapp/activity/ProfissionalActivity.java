package com.fichapp.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;

import com.fichapp.model.ProfissionalModel;
import com.fichapp.R;
import com.fichapp.business.ProfissionalBS;
import com.fichapp.util.Utilitario;

public class ProfissionalActivity extends AppCompatActivity {

    private ProfissionalModel profissionalModel;
    private ProfissionalBS profissionalBS;

    private AutoCompleteTextView mCbo;
    private AutoCompleteTextView mCns;
    private AutoCompleteTextView mNome;
    private AutoCompleteTextView mUsuario;
    private AutoCompleteTextView mSenha;
    private AutoCompleteTextView mConfirmarSenha;
    private CheckBox mFlagAtivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);

        getSupportActionBar().setTitle("Cadastro de Profissional");

        Button btnGravar = (Button) findViewById(R.id.btnGravar);
        mCbo = (AutoCompleteTextView) findViewById(R.id.cbo);
        mCns = (AutoCompleteTextView) findViewById(R.id.tvCNS);
        mNome = (AutoCompleteTextView) findViewById(R.id.tv_nome);
        mUsuario = (AutoCompleteTextView) findViewById(R.id.usuario);
        mSenha = (AutoCompleteTextView) findViewById(R.id.senha);
        mConfirmarSenha = (AutoCompleteTextView) findViewById(R.id.confirmarSenha);
        mFlagAtivo = (CheckBox) findViewById(R.id.flag_ativo);

        this.profissionalBS = new ProfissionalBS(getApplicationContext());

        this.instanciarProfissionalModel();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    private void instanciarProfissionalModel() {

        this.profissionalModel = (ProfissionalModel) getIntent().getSerializableExtra("nomeTV");

        if (this.profissionalModel == null) {
            this.profissionalModel = new ProfissionalModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            mCbo.setText(this.profissionalModel.getCbo());
            mCns.setText(this.profissionalModel.getCns());
            mNome.setText(this.profissionalModel.getNome());
            mFlagAtivo.setChecked(this.profissionalModel.getFlagAtivo());
        }

    }

    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        if (Utilitario.isEmpty(mNome.getText().toString())) {
            aviso = Utilitario.addAviso("O nome do profissional está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(mCns.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNS está vazio", aviso);
            valido = false;
        } else if (!Utilitario.isCNSValido(mCns.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNS é inválido", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(mCbo.getText().toString())) {
            aviso = Utilitario.addAviso("O código CBO está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(mUsuario.getText().toString())) {
            aviso = Utilitario.addAviso("O usuário está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(mSenha.getText().toString())) {
            aviso = Utilitario.addAviso("A senha está vazia", aviso);
            valido = false;
        } else if (!mSenha.getText().toString().equals(mConfirmarSenha.getText().toString())){
            aviso = Utilitario.addAviso("As senhas não conferem", aviso);
            valido = false;
        }

        if (!valido) {
            Snackbar.make(getCurrentFocus(), aviso, Snackbar.LENGTH_LONG).show();
        }

        return valido;
    }

    private void gravar() {

        if (!validaCampos()) {
            return;
        }

        this.profissionalModel.setCbo(mCbo.getText().toString());
        this.profissionalModel.setCns(mCns.getText().toString());
        this.profissionalModel.setNome(mNome.getText().toString());
        this.profissionalModel.setUsuario(mUsuario.getText().toString());
        this.profissionalModel.setSenha(mSenha.getText().toString());
        this.profissionalModel.setFlagAtivo(mFlagAtivo.isChecked());

        profissionalBS.gravar(this.profissionalModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "ProfissionalFragment");
        startActivity(intent);


    }
}
