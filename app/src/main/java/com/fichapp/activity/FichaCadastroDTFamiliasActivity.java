package com.fichapp.activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroDTFamiliasBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

public class FichaCadastroDTFamiliasActivity extends AppCompatActivity {

    private FamiliaModel familiaModel;
    private FichaCadastroDTModel fichaCadastroDTModel;
    private FichaCadastroDTFamiliasBS fichaCadastroDTFamiliasBS;

    private FrameLayout flItemCadastroFamilias;
    private Toolbar toolbar;

   /* private EditText etProntuarioFamiliar;
    private EditText etCnsResponsavel;
    private EditText etDataNascimentoResponsavel;
    private Spinner spSalarioFamiliar;
    private EditText etResideMes;
    private EditText etResideAno;
    private EditText etNumMembros;
    private CheckBox cbMudou;*/

    private FloatingActionButton fabAdicionarFamilia;
    private FloatingActionButton fabGravar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_dt_familias);

        this.definirComponentes();

        this.configComponentes();

        this.fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    private void definirComponentes() {

        flItemCadastroFamilias = (FrameLayout) findViewById(R.id.fl_item_cadastro_familias);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        /*etProntuarioFamiliar = (EditText) findViewById(R.id.et_num_prontuario_familiar);
        etCnsResponsavel = (EditText) findViewById(R.id.et_cns_responsavel);
        etDataNascimentoResponsavel = (EditText) findViewById(R.id.et_data_nascimento);
        spSalarioFamiliar = (Spinner) findViewById(R.id.sp_renda_familiar);
        etResideMes = (EditText) findViewById(R.id.et_reside_mes);
        etResideAno = (EditText) findViewById(R.id.et_reside_ano);
        etNumMembros = (EditText) findViewById(R.id.et_num_membros);
        cbMudou = (CheckBox) findViewById(R.id.cb_mudou_se);*/

        fabAdicionarFamilia = (FloatingActionButton) findViewById(R.id.fab_adicionar_familia);
        fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);

    }

    private void configComponentes() {

        setSupportActionBar(toolbar);
        toolbar.setTitle("Cadastro Familiar");

        this.carregarSpinner();

    }

    private void instanciarFichaVisitaDTModel() {

        this.familiaModel = (FamiliaModel) getIntent().getSerializableExtra("fichaCadastroDTFamilias");

        if (this.familiaModel == null) {
            this.familiaModel = new FamiliaModel();
        } else {
            setModelToActivity();
        }

    }

    private void gravar() {

        //if (!validaCampos()) { return; }

        setActivityToModel();

        this.fichaCadastroDTFamiliasBS.gravar(this.familiaModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, FichaCadastroDTActivity.class);
        startActivity(intent);

    }

    private void carregarSpinner() {

        /*
        ArrayAdapter<TipoModel> spAdapter;

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboRendaFamiliar());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spSalarioFamiliar.setAdapter(spAdapter);*/

    }

    private  void setActivityToModel() {

        this.familiaModel.setFichaCadastroDTModel(new FichaCadastroDTModel(fichaCadastroDTModel.getId()));

        /*this.familiaModel.setProntuario(etProntuarioFamiliar.getText().toString());
        this.familiaModel.setCnsResponsavel(etCnsResponsavel.getText().toString());
        this.familiaModel.setDataNascimentoResponsavel(Utilitario.getDate(etDataNascimentoResponsavel.getText().toString()));
        this.familiaModel.setRendaFamiliar((TipoModel) this.spSalarioFamiliar.getSelectedItem());
        this.familiaModel.setResideMes(Utilitario.isEmpty(etResideMes.getText().toString()) ? null : Integer.valueOf(etResideMes.getText().toString()));
        this.familiaModel.setResideAno(Utilitario.isEmpty(etResideAno.getText().toString()) ? null : Integer.valueOf(etResideAno.getText().toString()));
        this.familiaModel.setNumeroMembros(Utilitario.isEmpty(etNumMembros.getText().toString()) ? null : Integer.valueOf(etNumMembros.getText().toString()));
        this.familiaModel.setFlagMudou(cbMudou.isChecked());*/

    }

    private void setModelToActivity() {

        /*etProntuarioFamiliar.setText(this.familiaModel.getProntuario());
        etCnsResponsavel.setText(this.familiaModel.getCnsResponsavel());
        etDataNascimentoResponsavel.setText(Utilitario.getDataFormatada(this.familiaModel.getDataNascimentoResponsavel()));
        spSalarioFamiliar.setSelection(new TipoModel().getComboRendaFamiliar().indexOf(this.familiaModel.getRendaFamiliar()));
        etResideMes.setText(this.familiaModel.getResideMes().toString());
        etResideAno.setText(this.familiaModel.getResideAno().toString());
        etNumMembros.setText(this.familiaModel.getNumeroMembros().toString());
        cbMudou.setChecked(this.familiaModel.getFlagMudou());*/

    }

}
