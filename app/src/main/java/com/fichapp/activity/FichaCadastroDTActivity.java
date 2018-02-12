package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
import com.fichapp.business.MunicipioBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.MunicipioModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Mascara;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class FichaCadastroDTActivity extends TemplateActivity {

    private FichaCadastroDTModel fichaCadastroDTModel;
    private FichaCadastroDTBS fichaCadastroDTBS;
    private MunicipioBS municipioBS;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Toolbar toolbar;

    private Spinner spUF;
    private AutoCompleteTextView acTipoLogradouro;
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

    private EditText etCep;
    private Spinner spMunicipio;
    private EditText etBairro;
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

    private LinearLayout llCondicoesMoradia;

    private Integer codigoTipoLogradouro;
    private List<TipoModel> tiposLogradouro;


    public static FichaCadastroDTActivity fichaCadastroDTActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_ficha_cadastro_dt);
        super.onCreate(savedInstanceState);

        fichaCadastroDTActivity = this;

        this.definirComponentes();

        this.configToolbar();

        this.carregarSpinners();

        this.configListeners();

        //this.configData();

        this.instanciarFichaCadastroDTModel();

        this.configMascaras();

        this.configComponentes();

        onLongClickRg(findViewById(R.id.ll_main));

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
                setActivityToModel();
                intent.putExtra("fichaCadastroDT", fichaCadastroDTModel);
                startActivity(intent);
            }
        });


    }

    public static FichaCadastroDTActivity getInstance() {
        return fichaCadastroDTActivity;
    }

    private void definirComponentes() {

        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        etCep = (EditText) findViewById(R.id.tv_cep);
        spUF = (Spinner) findViewById(R.id.spinner_uf);
        spMunicipio = (Spinner) findViewById(R.id.spinner_municipio);
        etBairro = (EditText) findViewById(R.id.et_bairro);
        acTipoLogradouro = (AutoCompleteTextView) findViewById(R.id.et_tipo_logradouro);
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

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        this.fichaCadastroDTBS = new FichaCadastroDTBS(getApplication());
        this.municipioBS = new MunicipioBS(getApplication());

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

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboUF());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spUF.setAdapter(spAdapter);

        tiposLogradouro = new TipoModel().getComboTipoLogradouro();
        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, tiposLogradouro);
        acTipoLogradouro.setAdapter(spAdapter);

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

    private void configMascaras() {

        String mascaraData = "##/##/####";
        //String mascaraCep = "#####-###";
        String mascaraTelefone = "(##)####-####";
        String mascaraTelCelular = "(##)#####-####";

        etDataRegistro.addTextChangedListener(Mascara.insert(mascaraData, etDataRegistro));
        etDataRegistro.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataRegistro));

        //etCep.addTextChangedListener(Mascara.insert(mascaraCep, etCep));

        etTelefoneResidencia.addTextChangedListener(Mascara.insert(mascaraTelefone, etTelefoneResidencia));
        etTelefoneResidencia.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraTelefone, etTelefoneResidencia));
        etTelefoneContato.addTextChangedListener(Mascara.insert(mascaraTelCelular, etTelefoneContato));
        etTelefoneContato.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraTelCelular, etTelefoneContato));
        etTelefoneContatoResponsavel.addTextChangedListener(Mascara.insert(mascaraTelCelular, etTelefoneContatoResponsavel));
        etTelefoneContatoResponsavel.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraTelCelular, etTelefoneContatoResponsavel));


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

        if (!validaCampos()) { return; }

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

    private void configListeners() {

        this.desabilitaEditText(cbSemNumero, etNumero);
        this.desabilitaEditText(cbForaDeArea, etMicroarea);

        spUF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (!Utilitario.isEmpty(((TipoModel)spUF.getSelectedItem()).getCodigo())) {

                    List<MunicipioModel> municipios = new MunicipioBS(fichaCadastroDTActivity).pesquisar(((TipoModel) spUF.getSelectedItem()).getAbreviacao());

                    if (!Utilitario.isEmpty(municipios) && municipios.size() > 0) {

                        FichaCadastroDTActivity.this.carregarSpinnerMunicipio(spMunicipio, municipios);

                        spMunicipio.setSelection(municipios.indexOf(fichaCadastroDTModel.getMunicipio()));

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spUF.setSelection(0);
            }

        });

        spTipoImovel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                desabilitaCondicoesMoradia(position, cbVisitaRecusada.isChecked());

                if (!Utilitario.isEmpty(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo()) && ((TipoModel)spTipoImovel.getSelectedItem()).getCodigo() == 1) {
                    habilitarComponentes(rgTemAnimais);
                } else {
                    desabilitarComponentes(rgTemAnimais);
                }

                List<Integer> tipos = new ArrayList<>(Arrays.asList(7,8,9,10,11));
                if (!Utilitario.isEmpty(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo()) && tipos.contains(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo())) {
                    desabilitarComponentes(spSituacaoMoradia);
                    desabilitarComponentes(rgTipoDomicilio);
                    desabilitarComponentes(rgAcessoDomicilio);
                    desabilitarComponentes(spCondicaoPosseTerra);
                    desabilitarComponentes(etNumComodos);
                    desabilitarComponentes(spMaterialParedes);
                    habilitarComponentes(llInstituicaoPermanencia);
                    llInstituicaoPermanencia.setVisibility(View.VISIBLE);
                } else {
                    habilitarComponentes(spSituacaoMoradia);
                    habilitarComponentes(rgTipoDomicilio);
                    habilitarComponentes(rgAcessoDomicilio);
                    habilitarComponentes(spCondicaoPosseTerra);
                    habilitarComponentes(etNumComodos);
                    habilitarComponentes(spMaterialParedes);
                    desabilitarComponentes(llInstituicaoPermanencia);
                    llInstituicaoPermanencia.setVisibility(View.GONE);
                }
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
                if (b) {
                    desabilitaLinearLayout(llInstituicaoPermanencia);
                    llCondicoesMoradia.setVisibility(View.GONE);
                    btCadastrarFamilias.setVisibility(View.GONE);
                } else {
                    habilitaLinearLayout(llInstituicaoPermanencia);
                    llCondicoesMoradia.setVisibility(View.VISIBLE);
                    btCadastrarFamilias.setVisibility(View.VISIBLE);
                }
            }
        });

        rgTemAnimais.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));
                if (indexRg == 0) {
                    habilitarComponentes(etQuantidadeAnimais);
                    habilitarComponentes(llAnimais);
                } else {
                    desabilitarComponentes(etQuantidadeAnimais);
                    desabilitarComponentes(llAnimais);
                }
            }
        });

        rgLocalizacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));
                if (indexRg == 1) {
                    habilitarComponentes(spCondicaoPosseTerra);
                } else {
                    desabilitarComponentes(spCondicaoPosseTerra);
                }
            }
        });

        acTipoLogradouro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                codigoTipoLogradouro = ((TipoModel) acTipoLogradouro.getAdapter().getItem(position)).getCodigo();
            }
        });

        acTipoLogradouro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                codigoTipoLogradouro = null;
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        acTipoLogradouro.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (Utilitario.isEmpty(codigoTipoLogradouro)) {
                    acTipoLogradouro.getText().clear();
                }
            }
        });

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

    private boolean validaCampos() {

        boolean valido = true;

        Utilitario.limparErros(findViewById(R.id.ll_main));

        String aviso = "";
        String msg;

        if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            msg = "Preencha a data de registro";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_registro), msg);
            valido = false;
        } else if (!Utilitario.dataValida(etDataRegistro.getText().toString())) {
            msg = "A data de registro não é válida";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_registro), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etCep.getText().toString())) {
            msg = "Preencha o CEP";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_cep), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(((TipoModel)spUF.getSelectedItem()).getCodigo())) {
            msg = "Selecione o UF";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_uf), msg);
            valido = false;
        }

        if (Utilitario.isEmpty((spMunicipio.getSelectedItem())) || Utilitario.isEmpty(((MunicipioModel)spMunicipio.getSelectedItem()).getCodigo())) {
            msg = "Selecione o município";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_municipio), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etBairro.getText().toString())) {
            msg = "Preencha o bairro";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_bairro), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(acTipoLogradouro.getText().toString())) {
            msg = "Preencha o tipo de logradouro";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_tipo_logradouro), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etNomeLogradouro.getText().toString())) {
            msg = "Preencha o nome do logradouro";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_nome_logradouro), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etNumero.getText().toString())) && !cbSemNumero.isChecked()) {
            msg = "Preencha o número";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_numero), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etMicroarea.getText().toString())) && !cbForaDeArea.isChecked()) {
            msg = "Preencha a microárea";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_microarea), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo())) {
            msg = "Selecione o tipo de imóvel";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_tipo_imovel), msg);
            valido = false;
        }

        if (!cbVisitaRecusada.isChecked()) {

            List<Integer> tipos = new ArrayList<>(Arrays.asList(2,3,4,5,6,12,99));
            if (Utilitario.isEmpty(((TipoModel)spSituacaoMoradia.getSelectedItem()).getCodigo()) && (!Utilitario.isEmpty(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo()) && !tipos.contains(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo()))) {
                msg = "Selecione a situação de moradia";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_situacao_moradia), msg);
                valido = false;
            }

            if (rgLocalizacao.getCheckedRadioButtonId() == -1 && !tipos.contains(((TipoModel)spTipoImovel.getSelectedItem()).getCodigo())) {
                msg = "Selecione a localização";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_localizacao), msg);
                valido = false;
            }

            if (!Utilitario.isEmpty(etNumMoradores.getText().toString()) && this.fichaCadastroDTModel.getFamilias().size() > Integer.valueOf(etNumMoradores.getText().toString())) {
                msg = "Número de moradores inválido";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.til_num_moradores), msg);
                valido = false;
            }

        }

        if (!aviso.isEmpty()) {
            final String finalAviso = aviso;
            Snackbar snackbar = Snackbar.make(fabGravar, "Alguns itens estão pendentes", Snackbar.LENGTH_LONG).setAction("DETALHES", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utilitario.alertar(FichaCadastroDTActivity.this, finalAviso);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();

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

        etDataRegistro.setText(Utilitario.getDataFormatada(this.fichaCadastroDTModel.getDataRegistro()));
        etCep.setText(this.fichaCadastroDTModel.getCep());
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getUf().getCodigo()) && this.fichaCadastroDTModel.getUf().getCodigo() > 0) {

            spUF.setSelection(new TipoModel().getComboUF().indexOf(this.fichaCadastroDTModel.getUf()));

            if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getMunicipio().getCodigo()) && this.fichaCadastroDTModel.getMunicipio().getCodigo() > 0) {
                spMunicipio.setSelection(municipioBS.pesquisar(((TipoModel)spUF.getSelectedItem()).getDescricao()).indexOf(this.fichaCadastroDTModel.getMunicipio()));
            }

        }

        etBairro.setText(this.fichaCadastroDTModel.getBairro());

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getTipoLogradouro()) && this.fichaCadastroDTModel.getTipoLogradouro().getCodigo() > 0) {
            TipoModel tipoLogradouroModel = tiposLogradouro.get(tiposLogradouro.indexOf(this.fichaCadastroDTModel.getTipoLogradouro()));
            if (!Utilitario.isEmpty(tipoLogradouroModel)) {
                acTipoLogradouro.setText(tipoLogradouroModel.toString());
                codigoTipoLogradouro = tipoLogradouroModel.getCodigo();
            }
        }

        etNomeLogradouro.setText(this.fichaCadastroDTModel.getNomeLogragouro());
        etComplemento.setText(this.fichaCadastroDTModel.getComplemento());
        etPontoReferencia.setText(this.fichaCadastroDTModel.getPontoReferencia());
        etNumero.setText(this.fichaCadastroDTModel.getNumero());
        cbSemNumero.setChecked(this.fichaCadastroDTModel.getFlagSemNumero() == null ? false : this.fichaCadastroDTModel.getFlagSemNumero());
        etMicroarea.setText(this.fichaCadastroDTModel.getMicroArea());
        cbForaDeArea.setChecked(this.fichaCadastroDTModel.getFlagForaDeArea() == null ? false : this.fichaCadastroDTModel.getFlagForaDeArea());

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getTipoImovel().getCodigo()) && this.fichaCadastroDTModel.getTipoImovel().getCodigo() > 0) {
            spTipoImovel.setSelection(new TipoModel().getComboTipoImovel().indexOf(this.fichaCadastroDTModel.getTipoImovel()));
        }

        etTelefoneResidencia.setText(this.fichaCadastroDTModel.getTelResidencia());
        etTelefoneContato.setText(this.fichaCadastroDTModel.getTelContato());

        cbVisitaRecusada.setChecked(Utilitario.isEmpty(this.fichaCadastroDTModel.getFlagRecusado()) ? false : this.fichaCadastroDTModel.getFlagRecusado());

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getSituacaoMoradia().getCodigo()) && this.fichaCadastroDTModel.getSituacaoMoradia().getCodigo() > 0) {
            spSituacaoMoradia.setSelection(new TipoModel().getComboSituacaoMoradia().indexOf(this.fichaCadastroDTModel.getSituacaoMoradia()));
        }

        setPosicaoSelecionadoRG(rgLocalizacao, this.fichaCadastroDTModel.getLocalizacao());
        setPosicaoSelecionadoRG(rgTipoDomicilio, this.fichaCadastroDTModel.getTipoDomicilio());
        setPosicaoSelecionadoRG(rgAcessoDomicilio, this.fichaCadastroDTModel.getAcessoDomicilio());

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getCondicaoTerra().getCodigo()) && this.fichaCadastroDTModel.getCondicaoTerra().getCodigo() > 0) {
            spCondicaoPosseTerra.setSelection(new TipoModel().getComboPosseTerra().indexOf(this.fichaCadastroDTModel.getCondicaoTerra()));
        }

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getNumMoradores()) && this.fichaCadastroDTModel.getNumMoradores() > 0) {
            etNumMoradores.setText(this.fichaCadastroDTModel.getNumMoradores().toString());
        }

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getNumComodos()) && this.fichaCadastroDTModel.getNumComodos() > 0) {
            etNumComodos.setText(this.fichaCadastroDTModel.getNumComodos().toString());
        }

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getMaterialParedes().getCodigo()) && this.fichaCadastroDTModel.getMaterialParedes().getCodigo() > 0) {
            spMaterialParedes.setSelection(new TipoModel().getComboMaterialParedes().indexOf(this.fichaCadastroDTModel.getMaterialParedes()));
        }

        setPosicaoSelecionadoRG(rgTemEnergiaEletrica, this.fichaCadastroDTModel.getFlagEnergiaEletrica());

        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getAbastecimentoAgua()) && !Utilitario.isEmpty(this.fichaCadastroDTModel.getAbastecimentoAgua().getCodigo()) && this.fichaCadastroDTModel.getAbastecimentoAgua().getCodigo() > 0) {
            spAbastecimentoAgua.setSelection(new TipoModel().getComboAbastecimentoAgua().indexOf(this.fichaCadastroDTModel.getAbastecimentoAgua()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getAguaConsumo()) && !Utilitario.isEmpty(this.fichaCadastroDTModel.getAguaConsumo().getCodigo()) && this.fichaCadastroDTModel.getAguaConsumo().getCodigo() > 0) {
            spAguaConsumo.setSelection(new TipoModel().getComboAguaConsumo().indexOf(this.fichaCadastroDTModel.getAguaConsumo()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getEscoamentoBanheiro()) && !Utilitario.isEmpty(this.fichaCadastroDTModel.getEscoamentoBanheiro().getCodigo()) && this.fichaCadastroDTModel.getEscoamentoBanheiro().getCodigo() > 0) {
            spEscoamentoBanheiro.setSelection(new TipoModel().getComboEscoamentoBanheiro().indexOf(this.fichaCadastroDTModel.getEscoamentoBanheiro()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroDTModel.getDestinoLixo()) && !Utilitario.isEmpty(this.fichaCadastroDTModel.getDestinoLixo().getCodigo()) && this.fichaCadastroDTModel.getDestinoLixo().getCodigo() > 0) {
            spDestinoLixo.setSelection(new TipoModel().getComboDestinoLixo().indexOf(this.fichaCadastroDTModel.getDestinoLixo()));
        }

        setPosicaoSelecionadoRG(rgTemAnimais, this.fichaCadastroDTModel.getFlagAnimais());
        etQuantidadeAnimais.setText(this.fichaCadastroDTModel.getQtdAnimais() == null ? null : this.fichaCadastroDTModel.getQtdAnimais().toString());
        cbGato.setChecked(this.fichaCadastroDTModel.getFlagGato() == null ? false : this.fichaCadastroDTModel.getFlagGato());
        cbCachorro.setChecked(this.fichaCadastroDTModel.getFlagCachorro() == null ? false : this.fichaCadastroDTModel.getFlagCachorro());
        cbPassaro.setChecked(this.fichaCadastroDTModel.getFlagPassaro() == null ? false : this.fichaCadastroDTModel.getFlagPassaro());
        cbOutrosAnimais.setChecked(this.fichaCadastroDTModel.getFlagOutrosAnimais() == null ? false: this.fichaCadastroDTModel.getFlagOutrosAnimais());

        btCadastrarFamilias.setText(String.format("Familias (%d)", this.fichaCadastroDTModel.getFamilias().size()));

        etNomeInstituicao.setText(this.fichaCadastroDTModel.getNomeInstituicao());
        setPosicaoSelecionadoRG(rgOutrosProfissionais, this.fichaCadastroDTModel.getFlagOutrosProfissionais());
        etNomeResponsavel.setText(this.fichaCadastroDTModel.getNomeResponsavel());
        etCnsResponsavel.setText(this.fichaCadastroDTModel.getCnsResponsavel());
        etCargoInstituicao.setText(this.fichaCadastroDTModel.getCargoInstituicao());
        etTelefoneContatoResponsavel.setText(this.fichaCadastroDTModel.getTelContatoResponsavel());

    }

    private void setActivityToModel() {

        this.fichaCadastroDTModel.setProfissionalModel(new ProfissionalModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("id", 0)));
        this.fichaCadastroDTModel.setCnesModel(new CNESModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("cnes_id", 0)));

        this.fichaCadastroDTModel.setDataRegistro(Utilitario.getDate(etDataRegistro.getText().toString()));

        this.fichaCadastroDTModel.setCep(etCep.getText().toString());
        this.fichaCadastroDTModel.setUf((TipoModel) spUF.getSelectedItem());
        this.fichaCadastroDTModel.setMunicipio((MunicipioModel) spMunicipio.getSelectedItem());
        this.fichaCadastroDTModel.setBairro(etBairro.getText().toString());
        this.fichaCadastroDTModel.setTipoLogradouro(new TipoModel(codigoTipoLogradouro));
        this.fichaCadastroDTModel.setNomeLogragouro(etNomeLogradouro.getText().toString());
        this.fichaCadastroDTModel.setComplemento(etComplemento.getText().toString());
        this.fichaCadastroDTModel.setPontoReferencia(etPontoReferencia.getText().toString());
        this.fichaCadastroDTModel.setNumero(etNumero.getText().toString());
        this.fichaCadastroDTModel.setFlagSemNumero(cbSemNumero.isChecked());
        this.fichaCadastroDTModel.setMicroArea(etMicroarea.getText().toString());
        this.fichaCadastroDTModel.setFlagForaDeArea(cbForaDeArea.isChecked());

        this.fichaCadastroDTModel.setTipoImovel((TipoModel) this.spTipoImovel.getSelectedItem());

        this.fichaCadastroDTModel.setTelResidencia(etTelefoneResidencia.getText().toString());
        this.fichaCadastroDTModel.setTelContato(etTelefoneContato.getText().toString());

        this.fichaCadastroDTModel.setFlagRecusado(cbVisitaRecusada.isChecked());

        this.fichaCadastroDTModel.setSituacaoMoradia((TipoModel) this.spSituacaoMoradia.getSelectedItem());

        this.fichaCadastroDTModel.setLocalizacao
                (this.getPosicaoSelecionadoRG(rgLocalizacao).equals(0) ? 83 :
                        this.getPosicaoSelecionadoRG(rgLocalizacao).equals(1) ? 84 : -1);

        this.fichaCadastroDTModel.setTipoDomicilio
                (this.getPosicaoSelecionadoRG(rgTipoDomicilio).equals(0) ? 85 :
                        this.getPosicaoSelecionadoRG(rgTipoDomicilio).equals(1) ? 86 :
                                this.getPosicaoSelecionadoRG(rgTipoDomicilio).equals(2) ? 87 :
                                        this.getPosicaoSelecionadoRG(rgTipoDomicilio).equals(3) ? 88 : -1);

        this.fichaCadastroDTModel.setAcessoDomicilio
                (this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(0) ? 89 :
                        this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(1) ? 90 :
                                this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(2) ? 91 :
                                        this.getPosicaoSelecionadoRG(rgAcessoDomicilio).equals(3) ? 92 : -1);

        this.fichaCadastroDTModel.setCondicaoTerra((TipoModel) this.spCondicaoPosseTerra.getSelectedItem());
        this.fichaCadastroDTModel.setNumMoradores(Utilitario.isEmpty(etNumMoradores.getText().toString()) ? null : new Integer(etNumMoradores.getText().toString()));
        this.fichaCadastroDTModel.setNumComodos(Utilitario.isEmpty(etNumComodos.getText().toString()) ? null : new Integer(etNumComodos.getText().toString()));

        this.fichaCadastroDTModel.setMaterialParedes((TipoModel) this.spMaterialParedes.getSelectedItem());

        this.fichaCadastroDTModel.setFlagEnergiaEletrica(this.getPosicaoSelecionadoRG(rgTemEnergiaEletrica));

        this.fichaCadastroDTModel.setAbastecimentoAgua((TipoModel) this.spAbastecimentoAgua.getSelectedItem());
        this.fichaCadastroDTModel.setAguaConsumo((TipoModel) this.spAguaConsumo.getSelectedItem());
        this.fichaCadastroDTModel.setEscoamentoBanheiro((TipoModel) this.spEscoamentoBanheiro.getSelectedItem());
        this.fichaCadastroDTModel.setDestinoLixo((TipoModel) this.spDestinoLixo.getSelectedItem());

        this.fichaCadastroDTModel.setFlagAnimais(this.getPosicaoSelecionadoRG(rgTemAnimais));
        this.fichaCadastroDTModel.setQtdAnimais(Utilitario.isEmpty(etQuantidadeAnimais.getText().toString()) ? null : Integer.valueOf(etQuantidadeAnimais.getText().toString()));
        this.fichaCadastroDTModel.setFlagGato(cbGato.isChecked());
        this.fichaCadastroDTModel.setFlagCachorro(cbCachorro.isChecked());
        this.fichaCadastroDTModel.setFlagPassaro(cbPassaro.isChecked());
        this.fichaCadastroDTModel.setFlagOutrosAnimais(cbOutrosAnimais.isChecked());

        this.fichaCadastroDTModel.setNomeInstituicao(etNomeInstituicao.getText().toString());
        this.fichaCadastroDTModel.setFlagOutrosProfissionais(this.getPosicaoSelecionadoRG(rgOutrosProfissionais));
        this.fichaCadastroDTModel.setNomeResponsavel(etNomeResponsavel.getText().toString());
        this.fichaCadastroDTModel.setCnsResponsavel(etCnsResponsavel.getText().toString());
        this.fichaCadastroDTModel.setCargoInstituicao(etCargoInstituicao.getText().toString());
        this.fichaCadastroDTModel.setTelContatoResponsavel(etTelefoneContatoResponsavel.getText().toString());

    }


}
