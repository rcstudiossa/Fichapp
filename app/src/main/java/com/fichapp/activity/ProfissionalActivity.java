package com.fichapp.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.util.List;

public class ProfissionalActivity extends TemplateActivity {

    private ProfissionalModel profissionalModel;
    private ProfissionalBS profissionalBS;

    private EditText etCns;
    private EditText etIne;
    private EditText etNome;
    private EditText etUsuario;
    private EditText etSenha;
    private EditText etConfirmarSenha;
    private CheckBox mFlagAtivo;
    private Spinner spHospital;
    private Spinner spCbo;
    private Button btGravar;
    private Toolbar toolbar;

    List<CNESModel> hospitais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_profissional);

        super.onCreate(savedInstanceState);

        this.definirComponentes();

        this.configToolbar();

        this.profissionalBS = new ProfissionalBS(getApplicationContext());

        this.carregarCombos();

        this.instanciarProfissionalModel();

        this.btGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    private void definirComponentes() {

        btGravar = (Button) findViewById(R.id.bt_gravar);
        spCbo = (Spinner) findViewById(R.id.spinner_cbo);
        etCns = (EditText) findViewById(R.id.et_cns);
        etIne = (EditText) findViewById(R.id.et_ine);
        etNome = (EditText) findViewById(R.id.et_nome);
        etUsuario = (EditText) findViewById(R.id.et_usuario);
        etSenha = (EditText) findViewById(R.id.et_senha);
        etConfirmarSenha = (EditText) findViewById(R.id.et_confirmar_senha);
        mFlagAtivo = (CheckBox) findViewById(R.id.flag_ativo);
        spHospital = (Spinner) findViewById(R.id.spinner_hospital);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    private void configToolbar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Profissional");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfissionalActivity.this, MainActivity.class);
                intent.putExtra("fragment", "ProfissionalFragment");
                startActivity(intent);
                finish();
            }
        });

    }

    private void instanciarProfissionalModel() {

        this.profissionalModel = (ProfissionalModel) getIntent().getSerializableExtra("nomeTV");

        if (this.profissionalModel == null) {
            this.profissionalModel = new ProfissionalModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            spCbo.setSelection(new TipoModel().getComboCBO().indexOf(this.profissionalModel.getCbo()));
            etCns.setText(this.profissionalModel.getCns());
            etIne.setText(this.profissionalModel.getIne());
            etNome.setText(this.profissionalModel.getNome());
            etUsuario.setText(this.profissionalModel.getUsuario());
            etSenha.setText(this.profissionalModel.getSenha());
            etConfirmarSenha.setText(this.profissionalModel.getSenha());
            mFlagAtivo.setChecked(this.profissionalModel.getFlagAtivo());
            spHospital.setSelection(this.hospitais.indexOf(new CNESModel(this.profissionalModel.getCnesModel().getId())));
        }

    }

    private void carregarCombos() {

        CNESBS cnesBS = new CNESBS(this);
        hospitais = cnesBS.pesquisarAtivos();
        hospitais.add(0, new CNESModel("Selecione o CNES*"));
        ArrayAdapter<CNESModel> adapterHospital = new ArrayAdapter<>(this, R.layout.spinner_item, hospitais);
        spHospital.setAdapter(adapterHospital);
        adapterHospital.setDropDownViewResource(R.layout.spinner_dropdown_item);

        ArrayAdapter<TipoModel> spAdapter;

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboCBO());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spCbo.setAdapter(spAdapter);

    }

    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        if (Utilitario.isEmpty(etNome.getText().toString())) {
            aviso = Utilitario.addAviso("O nome do profissional está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(etCns.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNS está vazio", aviso);
            valido = false;
        } else if (!Utilitario.isCNSValido(etCns.getText().toString())) {
            aviso = Utilitario.addAviso("O código CNS é inválido", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(etIne.getText().toString())) {
            aviso = Utilitario.addAviso("O código INE está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(((TipoModel)spCbo.getSelectedItem()).getCodigo())) {
            aviso = Utilitario.addAviso("O código CBO está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(etUsuario.getText().toString())) {
            aviso = Utilitario.addAviso("O usuário está vazio", aviso);
            valido = false;
        }

        if (Utilitario.isEmpty(etSenha.getText().toString())) {
            aviso = Utilitario.addAviso("A senha está vazia", aviso);
            valido = false;
        } else if (!etSenha.getText().toString().equals(etConfirmarSenha.getText().toString())) {
            aviso = Utilitario.addAviso("As senhas não conferem", aviso);
            valido = false;
        }
        if (Utilitario.isEmpty(((CNESModel) spHospital.getSelectedItem()).getId())) {
            aviso = Utilitario.addAviso("O CNES está vazio", aviso);
            valido = false;
        }

        if (!aviso.isEmpty()) {
            Utilitario.alertar(ProfissionalActivity.this, aviso);
        }

        return valido;
    }

    private void gravar() {

        if (!validaCampos()) {
            return;
        }

        this.profissionalModel.setCbo((TipoModel)spCbo.getSelectedItem());
        this.profissionalModel.setCns(etCns.getText().toString());
        this.profissionalModel.setIne(etIne.getText().toString());
        this.profissionalModel.setNome(etNome.getText().toString());
        this.profissionalModel.setUsuario(etUsuario.getText().toString());
        this.profissionalModel.setSenha(etSenha.getText().toString());
        this.profissionalModel.setFlagAtivo(mFlagAtivo.isChecked());
        this.profissionalModel.setCnesModel((CNESModel) spHospital.getSelectedItem());

        profissionalBS.gravar(this.profissionalModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "ProfissionalFragment");
        startActivity(intent);

        finish();

    }

}
