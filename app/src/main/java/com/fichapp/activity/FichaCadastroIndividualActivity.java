package com.fichapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.fichapp.R;
import com.fichapp.business.FichaCadastroIndividualBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaCadastroIndividualModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Mascara;
import com.fichapp.util.Utilitario;

import java.util.List;


public class FichaCadastroIndividualActivity extends TemplateActivity {

    private FichaCadastroIndividualModel fichaCadastroIndividualModel;
    private FichaCadastroIndividualBS fichaCadastroIndividualBS;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Toolbar toolbar;

    private Spinner spPais;
    private Spinner spRaca;
    private Spinner spEtnia;
    private Spinner spParentesco;
    private Spinner spCurso;
    private Spinner spTrabalho;
    private Spinner spOrientacao;
    private Spinner spGenero;

    private EditText etCnsCidadao;
    private RadioGroup rgResponsavelFamiliar;
    private EditText etCnsResponsavelFamiliar;
    private EditText etMicroarea;
    private CheckBox cbForaDeArea;
    private EditText etNomeCompleto;
    private EditText etNomeSocial;
    private EditText etDataNascimento;
    private RadioGroup rgSexo;
    private EditText etNis;

    private EditText etNomeMae;
    private CheckBox cbMaeDesconhecido;
    private EditText etNomePai;
    private CheckBox cbPaiDesconhecido;

    private RadioGroup rgNacionalidade;
    private EditText etMunicipioNascimento;
    private LinearLayout llNaturalizacao;
    private EditText etPortariaNaturalizacao;
    private EditText etDataNaturalizacao;
    private EditText etDataEntrada;

    private EditText etTelefoneCelular;
    private EditText etEmailCidadao;

    private CheckBox cbVisitaRecusada;

    private EditText etOcupacao;
    private RadioGroup rgFrequentaEscola;

    private CheckBox cbFicaComAdultoResponsavel;
    private CheckBox cbFicaComOutrasCriancas;
    private CheckBox cbFicaComAdolescente;
    private CheckBox cbFicaEmCreche;
    private CheckBox cbFicaSozinha;
    private CheckBox cbFicaOutro;

    private RadioGroup rgFrequentaCuidador;
    private RadioGroup rgParticipaGrupoComunitario;
    private RadioGroup rgPossuiPlanoDeSaude;
    private RadioGroup rgMembroDeComunidade;
    private EditText etQualComunidade;

    private RadioGroup rgInformarOrientacao;
    private RadioGroup rgInformarIdentidadeGenero;

    private LinearLayout llTemDeficiencia;
    private LinearLayout llTipoDeficiencia;
    private RadioGroup rgDeficiencia;
    private CheckBox cbDeficienciaAuditiva;
    private CheckBox cbDeficienciaVisual;
    private CheckBox cbDeficienciaIntelectual;
    private CheckBox cbDeficienciaFisica;
    private CheckBox cbOutraDeficiencia;

    private RadioGroup rgSaidaCadastro;
    private EditText etNumeroDO;
    private EditText etDataObito;

    private RadioGroup rgGestante;
    private EditText etQualMaternidade;
    private RadioGroup rgPeso;

    private RadioGroup rgFumante;
    private RadioGroup rgAlcool;
    private RadioGroup rgOutrasDrogas;
    private RadioGroup rgHipertensao;
    private RadioGroup rgDiabetes;
    private RadioGroup rgAvcDerrame;
    private RadioGroup rgInfarto;

    private LinearLayout llDoencaCardiaca;
    private RadioGroup rgDoencaCardiaca;
    private CheckBox cbInsuficienciaCardiaca;
    private CheckBox cbOutraDoencaCardiaca;
    private CheckBox cbNaoSabeDoencaCardiaca;

    private LinearLayout llProblemaRins;
    private RadioGroup rgProblemaRins;
    private CheckBox cbInsuficienciaRenal;
    private CheckBox cbOutroProblemaRins;
    private CheckBox cbNaoSabeProblemaRins;

    private LinearLayout llDoencaRespiratoria;
    private RadioGroup rgDoencaRespiratoria;
    private CheckBox cbAsma;
    private CheckBox cbEnfisema;
    private CheckBox cbOutraDoencaRespiratoria;
    private CheckBox cbNaoSabeDoencaRespiratoria;

    private RadioGroup rgHanseniase;
    private RadioGroup rgTuberculose;
    private RadioGroup rgCancer;
    private RadioGroup rgInternado;
    private EditText etQualMotivoInternamento;
    private RadioGroup rgProblemaMental;
    private RadioGroup rgAcamado;
    private RadioGroup rgDomiciliado;
    private RadioGroup rgPlantasMedicinais;
    private EditText etQuaisPlantas;
    private RadioGroup rgOutrasPraticasIntegrativas;
    private EditText etOutrasCondicoesSaude;

    private RadioGroup rgSituacaoRua;
    private RadioGroup rgTempoSituacaoRua;
    private RadioGroup rgRecebeBeneficio;
    private RadioGroup rgReferenciaFamiliar;

    private RadioGroup rgFrequenciaAlimentacao;
    private RadioButton rbBrasileira;
    private CheckBox cbAlimentacaoRestaurantePopular;
    private CheckBox cbAlimentacaoDoacaoGrupoReligioso;
    private CheckBox cbAlimentacaoDoacaoRestaurante;
    private CheckBox cbAlimentacaoDoacaoPopular;
    private CheckBox cbAlimentacaoOutras;

    private RadioGroup rgAcompanhadoInstituicao;
    private EditText etQualInstituicao;
    private RadioGroup rgVisitaFamiliar;
    private EditText etGrauParentesco;

    private LinearLayout llHigienePessoal;
    private RadioGroup rgAcessoHigienePessoal;
    private CheckBox cbAcessoBanho;
    private CheckBox cbAcessoSanitario;
    private CheckBox cbAcessoHigieneBucal;
    private CheckBox cbAcessoOutras;

    private FloatingActionButton fabGravar;

    private LinearLayout llSocioDemografico;
    private LinearLayout llCondicoesSaude;
    private LinearLayout llSituacaoRua;
    private LinearLayout llSeSituacaoRua;

    private RelativeLayout rlMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_ficha_cadastro_individual);

        super.onCreate(savedInstanceState);

        this.definirComponentes();

        this.configToolbar();

        this.carregarSpinners();

        this.configListeners();

        //this.configDatas();

        this.instanciarFichaCadastroIndividualModel();

        this.configComponentes();

        this.configMascaras();

        this.fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    @Override
    protected void configComponentes() {

        //rgNacionalidade.check(0);

        super.configComponentes();

        rbBrasileira.setChecked(true);
        spRaca.setSelection(0);

        spPais.setEnabled(false);
        spPais.setSelection(new TipoModel().getComboPais().indexOf(new TipoModel(31)));

    }

    private void definirComponentes() {

        //EditTexts
        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        etCnsCidadao = (EditText) findViewById(R.id.et_cns);
        etCnsResponsavelFamiliar = (EditText) findViewById(R.id.et_cns_responsavel_familiar);
        etMicroarea = (EditText) findViewById(R.id.et_microarea);
        etNomeCompleto = (EditText) findViewById(R.id.et_nome_completo);
        etNomeSocial = (EditText) findViewById(R.id.et_nome_social);
        etDataNascimento = (EditText) findViewById(R.id.et_data_nascimento);
        etNis = (EditText) findViewById(R.id.et_nis);
        etNomeMae = (EditText) findViewById(R.id.et_nome_mae);
        etNomePai = (EditText) findViewById(R.id.et_nome_pai);
        etMunicipioNascimento = (EditText) findViewById(R.id.et_municipio_nascimento);
        etPortariaNaturalizacao = (EditText) findViewById(R.id.et_portaria_naturalizacao);
        etDataNaturalizacao = (EditText) findViewById(R.id.et_data_naturalizacao);
        etDataEntrada = (EditText) findViewById(R.id.et_data_entrada);
        etTelefoneCelular = (EditText) findViewById(R.id.et_telefone_celular);
        etEmailCidadao = (EditText) findViewById(R.id.et_email);
        etGrauParentesco = (EditText) findViewById(R.id.et_qual_parentesco);
        etOcupacao = (EditText) findViewById(R.id.et_ocupacao);
        etQualComunidade = (EditText) findViewById(R.id.et_qual_povo);
        etNumeroDO = (EditText) findViewById(R.id.et_numero_do);
        etDataObito = (EditText) findViewById(R.id.et_data_obito);
        etQualMaternidade = (EditText) findViewById(R.id.et_qual_maternidade);
        etQualMotivoInternamento = (EditText) findViewById(R.id.et_motivo_internacao);
        etQuaisPlantas = (EditText) findViewById(R.id.et_quais_plantas_medicinais);
        etOutrasCondicoesSaude = (EditText) findViewById(R.id.et_outras_condicoes_saude);
        etQualInstituicao = (EditText) findViewById(R.id.et_qual_instituicao);

        //Spinners
        spPais = (Spinner) findViewById(R.id.spinner_municipio);
        spRaca = (Spinner) findViewById(R.id.spinner_raca);
        spEtnia = (Spinner) findViewById(R.id.spinner_etnia);
        spPais = (Spinner) findViewById(R.id.spinner_municipio);
        spParentesco = (Spinner) findViewById(R.id.spinner_parentesco);
        spCurso = (Spinner) findViewById(R.id.spinner_curso_frequentado);
        spTrabalho = (Spinner) findViewById(R.id.spinner_situacao_trabalho);
        spOrientacao = (Spinner) findViewById(R.id.spinner_orientacao);
        spGenero = (Spinner) findViewById(R.id.spinner_identidade_genero);

        //RadioGroups
        rgAcamado = (RadioGroup) findViewById(R.id.rg_acamado);
        rgAcessoHigienePessoal = (RadioGroup) findViewById(R.id.rg_higiene_pessoal);
        rgAcompanhadoInstituicao = (RadioGroup) findViewById(R.id.rg_outra_instituicao);
        rgAlcool = (RadioGroup) findViewById(R.id.rg_alcool);
        rgAvcDerrame = (RadioGroup) findViewById(R.id.rg_avc);
        rgCancer = (RadioGroup) findViewById(R.id.rg_cancer);
        rgDeficiencia = (RadioGroup) findViewById(R.id.rg_deficiencia);
        rgDiabetes = (RadioGroup) findViewById(R.id.rg_diabetes);
        rgDoencaCardiaca = (RadioGroup) findViewById(R.id.rg_doenca_cardiaca);
        rgDoencaRespiratoria = (RadioGroup) findViewById(R.id.rg_doenca_respiratoria);
        rgDomiciliado = (RadioGroup) findViewById(R.id.rg_domiciliado);
        rgFrequenciaAlimentacao = (RadioGroup) findViewById(R.id.rg_frequencia_alimentacao);
        rgFrequentaCuidador = (RadioGroup) findViewById(R.id.rg_frequenta_cuidador);
        rgFrequentaEscola = (RadioGroup) findViewById(R.id.rg_frequenta_escola);
        rgFumante = (RadioGroup) findViewById(R.id.rg_fumante);
        rgGestante = (RadioGroup) findViewById(R.id.rg_gestante);
        rgHanseniase = (RadioGroup) findViewById(R.id.rg_hanseniase);
        rgHipertensao = (RadioGroup) findViewById(R.id.rg_hipertensao);
        rgInfarto = (RadioGroup) findViewById(R.id.rg_infarto);
        rgInformarIdentidadeGenero = (RadioGroup) findViewById(R.id.rg_informar_identidade_genero);
        rgInformarOrientacao = (RadioGroup) findViewById(R.id.rg_informar_orientacao);
        rgInternado = (RadioGroup) findViewById(R.id.rg_internacao);
        rgMembroDeComunidade = (RadioGroup) findViewById(R.id.rg_povo_comunidade);
        rgNacionalidade = (RadioGroup) findViewById(R.id.rg_nacionalidade);
        rbBrasileira = (RadioButton) findViewById(R.id.rb_brasileira);
        rgOutrasDrogas = (RadioGroup) findViewById(R.id.rg_outras_drogas);
        rgOutrasPraticasIntegrativas = (RadioGroup) findViewById(R.id.rg_praticas_integrativas);
        rgParticipaGrupoComunitario = (RadioGroup) findViewById(R.id.rg_participa_grupo_comunitario);
        rgPeso = (RadioGroup) findViewById(R.id.rg_peso);
        rgPlantasMedicinais = (RadioGroup) findViewById(R.id.rg_plantas_medicinais);
        rgPossuiPlanoDeSaude = (RadioGroup) findViewById(R.id.rg_plano_privado);
        rgProblemaMental = (RadioGroup) findViewById(R.id.rg_problema_mental);
        rgProblemaRins = (RadioGroup) findViewById(R.id.rg_problema_rins);
        rgRecebeBeneficio = (RadioGroup) findViewById(R.id.rg_recebe_beneficio);
        rgReferenciaFamiliar = (RadioGroup) findViewById(R.id.rg_referencia_familiar);
        rgResponsavelFamiliar = (RadioGroup) findViewById(R.id.rg_responsavel_familiar);
        rgSaidaCadastro = (RadioGroup) findViewById(R.id.rg_saida_cadastro);
        rgSexo = (RadioGroup) findViewById(R.id.rg_sexo);
        rgSituacaoRua = (RadioGroup) findViewById(R.id.rg_esta_situacao_rua);
        rgTempoSituacaoRua = (RadioGroup) findViewById(R.id.rg_tempo_situacao_rua);
        rgTuberculose = (RadioGroup) findViewById(R.id.rg_tuberculose);
        rgVisitaFamiliar = (RadioGroup) findViewById(R.id.rg_visita_familiar);


        //Checkboxes
        cbAcessoBanho = (CheckBox) findViewById(R.id.cb_banho);
        cbAcessoHigieneBucal = (CheckBox) findViewById(R.id.cb_higiene_bucal);
        cbAcessoOutras = (CheckBox) findViewById(R.id.cb_higiene_pessoal_outras);
        cbAcessoSanitario = (CheckBox) findViewById(R.id.cb_acesso_sanitario);
        cbAlimentacaoDoacaoGrupoReligioso = (CheckBox) findViewById(R.id.cb_doacao_grupo_religioso);
        cbAlimentacaoDoacaoPopular = (CheckBox) findViewById(R.id.cb_doacao_popular);
        cbAlimentacaoDoacaoRestaurante = (CheckBox) findViewById(R.id.cb_doacao_restaurante);
        cbAlimentacaoOutras = (CheckBox) findViewById(R.id.cb_alimentacao_outras);
        cbAlimentacaoRestaurantePopular = (CheckBox) findViewById(R.id.cb_restaurante_popular);
        cbAsma = (CheckBox) findViewById(R.id.cb_doenca_respiratoria_asma);
        cbDeficienciaAuditiva = (CheckBox) findViewById(R.id.cb_deficiencia_auditiva);
        cbDeficienciaFisica = (CheckBox) findViewById(R.id.cb_deficiencia_fisica);
        cbDeficienciaIntelectual = (CheckBox) findViewById(R.id.cb_deficiencia_intelectual);
        cbDeficienciaVisual = (CheckBox) findViewById(R.id.cb_deficiencia_visual);
        cbEnfisema = (CheckBox) findViewById(R.id.cb_doenca_respiratoria_enfisema);
        cbFicaComAdolescente = (CheckBox) findViewById(R.id.cb_fica_com_adolescente);
        cbFicaComAdultoResponsavel = (CheckBox) findViewById(R.id.cb_adulto_responsavel);
        cbFicaComOutrasCriancas = (CheckBox) findViewById(R.id.cb_outras_criancas);
        cbFicaEmCreche = (CheckBox) findViewById(R.id.cb_creche);
        cbFicaOutro = (CheckBox) findViewById(R.id.cb_fica_outro);
        cbFicaSozinha = (CheckBox) findViewById(R.id.cb_sozinha);
        cbForaDeArea = (CheckBox) findViewById(R.id.cb_fora_de_area);
        cbInsuficienciaCardiaca = (CheckBox) findViewById(R.id.cb_insuficiencia_cardiaca);
        cbInsuficienciaRenal = (CheckBox) findViewById(R.id.cb_insuficiencia_renal);
        cbMaeDesconhecido = (CheckBox) findViewById(R.id.cb_desconhecido_mae);
        cbNaoSabeDoencaCardiaca = (CheckBox) findViewById(R.id.cb_doenca_cardiaca_nao_sabe);
        cbNaoSabeDoencaRespiratoria = (CheckBox) findViewById(R.id.cb_doenca_respiratoria_nao_sabe);
        cbNaoSabeProblemaRins = (CheckBox) findViewById(R.id.cb_problema_rins_nao_sabe);
        cbOutraDeficiencia = (CheckBox) findViewById(R.id.cb_deficiencia_outra);
        cbOutraDoencaCardiaca = (CheckBox) findViewById(R.id.cb_doenca_cardiaca_outra);
        cbOutraDoencaRespiratoria = (CheckBox) findViewById(R.id.cb_doenca_respiratoria_outra);
        cbOutroProblemaRins = (CheckBox) findViewById(R.id.cb_problema_rins_outra);
        cbPaiDesconhecido = (CheckBox) findViewById(R.id.cb_desconhecido_pai);
        cbVisitaRecusada = (CheckBox) findViewById(R.id.cb_visita_recusada);

        //LinearLayouts
        llTemDeficiencia = (LinearLayout) findViewById(R.id.ll_tem_deficiencia);
        llTipoDeficiencia = (LinearLayout) findViewById(R.id.ll_tipo_deficiencia);
        llNaturalizacao = (LinearLayout) findViewById(R.id.ll_naturalizacao);
        llDoencaCardiaca = (LinearLayout) findViewById(R.id.ll_doenca_cardiaca);
        llProblemaRins = (LinearLayout) findViewById(R.id.ll_problema_rins);
        llDoencaRespiratoria = (LinearLayout) findViewById(R.id.ll_doenca_respiratoria);
        llHigienePessoal = (LinearLayout) findViewById(R.id.ll_higiene_pessoal);

        llSocioDemografico = (LinearLayout) findViewById(R.id.ll_socio_demografico);
        llCondicoesSaude = (LinearLayout) findViewById(R.id.ll_condicoes_saude);
        llSituacaoRua = (LinearLayout) findViewById(R.id.ll_situacao_rua);
        llSeSituacaoRua = (LinearLayout) findViewById(R.id.ll_se_situacao_rua);

        fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        rlMain = (RelativeLayout) findViewById(R.id.rl_main);


        this.fichaCadastroIndividualBS = new FichaCadastroIndividualBS(getApplication());

        this.profissionalModel = new ProfissionalModel();
        this.cnesModel = new CNESModel();

    }

    private void configToolbar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cadastro Individual");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FichaCadastroIndividualActivity.this, MainActivity.class);
                intent.putExtra("fragment", "FichaCadastroIndividualFragment");
                startActivity(intent);
                finish();
            }
        });

    }

    private void carregarSpinnerPais(boolean flagComBrasil) {

        ArrayAdapter<TipoModel> spAdapter;

        List<TipoModel> paises = new TipoModel().getComboPais();

        if (!flagComBrasil) {
            paises.remove(30);
        }

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, paises);
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spPais.setAdapter(spAdapter);

    }

    private void carregarSpinners() {

        ArrayAdapter<TipoModel> spAdapter;

        this.carregarSpinnerPais(Boolean.TRUE);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboRaca());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spRaca.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboEtnia());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spEtnia.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboParentesco());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spParentesco.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboCurso());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spCurso.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboTrabalho());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spTrabalho.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboOrientacaoSexual());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spOrientacao.setAdapter(spAdapter);

        spAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, new TipoModel().getComboGeneroSexual());
        spAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spGenero.setAdapter(spAdapter);

    }

    private void configDatas() {

        this.configDatePicker(FichaCadastroIndividualActivity.this, etDataRegistro.getText().toString(), etDataRegistro);
        this.configDatePicker(FichaCadastroIndividualActivity.this, etDataNascimento.getText().toString(), etDataNascimento);
        this.configDatePicker(FichaCadastroIndividualActivity.this, etDataNaturalizacao.getText().toString(), etDataNaturalizacao);
        this.configDatePicker(FichaCadastroIndividualActivity.this, etDataEntrada.getText().toString(), etDataEntrada);
        this.configDatePicker(FichaCadastroIndividualActivity.this, etDataObito.getText().toString(), etDataObito);

    }

    private void instanciarFichaCadastroIndividualModel() {

        this.fichaCadastroIndividualModel = (FichaCadastroIndividualModel) getIntent().getSerializableExtra("fichaCadastroIndividual");

        if (this.fichaCadastroIndividualModel == null) {
            this.fichaCadastroIndividualModel = new FichaCadastroIndividualModel();
        } else {
            this.setModelToActivity();
        }

    }

    private void gravar() {

        if (!validaCampos()) { return; }

        this.setActivityToModel();

        this.fichaCadastroIndividualBS.gravar(this.fichaCadastroIndividualModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaCadastroIndividualFragment");
        startActivity(intent);

        finish();

    }

    private boolean algumCheckBoxMarcado(LinearLayout ll) {

        Boolean marcado = false;
        int checks = 0;

        for (int i = 0; i < ll.getChildCount(); i++) {
            if (ll.getChildAt(i) instanceof CheckBox) {
                if (((CheckBox) ll.getChildAt(i)).isChecked()) {
                    checks++;
                }
            } else if (ll.getChildAt(i) instanceof LinearLayout) {

                if (algumCheckBoxMarcado((LinearLayout) ll.getChildAt(i))) {
                    checks++;
                }
            }
        }

        if (checks > 0) {
            marcado = true;
        }

        return marcado;
    }


    private boolean validaCampos() {

        boolean valido = true;

        Utilitario.limparErros(findViewById(R.id.ll_main));

        String aviso = "";
        String msg;

        int indexInternado = rgInternado.indexOfChild(findViewById(rgInternado.getCheckedRadioButtonId()));
        int indexUsaPlantas = rgPlantasMedicinais.indexOfChild(findViewById(rgPlantasMedicinais.getCheckedRadioButtonId()));
        int indexSituacaoRua = rgSituacaoRua.indexOfChild(findViewById(rgSituacaoRua.getCheckedRadioButtonId()));
        int indexResponsavel = rgResponsavelFamiliar.indexOfChild(findViewById(rgResponsavelFamiliar.getCheckedRadioButtonId()));
        int indexDoencaCardiaca = rgDoencaCardiaca.indexOfChild(findViewById(rgDoencaCardiaca.getCheckedRadioButtonId()));
        int indexDoencaRespiratoria = rgDoencaRespiratoria.indexOfChild(findViewById(rgDoencaRespiratoria.getCheckedRadioButtonId()));
        int indexProblemaRins = rgProblemaRins.indexOfChild(findViewById(rgProblemaRins.getCheckedRadioButtonId()));
        int indexHigienePessoal = rgAcessoHigienePessoal.indexOfChild(findViewById(rgAcessoHigienePessoal.getCheckedRadioButtonId()));
        int indexDeficiencia = rgDeficiencia.indexOfChild(findViewById(rgDeficiencia.getCheckedRadioButtonId()));
        int indexSaidaCadastro = rgSaidaCadastro.indexOfChild(findViewById(rgSaidaCadastro.getCheckedRadioButtonId()));
        int indexNacionalidade = rgNacionalidade.indexOfChild(findViewById(rgNacionalidade.getCheckedRadioButtonId()));

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

        if ((!Utilitario.isEmpty(etCnsCidadao.getText().toString())) && !Utilitario.isCNSValido(etCnsCidadao.getText().toString())) {
            msg = "O CNS do cidadão não é válido";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_cns_cidadao), msg);
            valido = false;
        }

        if (indexResponsavel == 1 && Utilitario.isEmpty(etCnsResponsavelFamiliar.getText().toString())) {
            msg = "Preencha o CNS do responsável";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_cns_responsavel), msg);
            valido = false;
        } else if (!Utilitario.isCNSValido(etCnsResponsavelFamiliar.getText().toString())) {
            msg = "O CNS do responsável não é válido";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_cns_responsavel), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etMicroarea.getText().toString())) && !cbForaDeArea.isChecked()) {
            msg = "Preencha a microárea";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_microarea), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etNomeCompleto.getText().toString()))) {
            msg = "Preencha o nome do cidadão";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_nome_completo), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etDataNascimento.getText().toString()))) {
            msg = "Preencha a data de nascimento";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_nascimento), msg);
            valido = false;
        } else if (!Utilitario.dataValida(etDataNascimento.getText().toString())) {
            msg = "A data de nascimento não é válida";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_nascimento), msg);
            valido = false;
        }

        if (rgSexo.getCheckedRadioButtonId() == -1) {
            msg = "Selecione o sexo";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_sexo), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(((TipoModel) spRaca.getSelectedItem()).getCodigo())) {
            msg = "Selecione a raça/cor";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_raca), msg);
            valido = false;
        }

        if (!Utilitario.isEmpty((spRaca.getSelectedItem())) && !Utilitario.isEmpty(((TipoModel)spRaca.getSelectedItem()).getCodigo()) && ((TipoModel)spRaca.getSelectedItem()).getCodigo() == 5) {
            msg = "Selecione a etnia";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_etnia), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etNomeMae.getText().toString())) && !cbMaeDesconhecido.isChecked()) {
            msg = "Preencha o nome da mãe";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_nome_mae), msg);
            valido = false;
        }

        if ((Utilitario.isEmpty(etNomePai.getText().toString())) && !cbPaiDesconhecido.isChecked()) {
            msg = "Preencha o nome do pai";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_nome_pai), msg);
            valido = false;
        }

        if (rgNacionalidade.getCheckedRadioButtonId() == -1) {
            msg = "Selecione a nacionalidade";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_nacionalidade), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(((TipoModel) spPais.getSelectedItem()).getCodigo()) && (indexNacionalidade == 2)) {
            msg = "Selecione o país de nascimento";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.tv_municipio), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etMunicipioNascimento.getText().toString()) && (indexNacionalidade == 0)) {
            msg = "Preencha o município de nascimento";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_municipio_nascimento), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etPortariaNaturalizacao.getText().toString()) && (indexNacionalidade == 1)) {
            msg = "Preencha a portaria de naturalização";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_portaria_naturalizacao), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etDataNaturalizacao.getText().toString()) && (indexNacionalidade == 1)) {
            msg = "Preencha a data de naturalização";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_naturalizacao), msg);
            valido = false;
        } else if (!Utilitario.dataValida(etDataNaturalizacao.getText().toString())) {
            msg = "A data de naturalização não é válida";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_naturalizacao), msg);
            valido = false;
        }

        if (Utilitario.isEmpty(etDataEntrada.getText().toString()) && (indexNacionalidade == 2)) {
            msg = "Preencha a data de entrada";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_entrada), msg);
            valido = false;
        } else if (!Utilitario.dataValida(etDataEntrada.getText().toString())) {
            msg = "A data de entrada não é válida";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_data_entrada), msg);
            valido = false;
        }

        if ((!Utilitario.isEmpty(etEmailCidadao.getText().toString())) && !Utilitario.isEmailValido(etEmailCidadao.getText().toString())) {
            msg = "O e-mail não é válido";
            aviso = Utilitario.addAviso(msg, aviso);
            Utilitario.exibirErro(findViewById(R.id.til_email), msg);
            valido = false;
        }

        if (!cbVisitaRecusada.isChecked()) {

            if (rgFrequentaEscola.getCheckedRadioButtonId() == -1) {
                msg = "Informe se frequenta escola ou creche";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_frequenta_escola), msg);
                valido = false;
            }

            if (rgDeficiencia.getCheckedRadioButtonId() == -1) {
                msg = "Informe se tem alguma deficiência";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_deficiencia), msg);
                valido = false;
            } else if (!this.algumCheckBoxMarcado(llTemDeficiencia) && indexDeficiencia == 0) {
                msg = "Informe a(s) deficiência(s)";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_deficiencia), msg);
                valido = false;
            }

            if ((Utilitario.isEmpty(etNumeroDO.getText().toString())) && indexSaidaCadastro == 1) {
                msg = "Preencha o número da D.O.";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.til_numero_do), msg);
                valido = false;
            }

            if ((Utilitario.isEmpty(etDataObito.getText().toString())) && indexSaidaCadastro == 1) {
                msg = "Preencha a data do óbito";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.til_data_obito), msg);
                valido = false;
            } else if (!Utilitario.isEmpty(etDataObito.getText().toString()) && !Utilitario.dataValida(etDataObito.getText().toString())) {
                msg = "A data do óbito não é válida";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.til_data_obito), msg);
                valido = false;
            }

            if (!this.algumCheckBoxMarcado(llDoencaCardiaca) && indexDoencaCardiaca == 0) {
                msg = "Informe a(s) doença(s)";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_doenca_cardiaca), msg);
                valido = false;
            }

            if (!this.algumCheckBoxMarcado(llProblemaRins) && indexProblemaRins == 0) {
                msg = "Informe o(s) problema(s)";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_problema_rins), msg);
                valido = false;
            }

            if (!this.algumCheckBoxMarcado(llDoencaRespiratoria) && indexDoencaRespiratoria == 0) {
                msg = "Informe a(s) doença(s)";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_doenca_respiratoria), msg);
                valido = false;
            }

            if (Utilitario.isEmpty(etQualMotivoInternamento.getText().toString()) && indexInternado == 0) {
                msg = "Informe o motivo do internamento";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_internamento), msg);
                valido = false;
            }

            if (Utilitario.isEmpty(etQuaisPlantas.getText().toString()) && indexUsaPlantas == 0) {
                msg = "Informe a(s) planta(s) utilizada(s)";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_doenca_cardiaca), msg);
                valido = false;
            }

            if (rgSituacaoRua.getCheckedRadioButtonId() == -1) {
                msg = "Informe se está em situação de rua";
                aviso = Utilitario.addAviso(msg, aviso);
                Utilitario.exibirErro(findViewById(R.id.tv_situacao_rua), msg);
                valido = false;
            }

            if (indexSituacaoRua == 0) {

                if (!this.algumCheckBoxMarcado(llHigienePessoal) && indexHigienePessoal == 0) {
                    msg = "Informe o acesso a higiene pessoal";
                    aviso = Utilitario.addAviso(msg, aviso);
                    Utilitario.exibirErro(findViewById(R.id.tv_higiene_pessoal), msg);
                    valido = false;
                }

            }

        }

        if (!aviso.isEmpty()) {
            final String finalAviso = aviso;
            Snackbar snackbar = Snackbar.make(fabGravar, "Alguns itens estão pendentes", Snackbar.LENGTH_LONG).setAction("DETALHES", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utilitario.alertar(FichaCadastroIndividualActivity.this, finalAviso);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();

        }

        return valido;

    }

    private void configListeners() {

        this.desabilitaEditText(rgMembroDeComunidade, 1, etQualComunidade);
        this.desabilitaEditText(rgGestante, 1, etQualMaternidade);
        this.desabilitaEditText(rgInternado, 1, etQualMotivoInternamento);
        this.desabilitaEditText(rgPlantasMedicinais, 1, etQuaisPlantas);
        this.desabilitaEditText(rgAcompanhadoInstituicao, 1, etQualInstituicao);
        this.desabilitaEditText(rgVisitaFamiliar, 1, etGrauParentesco);

        this.desabilitaEditText(cbForaDeArea, etMicroarea);
        this.desabilitaEditText(cbMaeDesconhecido, etNomeMae);
        this.desabilitaEditText(cbPaiDesconhecido, etNomePai);

        this.desabilitaLinearLayout(rgDeficiencia, 1, llTipoDeficiencia);
        this.desabilitaLinearLayout(rgDoencaCardiaca, 1, llDoencaCardiaca);
        this.desabilitaLinearLayout(rgProblemaRins, 1, llProblemaRins);
        this.desabilitaLinearLayout(rgDoencaRespiratoria, 1, llDoencaRespiratoria);
        this.desabilitaLinearLayout(rgAcessoHigienePessoal, 1, llHigienePessoal);

        this.desabilitaSpinner(rgInformarOrientacao, 1, spOrientacao);
        this.desabilitaSpinner(rgInformarIdentidadeGenero, 1, spGenero);

        spRaca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                desabilitarComponentes(spEtnia);

                if (!Utilitario.isEmpty(((TipoModel)spRaca.getSelectedItem()).getCodigo()) && ((TipoModel)spRaca.getSelectedItem()).getCodigo() == 5) {
                    habilitarComponentes(spEtnia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spRaca.setSelection(0);
            }

        });

        rgResponsavelFamiliar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));
                if (indexRg == 1) {
                    habilitarComponentes(etCnsResponsavelFamiliar);
                    habilitarComponentes(spParentesco);
                } else {
                    desabilitarComponentes(etCnsResponsavelFamiliar);
                    desabilitarComponentes(spParentesco);
                }
            }
        });

        rgSaidaCadastro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));
                if (indexRg == 1) {
                    habilitarComponentes(etNumeroDO);
                    habilitarComponentes(etDataObito);
                } else {
                    desabilitarComponentes(etNumeroDO);
                    desabilitarComponentes(etDataObito);
                }
            }
        });

        rgSituacaoRua.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));
                if (indexRg == 0) {
                    habilitarComponentes(rgTempoSituacaoRua);
                    habilitarComponentes(llSeSituacaoRua);
                } else {
                    desabilitarComponentes(rgTempoSituacaoRua);
                    desabilitarComponentes(llSeSituacaoRua);
                }
            }
        });

        rgNacionalidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                if (indexRg != 2) {
                    FichaCadastroIndividualActivity.this.carregarSpinnerPais(Boolean.TRUE);
                    spPais.setEnabled(false);
                    spPais.setClickable(false);
                    spPais.setSelection(0);
                } else {
                    FichaCadastroIndividualActivity.this.carregarSpinnerPais(Boolean.FALSE);
                    spPais.setEnabled(true);
                    spPais.setClickable(true);
                    spPais.performClick();
                }

                if (!spPais.isEnabled()) {
                    spPais.setSelection(new TipoModel().getComboPais().indexOf(new TipoModel(31)));
                }

                FichaCadastroIndividualActivity.this.validaHabilitacaoEditText(etMunicipioNascimento, indexRg == 0);
                FichaCadastroIndividualActivity.this.validaHabilitacaoEditText(etDataEntrada, indexRg == 2);
                FichaCadastroIndividualActivity.this.validaHabilitacaoEditText(etDataNaturalizacao, indexRg == 1);
                FichaCadastroIndividualActivity.this.validaHabilitacaoEditText(etPortariaNaturalizacao, indexRg == 1);


            }
        });

        rgSaidaCadastro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                Integer indexRg = rg.indexOfChild(findViewById(checkedId));

                if (indexRg == 0) {
                    desabilitaEditText(etNumeroDO);
                    desabilitaEditText(etDataObito);
                } else {
                    habilitaEditText(etNumeroDO);
                    habilitaEditText(etDataObito);
                }

            }
        });

        cbVisitaRecusada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    desabilitaLinearLayout(llSocioDemografico);
                    desabilitaLinearLayout(llCondicoesSaude);
                    desabilitaLinearLayout(llSituacaoRua);
                    llSocioDemografico.setVisibility(View.GONE);
                    llCondicoesSaude.setVisibility(View.GONE);
                    llSituacaoRua.setVisibility(View.GONE);

                } else {
                    llSocioDemografico.setVisibility(View.VISIBLE);
                    llCondicoesSaude.setVisibility(View.VISIBLE);
                    llSituacaoRua.setVisibility(View.VISIBLE);
                    habilitaLinearLayout(llSocioDemografico);
                    habilitaLinearLayout(llCondicoesSaude);
                    habilitaLinearLayout(llSituacaoRua);
                }
            }
        });

    }

    private void configMascaras() {

        final String mascaraData = "##/##/####";
        final String mascaraTelefone = "(##)#####-####";

        etDataRegistro.addTextChangedListener(Mascara.insert(mascaraData, etDataRegistro));
        etDataRegistro.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataRegistro));
        etDataNascimento.addTextChangedListener(Mascara.insert(mascaraData, etDataNascimento));
        etDataNascimento.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataNascimento));
        etDataNaturalizacao.addTextChangedListener(Mascara.insert(mascaraData, etDataNaturalizacao));
        etDataNaturalizacao.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataNaturalizacao));
        etDataEntrada.addTextChangedListener(Mascara.insert(mascaraData, etDataEntrada));
        etDataEntrada.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataEntrada));
        etDataObito.addTextChangedListener(Mascara.insert(mascaraData, etDataObito));
        etDataObito.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataObito));

        etTelefoneCelular.addTextChangedListener(Mascara.insert(mascaraTelefone, etTelefoneCelular));
        etTelefoneCelular.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraTelefone, etTelefoneCelular));

    }

    private boolean validaDatas() {

        boolean valido = true;

        return valido;

    }

    private void setPosicaoSelecionadoRG(RadioGroup radioGroup, Integer valor) {

        if (Utilitario.isEmpty(valor) || valor.equals(-1)) {
            return;
        }

        if (radioGroup == rgNacionalidade) {

            switch (valor) {
                case 1: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 2: {
                    ativaRG(radioGroup, 1);
                    break;
                }
                case 3: {
                    ativaRG(radioGroup, 2);
                    break;
                }
            }
        } else if (radioGroup == rgSaidaCadastro) {
            switch (valor) {
                case 135: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 136: {
                    ativaRG(radioGroup, 1);
                    break;
                }
            }
        } else if (radioGroup == rgPeso) {
            switch (valor) {
                case 21: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 22: {
                    ativaRG(radioGroup, 1);
                    break;
                }
                case 23: {
                    ativaRG(radioGroup, 2);
                    break;
                }
            }
        } else if (radioGroup == rgTempoSituacaoRua) {
            switch (valor) {
                case 17: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 18: {
                    ativaRG(radioGroup, 1);
                    break;
                }
                case 19: {
                    ativaRG(radioGroup, 2);
                    break;
                }
                case 20: {
                    ativaRG(radioGroup, 3);
                    break;
                }
            }
        } else if (radioGroup == rgFrequenciaAlimentacao) {
            switch (valor) {
                case 34: {
                    ativaRG(radioGroup, 0);
                    break;
                }
                case 35: {
                    ativaRG(radioGroup, 1);
                    break;
                }
                case 36: {
                    ativaRG(radioGroup, 2);
                    break;
                }
            }
        } else {
            ativaRG(radioGroup, valor);
        }


    }


    private void setModelToActivity() {

        etDataRegistro.setText(Utilitario.getDataFormatada(this.fichaCadastroIndividualModel.getDataRegistro()));
        etCnsCidadao.setText(this.fichaCadastroIndividualModel.getCnsCidadao());
        setPosicaoSelecionadoRG(rgResponsavelFamiliar, this.fichaCadastroIndividualModel.getFlagResponsavelFamiliar());
        etCnsResponsavelFamiliar.setText(this.fichaCadastroIndividualModel.getCnsResponsavelFamiliar());
        etMicroarea.setText(this.fichaCadastroIndividualModel.getMicroarea());
        cbForaDeArea.setChecked(this.fichaCadastroIndividualModel.getFlagForaDeArea());
        etNomeCompleto.setText(this.fichaCadastroIndividualModel.getNomeCompleto());
        etNomeSocial.setText(this.fichaCadastroIndividualModel.getNomeSocial());
        etDataNascimento.setText(Utilitario.getDataFormatada(this.fichaCadastroIndividualModel.getDataNascimento()));
        setPosicaoSelecionadoRG(rgSexo, this.fichaCadastroIndividualModel.getSexo());
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getRaca()) && this.fichaCadastroIndividualModel.getRaca().getCodigo() > 0) {
            spRaca.setSelection(new TipoModel().getComboRaca().indexOf(this.fichaCadastroIndividualModel.getRaca()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getEtnia()) && this.fichaCadastroIndividualModel.getEtnia().getCodigo() > 0) {
            spEtnia.setSelection(new TipoModel().getComboEtnia().indexOf(this.fichaCadastroIndividualModel.getEtnia()));
        }
        etNis.setText(this.fichaCadastroIndividualModel.getNis());
        etNomeMae.setText(this.fichaCadastroIndividualModel.getNomeMae());
        cbMaeDesconhecido.setChecked(this.fichaCadastroIndividualModel.getFlagMaeDesconhecido());
        etNomePai.setText(this.fichaCadastroIndividualModel.getNomePai());
        cbPaiDesconhecido.setChecked(this.fichaCadastroIndividualModel.getFlagPaiDesconhecido());
        setPosicaoSelecionadoRG(rgNacionalidade, this.fichaCadastroIndividualModel.getNacionalidade());
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getPaisNascimento()) && this.fichaCadastroIndividualModel.getPaisNascimento().getCodigo() > 0) {
            spPais.setSelection(new TipoModel().getComboPais().indexOf(this.fichaCadastroIndividualModel.getPaisNascimento()));
        }
        etMunicipioNascimento.setText(this.fichaCadastroIndividualModel.getMunicipioUfNascimento());
        etPortariaNaturalizacao.setText(this.fichaCadastroIndividualModel.getPortariaNaturalizacao());
        etDataNaturalizacao.setText(Utilitario.getDataFormatada(this.fichaCadastroIndividualModel.getDataNaturalizacao()));
        etDataEntrada.setText(Utilitario.getDataFormatada(this.fichaCadastroIndividualModel.getDataEntrada()));
        etTelefoneCelular.setText(this.fichaCadastroIndividualModel.getTelefoneCelular());
        etEmailCidadao.setText(this.fichaCadastroIndividualModel.getEmailCidadao());
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getParentescoResponsavelFamiliar()) && this.fichaCadastroIndividualModel.getParentescoResponsavelFamiliar().getCodigo() > 0) {
            spParentesco.setSelection(new TipoModel().getComboParentesco().indexOf(this.fichaCadastroIndividualModel.getParentescoResponsavelFamiliar()));
        }
        etOcupacao.setText(this.fichaCadastroIndividualModel.getOcupacao());
        setPosicaoSelecionadoRG(rgFrequentaEscola, this.fichaCadastroIndividualModel.getFlagFrequentaEscola());
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getCursoMaisElevado()) && this.fichaCadastroIndividualModel.getCursoMaisElevado().getCodigo() > 0) {
            spCurso.setSelection(new TipoModel().getComboCurso().indexOf(this.fichaCadastroIndividualModel.getCursoMaisElevado()));
        }
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getSituacaoMercado()) && this.fichaCadastroIndividualModel.getSituacaoMercado().getCodigo() > 0) {
            spTrabalho.setSelection(new TipoModel().getComboTrabalho().indexOf(this.fichaCadastroIndividualModel.getSituacaoMercado()));
        }
        cbFicaComAdultoResponsavel.setChecked(this.fichaCadastroIndividualModel.getFlagFicaComAdultoResponsavel());
        cbFicaEmCreche.setChecked(this.fichaCadastroIndividualModel.getFlagFicaEmCreche());
        cbFicaComOutrasCriancas.setChecked(this.fichaCadastroIndividualModel.getFlagFicaComOutrasCriancas());
        cbFicaSozinha.setChecked(this.fichaCadastroIndividualModel.getFlagFicaSozinha());
        cbFicaComAdolescente.setChecked(this.fichaCadastroIndividualModel.getFlagFicaComAdolescente());
        cbFicaOutro.setChecked(this.fichaCadastroIndividualModel.getFlagFicaOutro());
        setPosicaoSelecionadoRG(rgFrequentaCuidador, this.fichaCadastroIndividualModel.getFlagFrequentaCuidador());
        setPosicaoSelecionadoRG(rgParticipaGrupoComunitario, this.fichaCadastroIndividualModel.getFlagParticipaGrupoComunitario());
        setPosicaoSelecionadoRG(rgPossuiPlanoDeSaude, this.fichaCadastroIndividualModel.getFlagPossuiPlanoDeSaude());
        setPosicaoSelecionadoRG(rgMembroDeComunidade, this.fichaCadastroIndividualModel.getFlagMembroDeComunidade());
        etQualComunidade.setText(this.fichaCadastroIndividualModel.getQualComunidade());
        setPosicaoSelecionadoRG(rgInformarOrientacao, this.fichaCadastroIndividualModel.getFlagInformarOrientacao());
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getOrientacaoSexual()) && this.fichaCadastroIndividualModel.getOrientacaoSexual().getCodigo() > 0) {
            spOrientacao.setSelection(new TipoModel().getComboOrientacaoSexual().indexOf(this.fichaCadastroIndividualModel.getOrientacaoSexual()));
        }
        setPosicaoSelecionadoRG(rgInformarIdentidadeGenero, this.fichaCadastroIndividualModel.getFlagInformarIdentidadeGenero());
        if (!Utilitario.isEmpty(this.fichaCadastroIndividualModel.getIdentidadeGenero()) && this.fichaCadastroIndividualModel.getIdentidadeGenero().getCodigo() > 0) {
            spGenero.setSelection(new TipoModel().getComboGeneroSexual().indexOf(this.fichaCadastroIndividualModel.getIdentidadeGenero()));
        }
        setPosicaoSelecionadoRG(rgDeficiencia, this.fichaCadastroIndividualModel.getFlagDeficiencia());
        cbDeficienciaAuditiva.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaAuditiva());
        cbDeficienciaFisica.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaFisica());
        cbDeficienciaIntelectual.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaIntelectual());
        cbDeficienciaVisual.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaVisual());
        cbOutraDeficiencia.setChecked(this.fichaCadastroIndividualModel.getFlagOutraDeficiencia());
        setPosicaoSelecionadoRG(rgSaidaCadastro, this.fichaCadastroIndividualModel.getSaidaCadastro());
        etNumeroDO.setText(this.fichaCadastroIndividualModel.getNumeroDO());
        etDataObito.setText(Utilitario.getDataFormatada(this.fichaCadastroIndividualModel.getDataObito()));
        setPosicaoSelecionadoRG(rgGestante, this.fichaCadastroIndividualModel.getFlagGestante());
        etQualMaternidade.setText(this.fichaCadastroIndividualModel.getQualMaternidade());
        setPosicaoSelecionadoRG(rgPeso, this.fichaCadastroIndividualModel.getPeso());
        setPosicaoSelecionadoRG(rgFumante, this.fichaCadastroIndividualModel.getFlagFumante());
        setPosicaoSelecionadoRG(rgAlcool, this.fichaCadastroIndividualModel.getFlagAlcool());
        setPosicaoSelecionadoRG(rgOutrasDrogas, this.fichaCadastroIndividualModel.getFlagOutrasDrogas());
        setPosicaoSelecionadoRG(rgHipertensao, this.fichaCadastroIndividualModel.getFlagHipertensao());
        setPosicaoSelecionadoRG(rgDiabetes, this.fichaCadastroIndividualModel.getFlagDiabetes());
        setPosicaoSelecionadoRG(rgAvcDerrame, this.fichaCadastroIndividualModel.getFlagAvcDerrame());
        setPosicaoSelecionadoRG(rgInfarto, this.fichaCadastroIndividualModel.getFlagInfarto());
        setPosicaoSelecionadoRG(rgDoencaCardiaca, this.fichaCadastroIndividualModel.getFlagDoencaCardiaca());
        cbInsuficienciaCardiaca.setChecked(this.fichaCadastroIndividualModel.getFlagInsuficienciaCardiaca());
        cbOutraDoencaCardiaca.setChecked(this.fichaCadastroIndividualModel.getFlagOutraDoencaCardiaca());
        cbNaoSabeDoencaCardiaca.setChecked(this.fichaCadastroIndividualModel.getFlagNaoSabeDoencaCardiaca());
        setPosicaoSelecionadoRG(rgProblemaRins, this.fichaCadastroIndividualModel.getFlagProblemaRins());
        cbInsuficienciaRenal.setChecked(this.fichaCadastroIndividualModel.getFlagInsuficienciaRenal());
        cbOutroProblemaRins.setChecked(this.fichaCadastroIndividualModel.getFlagOutroProblemaRins());
        cbNaoSabeProblemaRins.setChecked(this.fichaCadastroIndividualModel.getFlagNaoSabeProblemaRins());
        setPosicaoSelecionadoRG(rgDoencaRespiratoria, this.fichaCadastroIndividualModel.getFlagDoencaRespiratoria());
        cbAsma.setChecked(this.fichaCadastroIndividualModel.getFlagAsma());
        cbEnfisema.setChecked(this.fichaCadastroIndividualModel.getFlagEnfisema());
        cbOutraDoencaRespiratoria.setChecked(this.fichaCadastroIndividualModel.getFlagOutraDoencaRespiratoria());
        cbNaoSabeDoencaRespiratoria.setChecked(this.fichaCadastroIndividualModel.getFlagNaoSabeDoencaRespiratoria());
        setPosicaoSelecionadoRG(rgHanseniase, this.fichaCadastroIndividualModel.getFlagHanseniase());
        setPosicaoSelecionadoRG(rgTuberculose, this.fichaCadastroIndividualModel.getFlagTuberculose());
        setPosicaoSelecionadoRG(rgCancer, this.fichaCadastroIndividualModel.getFlagCancer());
        setPosicaoSelecionadoRG(rgInternado, this.fichaCadastroIndividualModel.getFlagInternado());
        etQualMotivoInternamento.setText(this.fichaCadastroIndividualModel.getQualMotivoInternamento());
        setPosicaoSelecionadoRG(rgProblemaMental, this.fichaCadastroIndividualModel.getFlagProblemaMental());
        setPosicaoSelecionadoRG(rgAcamado, this.fichaCadastroIndividualModel.getFlagAcamado());
        setPosicaoSelecionadoRG(rgDomiciliado, this.fichaCadastroIndividualModel.getFlagDomiciliado());
        setPosicaoSelecionadoRG(rgPlantasMedicinais, this.fichaCadastroIndividualModel.getFlagPlantasMedicinais());
        etQuaisPlantas.setText(this.fichaCadastroIndividualModel.getQuaisPlantas());
        setPosicaoSelecionadoRG(rgOutrasPraticasIntegrativas, this.fichaCadastroIndividualModel.getFlagOutrasPraticasIntegrativas());
        etOutrasCondicoesSaude.setText(this.fichaCadastroIndividualModel.getOutrasCondicoesSaude());
        setPosicaoSelecionadoRG(rgSituacaoRua, this.fichaCadastroIndividualModel.getFlagSituacaoRua());
        setPosicaoSelecionadoRG(rgTempoSituacaoRua, this.fichaCadastroIndividualModel.getTempoSituacaoRua());
        setPosicaoSelecionadoRG(rgRecebeBeneficio, this.fichaCadastroIndividualModel.getFlagRecebeBeneficio());
        setPosicaoSelecionadoRG(rgReferenciaFamiliar, this.fichaCadastroIndividualModel.getFlagReferenciaFamiliar());
        setPosicaoSelecionadoRG(rgFrequenciaAlimentacao, this.fichaCadastroIndividualModel.getFrequenciaAlimentacao());
        cbAlimentacaoRestaurantePopular.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoRestaurantePopular());
        cbAlimentacaoDoacaoPopular.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoDoacaoPopular());
        cbAlimentacaoDoacaoGrupoReligioso.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoDoacaoGrupoReligioso());
        cbAlimentacaoOutras.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoOutras());
        cbAlimentacaoDoacaoRestaurante.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoDoacaoRestaurante());
        setPosicaoSelecionadoRG(rgAcompanhadoInstituicao, this.fichaCadastroIndividualModel.getFlagAcompanhadoInstituicao());
        etQualInstituicao.setText(this.fichaCadastroIndividualModel.getQualInstituicao());
        setPosicaoSelecionadoRG(rgVisitaFamiliar, this.fichaCadastroIndividualModel.getFlagVisitaFamiliar());
        etGrauParentesco.setText(this.fichaCadastroIndividualModel.getGrauParentesco());
        setPosicaoSelecionadoRG(rgAcessoHigienePessoal, this.fichaCadastroIndividualModel.getFlagAcessoHigienePessoal());
        cbAcessoBanho.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoBanho());
        cbAcessoSanitario.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoSanitario());
        cbAcessoHigieneBucal.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoHigieneBucal());
        cbAcessoOutras.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoOutras());

    }

    private void setActivityToModel() {

        this.fichaCadastroIndividualModel.setProfissionalModel(new ProfissionalModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("id", 0)));
        this.fichaCadastroIndividualModel.setCnesModel(new CNESModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("cnes_id", 0)));
        this.fichaCadastroIndividualModel.setDataRegistro(Utilitario.getDate(etDataRegistro.getText().toString()));
        this.fichaCadastroIndividualModel.setCnsCidadao(etCnsCidadao.getText().toString());
        this.fichaCadastroIndividualModel.setFlagResponsavelFamiliar(this.getPosicaoSelecionadoRG(rgResponsavelFamiliar));
        this.fichaCadastroIndividualModel.setCnsResponsavelFamiliar(etCnsResponsavelFamiliar.getText().toString());
        this.fichaCadastroIndividualModel.setMicroarea(etMicroarea.getText().toString());
        this.fichaCadastroIndividualModel.setFlagForaDeArea(cbForaDeArea.isChecked());
        this.fichaCadastroIndividualModel.setNomeCompleto(etNomeCompleto.getText().toString());
        this.fichaCadastroIndividualModel.setNomeSocial(etNomeSocial.getText().toString());
        this.fichaCadastroIndividualModel.setDataNascimento(Utilitario.getDate(etDataNascimento.getText().toString()));
        this.fichaCadastroIndividualModel.setSexo(this.getPosicaoSelecionadoRG(rgSexo).equals(-1) ? 4 : this.getPosicaoSelecionadoRG(rgSexo));
        this.fichaCadastroIndividualModel.setRaca((TipoModel) this.spRaca.getSelectedItem());
        this.fichaCadastroIndividualModel.setEtnia((TipoModel) this.spEtnia.getSelectedItem());
        this.fichaCadastroIndividualModel.setNis(etNis.getText().toString());
        this.fichaCadastroIndividualModel.setNomeMae(etNomeMae.getText().toString());
        this.fichaCadastroIndividualModel.setNomePai(etNomePai.getText().toString());
        this.fichaCadastroIndividualModel.setNacionalidade(this.getPosicaoSelecionadoRG(rgNacionalidade) + 1);
        this.fichaCadastroIndividualModel.setPaisNascimento((TipoModel) this.spPais.getSelectedItem());
        this.fichaCadastroIndividualModel.setMunicipioUfNascimento(etMunicipioNascimento.getText().toString());
        this.fichaCadastroIndividualModel.setPortariaNaturalizacao(etPortariaNaturalizacao.getText().toString());
        this.fichaCadastroIndividualModel.setDataNaturalizacao(Utilitario.getDate(etDataNaturalizacao.getText().toString()));
        this.fichaCadastroIndividualModel.setDataEntrada(Utilitario.getDate(etDataEntrada.getText().toString()));
        this.fichaCadastroIndividualModel.setTelefoneCelular(etTelefoneCelular.getText().toString());
        this.fichaCadastroIndividualModel.setEmailCidadao(etEmailCidadao.getText().toString());
        this.fichaCadastroIndividualModel.setParentescoResponsavelFamiliar((TipoModel) this.spParentesco.getSelectedItem());
        this.fichaCadastroIndividualModel.setOcupacao(etOcupacao.getText().toString());
        this.fichaCadastroIndividualModel.setFlagFrequentaEscola(this.getPosicaoSelecionadoRG(rgFrequentaEscola));
        this.fichaCadastroIndividualModel.setCursoMaisElevado((TipoModel) this.spCurso.getSelectedItem());
        this.fichaCadastroIndividualModel.setSituacaoMercado((TipoModel) this.spTrabalho.getSelectedItem());
        this.fichaCadastroIndividualModel.setFlagFicaComAdultoResponsavel(cbFicaComAdultoResponsavel.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaEmCreche(cbFicaEmCreche.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaComOutrasCriancas(cbFicaComOutrasCriancas.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaSozinha(cbFicaSozinha.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaComAdolescente(cbFicaComAdolescente.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaOutro(cbFicaOutro.isChecked());
        this.fichaCadastroIndividualModel.setFlagFrequentaCuidador(this.getPosicaoSelecionadoRG(rgFrequentaCuidador));
        this.fichaCadastroIndividualModel.setFlagParticipaGrupoComunitario(this.getPosicaoSelecionadoRG(rgParticipaGrupoComunitario));
        this.fichaCadastroIndividualModel.setFlagPossuiPlanoDeSaude(this.getPosicaoSelecionadoRG(rgPossuiPlanoDeSaude));
        this.fichaCadastroIndividualModel.setFlagMembroDeComunidade(this.getPosicaoSelecionadoRG(rgMembroDeComunidade));
        this.fichaCadastroIndividualModel.setQualComunidade(etQualComunidade.getText().toString());
        this.fichaCadastroIndividualModel.setFlagInformarOrientacao(this.getPosicaoSelecionadoRG(rgInformarOrientacao));
        this.fichaCadastroIndividualModel.setOrientacaoSexual((TipoModel) this.spOrientacao.getSelectedItem());
        this.fichaCadastroIndividualModel.setFlagInformarIdentidadeGenero(this.getPosicaoSelecionadoRG(rgInformarIdentidadeGenero));
        this.fichaCadastroIndividualModel.setIdentidadeGenero((TipoModel) this.spGenero.getSelectedItem());
        this.fichaCadastroIndividualModel.setFlagDeficiencia(this.getPosicaoSelecionadoRG(rgDeficiencia));
        this.fichaCadastroIndividualModel.setFlagDeficienciaAuditiva(cbDeficienciaAuditiva.isChecked());
        this.fichaCadastroIndividualModel.setFlagDeficienciaFisica(cbDeficienciaFisica.isChecked());
        this.fichaCadastroIndividualModel.setFlagDeficienciaIntelectual(cbDeficienciaIntelectual.isChecked());
        this.fichaCadastroIndividualModel.setFlagDeficienciaVisual(cbDeficienciaVisual.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutraDeficiencia(cbOutraDeficiencia.isChecked());
        this.fichaCadastroIndividualModel.setSaidaCadastro(this.getPosicaoSelecionadoRG(rgSaidaCadastro).equals(-1) ? -1 : this.getPosicaoSelecionadoRG(rgSaidaCadastro).equals(0) ? 135 : 136);
        this.fichaCadastroIndividualModel.setNumeroDO(etNumeroDO.getText().toString());
        this.fichaCadastroIndividualModel.setDataObito(Utilitario.getDate(etDataObito.getText().toString()));
        this.fichaCadastroIndividualModel.setFlagGestante(this.getPosicaoSelecionadoRG(rgGestante));
        this.fichaCadastroIndividualModel.setQualMaternidade(etQualMaternidade.getText().toString());
        this.fichaCadastroIndividualModel.setPeso(this.getPosicaoSelecionadoRG(rgPeso).equals(-1) ? -1 : this.getPosicaoSelecionadoRG(rgPeso).equals(0) ? 21 : this.getPosicaoSelecionadoRG(rgPeso).equals(1) ? 22 : 23);
        this.fichaCadastroIndividualModel.setFlagFumante(this.getPosicaoSelecionadoRG(rgFumante));
        this.fichaCadastroIndividualModel.setFlagAlcool(this.getPosicaoSelecionadoRG(rgAlcool));
        this.fichaCadastroIndividualModel.setFlagOutrasDrogas(this.getPosicaoSelecionadoRG(rgOutrasDrogas));
        this.fichaCadastroIndividualModel.setFlagHipertensao(this.getPosicaoSelecionadoRG(rgHipertensao));
        this.fichaCadastroIndividualModel.setFlagDiabetes(this.getPosicaoSelecionadoRG(rgDiabetes));
        this.fichaCadastroIndividualModel.setFlagAvcDerrame(this.getPosicaoSelecionadoRG(rgAvcDerrame));
        this.fichaCadastroIndividualModel.setFlagInfarto(this.getPosicaoSelecionadoRG(rgInfarto));
        this.fichaCadastroIndividualModel.setFlagDoencaCardiaca(this.getPosicaoSelecionadoRG(rgDoencaCardiaca));
        this.fichaCadastroIndividualModel.setFlagInsuficienciaCardiaca(cbInsuficienciaCardiaca.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutraDoencaCardiaca(cbOutraDoencaCardiaca.isChecked());
        this.fichaCadastroIndividualModel.setFlagNaoSabeDoencaCardiaca(cbNaoSabeDoencaCardiaca.isChecked());
        this.fichaCadastroIndividualModel.setFlagProblemaRins(this.getPosicaoSelecionadoRG(rgProblemaRins));
        this.fichaCadastroIndividualModel.setFlagInsuficienciaRenal(cbInsuficienciaRenal.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutroProblemaRins(cbOutroProblemaRins.isChecked());
        this.fichaCadastroIndividualModel.setFlagNaoSabeProblemaRins(cbNaoSabeProblemaRins.isChecked());
        this.fichaCadastroIndividualModel.setFlagDoencaRespiratoria(this.getPosicaoSelecionadoRG(rgDoencaRespiratoria));
        this.fichaCadastroIndividualModel.setFlagAsma(cbAsma.isChecked());
        this.fichaCadastroIndividualModel.setFlagEnfisema(cbEnfisema.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutraDoencaRespiratoria(cbOutraDoencaRespiratoria.isChecked());
        this.fichaCadastroIndividualModel.setFlagNaoSabeDoencaRespiratoria(cbNaoSabeDoencaRespiratoria.isChecked());
        this.fichaCadastroIndividualModel.setFlagHanseniase(this.getPosicaoSelecionadoRG(rgHanseniase));
        this.fichaCadastroIndividualModel.setFlagTuberculose(this.getPosicaoSelecionadoRG(rgTuberculose));
        this.fichaCadastroIndividualModel.setFlagCancer(this.getPosicaoSelecionadoRG(rgCancer));
        this.fichaCadastroIndividualModel.setFlagInternado(this.getPosicaoSelecionadoRG(rgInternado));
        this.fichaCadastroIndividualModel.setQualMotivoInternamento(etQualMotivoInternamento.getText().toString());
        this.fichaCadastroIndividualModel.setFlagProblemaMental(this.getPosicaoSelecionadoRG(rgProblemaMental));
        this.fichaCadastroIndividualModel.setFlagAcamado(this.getPosicaoSelecionadoRG(rgAcamado));
        this.fichaCadastroIndividualModel.setFlagDomiciliado(this.getPosicaoSelecionadoRG(rgDomiciliado));
        this.fichaCadastroIndividualModel.setFlagPlantasMedicinais(this.getPosicaoSelecionadoRG(rgPlantasMedicinais));
        this.fichaCadastroIndividualModel.setQuaisPlantas(etQuaisPlantas.getText().toString());
        this.fichaCadastroIndividualModel.setFlagOutrasPraticasIntegrativas(this.getPosicaoSelecionadoRG(rgOutrasPraticasIntegrativas));
        this.fichaCadastroIndividualModel.setOutrasCondicoesSaude(etOutrasCondicoesSaude.getText().toString());
        this.fichaCadastroIndividualModel.setFlagSituacaoRua(this.getPosicaoSelecionadoRG(rgSituacaoRua));
        this.fichaCadastroIndividualModel.setTempoSituacaoRua(this.getPosicaoSelecionadoRG(rgTempoSituacaoRua).equals(-1) ? -1 : this.getPosicaoSelecionadoRG(rgTempoSituacaoRua).equals(0) ? 17 : this.getPosicaoSelecionadoRG(rgTempoSituacaoRua).equals(1) ? 18 : this.getPosicaoSelecionadoRG(rgTempoSituacaoRua).equals(2) ? 19 : 20);
        this.fichaCadastroIndividualModel.setFlagRecebeBeneficio(this.getPosicaoSelecionadoRG(rgRecebeBeneficio));
        this.fichaCadastroIndividualModel.setFlagReferenciaFamiliar(this.getPosicaoSelecionadoRG(rgReferenciaFamiliar));
        this.fichaCadastroIndividualModel.setFrequenciaAlimentacao(this.getPosicaoSelecionadoRG(rgFrequenciaAlimentacao).equals(-1) ? -1 : this.getPosicaoSelecionadoRG(rgFrequenciaAlimentacao).equals(0) ? 34 : this.getPosicaoSelecionadoRG(rgFrequenciaAlimentacao).equals(1) ? 35 : 36);
        this.fichaCadastroIndividualModel.setFlagAlimentacaoRestaurantePopular(cbAlimentacaoRestaurantePopular.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoDoacaoPopular(cbAlimentacaoDoacaoPopular.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoDoacaoGrupoReligioso(cbAlimentacaoDoacaoGrupoReligioso.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoOutras(cbAlimentacaoOutras.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoDoacaoRestaurante(cbAlimentacaoDoacaoRestaurante.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcompanhadoInstituicao(this.getPosicaoSelecionadoRG(rgAcompanhadoInstituicao));
        this.fichaCadastroIndividualModel.setQualInstituicao(etQualInstituicao.getText().toString());
        this.fichaCadastroIndividualModel.setGrauParentesco(etGrauParentesco.getText().toString());
        this.fichaCadastroIndividualModel.setFlagVisitaFamiliar(this.getPosicaoSelecionadoRG(rgVisitaFamiliar));
        this.fichaCadastroIndividualModel.setFlagAcessoHigienePessoal(this.getPosicaoSelecionadoRG(rgAcessoHigienePessoal));
        this.fichaCadastroIndividualModel.setFlagAcessoBanho(cbAcessoBanho.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcessoSanitario(cbAcessoSanitario.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcessoHigieneBucal(cbAcessoHigieneBucal.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcessoOutras(cbAcessoOutras.isChecked());

    }

}
