package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroDTBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class FichaCadastroDTActivity extends TemplateActivity {

    private FichaCadastroDTModel fichaCadastroDTModel;
    private FichaCadastroDTBS fichaCadastroDTBS;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Toolbar toolbar;

    private Spinner spTipoImovel;
    private Spinner spSituacaoMoradia;
    private Spinner spCondicaoPosseTerra;
    private EditText etNumMoradores;
    private EditText etNumComodos;
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
    private RadioGroup rgTipoDomicilio;
    private RadioGroup rgAcessoDomicilio;
    private RadioGroup rgTemEnergiaEletrica;

    private RadioGroup rgTemAnimais;
    private EditText etQuantidadeAnimais;

    private LinearLayout llAnimais;
    private CheckBox cbGato;
    private CheckBox cbCachorro;
    private CheckBox cbPassaro;
    private CheckBox cbOutrosAnimais;

    private CheckBox cbVisitaRecusada;

    private LinearLayout llInstituicaoPermanencia;
    private EditText etNomeInstituicao;
    private RadioGroup rgOutrosProfissionais;
    private EditText etNomeResponsavel;
    private EditText etCnsResponsavel;
    private EditText etCargoInstituicao;
    private EditText etTelefoneContatoResponsavel;

    private Button btCadastrarFamilias;
    private FloatingActionButton fabGravar;

    private LinearLayout llRodape;
    private LinearLayout llCondicoesMoradia;

    private Integer indexRgTemAnimais;
    private Boolean flagVisitaRecusada;
    private Boolean flagSemNumero;
    private Boolean flagForaDeArea;

    public static FichaCadastroDTActivity fichaCadastroDTActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_ficha_cadastro_dt);
        super.onCreate(savedInstanceState);

        fichaCadastroDTActivity = this;

        this.definirComponentes();

        this.configToolbar();

        this.carregarSpinners();

        this.configData();

        this.instanciarFichaCadastroDTModel();

        this.lerRestricoes();

        this.desabilitaCampos();

        fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

        btCadastrarFamilias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FichaCadastroDTActivity.this, FichaCadastroDTFamiliasActivity.class);
                intent.putExtra("fichaCadastroDT", fichaCadastroDTModel);
                startActivity(intent);
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
        etNumMoradores = (EditText) findViewById(R.id.et_num_moradores);
        etNumComodos = (EditText) findViewById(R.id.et_num_comodos);
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
        spMaterialParedes = (Spinner) findViewById(R.id.spinner_material_paredes);
        spAbastecimentoAgua = (Spinner) findViewById(R.id.spinner_abastecimento_agua);
        spAguaConsumo = (Spinner) findViewById(R.id.spinner_agua_consumo);
        spEscoamentoBanheiro = (Spinner) findViewById(R.id.spinner_escoamento_banheiro);
        spDestinoLixo = (Spinner) findViewById(R.id.spinner_destino_lixo);

        //RadioGroups
        rgAcessoDomicilio = (RadioGroup) findViewById(R.id.rg_acesso_domicilio);
        rgTipoDomicilio = (RadioGroup) findViewById(R.id.rg_tipo_domicilio);
        rgLocalizacao = (RadioGroup) findViewById(R.id.rg_localizacao);
        rgOutrosProfissionais = (RadioGroup) findViewById(R.id.rg_outros_profissionais);
        rgTemAnimais = (RadioGroup) findViewById(R.id.rg_animais);
        rgTemEnergiaEletrica = (RadioGroup) findViewById(R.id.rg_disponibilidade_energia);

        //Checkboxes
        cbVisitaRecusada = (CheckBox) findViewById(R.id.cb_visita_recusada);
        cbSemNumero = (CheckBox) findViewById(R.id.cb_sem_numero);
        cbForaDeArea = (CheckBox) findViewById(R.id.cb_fora_de_area);
        cbGato = (CheckBox) findViewById(R.id.cb_gato);
        cbCachorro = (CheckBox) findViewById(R.id.cb_cachorro);
        cbPassaro = (CheckBox) findViewById(R.id.cb_passaro);
        cbOutrosAnimais = (CheckBox) findViewById(R.id.cb_outros_animais);

        llAnimais = (LinearLayout) findViewById(R.id.ll_animais);
        llCondicoesMoradia = (LinearLayout) findViewById(R.id.ll_condicoes_moradia);
        llInstituicaoPermanencia = (LinearLayout) findViewById(R.id.ll_instituicao_permanencia);

        btCadastrarFamilias = (Button) findViewById(R.id.bt_cadastrar_familias);

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

    private void instanciarFichaCadastroDTModel() {

        this.fichaCadastroDTModel = (FichaCadastroDTModel) getIntent().getSerializableExtra("fichaCadastroDT");

        if (this.fichaCadastroDTModel == null) {
            this.fichaCadastroDTModel = new FichaCadastroDTModel();
            this.fichaCadastroDTModel.setFamilias(new ArrayList<FamiliaModel>());
        } else {
            this.setModelToActivity();
        }

    }

    private void gravar() {

        /* if (!validaCampos()) { return; } */

        this.setActivityToModel();

        this.fichaCadastroDTBS.gravar(this.fichaCadastroDTModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaCadastroDTFragment");
        startActivity(intent);

        finish();

        /*
        Intent intent = new Intent(this, FichaCadastroDTFamiliasActivity.class);
        startActivity(intent); */


    }

    private void lerRestricoes() {

        spTipoImovel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                desabilitaCondicoesMoradia(position, cbVisitaRecusada.isChecked());
                //desabilitaInstituicaoPermanencia(position, cbVisitaRecusada.isChecked());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spTipoImovel.setSelection(0);
            }
        });

        cbVisitaRecusada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                desabilitaCondicoesMoradia(spTipoImovel.getSelectedItemPosition(), b);
                //desabilitaInstituicaoPermanencia(spTipoImovel.getSelectedItemPosition(), b);
            }
        });

        rgTemAnimais.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                indexRgTemAnimais = i;
            }
        });

    }

    private void desabilitaCampos() {

        this.desabilitaEditText(cbSemNumero, etNumero);
        this.desabilitaEditText(cbForaDeArea, etMicroarea);


        //this.desabilitaAnimais();

        //this.desabilitaRodape(llRodape);

    }

    private void desabilitaAnimais() {

        if (/*indexSpTipoImovel != 1 ||*/ flagVisitaRecusada) {
            desabilitaRadioGroup(rgTemAnimais);
            desabilitaLinearLayout(llAnimais);
            desabilitaEditText(etQuantidadeAnimais);
        } else {
            habilitaRadioGroup(rgTemAnimais);
            habilitaLinearLayout(llAnimais);
            habilitaEditText(etQuantidadeAnimais);
        }

        desabilitaEditText(rgTemAnimais, 1, etQuantidadeAnimais);

        //TODO: Deve ser maior ou igual ao número de opções selecionadas no campo animaisNoDomicilio.

    }

    private void desabilitaCondicoesMoradia(Integer posicaoTipoImovel, Boolean flagVisitaRecusada) {

        List<Integer> tipos = new ArrayList<>(Arrays.asList(2,3,4,5,6,12,13));

        boolean desaparecer = tipos.contains(posicaoTipoImovel) || flagVisitaRecusada;

        this.llCondicoesMoradia.setVisibility(desaparecer ? View.GONE : View.VISIBLE);

        if (desaparecer) {

            this.spSituacaoMoradia.setSelection(0);
            this.rgLocalizacao.clearCheck();
            this.rgTipoDomicilio.clearCheck();
            this.rgAcessoDomicilio.clearCheck();
            this.spCondicaoPosseTerra.setSelection(0);
            this.spMaterialParedes.setSelection(0);
            this.rgTemEnergiaEletrica.clearCheck();
            this.spAbastecimentoAgua.setSelection(0);
            this.spAguaConsumo.setSelection(0);
            this.spEscoamentoBanheiro.setSelection(0);
            this.spDestinoLixo.setSelection(0);
            this.rgTemAnimais.clearCheck();
            this.etQuantidadeAnimais.getText().clear();
            this.cbGato.setChecked(false);
            this.cbCachorro.setChecked(false);
            this.cbPassaro.setChecked(false);
            this.cbOutrosAnimais.setChecked(false);

        }

    }

    private void desabilitaInstituicaoPermanencia(Integer position, Boolean flagVisitaRecusada) {

        if ((!(position == 7 || position == 8 || position == 9 || position == 10 || position == 11)) || (flagVisitaRecusada)) {

            this.llInstituicaoPermanencia.setVisibility(View.GONE);

            this.etNomeInstituicao.getText().clear();
            this.rgOutrosProfissionais.clearCheck();
            this.etNomeResponsavel.getText().clear();
            this.etCnsResponsavel.getText().clear();
            this.etCargoInstituicao.getText().clear();
            this.etTelefoneContatoResponsavel.getText().clear();

        }

    }

    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            aviso = Utilitario.addAviso("Preencha a data de registro.", aviso);
            valido = false;
        }

        if (!cbVisitaRecusada.isChecked()) {

            //TODO: areaProducaoRural

            if (((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == null) {
                aviso = Utilitario.addAviso("Selecione o tipo de imóvel.", aviso);
                valido = false;
            } else if (Utilitario.isEmpty(etBairro.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha o bairro.", aviso);
                valido = false;
            } else if (Utilitario.isEmpty(etCep.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha o CEP.", aviso);
                valido = false;
            } else if (Utilitario.isEmpty(etMunicipio.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha o Município.", aviso);
                valido = false;
            } else if (Utilitario.isEmpty(etNomeLogradouro.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha o nome do logradouro.", aviso);
                valido = false;
            } else if ((Utilitario.isEmpty(etNumero.getText().toString())) && cbSemNumero.isChecked()) {
                aviso = Utilitario.addAviso("Preencha o número.", aviso);
                valido = false;
            } else if (Utilitario.isEmpty(etUf.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha o UF.", aviso);
                valido = false;
            } else if (Utilitario.isEmpty(etTipoLogradouro.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha o tipo do logradouro.", aviso);
                valido = false;
            } else if ((Utilitario.isEmpty(etMicroarea.getText().toString())) && !cbForaDeArea.isChecked()) {
                aviso = Utilitario.addAviso("Preencha a microárea.", aviso);
                valido = false;
            } else if (rgLocalizacao.getCheckedRadioButtonId() == -1) {
                aviso = Utilitario.addAviso("Selecione a localização.", aviso);
                valido = false;
            } else if ((((TipoModel)spSituacaoMoradia.getSelectedItem()).getCodigo() == null) && (!(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == 7 || ((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == 8 || ((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == 9 || ((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == 10 || ((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == 11))) {
                aviso = Utilitario.addAviso("Selecione a situação de moradia.", aviso);
                valido = false;
            } else if ((Utilitario.isEmpty(etNomeResponsavel.getText().toString()))) {
                aviso = Utilitario.addAviso("Preencha o nome do responsável técnico.", aviso);
                valido = false;
            }

        }

        if (!aviso.isEmpty()) {
            Utilitario.alertar(FichaCadastroDTActivity.this, aviso);
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
        etQuantidadeAnimais.setText(this.fichaCadastroDTModel.getQtdAnimais() == null ? null : this.fichaCadastroDTModel.getQtdAnimais().toString());
        etNomeInstituicao.setText(this.fichaCadastroDTModel.getNomeInstituicao());
        etNomeResponsavel.setText(this.fichaCadastroDTModel.getNomeResponsavel());
        etCnsResponsavel.setText(this.fichaCadastroDTModel.getCnsResponsavel());
        etCargoInstituicao.setText(this.fichaCadastroDTModel.getCargoInstituicao());
        etTelefoneContatoResponsavel.setText(this.fichaCadastroDTModel.getTelContatoResponsavel());

        //Spinners
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getTipoImovel()) && this.fichaCadastroDTModel.getTipoImovel().getCodigo() > 0) {
            spTipoImovel.setSelection(new TipoModel().getComboTipoImovel().indexOf(this.fichaCadastroDTModel.getTipoImovel()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getDestinoLixo()) && this.fichaCadastroDTModel.getDestinoLixo().getCodigo() > 0) {
            spDestinoLixo.setSelection(new TipoModel().getComboDestinoLixo().indexOf(this.fichaCadastroDTModel.getDestinoLixo()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getMaterialParedes()) && this.fichaCadastroDTModel.getMaterialParedes().getCodigo() > 0) {
            spMaterialParedes.setSelection(new TipoModel().getComboMaterialParedes().indexOf(this.fichaCadastroDTModel.getMaterialParedes()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getAbastecimentoAgua()) && this.fichaCadastroDTModel.getAbastecimentoAgua().getCodigo() > 0) {
            spAbastecimentoAgua.setSelection(new TipoModel().getComboAbastecimentoAgua().indexOf(this.fichaCadastroDTModel.getAbastecimentoAgua()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getAguaConsumo()) && this.fichaCadastroDTModel.getAguaConsumo().getCodigo() > 0) {
            spAguaConsumo.setSelection(new TipoModel().getComboAguaConsumo().indexOf(this.fichaCadastroDTModel.getAguaConsumo()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getEscoamentoBanheiro()) && this.fichaCadastroDTModel.getEscoamentoBanheiro().getCodigo() > 0) {
            spEscoamentoBanheiro.setSelection(new TipoModel().getComboEscoamentoBanheiro().indexOf(this.fichaCadastroDTModel.getEscoamentoBanheiro()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getSituacaoMoradia()) && this.fichaCadastroDTModel.getSituacaoMoradia().getCodigo() > 0) {
            spSituacaoMoradia.setSelection(new TipoModel().getComboSituacaoMoradia().indexOf(this.fichaCadastroDTModel.getSituacaoMoradia()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getCondicaoTerra()) && this.fichaCadastroDTModel.getCondicaoTerra().getCodigo() > 0) {
            spCondicaoPosseTerra.setSelection(new TipoModel().getComboPosseTerra().indexOf(this.fichaCadastroDTModel.getCondicaoTerra()));
        }

        //RadioGroups
        //TODO: setPosicaoSelecionadoRG(rgTipoDomicilio, this.fichaCadastroDTModel.getTipoDomicilio());
        setPosicaoSelecionadoRG(rgAcessoDomicilio, this.fichaCadastroDTModel.getAcessoDomicilio());
        setPosicaoSelecionadoRG(rgLocalizacao, this.fichaCadastroDTModel.getLocalizacao());
        setPosicaoSelecionadoRG(rgOutrosProfissionais, this.fichaCadastroDTModel.getFlagOutrosProfissionais());
        setPosicaoSelecionadoRG(rgTemAnimais, this.fichaCadastroDTModel.getFlagAnimais());
        setPosicaoSelecionadoRG(rgTemEnergiaEletrica, this.fichaCadastroDTModel.getFlagEnergiaEletrica());

        //Checkboxes
        cbSemNumero.setChecked(this.fichaCadastroDTModel.getFlagSemNumero() == null ? false : this.fichaCadastroDTModel.getFlagSemNumero());
        cbForaDeArea.setChecked(this.fichaCadastroDTModel.getFlagForaDeArea() == null ? false : this.fichaCadastroDTModel.getFlagForaDeArea());
        cbGato.setChecked(this.fichaCadastroDTModel.getFlagGato() == null ? false : this.fichaCadastroDTModel.getFlagGato());
        cbCachorro.setChecked(this.fichaCadastroDTModel.getFlagCachorro() == null ? false : this.fichaCadastroDTModel.getFlagCachorro());
        cbPassaro.setChecked(this.fichaCadastroDTModel.getFlagPassaro() == null ? false : this.fichaCadastroDTModel.getFlagPassaro());
        cbOutrosAnimais.setChecked(this.fichaCadastroDTModel.getFlagOutrosAnimais() == null ? false: this.fichaCadastroDTModel.getFlagOutrosAnimais());

        btCadastrarFamilias.setText(String.format("Familias (%d)", this.fichaCadastroDTModel.getFamilias().size()));


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

        //TODO: rgTipoDomicilio

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
