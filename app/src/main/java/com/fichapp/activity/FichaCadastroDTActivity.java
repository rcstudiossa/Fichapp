package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroDTBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FichaCadastroDTActivity extends TemplateActivity {

    private FichaCadastroDTModel fichaCadastroDTModel;
    private FichaCadastroDTBS fichaCadastroDTBS;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Toolbar toolbar;

    private Spinner spTipoImovel;
    private Spinner spSituacaoMoradia;
    private Spinner spCondicaoPosseTerra;
    private Spinner spNumMoradores;
    private Spinner spNumComodos;
    private Spinner spMaterialParedes;
    private Spinner spAbastecimentoAgua;
    private Spinner spAguaConsumo;
    private Spinner spEscoamentoBanheiro;
    private Spinner spDestinoLixo;

    private EditText etDataRegistro;

    private EditText etCep;
    private EditText etUf;
    private EditText etMunicipio;
    private EditText etBairro;
    private EditText etTipoLogradouro;
    private EditText etNomeLogradouro;
    private EditText etComplemento;
    private EditText etPontoReferencia;
    private EditText etNumero;
    private CheckBox cbSemNumero;
    private EditText etMicroarea;
    private CheckBox cbForaDeArea;
    private EditText etTelefoneResidencia;
    private EditText etTelefoneContato;

    private RadioGroup rgLocalizacao;
    private RadioGroup rgAcessoDomicilio;
    private RadioGroup rgTemEnergiaEletrica;

    private RadioGroup rgTemAnimais;
    private EditText etQuantidadeAnimais;

    private CheckBox cbGato;
    private CheckBox cbCachorro;
    private CheckBox cbPassaro;
    private CheckBox cbOutrosAnimais;

    private EditText etNomeInstituicao;
    private RadioGroup rgOutrosProfissionais;
    private EditText etNomeResponsavel;
    private EditText etCnsResponsavel;
    private EditText etCargoInstituicao;
    private EditText etTelefoneContatoResponsavel;

    private FloatingActionButton fabGravar;

    private LinearLayout llRodape;

    public static FichaCadastroDTActivity fichaCadastroDTActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_ficha_cadastro_dt);
        super.onCreate(savedInstanceState);

        fichaCadastroDTActivity = this;

        this.instanciarFichaVisitaDTModel();

        this.definirComponentes();

        this.configToolbar();

        this.carregarSpinners();

        this.desabilitaCampos();

        this.configData();

        fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });


    }

    public static FichaCadastroDTActivity getInstance() {
        return fichaCadastroDTActivity;
    }

    private void definirComponentes() {

        //EditTexts
        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        etCep = (EditText) findViewById(R.id.tv_cep);
        etUf = (EditText) findViewById(R.id.et_uf);
        etMunicipio = (EditText) findViewById(R.id.et_municipio);
        etBairro = (EditText) findViewById(R.id.et_bairro);
        etTipoLogradouro = (EditText) findViewById(R.id.et_tipo_logradouro);
        etNomeLogradouro = (EditText) findViewById(R.id.et_nome_logradouro);
        etComplemento = (EditText) findViewById(R.id.et_complemento);
        etPontoReferencia = (EditText) findViewById(R.id.et_ponto_referencia);
        etNumero = (EditText) findViewById(R.id.et_numero_casa);
        etMicroarea = (EditText) findViewById(R.id.et_microarea);
        etTelefoneResidencia = (EditText) findViewById(R.id.et_tel_residencial);
        etTelefoneContato = (EditText) findViewById(R.id.et_tel_contato);
        etQuantidadeAnimais = (EditText) findViewById(R.id.et_quantidade_animais);
        etNomeInstituicao = (EditText) findViewById(R.id.et_nome_instituicao_permanencia);
        etNomeResponsavel = (EditText) findViewById(R.id.et_nome_responsavel);
        etCnsResponsavel = (EditText) findViewById(R.id.et_cns_responsavel);
        etCargoInstituicao = (EditText) findViewById(R.id.et_cargo_profissional);
        etTelefoneContatoResponsavel = (EditText) findViewById(R.id.et_tel_contato_responsavel);

        //Spinners
        spTipoImovel = (Spinner) findViewById(R.id.spinner_tipo_imovel);
        spSituacaoMoradia = (Spinner) findViewById(R.id.spinner_situacao_moradia);
        spCondicaoPosseTerra = (Spinner) findViewById(R.id.spinner_condicao_posse_terra);
        spNumMoradores = (Spinner) findViewById(R.id.spinner_numero_moradores);
        spNumComodos = (Spinner) findViewById(R.id.spinner_numero_comodos);
        spMaterialParedes = (Spinner) findViewById(R.id.spinner_material_paredes);
        spAbastecimentoAgua = (Spinner) findViewById(R.id.spinner_abastecimento_agua);
        spAguaConsumo = (Spinner) findViewById(R.id.spinner_agua_consumo);
        spEscoamentoBanheiro = (Spinner) findViewById(R.id.spinner_escoamento_banheiro);
        spDestinoLixo = (Spinner) findViewById(R.id.spinner_destino_lixo);

        //RadioGroups
        rgAcessoDomicilio = (RadioGroup) findViewById(R.id.rg_acesso_domicilio);
        rgLocalizacao = (RadioGroup) findViewById(R.id.rg_localizacao);
        rgOutrosProfissionais = (RadioGroup) findViewById(R.id.rg_outros_profissionais);
        rgTemAnimais = (RadioGroup) findViewById(R.id.rg_animais);
        rgTemEnergiaEletrica = (RadioGroup) findViewById(R.id.rg_disponibilidade_energia);

        //Checkboxes
        cbSemNumero = (CheckBox) findViewById(R.id.cb_sem_numero);
        cbForaDeArea = (CheckBox) findViewById(R.id.cb_fora_de_area);
        cbGato = (CheckBox) findViewById(R.id.cb_gato);
        cbCachorro = (CheckBox) findViewById(R.id.cb_cachorro);
        cbPassaro = (CheckBox) findViewById(R.id.cb_passaro);
        cbOutrosAnimais = (CheckBox) findViewById(R.id.cb_outros_animais);

        fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);

        llRodape = (LinearLayout) findViewById(R.id.include_rodape_cadastro_dt);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        this.fichaCadastroDTBS = new FichaCadastroDTBS(getApplication());

    }

    private void configToolbar() {

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cadastro Domiciliar/Territorial");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FichaCadastroDTActivity.this, MainActivity.class);
                intent.putExtra("fragment", "FichaCadastroDTFragment");
                startActivity(intent);
                finish();
            }
        });

    }

    private void carregarSpinners() {

        this.carregarSpinnerTipoImovel(spTipoImovel);

        ArrayAdapter<TipoModel> spAdapter;

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboSituacaoMoradia());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spSituacaoMoradia.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboPosseTerra());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spCondicaoPosseTerra.setAdapter(spAdapter);

        ArrayAdapter spAdapterNumMoradores = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumMoradores.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spNumMoradores.setAdapter(spAdapterNumMoradores);

        ArrayAdapter spAdapterNumComodos = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumComodos.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spNumComodos.setAdapter(spAdapterNumComodos);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboMaterialParedes());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spMaterialParedes.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboAbastecimentoAgua());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spAbastecimentoAgua.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboAguaConsumo());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spAguaConsumo.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboEscoamentoBanheiro());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spEscoamentoBanheiro.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboDestinoLixo());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spDestinoLixo.setAdapter(spAdapter);

    }

    private void configData() {

        final Calendar registroCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            registroCalendar.setTime(Utilitario.getDate(etDataRegistro.getText().toString()));
        }

        final DatePickerDialog.OnDateSetListener dataRegistro = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                registroCalendar.set(Calendar.YEAR, year);
                registroCalendar.set(Calendar.MONTH, monthOfYear);
                registroCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etDataRegistro, registroCalendar);
            }
        };

        etDataRegistro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(FichaCadastroDTActivity.this, dataRegistro,
                        registroCalendar.get(Calendar.YEAR),
                        registroCalendar.get(Calendar.MONTH),
                        registroCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void instanciarFichaVisitaDTModel() {

        this.fichaCadastroDTModel = (FichaCadastroDTModel) getIntent().getSerializableExtra("fichaCadastroDT");

        if (this.fichaCadastroDTModel == null) {
            this.fichaCadastroDTModel = new FichaCadastroDTModel();
        } else {
            this.setModelToActivity();
        }

    }

    private void gravar() {

        /* if (!validaCampos()) { return; } */

        setActivityToModel();

        this.fichaCadastroDTBS.gravar(this.fichaCadastroDTModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaCadastroDTFragment");
        startActivity(intent);

        finish();

        /*
        Intent intent = new Intent(this, CadastroDTFamiliasActivity.class);
        startActivity(intent); */


    }

    private void desabilitaCampos() {

        this.desabilitaEditText(cbSemNumero, etNumero);
        this.desabilitaEditText(cbForaDeArea, etMicroarea);

        this.desabilitaEditText(rgTemAnimais, 1, etQuantidadeAnimais);

        //this.desabilitaRodape(llRodape);

    }

    private boolean validaCampos() {

        boolean valido = true;

        if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            Snackbar.make(getCurrentFocus(), "Preencha a data de registro.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        return valido;

    }


    private void setPosicaoSelecionadoRG(RadioGroup radioGroup, Integer valor) {

        if (Utilitario.isEmpty(valor) || valor.equals(-1)) {
            return;
        }

        if (radioGroup == rgAcessoDomicilio) {

            switch (valor) {
                case 89: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 90: {
                    ativaRG(radioGroup, 1);
                    break;
                }
                case 91: {
                    ativaRG(radioGroup, 2);
                    break;
                }
                case 92: {
                    ativaRG(radioGroup, 3);
                    break;
                }
            }

        } else if (radioGroup == rgLocalizacao) {
            switch (valor) {
                case 83: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 84: {
                    ativaRG(radioGroup, 1);
                    break;
                }
            }

        } else {
            ativaRG(radioGroup, valor);
        }


    }


    private void setModelToActivity() {

        //EditTexts
        etDataRegistro.setText(Utilitario.getDataFormatada(this.fichaCadastroDTModel.getDataRegistro()));
        etCep.setText(this.fichaCadastroDTModel.getCep());
        etUf.setText(this.fichaCadastroDTModel.getUf());
        etMunicipio.setText(this.fichaCadastroDTModel.getMunicipio());
        etBairro.setText(this.fichaCadastroDTModel.getBairro());
        etTipoLogradouro.setText(this.fichaCadastroDTModel.getTipoLogradouro());
        etNomeLogradouro.setText(this.fichaCadastroDTModel.getNomeLogragouro());
        etComplemento.setText(this.fichaCadastroDTModel.getComplemento());
        etPontoReferencia.setText(this.fichaCadastroDTModel.getPontoReferencia());
        etNumero.setText(this.fichaCadastroDTModel.getNumero());
        etMicroarea.setText(this.fichaCadastroDTModel.getMicroArea());
        etTelefoneResidencia.setText(this.fichaCadastroDTModel.getTelResidencia());
        etTelefoneContato.setText(this.fichaCadastroDTModel.getTelContato());
        etQuantidadeAnimais.setText(this.fichaCadastroDTModel.getQtdAnimais());
        etNomeInstituicao.setText(this.fichaCadastroDTModel.getNomeInstituicao());
        etNomeResponsavel.setText(this.fichaCadastroDTModel.getNomeResponsavel());
        etCnsResponsavel.setText(this.fichaCadastroDTModel.getCnsResponsavel());
        etCargoInstituicao.setText(this.fichaCadastroDTModel.getCargoInstituicao());
        etTelefoneContatoResponsavel.setText(this.fichaCadastroDTModel.getTelContatoResponsavel());

        //Spinners
        spTipoImovel.setSelection(new TipoModel().getComboTipoImovel().indexOf(this.fichaCadastroDTModel.getTipoImovel()));
        spDestinoLixo.setSelection(new TipoModel().getComboDestinoLixo().indexOf(this.fichaCadastroDTModel.getDestinoLixo()));
        spMaterialParedes.setSelection(new TipoModel().getComboMaterialParedes().indexOf(this.fichaCadastroDTModel.getMaterialParedes()));
        spAbastecimentoAgua.setSelection(new TipoModel().getComboAbastecimentoAgua().indexOf(this.fichaCadastroDTModel.getAbastecimentoAgua()));
        spAguaConsumo.setSelection(new TipoModel().getComboAguaConsumo().indexOf(this.fichaCadastroDTModel.getAguaConsumo()));
        spEscoamentoBanheiro.setSelection(new TipoModel().getComboEscoamentoBanheiro().indexOf(this.fichaCadastroDTModel.getEscoamentoBanheiro()));
        spSituacaoMoradia.setSelection(new TipoModel().getComboSituacaoMoradia().indexOf(this.fichaCadastroDTModel.getSituacaoMoradia()));
        spCondicaoPosseTerra.setSelection(new TipoModel().getComboPosseTerra().indexOf(this.fichaCadastroDTModel.getCondicaoTerra()));

        //RadioGroups
        setPosicaoSelecionadoRG(rgAcessoDomicilio, this.fichaCadastroDTModel.getAcessoDomicilio());
        setPosicaoSelecionadoRG(rgLocalizacao, this.fichaCadastroDTModel.getLocalizacao());
        setPosicaoSelecionadoRG(rgOutrosProfissionais, this.fichaCadastroDTModel.getFlagOutrosProfissionais());
        setPosicaoSelecionadoRG(rgTemAnimais, this.fichaCadastroDTModel.getFlagAnimais());
        setPosicaoSelecionadoRG(rgTemEnergiaEletrica, this.fichaCadastroDTModel.getFlagEnergiaEletrica());

        //Checkboxes
        cbSemNumero.setChecked(this.fichaCadastroDTModel.getFlagSemNumero());
        cbForaDeArea.setChecked(this.fichaCadastroDTModel.getFlagForaDeArea());
        cbGato.setChecked(this.fichaCadastroDTModel.getFlagGato());
        cbCachorro.setChecked(this.fichaCadastroDTModel.getFlagCachorro());
        cbPassaro.setChecked(this.fichaCadastroDTModel.getFlagPassaro());
        cbOutrosAnimais.setChecked(this.fichaCadastroDTModel.getFlagOutrosAnimais());


    }

    private void setActivityToModel() {

        this.fichaCadastroDTModel.setProfissionalModel(new ProfissionalModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("id", 0)));
        this.fichaCadastroDTModel.setCnesModel(new CNESModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("cnes_id", 0)));
        this.fichaCadastroDTModel.setDataRegistro(Utilitario.getDate(etDataRegistro.getText().toString()));

        //EditTexts
        this.fichaCadastroDTModel.setCep(etCep.getText().toString());
        this.fichaCadastroDTModel.setUf(etUf.getText().toString());
        this.fichaCadastroDTModel.setMunicipio(etMunicipio.getText().toString());
        this.fichaCadastroDTModel.setBairro(etBairro.getText().toString());
        this.fichaCadastroDTModel.setTipoLogradouro(etTipoLogradouro.getText().toString());
        this.fichaCadastroDTModel.setNomeLogragouro(etNomeLogradouro.getText().toString());
        this.fichaCadastroDTModel.setComplemento(etComplemento.getText().toString());
        this.fichaCadastroDTModel.setPontoReferencia(etPontoReferencia.getText().toString());
        this.fichaCadastroDTModel.setNumero(etNumero.getText().toString());
        this.fichaCadastroDTModel.setMicroArea(etMicroarea.getText().toString());
        this.fichaCadastroDTModel.setTelResidencia(etTelefoneResidencia.getText().toString());
        this.fichaCadastroDTModel.setTelContato(etTelefoneContato.getText().toString());
        this.fichaCadastroDTModel.setQtdAnimais(Utilitario.isEmpty(etQuantidadeAnimais.getText().toString()) ? null : Integer.valueOf(etQuantidadeAnimais.getText().toString()));
        this.fichaCadastroDTModel.setNomeInstituicao(etNomeInstituicao.getText().toString());
        this.fichaCadastroDTModel.setNomeResponsavel(etNomeResponsavel.getText().toString());
        this.fichaCadastroDTModel.setCnsResponsavel(etCnsResponsavel.getText().toString());
        this.fichaCadastroDTModel.setCargoInstituicao(etCargoInstituicao.getText().toString());
        this.fichaCadastroDTModel.setTelContatoResponsavel(etTelefoneContatoResponsavel.getText().toString());

        //Spinners
        this.fichaCadastroDTModel.setTipoImovel((TipoModel) this.spTipoImovel.getSelectedItem());
        this.fichaCadastroDTModel.setSituacaoMoradia((TipoModel) this.spSituacaoMoradia.getSelectedItem());
        this.fichaCadastroDTModel.setCondicaoTerra((TipoModel) this.spCondicaoPosseTerra.getSelectedItem());
        this.fichaCadastroDTModel.setDestinoLixo((TipoModel) this.spDestinoLixo.getSelectedItem());
        this.fichaCadastroDTModel.setAbastecimentoAgua((TipoModel) this.spAbastecimentoAgua.getSelectedItem());
        this.fichaCadastroDTModel.setAguaConsumo((TipoModel) this.spAguaConsumo.getSelectedItem());
        this.fichaCadastroDTModel.setEscoamentoBanheiro((TipoModel) this.spEscoamentoBanheiro.getSelectedItem());
        this.fichaCadastroDTModel.setMaterialParedes((TipoModel) this.spMaterialParedes.getSelectedItem());

        //RadioGroups
        this.fichaCadastroDTModel.setAcessoDomicilio
                (this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(0) ? 89 :
                        this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(1) ? 90 :
                                this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(2) ? 91 :
                                        this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(3) ? 92 : -1);

        this.fichaCadastroDTModel.setLocalizacao
                (this.getPosicaoSelecionadoRG(rgLocalizacao).equals(0) ? 83 :
                        this.getPosicaoSelecionadoRG(rgLocalizacao).equals(1) ? 84 : -1);

        this.fichaCadastroDTModel.setFlagOutrosProfissionais(this.getPosicaoSelecionadoRG(rgOutrosProfissionais));
        this.fichaCadastroDTModel.setFlagAnimais(this.getPosicaoSelecionadoRG(rgTemAnimais));
        this.fichaCadastroDTModel.setFlagEnergiaEletrica(this.getPosicaoSelecionadoRG(rgTemEnergiaEletrica));

        //Checkboxes
        this.fichaCadastroDTModel.setFlagSemNumero(cbSemNumero.isChecked());
        this.fichaCadastroDTModel.setFlagForaDeArea(cbForaDeArea.isChecked());
        this.fichaCadastroDTModel.setFlagGato(cbGato.isChecked());
        this.fichaCadastroDTModel.setFlagCachorro(cbCachorro.isChecked());
        this.fichaCadastroDTModel.setFlagPassaro(cbPassaro.isChecked());
        this.fichaCadastroDTModel.setFlagOutrosAnimais(cbOutrosAnimais.isChecked());


    }


}
