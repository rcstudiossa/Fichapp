package com.fichapp.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.fichapp.business.CNESBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.R;
import com.fichapp.business.ProfissionalBS;
import com.fichapp.util.Utilitario;

import java.util.List;

public class ProfissionalActivity extends AppCompatActivity {

    private ProfissionalModel profissionalModel;
    private ProfissionalBS profissionalBS;

    private Integer qtdNome = 0;
    private Integer qtdCns = 0;
    private Integer qtdCbo = 0;
    private Integer qtdUsuario = 0;
    private Integer qtdSenha = 0;
    private Integer qtdConfirmarSenha = 0;

    private EditText cboET;
    private EditText cnsET;
    private EditText nomeET;
    private EditText usuarioET;
    private EditText senhaET;
    private EditText confirmarSenhaET;
    private CheckBox mFlagAtivo;
    private Spinner spinnerHospital;
    private Button gravarBT;

    List<CNESModel> hospitais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);

        getSupportActionBar().setTitle("Cadastro de Profissional");

        gravarBT = (Button) findViewById(R.id.bt_gravar);
        cboET = (EditText) findViewById(R.id.et_cbo);
        cnsET = (EditText) findViewById(R.id.et_cns);
        nomeET = (EditText) findViewById(R.id.et_nome);
        usuarioET = (EditText) findViewById(R.id.et_usuario);
        senhaET = (EditText) findViewById(R.id.et_senha);
        confirmarSenhaET = (EditText) findViewById(R.id.et_confirmar_senha);
        mFlagAtivo = (CheckBox) findViewById(R.id.flag_ativo);
        spinnerHospital = (Spinner) findViewById(R.id.spinner_hospital);

        this.profissionalBS = new ProfissionalBS(getApplicationContext());

        this.carregarCombos();

        this.instanciarProfissionalModel();

        gravarBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

        this.leitorCampos();

    }

    private void instanciarProfissionalModel() {

        this.profissionalModel = (ProfissionalModel) getIntent().getSerializableExtra("nomeTV");

        if (this.profissionalModel == null) {
            this.profissionalModel = new ProfissionalModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            cboET.setText(this.profissionalModel.getCbo());
            cnsET.setText(this.profissionalModel.getCns());
            nomeET.setText(this.profissionalModel.getNome());
            mFlagAtivo.setChecked(this.profissionalModel.getFlagAtivo());
            spinnerHospital.setSelection(this.hospitais.indexOf(new CNESModel(this.profissionalModel.getCnesModel().getId())));
        }

    }

    private void carregarCombos() {

        CNESBS cnesBS = new CNESBS(this);
        hospitais = cnesBS.pesquisarAtivos();
        hospitais.add(0, new CNESModel("Selecione o CNES"));
        ArrayAdapter<CNESModel> adapterHospital = new ArrayAdapter<>(this, R.layout.spinner_item, hospitais);
        spinnerHospital.setAdapter(adapterHospital);
        adapterHospital.setDropDownViewResource(R.layout.spinner_dropdown_item);

    }

    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        if (Utilitario.isEmpty(nomeET.getText().toString())) {
            aviso = Utilitario.addAviso("O nome do profissional está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(cnsET.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNS está vazio", aviso);
            valido = false;
        } else if (!Utilitario.isCNSValido(cnsET.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNS é inválido", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(cboET.getText().toString())) {
            aviso = Utilitario.addAviso("O código CBO está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(usuarioET.getText().toString())) {
            aviso = Utilitario.addAviso("O usuário está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(senhaET.getText().toString())) {
            aviso = Utilitario.addAviso("A senha está vazia", aviso);
            valido = false;
        } else if (!senhaET.getText().toString().equals(confirmarSenhaET.getText().toString())) {
            aviso = Utilitario.addAviso("As senhas não conferem", aviso);
            valido = false;
        }
        if (Utilitario.isEmpty(spinnerHospital.getSelectedItem()) && Utilitario.isEmpty(((CNESModel)spinnerHospital.getSelectedItem()).getId())) {
            aviso = Utilitario.addAviso("O CNES está vazio", aviso);
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

        this.profissionalModel.setCbo(cboET.getText().toString());
        this.profissionalModel.setCns(cnsET.getText().toString());
        this.profissionalModel.setNome(nomeET.getText().toString());
        this.profissionalModel.setUsuario(usuarioET.getText().toString());
        this.profissionalModel.setSenha(senhaET.getText().toString());
        this.profissionalModel.setFlagAtivo(mFlagAtivo.isChecked());
        this.profissionalModel.setCnesModel((CNESModel) spinnerHospital.getSelectedItem());

        profissionalBS.gravar(this.profissionalModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "ProfissionalFragment");
        startActivity(intent);

        finish();

    }

    private void leitorCampos() {

        gravarBT.setEnabled(false);

        TextWatcher validador = new Validador();

        nomeET.addTextChangedListener(validador);
        cnsET.addTextChangedListener(validador);
        cboET.addTextChangedListener(validador);
        usuarioET.addTextChangedListener(validador);
        senhaET.addTextChangedListener(validador);
        confirmarSenhaET.addTextChangedListener(validador);

    }

    private boolean camposValidosBotao() {


       return !Utilitario.isEmpty(nomeET.getText().toString()) && !Utilitario.isEmpty(usuarioET.getText().toString()) && !Utilitario.isEmpty(senhaET.getText().toString()) && !Utilitario.isEmpty(confirmarSenhaET.getText().toString()) && cnsET.getText().length() == 15 && cboET.getText().length() == 6;

    }

    private void validadorBotao() {

        gravarBT.setEnabled(false);

        if (camposValidosBotao()) {
            gravarBT.setEnabled(true);
        }

    }

    private class Validador implements TextWatcher {

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            validadorBotao();
        }

    }

}
