package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.fichapp.R;
import com.fichapp.adapter.FichaCadastroDTFamiliasAdapter;
import com.fichapp.business.FichaCadastroDTFamiliasBS;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FichaCadastroDTFamiliasActivity extends AppCompatActivity {

    private FichaCadastroDTModel fichaCadastroDTModel;
    private FichaCadastroDTFamiliasBS fichaCadastroDTFamiliasBS;

    private Toolbar toolbar;

    private EditText etProntuarioFamiliar;
    private EditText etCnsResponsavel;
    private EditText etDataNascimentoResponsavel;
    private Spinner spSalarioFamiliar;
    private EditText etResideMes;
    private EditText etResideAno;
    private EditText etNumMembros;
    private CheckBox cbMudou;

    private Button btAdicionarFamilia;
    private FloatingActionButton fabGravar;

    private FichaCadastroDTFamiliasAdapter adapter;
    protected RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_dt_familias);

        this.definirComponentes();

        this.configComponentes();

        this.instanciarFichaCadastroDTModel();

        this.configData();

        this.btAdicionarFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarFamilia();
            }
        });

        this.fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    private void definirComponentes() {

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_ficha_familias_dt);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        etProntuarioFamiliar = (EditText) findViewById(R.id.et_num_prontuario_familiar);
        etCnsResponsavel = (EditText) findViewById(R.id.et_cns_responsavel);
        etDataNascimentoResponsavel = (EditText) findViewById(R.id.et_data_nascimento);
        spSalarioFamiliar = (Spinner) findViewById(R.id.sp_renda_familiar);
        etResideMes = (EditText) findViewById(R.id.et_reside_mes);
        etResideAno = (EditText) findViewById(R.id.et_reside_ano);
        etNumMembros = (EditText) findViewById(R.id.et_num_membros);
        cbMudou = (CheckBox) findViewById(R.id.cb_mudou_se);

        btAdicionarFamilia = (Button) findViewById(R.id.bt_adicionar_familia);
        fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);

    }

    private void instanciarFichaCadastroDTModel() {

        this.fichaCadastroDTModel = (FichaCadastroDTModel) getIntent().getSerializableExtra("fichaCadastroDT");
        adapter = new FichaCadastroDTFamiliasAdapter(this, this.fichaCadastroDTModel.getFamilias());
        mRecyclerView.setAdapter(adapter);

    }

    private void configComponentes() {

        setSupportActionBar(toolbar);
        toolbar.setTitle("Cadastro Familiar");

        this.configToolbar();

        this.carregarSpinner();

        this.configRV();

    }

    private void configToolbar() {

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Famílias");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FichaCadastroDTFamiliasActivity.this, FichaCadastroDTActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void adicionarFamilia() {

        //if (!validaCampos()) { return; }

        adapter.addListItem(getFamilia());

    }

    private void gravar() {

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, FichaCadastroDTActivity.class);
        intent.putExtra("fichaCadastroDT", fichaCadastroDTModel);
        startActivity(intent);

    }

    private void carregarSpinner() {

        ArrayAdapter<TipoModel> spAdapter;

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboRendaFamiliar());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spSalarioFamiliar.setAdapter(spAdapter);

    }

    private FamiliaModel getFamilia() {

        FamiliaModel familiaModel = new FamiliaModel();
        familiaModel.setFichaCadastroDTModel(this.fichaCadastroDTModel);
        familiaModel.setProntuario(etProntuarioFamiliar.getText().toString());
        familiaModel.setCnsResponsavel(etCnsResponsavel.getText().toString());
        familiaModel.setDataNascimentoResponsavel(Utilitario.getDate(etDataNascimentoResponsavel.getText().toString()));
        familiaModel.setRendaFamiliar((TipoModel) this.spSalarioFamiliar.getSelectedItem());
        familiaModel.setResideMes(Utilitario.isEmpty(etResideMes.getText().toString()) ? null : Integer.valueOf(etResideMes.getText().toString()));
        familiaModel.setResideAno(Utilitario.isEmpty(etResideAno.getText().toString()) ? null : Integer.valueOf(etResideAno.getText().toString()));
        familiaModel.setNumeroMembros(Utilitario.isEmpty(etNumMembros.getText().toString()) ? null : Integer.valueOf(etNumMembros.getText().toString()));
        familiaModel.setFlagMudou(cbMudou.isChecked());

        return familiaModel;

    }

    protected void configRV() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void configData() {

        final Calendar registroCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataNascimentoResponsavel.getText().toString())) {
            registroCalendar.setTime(Utilitario.getDate(etDataNascimentoResponsavel.getText().toString()));
        }

        final DatePickerDialog.OnDateSetListener dataRegistro = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                registroCalendar.set(Calendar.YEAR, year);
                registroCalendar.set(Calendar.MONTH, monthOfYear);
                registroCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etDataNascimentoResponsavel, registroCalendar);
            }
        };

        etDataNascimentoResponsavel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(FichaCadastroDTFamiliasActivity.this, dataRegistro,
                        registroCalendar.get(Calendar.YEAR),
                        registroCalendar.get(Calendar.MONTH),
                        registroCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel(EditText editText, Calendar calendar) {

        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        editText.setText(sdf.format(calendar.getTime()));
    }

}
