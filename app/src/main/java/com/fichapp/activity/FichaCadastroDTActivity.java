package com.fichapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroDTBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.ProfissionalModel;

import java.util.List;

public class FichaCadastroDTActivity extends AppCompatActivity {

    private FichaCadastroDTModel fichaCadastroDTModel;
    private FichaCadastroDTBS fichaCadastroDTBS;

    private List<ProfissionalModel> profissionais;
    private List<CNESModel> hospitais;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_cadastro_dt);

        this.definirComponentes();

        this.carregarSpinners();






    }

    private void definirComponentes() {

        //EDITTEXTS
        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        etCep = (EditText) findViewById(R.id.et_cep);
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

        //SPINNNERS
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

        //RADIOGROUPS
        rgAcessoDomicilio = (RadioGroup) findViewById(R.id.rg_acesso_domicilio);
        rgLocalizacao = (RadioGroup) findViewById(R.id.rg_localizacao);
        rgOutrosProfissionais = (RadioGroup) findViewById(R.id.rg_outros_profissionais);
        rgTemAnimais = (RadioGroup) findViewById(R.id.rg_animais);
        rgTurno = (RadioGroup) findViewById(R.id.rg_turno);
        rgTemEnergiaEletrica = (RadioGroup) findViewById(R.id.rg_disponibilidade_energia);

        //CHECKBOXES
        cbSemNumero = (CheckBox) findViewById(R.id.cb_sem_numero);
        cbForaDeArea = (CheckBox) findViewById(R.id.cb_fora_de_area);
        cbGato = (CheckBox) findViewById(R.id.cb_gato);
        cbCachorro = (CheckBox) findViewById(R.id.cb_cachorro);
        cbPassaro = (CheckBox) findViewById(R.id.cb_passaro);
        cbOutrosAnimais = (CheckBox) findViewById(R.id.cb_outros_animais);

        btnGravar = (Button) findViewById(R.id.btn_gravar_cadastro_dt);

        llRodape = (LinearLayout) findViewById(R.id.include_rodape_cadastro_dt);

    }

    private void carregarSpinners() {

        ArrayAdapter spAdapterTipoImovel = ArrayAdapter.createFromResource(this, R.array.tipo_imovel, R.layout.spinner_item);
        spAdapterTipoImovel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoImovel.setAdapter(spAdapterTipoImovel);

        ArrayAdapter spAdapterSituacaoMoradia = ArrayAdapter.createFromResource(this, R.array.situacao_moradia, R.layout.spinner_item);
        spAdapterSituacaoMoradia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSituacaoMoradia.setAdapter(spAdapterSituacaoMoradia);

        ArrayAdapter spAdapterPosseTerra = ArrayAdapter.createFromResource(this, R.array.posse_terra, R.layout.spinner_item);
        spAdapterPosseTerra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCondicaoPosseTerra.setAdapter(spAdapterPosseTerra);

        ArrayAdapter spAdapterNumMoradores = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumMoradores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumMoradores.setAdapter(spAdapterNumMoradores);

        ArrayAdapter spAdapterNumComodos = ArrayAdapter.createFromResource(this, R.array.numeros, R.layout.spinner_item);
        spAdapterNumComodos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumComodos.setAdapter(spAdapterNumComodos);

        ArrayAdapter spAdapterMaterialParedes = ArrayAdapter.createFromResource(this, R.array.material_paredes, R.layout.spinner_item);
        spAdapterMaterialParedes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMaterialParedes.setAdapter(spAdapterMaterialParedes);

        ArrayAdapter spAdapterAbastecimentoAgua = ArrayAdapter.createFromResource(this, R.array.abastecimento_agua, R.layout.spinner_item);
        spAdapterAbastecimentoAgua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAbastecimentoAgua.setAdapter(spAdapterAbastecimentoAgua);

        ArrayAdapter spAdapterAguaConsumo = ArrayAdapter.createFromResource(this, R.array.agua_consumo, R.layout.spinner_item);
        spAdapterAguaConsumo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAguaConsumo.setAdapter(spAdapterAguaConsumo);

        ArrayAdapter spAdapterEscoamentoBanheiro = ArrayAdapter.createFromResource(this, R.array.escoamento_banheiro, R.layout.spinner_item);
        spAdapterEscoamentoBanheiro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEscoamentoBanheiro.setAdapter(spAdapterEscoamentoBanheiro);

        ArrayAdapter spAdapterDestinoLixo = ArrayAdapter.createFromResource(this, R.array.destino_lixo, R.layout.spinner_item);
        spAdapterDestinoLixo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDestinoLixo.setAdapter(spAdapterDestinoLixo);

    }



}
