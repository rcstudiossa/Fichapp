package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import com.fichapp.util.Utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
    private RadioGroup rgTurno;

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

    private Button btnGravar;

    private LinearLayout llRodape;

    private Integer itemTemEnergiaEletrica;
    private Integer itemTurnoSelecionado;
    private Integer itemTemAnimais;
    private Integer itemOutrosProfissionais;
    private Integer itemAcessoDomicilio;
    private Integer itemLocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_ficha_cadastro_dt);

        super.onCreate(savedInstanceState);

        this.instanciarFichaVisitaDTModel();

        this.definirComponentes();

        this.configToolbar();

        this.carregarSpinners();

        this.configData();

        this.lerRadios();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });


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
        rgTurno = (RadioGroup) findViewById(R.id.rg_turno);
        rgTemEnergiaEletrica = (RadioGroup) findViewById(R.id.rg_disponibilidade_energia);

        //Checkboxes
        cbSemNumero = (CheckBox) findViewById(R.id.cb_sem_numero);
        cbForaDeArea = (CheckBox) findViewById(R.id.cb_fora_de_area);
        cbGato = (CheckBox) findViewById(R.id.cb_gato);
        cbCachorro = (CheckBox) findViewById(R.id.cb_cachorro);
        cbPassaro = (CheckBox) findViewById(R.id.cb_passaro);
        cbOutrosAnimais = (CheckBox) findViewById(R.id.cb_outros_animais);

        btnGravar = (Button) findViewById(R.id.btn_gravar_cadastro_dt);

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

    private void lerRadios() {

        itemTemEnergiaEletrica = rgTemEnergiaEletrica.indexOfChild(findViewById(rgTemEnergiaEletrica.getCheckedRadioButtonId()));
        itemTurnoSelecionado = rgTurno.indexOfChild(findViewById(rgTurno.getCheckedRadioButtonId()));
        itemTemAnimais = rgTemAnimais.indexOfChild(findViewById(rgTemAnimais.getCheckedRadioButtonId()));
        itemOutrosProfissionais = rgOutrosProfissionais.indexOfChild(findViewById(rgOutrosProfissionais.getCheckedRadioButtonId()));
        itemAcessoDomicilio = rgAcessoDomicilio.indexOfChild(findViewById(rgAcessoDomicilio.getCheckedRadioButtonId()));
        itemLocalizacao = rgLocalizacao.indexOfChild(findViewById(rgLocalizacao.getCheckedRadioButtonId()));

    }

    private void carregarSpinners() {

        ArrayAdapter spAdapterTipoImovel = ArrayAdapter.createFromResource(this, R.array.tipo_imovel, R.layout.spinner_item);
        spAdapterTipoImovel.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spTipoImovel.setAdapter(spAdapterTipoImovel);

        ArrayAdapter spAdapterSituacaoMoradia = ArrayAdapter.createFromResource(this, R.array.situacao_moradia, R.layout.spinner_item);
        spAdapterSituacaoMoradia.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spSituacaoMoradia.setAdapter(spAdapterSituacaoMoradia);

        ArrayAdapter spAdapterPosseTerra = ArrayAdapter.createFromResource(this, R.array.posse_terra, R.layout.spinner_item);
        spAdapterPosseTerra.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spCondicaoPosseTerra.setAdapter(spAdapterPosseTerra);

        ArrayAdapter spAdapterNumMoradores = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumMoradores.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spNumMoradores.setAdapter(spAdapterNumMoradores);

        ArrayAdapter spAdapterNumComodos = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumComodos.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spNumComodos.setAdapter(spAdapterNumComodos);

        ArrayAdapter spAdapterMaterialParedes = ArrayAdapter.createFromResource(this, R.array.material_paredes, R.layout.spinner_item);
        spAdapterMaterialParedes.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spMaterialParedes.setAdapter(spAdapterMaterialParedes);

        ArrayAdapter spAdapterAbastecimentoAgua = ArrayAdapter.createFromResource(this, R.array.abastecimento_agua, R.layout.spinner_item);
        spAdapterAbastecimentoAgua.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spAbastecimentoAgua.setAdapter(spAdapterAbastecimentoAgua);

        ArrayAdapter spAdapterAguaConsumo = ArrayAdapter.createFromResource(this, R.array.agua_consumo, R.layout.spinner_item);
        spAdapterAguaConsumo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spAguaConsumo.setAdapter(spAdapterAguaConsumo);

        ArrayAdapter spAdapterEscoamentoBanheiro = ArrayAdapter.createFromResource(this, R.array.escoamento_banheiro, R.layout.spinner_item);
        spAdapterEscoamentoBanheiro.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spEscoamentoBanheiro.setAdapter(spAdapterEscoamentoBanheiro);

        ArrayAdapter spAdapterDestinoLixo = ArrayAdapter.createFromResource(this, R.array.destino_lixo, R.layout.spinner_item);
        spAdapterDestinoLixo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spDestinoLixo.setAdapter(spAdapterDestinoLixo);

    }

    private void configData() {

        final Calendar registroCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener dataRegistro = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                registroCalendar.set(Calendar.YEAR, year);
                registroCalendar.set(Calendar.MONTH, monthOfYear);
                registroCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                atualizarCampoData(etDataRegistro, registroCalendar);
            }
        };

        etDataRegistro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(FichaCadastroDTActivity.this, dataRegistro, registroCalendar
                        .get(Calendar.YEAR), registroCalendar.get(Calendar.MONTH),
                        registroCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void atualizarCampoData(EditText editText, Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText.setText(sdf.format(calendar.getTime()));
    }

    private void instanciarFichaVisitaDTModel() {

        this.fichaCadastroDTModel = (FichaCadastroDTModel) getIntent().getSerializableExtra("fichaCadastroDT");

        if (this.fichaCadastroDTModel == null) {
            this.fichaCadastroDTModel = new FichaCadastroDTModel();
        } else {
            setModelToActivity();
        }

    }

    private void gravar() {

        //if (!validaCampos()) { return; }

        setActivityToModel();

        this.fichaCadastroDTBS.gravar(this.fichaCadastroDTModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaCadastroDTFragment");
        startActivity(intent);

        finish();

    }

    private boolean validaCampos() {

        boolean valido = true;

        if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            Snackbar.make(getCurrentFocus(), "Preencha a data de registro.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        return valido;

    }

    private void setModelToActivity() {

        //EditTexts
        etDataRegistro.setText(this.fichaCadastroDTModel.getDataRegistro().toString());
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

        //TODO: RADIOS E SPINNERS

        //Checkboxes
        cbSemNumero.setChecked(this.fichaCadastroDTModel.getFlagSemNumero());
        cbForaDeArea.setChecked(this.fichaCadastroDTModel.getFlagForaDeArea());
        cbGato.setChecked(this.fichaCadastroDTModel.getFlagGato());
        cbCachorro.setChecked(this.fichaCadastroDTModel.getFlagCachorro());
        cbPassaro.setChecked(this.fichaCadastroDTModel.getFlagPassaro());
        cbOutrosAnimais.setChecked(this.fichaCadastroDTModel.getFlagOutrosAnimais());


    }

    private void setActivityToModel() {

        //Data de Registro
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaCadastroDTModel.setDataRegistro(formato.parse(etDataRegistro.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de registro cadastrada errada.", Toast.LENGTH_LONG).show();
        }

        if (etQuantidadeAnimais.getText().toString().isEmpty()) {
            etQuantidadeAnimais.setText("0");
        }

        this.fichaCadastroDTModel.setProfissionalModel((ProfissionalModel) this.fichaCadastroDTModel.getProfissionalModel());
        this.fichaCadastroDTModel.setCnesModel((CNESModel) this.fichaCadastroDTModel.getCnesModel());

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
        this.fichaCadastroDTModel.setQtdAnimais(Integer.valueOf (etQuantidadeAnimais.getText().toString()));
        this.fichaCadastroDTModel.setNomeInstituicao(etNomeInstituicao.getText().toString());
        this.fichaCadastroDTModel.setNomeResponsavel(etNomeResponsavel.getText().toString());
        this.fichaCadastroDTModel.setCnsResponsavel(etCnsResponsavel.getText().toString());
        this.fichaCadastroDTModel.setCargoInstituicao(etCargoInstituicao.getText().toString());
        this.fichaCadastroDTModel.setTelContatoResponsavel(etTelefoneContatoResponsavel.getText().toString());

        //TODO: RADIOS E SPINNERS

        //Checkboxes
        this.fichaCadastroDTModel.setFlagSemNumero(cbSemNumero.isChecked());
        this.fichaCadastroDTModel.setFlagForaDeArea(cbForaDeArea.isChecked());
        this.fichaCadastroDTModel.setFlagGato(cbGato.isChecked());
        this.fichaCadastroDTModel.setFlagCachorro(cbCachorro.isChecked());
        this.fichaCadastroDTModel.setFlagPassaro(cbPassaro.isChecked());
        this.fichaCadastroDTModel.setFlagOutrosAnimais(cbOutrosAnimais.isChecked());
        
        
        
        
        
        
    }


}
