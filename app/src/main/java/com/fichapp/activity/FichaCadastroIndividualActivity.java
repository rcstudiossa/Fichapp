package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.fichapp.business.FichaCadastroIndividualBS;
import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaCadastroIndividualModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class FichaCadastroIndividualActivity extends TemplateActivity {

    private FichaCadastroIndividualModel fichaCadastroIndividualModel;
    private FichaCadastroIndividualBS fichaCadastroIndividualBS;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Toolbar toolbar;

    private Spinner spRaca;
    private Spinner spParentesco;
    private Spinner spCurso;
    private Spinner spTrabalho;
    private Spinner spOrientacao;
    private Spinner spGenero;

    private EditText etDataRegistro;
    private RadioGroup rgTurno;

    private EditText etCnsCidadao;
    private RadioGroup rgResponsavelFamiliar;
    private EditText etCnsResponsavelFamiliar;
    private EditText etMicroarea;
    private CheckBox cbForaDeArea;
    private EditText etNomeCompleto;
    private EditText etNomeSocial;
    private EditText etDataNascimento;
    private RadioGroup rgSexo;
    private EditText etEtnia;
    private EditText etNis;

    private EditText etNomeMae;
    private CheckBox cbMaeDesconhecido;
    private EditText etNomePai;
    private CheckBox cbPaiDesconhecido;

    private RadioGroup rgNacionalidade;
    private EditText etPaisNascimento;
    private EditText etMunicipioUfNascimento;
    private LinearLayout llNaturalizacao;
    private EditText etPortariaNaturalizacao;
    private EditText etDataNaturalizacao;
    private EditText etDataEntrada;

    private EditText etTelefoneCelular;
    private EditText etEmailCidadao;

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

    private LinearLayout llRodape;

    private Boolean flagAtivo;
    private Boolean flagExportado;


    private Integer itemRgAcamado;
    private Integer itemRgAcessoHigienePessoal;
    private Integer itemRgAcompanhadoInstituicao;
    private Integer itemRgAlcool;
    private Integer itemRgAvcDerrame;
    private Integer itemRgCancer;
    private Integer itemRgDeficiencia;
    private Integer itemRgDiabetes;
    private Integer itemRgDoencaCardiaca;
    private Integer itemRgDoencaRespiratoria;
    private Integer itemRgDomiciliado;
    private Integer itemRgFrequenciaAlimentacao;
    private Integer itemRgFrequentaCuidador;
    private Integer itemRgFrequentaEscola;
    private Integer itemRgFumante;
    private Integer itemRgGestante;
    private Integer itemRgHanseniase;
    private Integer itemRgHipertensao;
    private Integer itemRgInfarto;
    private Integer itemRgInformarIdentidadeGenero;
    private Integer itemRgInformarOrientacao;
    private Integer itemRgInternado;
    private Integer itemRgMembroDeComunidade;
    private Integer itemRgNacionalidade;
    private Integer itemRgOutrasDrogas;
    private Integer itemRgOutrasPraticasIntegrativas;
    private Integer itemRgParticipaGrupoComunitario;
    private Integer itemRgPeso;
    private Integer itemRgPlantasMedicinais;
    private Integer itemRgPossuiPlanoDeSaude;
    private Integer itemRgProblemaMental;
    private Integer itemRgProblemaRins;
    private Integer itemRgRecebeBeneficio;
    private Integer itemRgReferenciaFamiliar;
    private Integer itemRgResponsavelFamiliar;
    private Integer itemRgSaidaCadastro;
    private Integer itemRgSexo;
    private Integer itemRgSituacaoRua;
    private Integer itemRgTempoSituacaoRua;
    private Integer itemRgTuberculose;
    private Integer itemRgTurno;
    private Integer itemRgVisitaFamiliar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_ficha_cadastro_individual);
        super.onCreate(savedInstanceState);


        this.definirComponentes();

        this.configToolbar();

        this.instanciarFichaVisitaDTModel();

        this.carregarSpinners();

        this.desabilitaCampos();

        this.configDatas();

        this.lerRadios();

        this.fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }


    private void definirComponentes() {

        //EditTexts
        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        etCnsCidadao = (EditText) findViewById(R.id.et_cns);
        etCnsResponsavelFamiliar = (EditText) findViewById(R.id.et_cns_responsavel_familiar);
        etMicroarea = (EditText) findViewById(R.id.et_microarea);
        etNomeCompleto = (EditText) findViewById(R.id.et_nome);
        etNomeSocial = (EditText) findViewById(R.id.et_nome_social);
        etDataNascimento = (EditText) findViewById(R.id.et_data_nascimento);
        etEtnia = (EditText) findViewById(R.id.et_etnia);
        etNis = (EditText) findViewById(R.id.et_nis);
        etNomeMae = (EditText) findViewById(R.id.et_nome_mae);
        etNomePai = (EditText) findViewById(R.id.et_nome_pai);
        etPaisNascimento = (EditText) findViewById(R.id.et_pais_nascimento);
        etMunicipioUfNascimento = (EditText) findViewById(R.id.et_municipio_uf_nascimento);
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
        spRaca = (Spinner) findViewById(R.id.spinner_raca);
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
        rgTurno = (RadioGroup) findViewById(R.id.rg_turno);
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

        //LinearLayouts
        llTemDeficiencia = (LinearLayout) findViewById(R.id.ll_tem_deficiencia);
        llNaturalizacao = (LinearLayout) findViewById(R.id.ll_naturalizacao);
        llDoencaCardiaca = (LinearLayout) findViewById(R.id.ll_doenca_cardiaca);
        llProblemaRins = (LinearLayout) findViewById(R.id.ll_problema_rins);
        llDoencaRespiratoria = (LinearLayout) findViewById(R.id.ll_doenca_respiratoria);
        llHigienePessoal = (LinearLayout) findViewById(R.id.ll_higiene_pessoal);

        fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);

        llRodape = (LinearLayout) findViewById(R.id.include_rodape_cadastro_dt);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        this.fichaCadastroIndividualBS = new FichaCadastroIndividualBS(getApplication());

        this.profissionalModel = new ProfissionalModel();
        this.cnesModel = new CNESModel();

    }

    private void lerRadios() {

        itemRgAcamado = rgAcamado.indexOfChild(findViewById(rgAcamado.getCheckedRadioButtonId()));
        itemRgAcessoHigienePessoal = rgAcessoHigienePessoal.indexOfChild(findViewById(rgAcessoHigienePessoal.getCheckedRadioButtonId()));
        itemRgAcompanhadoInstituicao = rgAcompanhadoInstituicao.indexOfChild(findViewById(rgAcompanhadoInstituicao.getCheckedRadioButtonId()));
        itemRgAlcool = rgAlcool.indexOfChild(findViewById(rgAlcool.getCheckedRadioButtonId()));
        itemRgAvcDerrame = rgAvcDerrame.indexOfChild(findViewById(rgAvcDerrame.getCheckedRadioButtonId()));
        itemRgCancer = rgCancer.indexOfChild(findViewById(rgCancer.getCheckedRadioButtonId()));
        itemRgDeficiencia = rgDeficiencia.indexOfChild(findViewById(rgDeficiencia.getCheckedRadioButtonId()));
        itemRgDiabetes = rgDiabetes.indexOfChild(findViewById(rgDiabetes.getCheckedRadioButtonId()));
        itemRgDoencaCardiaca = rgDoencaCardiaca.indexOfChild(findViewById(rgDoencaCardiaca.getCheckedRadioButtonId()));
        itemRgDoencaRespiratoria = rgDoencaRespiratoria.indexOfChild(findViewById(rgDoencaRespiratoria.getCheckedRadioButtonId()));
        itemRgDomiciliado = rgDomiciliado.indexOfChild(findViewById(rgDomiciliado.getCheckedRadioButtonId()));
        itemRgFrequenciaAlimentacao = rgFrequenciaAlimentacao.indexOfChild(findViewById(rgFrequenciaAlimentacao.getCheckedRadioButtonId()));
        itemRgFrequentaCuidador = rgFrequentaCuidador.indexOfChild(findViewById(rgFrequentaCuidador.getCheckedRadioButtonId()));
        itemRgFrequentaEscola = rgFrequentaEscola.indexOfChild(findViewById(rgFrequentaEscola.getCheckedRadioButtonId()));
        itemRgFumante = rgFumante.indexOfChild(findViewById(rgFumante.getCheckedRadioButtonId()));
        itemRgGestante = rgGestante.indexOfChild(findViewById(rgGestante.getCheckedRadioButtonId()));
        itemRgHanseniase = rgHanseniase.indexOfChild(findViewById(rgHanseniase.getCheckedRadioButtonId()));
        itemRgHipertensao = rgHipertensao.indexOfChild(findViewById(rgHipertensao.getCheckedRadioButtonId()));
        itemRgInfarto = rgInfarto.indexOfChild(findViewById(rgInfarto.getCheckedRadioButtonId()));
        itemRgInformarIdentidadeGenero = rgInformarIdentidadeGenero.indexOfChild(findViewById(rgInformarIdentidadeGenero.getCheckedRadioButtonId()));
        itemRgInformarOrientacao = rgInformarOrientacao.indexOfChild(findViewById(rgInformarOrientacao.getCheckedRadioButtonId()));
        itemRgInternado = rgInternado.indexOfChild(findViewById(rgInternado.getCheckedRadioButtonId()));
        itemRgMembroDeComunidade = rgMembroDeComunidade.indexOfChild(findViewById(rgMembroDeComunidade.getCheckedRadioButtonId()));
        itemRgNacionalidade = rgNacionalidade.indexOfChild(findViewById(rgNacionalidade.getCheckedRadioButtonId()));
        itemRgOutrasDrogas = rgOutrasDrogas.indexOfChild(findViewById(rgOutrasDrogas.getCheckedRadioButtonId()));
        itemRgOutrasPraticasIntegrativas = rgOutrasPraticasIntegrativas.indexOfChild(findViewById(rgOutrasPraticasIntegrativas.getCheckedRadioButtonId()));
        itemRgParticipaGrupoComunitario = rgParticipaGrupoComunitario.indexOfChild(findViewById(rgParticipaGrupoComunitario.getCheckedRadioButtonId()));
        itemRgPeso = rgPeso.indexOfChild(findViewById(rgPeso.getCheckedRadioButtonId()));
        itemRgPlantasMedicinais = rgPlantasMedicinais.indexOfChild(findViewById(rgPlantasMedicinais.getCheckedRadioButtonId()));
        itemRgPossuiPlanoDeSaude = rgPossuiPlanoDeSaude.indexOfChild(findViewById(rgPossuiPlanoDeSaude.getCheckedRadioButtonId()));
        itemRgProblemaMental = rgProblemaMental.indexOfChild(findViewById(rgProblemaMental.getCheckedRadioButtonId()));
        itemRgProblemaRins = rgProblemaRins.indexOfChild(findViewById(rgProblemaRins.getCheckedRadioButtonId()));
        itemRgRecebeBeneficio = rgRecebeBeneficio.indexOfChild(findViewById(rgRecebeBeneficio.getCheckedRadioButtonId()));
        itemRgReferenciaFamiliar = rgReferenciaFamiliar.indexOfChild(findViewById(rgReferenciaFamiliar.getCheckedRadioButtonId()));
        itemRgResponsavelFamiliar = rgResponsavelFamiliar.indexOfChild(findViewById(rgResponsavelFamiliar.getCheckedRadioButtonId()));
        itemRgSaidaCadastro = rgSaidaCadastro.indexOfChild(findViewById(rgSaidaCadastro.getCheckedRadioButtonId()));
        itemRgSexo = rgSexo.indexOfChild(findViewById(rgSexo.getCheckedRadioButtonId()));
        itemRgSituacaoRua = rgSituacaoRua.indexOfChild(findViewById(rgSituacaoRua.getCheckedRadioButtonId()));
        itemRgTempoSituacaoRua = rgTempoSituacaoRua.indexOfChild(findViewById(rgTempoSituacaoRua.getCheckedRadioButtonId()));
        itemRgTuberculose = rgTuberculose.indexOfChild(findViewById(rgTuberculose.getCheckedRadioButtonId()));
        itemRgTurno = rgTurno.indexOfChild(findViewById(rgTurno.getCheckedRadioButtonId()));
        itemRgVisitaFamiliar = rgVisitaFamiliar.indexOfChild(findViewById(rgVisitaFamiliar.getCheckedRadioButtonId()));

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

    private void carregarSpinners() {

        ArrayAdapter spAdapterRaca = ArrayAdapter.createFromResource(this, R.array.raca, R.layout.spinner_item);
        spAdapterRaca.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spRaca.setAdapter(spAdapterRaca);

        ArrayAdapter spAdapterParentesco = ArrayAdapter.createFromResource(this, R.array.parentesco, R.layout.spinner_item);
        spAdapterParentesco.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spParentesco.setAdapter(spAdapterParentesco);

        ArrayAdapter spAdapterCurso = ArrayAdapter.createFromResource(this, R.array.curso, R.layout.spinner_item);
        spAdapterCurso.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spCurso.setAdapter(spAdapterCurso);

        ArrayAdapter spAdapterTrabalho = ArrayAdapter.createFromResource(this, R.array.trabalho, R.layout.spinner_item);
        spAdapterTrabalho.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spTrabalho.setAdapter(spAdapterTrabalho);

        ArrayAdapter spAdapterOrientacao = ArrayAdapter.createFromResource(this, R.array.orientacao, R.layout.spinner_item);
        spAdapterOrientacao.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spOrientacao.setAdapter(spAdapterOrientacao);

        ArrayAdapter spAdapterGenero = ArrayAdapter.createFromResource(this, R.array.genero, R.layout.spinner_item);
        spAdapterGenero.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spGenero.setAdapter(spAdapterGenero);

    }

    private void configDatas() {

        final Calendar registroCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            registroCalendar.setTime(Utilitario.getDate(etDataRegistro.getText().toString())) ;
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

                new DatePickerDialog(FichaCadastroIndividualActivity.this, dataRegistro,
                        registroCalendar.get(Calendar.YEAR),
                        registroCalendar.get(Calendar.MONTH),
                        registroCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        
        //-------------------------------------------------------------\\

        final Calendar nascimentoCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataNascimento.getText().toString())) {
            nascimentoCalendar.setTime(Utilitario.getDate(etDataNascimento.getText().toString())) ;
        }

        final DatePickerDialog.OnDateSetListener dataNascimento = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                nascimentoCalendar.set(Calendar.YEAR, year);
                nascimentoCalendar.set(Calendar.MONTH, monthOfYear);
                nascimentoCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etDataNascimento, nascimentoCalendar);
            }
        };

        etDataNascimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(FichaCadastroIndividualActivity.this, dataNascimento,
                        nascimentoCalendar.get(Calendar.YEAR),
                        nascimentoCalendar.get(Calendar.MONTH),
                        nascimentoCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //-------------------------------------------------------------\\

        final Calendar naturalizacaoCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataNaturalizacao.getText().toString())) {
            naturalizacaoCalendar.setTime(Utilitario.getDate(etDataNaturalizacao.getText().toString())) ;
        }

        final DatePickerDialog.OnDateSetListener dataNaturalizacao = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                naturalizacaoCalendar.set(Calendar.YEAR, year);
                naturalizacaoCalendar.set(Calendar.MONTH, monthOfYear);
                naturalizacaoCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etDataNaturalizacao, naturalizacaoCalendar);
            }
        };

        etDataNaturalizacao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(FichaCadastroIndividualActivity.this, dataNaturalizacao,
                        naturalizacaoCalendar.get(Calendar.YEAR),
                        naturalizacaoCalendar.get(Calendar.MONTH),
                        naturalizacaoCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //-------------------------------------------------------------\\

        final Calendar entradaCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataEntrada.getText().toString())) {
            entradaCalendar.setTime(Utilitario.getDate(etDataEntrada.getText().toString())) ;
        }

        final DatePickerDialog.OnDateSetListener dataEntrada = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                entradaCalendar.set(Calendar.YEAR, year);
                entradaCalendar.set(Calendar.MONTH, monthOfYear);
                entradaCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etDataEntrada, entradaCalendar);
            }
        };

        etDataEntrada.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(FichaCadastroIndividualActivity.this, dataEntrada,
                        entradaCalendar.get(Calendar.YEAR),
                        entradaCalendar.get(Calendar.MONTH),
                        entradaCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //-------------------------------------------------------------\\

        final Calendar obitoCalendar = Calendar.getInstance();
        if (!Utilitario.isEmpty(etDataObito.getText().toString())) {
            obitoCalendar.setTime(Utilitario.getDate(etDataObito.getText().toString())) ;
        }

        final DatePickerDialog.OnDateSetListener dataObito = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                obitoCalendar.set(Calendar.YEAR, year);
                obitoCalendar.set(Calendar.MONTH, monthOfYear);
                obitoCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etDataObito, obitoCalendar);
            }
        };

        etDataObito.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(FichaCadastroIndividualActivity.this, dataObito,
                        obitoCalendar.get(Calendar.YEAR),
                        obitoCalendar.get(Calendar.MONTH),
                        obitoCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel(EditText editText, Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        editText.setText(sdf.format(calendar.getTime()));
    }

    private void instanciarFichaVisitaDTModel() {

        this.fichaCadastroIndividualModel = (FichaCadastroIndividualModel) getIntent().getSerializableExtra("fichaCadastroIndividual");

        if (this.fichaCadastroIndividualModel == null) {
            this.fichaCadastroIndividualModel = new FichaCadastroIndividualModel();
        } else {
            this.setModelToActivity();
        }

    }

    private void gravar() {

        //if (!validaCampos()) { return; }

        setActivityToModel();

        this.fichaCadastroIndividualBS.gravar(this.fichaCadastroIndividualModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaCadastroIndividualFragment");
        startActivity(intent);

        finish();

    }

    private boolean validaCampos() {

        boolean valido = true;

        if (!Utilitario.isEmpty(etCnsCidadao.getText().toString())) {

            if (!Utilitario.isCNSValido(etCnsCidadao.getText().toString())) {
                Snackbar.make(fabGravar, "CNS do cidadão inválido.", Snackbar.LENGTH_LONG).show();
                valido = false;
            }

        } else {
            Snackbar.make(fabGravar, "Preencha a CNS do cidadão.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            Snackbar.make(fabGravar, "Preencha a data de registro.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        return valido;

    }

    private void desabilitaCampos() {

        this.desabilitaEditText(rgResponsavelFamiliar, 1, etCnsResponsavelFamiliar);
        this.desabilitaEditText(rgNacionalidade, 0, etPaisNascimento);
        this.desabilitaEditText(rgMembroDeComunidade, 1, etQualComunidade);
        this.desabilitaEditText(rgGestante, 1, etQualMaternidade);
        this.desabilitaEditText(rgInternado, 1, etQualMotivoInternamento);
        this.desabilitaEditText(rgPlantasMedicinais, 1, etQuaisPlantas);
        this.desabilitaEditText(rgAcompanhadoInstituicao, 1, etQualInstituicao);
        this.desabilitaEditText(rgVisitaFamiliar, 1, etGrauParentesco);

        this.desabilitaEditText(cbForaDeArea, etMicroarea);
        this.desabilitaEditText(cbMaeDesconhecido, etNomeMae);
        this.desabilitaEditText(cbPaiDesconhecido, etNomePai);

        this.desabilitaLinearLayout(rgDoencaCardiaca, 1, llDoencaCardiaca);
        this.desabilitaLinearLayout(rgProblemaRins, 1, llProblemaRins);
        this.desabilitaLinearLayout(rgDoencaRespiratoria, 1, llDoencaRespiratoria);
        this.desabilitaLinearLayout(rgAcessoHigienePessoal, 1, llHigienePessoal);

        this.desabilitaSpinner(rgInformarOrientacao, 1, spOrientacao);
        this.desabilitaSpinner(rgInformarIdentidadeGenero, 1, spGenero);

        this.desabilitaRadioGroup(rgSituacaoRua, 1, rgTempoSituacaoRua);

    }


    private void setModelToActivity() {

        //EditTexts
        etDataRegistro.setText(this.fichaCadastroIndividualModel.getDataRegistro().toString());
        etCnsCidadao.setText(this.fichaCadastroIndividualModel.getCnsCidadao());
        etCnsResponsavelFamiliar.setText(this.fichaCadastroIndividualModel.getCnsResponsavelFamiliar());
        etMicroarea.setText(this.fichaCadastroIndividualModel.getMicroarea());
        etNomeCompleto.setText(this.fichaCadastroIndividualModel.getNomeCompleto());
        etNomeSocial.setText(this.fichaCadastroIndividualModel.getNomeSocial());
        etDataNascimento.setText(this.fichaCadastroIndividualModel.getDataNascimento().toString());
        etEtnia.setText(this.fichaCadastroIndividualModel.getEtnia());
        etNis.setText(this.fichaCadastroIndividualModel.getNis());
        etNomeMae.setText(this.fichaCadastroIndividualModel.getNomeMae());
        etNomePai.setText(this.fichaCadastroIndividualModel.getNomePai());
        etPaisNascimento.setText(this.fichaCadastroIndividualModel.getPaisNascimento());
        etMunicipioUfNascimento.setText(this.fichaCadastroIndividualModel.getMunicipioUfNascimento());
        etPortariaNaturalizacao.setText(this.fichaCadastroIndividualModel.getPortariaNaturalizacao());
        etDataNaturalizacao.setText(this.fichaCadastroIndividualModel.getDataNaturalizacao().toString());
        etDataEntrada.setText(this.fichaCadastroIndividualModel.getDataEntrada().toString());
        etTelefoneCelular.setText(this.fichaCadastroIndividualModel.getTelefoneCelular());
        etEmailCidadao.setText(this.fichaCadastroIndividualModel.getEmailCidadao());
        etGrauParentesco.setText(this.fichaCadastroIndividualModel.getGrauParentesco());
        etOcupacao.setText(this.fichaCadastroIndividualModel.getOcupacao());
        etQualComunidade.setText(this.fichaCadastroIndividualModel.getQualComunidade());
        etNumeroDO.setText(this.fichaCadastroIndividualModel.getNumeroDO());
        etDataObito.setText(this.fichaCadastroIndividualModel.getDataObito().toString());
        etQualMotivoInternamento.setText(this.fichaCadastroIndividualModel.getQualMotivoInternamento());
        etQuaisPlantas.setText(this.fichaCadastroIndividualModel.getQuaisPlantas());
        etOutrasCondicoesSaude.setText(this.fichaCadastroIndividualModel.getOutrasCondicoesSaude());
        etQualInstituicao.setText(this.fichaCadastroIndividualModel.getQualInstituicao());

        //TODO: RADIOS E SPINNERS

        //Checkboxes
        cbAcessoBanho.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoBanho());
        cbAcessoHigieneBucal.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoHigieneBucal());
        cbAcessoOutras.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoOutras());
        cbAcessoSanitario.setChecked(this.fichaCadastroIndividualModel.getFlagAcessoSanitario());
        cbAlimentacaoDoacaoGrupoReligioso.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoDoacaoGrupoReligioso());
        cbAlimentacaoDoacaoPopular.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoDoacaoPopular());
        cbAlimentacaoDoacaoRestaurante.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoDoacaoRestaurante());
        cbAlimentacaoOutras.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoOutras());
        cbAlimentacaoRestaurantePopular.setChecked(this.fichaCadastroIndividualModel.getFlagAlimentacaoRestaurantePopular());
        cbAsma.setChecked(this.fichaCadastroIndividualModel.getFlagAsma());
        cbDeficienciaAuditiva.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaAuditiva());
        cbDeficienciaFisica.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaFisica());
        cbDeficienciaIntelectual.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaIntelectual());
        cbDeficienciaVisual.setChecked(this.fichaCadastroIndividualModel.getFlagDeficienciaVisual());
        cbEnfisema.setChecked(this.fichaCadastroIndividualModel.getFlagEnfisema());
        cbFicaComAdolescente.setChecked(this.fichaCadastroIndividualModel.getFlagFicaComAdolescente());
        cbFicaComAdultoResponsavel.setChecked(this.fichaCadastroIndividualModel.getFlagFicaComAdultoResponsavel());
        cbFicaComOutrasCriancas.setChecked(this.fichaCadastroIndividualModel.getFlagFicaComOutrasCriancas());
        cbFicaEmCreche.setChecked(this.fichaCadastroIndividualModel.getFlagFicaEmCreche());
        cbFicaOutro.setChecked(this.fichaCadastroIndividualModel.getFlagFicaOutro());
        cbFicaSozinha.setChecked(this.fichaCadastroIndividualModel.getFlagFicaSozinha());
        cbForaDeArea.setChecked(this.fichaCadastroIndividualModel.getFlagForaDeArea());
        cbInsuficienciaCardiaca.setChecked(this.fichaCadastroIndividualModel.getFlagInsuficienciaCardiaca());
        cbInsuficienciaRenal.setChecked(this.fichaCadastroIndividualModel.getFlagInsuficienciaRenal());
        cbMaeDesconhecido.setChecked(this.fichaCadastroIndividualModel.getFlagMaeDesconhecido());
        cbNaoSabeDoencaCardiaca.setChecked(this.fichaCadastroIndividualModel.getFlagNaoSabeDoencaCardiaca());
        cbNaoSabeDoencaRespiratoria.setChecked(this.fichaCadastroIndividualModel.getFlagNaoSabeDoencaRespiratoria());
        cbNaoSabeProblemaRins.setChecked(this.fichaCadastroIndividualModel.getFlagNaoSabeProblemaRins());
        cbOutraDeficiencia.setChecked(this.fichaCadastroIndividualModel.getFlagOutraDeficiencia());
        cbOutraDoencaCardiaca.setChecked(this.fichaCadastroIndividualModel.getFlagOutraDoencaCardiaca());
        cbOutraDoencaRespiratoria.setChecked(this.fichaCadastroIndividualModel.getFlagOutraDoencaRespiratoria());
        cbOutroProblemaRins.setChecked(this.fichaCadastroIndividualModel.getFlagOutroProblemaRins());
        cbPaiDesconhecido.setChecked(this.fichaCadastroIndividualModel.getFlagPaiDesconhecido());


    }

    private void setActivityToModel() {

        setDatesToModel();

        //EditTexts
        this.fichaCadastroIndividualModel.setCnsCidadao(etCnsCidadao.getText().toString());
        this.fichaCadastroIndividualModel.setCnsResponsavelFamiliar(etCnsResponsavelFamiliar.getText().toString());
        this.fichaCadastroIndividualModel.setMicroarea(etMicroarea.getText().toString());
        this.fichaCadastroIndividualModel.setNomeCompleto(etNomeCompleto.getText().toString());
        this.fichaCadastroIndividualModel.setNomeSocial(etNomeSocial.getText().toString());
        this.fichaCadastroIndividualModel.setEtnia(etEtnia.getText().toString());
        this.fichaCadastroIndividualModel.setNis(etNis.getText().toString());
        this.fichaCadastroIndividualModel.setNomeMae(etNomeMae.getText().toString());
        this.fichaCadastroIndividualModel.setNomePai(etNomePai.getText().toString());
        this.fichaCadastroIndividualModel.setPaisNascimento(etPaisNascimento.getText().toString());
        this.fichaCadastroIndividualModel.setMunicipioUfNascimento(etMunicipioUfNascimento.getText().toString());
        this.fichaCadastroIndividualModel.setPortariaNaturalizacao(etPortariaNaturalizacao.getText().toString());
        this.fichaCadastroIndividualModel.setTelefoneCelular(etTelefoneCelular.getText().toString());
        this.fichaCadastroIndividualModel.setEmailCidadao(etEmailCidadao.getText().toString());
        this.fichaCadastroIndividualModel.setGrauParentesco(etGrauParentesco.getText().toString());
        this.fichaCadastroIndividualModel.setOcupacao(etOcupacao.getText().toString());
        this.fichaCadastroIndividualModel.setQualComunidade(etQualComunidade.getText().toString());
        this.fichaCadastroIndividualModel.setNumeroDO(etNumeroDO.getText().toString());
        this.fichaCadastroIndividualModel.setQualMaternidade(etQualMaternidade.getText().toString());
        this.fichaCadastroIndividualModel.setQualMotivoInternamento(etQualMotivoInternamento.getText().toString());
        this.fichaCadastroIndividualModel.setQuaisPlantas(etQuaisPlantas.getText().toString());
        this.fichaCadastroIndividualModel.setOutrasCondicoesSaude(etOutrasCondicoesSaude.getText().toString());
        this.fichaCadastroIndividualModel.setQualInstituicao(etQualInstituicao.getText().toString());

        //TODO: RADIOS E SPINNERS

        //Checkboxes
        this.fichaCadastroIndividualModel.setFlagAcessoBanho(cbAcessoBanho.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcessoHigieneBucal(cbAcessoHigieneBucal.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcessoOutras(cbAcessoOutras.isChecked());
        this.fichaCadastroIndividualModel.setFlagAcessoSanitario(cbAcessoSanitario.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoDoacaoGrupoReligioso(cbAlimentacaoDoacaoGrupoReligioso.isChecked());

        this.fichaCadastroIndividualModel.setFlagAlimentacaoDoacaoPopular(cbAlimentacaoDoacaoPopular.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoDoacaoRestaurante(cbAlimentacaoDoacaoRestaurante.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoOutras(cbAlimentacaoOutras.isChecked());
        this.fichaCadastroIndividualModel.setFlagAlimentacaoRestaurantePopular(cbAlimentacaoRestaurantePopular.isChecked());
        this.fichaCadastroIndividualModel.setFlagAsma(cbAsma.isChecked());

        this.fichaCadastroIndividualModel.setFlagDeficienciaAuditiva(cbDeficienciaAuditiva.isChecked());
        this.fichaCadastroIndividualModel.setFlagDeficienciaFisica(cbDeficienciaFisica.isChecked());
        this.fichaCadastroIndividualModel.setFlagDeficienciaIntelectual(cbDeficienciaIntelectual.isChecked());
        this.fichaCadastroIndividualModel.setFlagDeficienciaVisual(cbDeficienciaVisual.isChecked());
        this.fichaCadastroIndividualModel.setFlagEnfisema(cbEnfisema.isChecked());

        this.fichaCadastroIndividualModel.setFlagFicaComAdolescente(cbFicaComAdolescente.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaComAdultoResponsavel(cbFicaComAdultoResponsavel.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaComOutrasCriancas(cbFicaComOutrasCriancas.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaEmCreche(cbFicaEmCreche.isChecked());
        this.fichaCadastroIndividualModel.setFlagFicaOutro(cbFicaOutro.isChecked());

        this.fichaCadastroIndividualModel.setFlagFicaSozinha(cbFicaSozinha.isChecked());
        this.fichaCadastroIndividualModel.setFlagForaDeArea(cbForaDeArea.isChecked());
        this.fichaCadastroIndividualModel.setFlagInsuficienciaCardiaca(cbInsuficienciaCardiaca.isChecked());
        this.fichaCadastroIndividualModel.setFlagInsuficienciaRenal(cbInsuficienciaRenal.isChecked());
        this.fichaCadastroIndividualModel.setFlagMaeDesconhecido(cbMaeDesconhecido.isChecked());

        this.fichaCadastroIndividualModel.setFlagNaoSabeDoencaCardiaca(cbNaoSabeDoencaCardiaca.isChecked());
        this.fichaCadastroIndividualModel.setFlagNaoSabeDoencaRespiratoria(cbNaoSabeDoencaRespiratoria.isChecked());
        this.fichaCadastroIndividualModel.setFlagNaoSabeProblemaRins(cbNaoSabeProblemaRins.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutraDeficiencia(cbOutraDeficiencia.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutraDoencaCardiaca(cbOutraDoencaCardiaca.isChecked());

        this.fichaCadastroIndividualModel.setFlagOutraDoencaRespiratoria(cbOutraDoencaRespiratoria.isChecked());
        this.fichaCadastroIndividualModel.setFlagOutroProblemaRins(cbOutroProblemaRins.isChecked());
        this.fichaCadastroIndividualModel.setFlagPaiDesconhecido(cbPaiDesconhecido.isChecked());

    }

    private void setDatesToModel() {

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaCadastroIndividualModel.setDataRegistro(formato.parse(etDataRegistro.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de Registro cadastrada errada.", Toast.LENGTH_LONG).show();
        }

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaCadastroIndividualModel.setDataNaturalizacao(formato.parse(etDataNaturalizacao.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de Naturalização cadastrada errada.", Toast.LENGTH_LONG).show();
        }

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaCadastroIndividualModel.setDataNascimento(formato.parse(etDataNascimento.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de Nascimento cadastrada errada.", Toast.LENGTH_LONG).show();
        }

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaCadastroIndividualModel.setDataEntrada(formato.parse(etDataEntrada.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de Entrada cadastrada errada.", Toast.LENGTH_LONG).show();
        }

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaCadastroIndividualModel.setDataObito(formato.parse(etDataObito.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de Óbito cadastrada errada.", Toast.LENGTH_LONG).show();
        }

    }


}
