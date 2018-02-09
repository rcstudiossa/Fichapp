package com.fichapp.activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Mascara;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FichaVisitaDTActivity extends TemplateActivity {

    private FichaVisitaDTModel fichaVisitaDTModel;
    private FichaVisitaDTBS fichaVisitaDTBS;

    private List<ProfissionalModel> profissionais;
    private List<CNESModel> hospitais;

    private Toolbar toolbar;

    private RadioButton rbTurnoM;
    private RadioButton rbTurnoT;
    private RadioButton rbTurnoN;
    private EditText etMicroarea;
    private CheckBox cbForaDeArea;
    private Spinner spinnerTipoImovel;

    private EditText etProntuario;
    private EditText etCnsCidadao;
    private EditText etNascimento;
    private RadioButton rbSexoM;
    private RadioButton rbSexoF;
    private CheckBox cbVisitaCompartilhada;

    private LinearLayout llMotivosVisita;

    private CheckBox cbCadastramentoAtt;
    private CheckBox cbVisitaPeriodica;

    private CheckBox cbConsulta;
    private CheckBox cbExame;
    private CheckBox cbVacina;
    private CheckBox cbBolsaFamilia;

    private CheckBox cbGestante;
    private CheckBox cbPuerpera;
    private CheckBox cbRecemNascido;
    private CheckBox cbCrianca;
    private CheckBox cbDesnutricao;
    private CheckBox cbReabilitacao;
    private CheckBox cbHipertensao;
    private CheckBox cbDiabetes;
    private CheckBox cbAsma;
    private CheckBox cbEnfisema;
    private CheckBox cbCancer;
    private CheckBox cbOutrasDoencas;
    private CheckBox cbHanseniase;
    private CheckBox cbTuberculose;
    private CheckBox cbSintomaticosRespiratorios;
    private CheckBox cbTabagista;
    private CheckBox cbAcamados;
    private CheckBox cbVulnerabilidadeSocial;
    private CheckBox cbAcompanhamentoBolsaFamilia;
    private CheckBox cbSaudeMental;
    private CheckBox cbUsuarioAlcool;
    private CheckBox cbUsuarioOutrasDrogas;

    private CheckBox cbAcaoEducativa;
    private CheckBox cbImovelComFoco;
    private CheckBox cbAcaoMecanica;
    private CheckBox cbTratamentoFocal;

    private CheckBox cbEgressoInternacao;
    private CheckBox cbConvite;
    private CheckBox cbOrientacao;
    private CheckBox cbOutros;

    private EditText etPeso;
    private EditText etAltura;

    private RadioGroup rgDesfecho;
    private RadioButton rbVisitaRealizada;
    private RadioButton rbVisitaRecusada;
    private RadioButton rbAusente;

    private FloatingActionButton fabGravar;

    private LinearLayout rodape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_ficha_visita_dt);

        super.onCreate(savedInstanceState);

        this.definirComponentes();

        this.configToolbar();

        this.fichaVisitaDTBS = new FichaVisitaDTBS(getApplication());

        this.carregarSpinners();

        this.configListeners();

        //this.configDatas();

        this.configMascaras();

        this.instanciarFichaVisitaDTModel();

        this.configComponentes();

        this.fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gravar();
            }
        });

    }

    private void definirComponentes() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        rbTurnoM = (RadioButton) findViewById(R.id.rb_turno_m);
        rbTurnoT = (RadioButton) findViewById(R.id.rb_turno_t);
        rbTurnoN = (RadioButton) findViewById(R.id.rb_turno_n);
        etMicroarea = (EditText) findViewById(R.id.et_microarea);
        cbForaDeArea = (CheckBox) findViewById(R.id.cb_fora_de_area);
        spinnerTipoImovel = (Spinner) findViewById(R.id.spinner_tipo_imovel);
        etProntuario = (EditText) findViewById(R.id.et_prontuario);
        etCnsCidadao = (EditText) findViewById(R.id.et_cns);
        etNascimento = (EditText) findViewById(R.id.et_data_nascimento);
        rbSexoM = (RadioButton) findViewById(R.id.rb_sexo_m);
        rbSexoF = (RadioButton) findViewById(R.id.rb_sexo_f);
        cbVisitaCompartilhada = (CheckBox) findViewById(R.id.visita_outro_profissional);

        cbCadastramentoAtt = (CheckBox) findViewById(R.id.cb_cadastramento_atualizacao);
        cbVisitaPeriodica = (CheckBox) findViewById(R.id.cb_visita_periodica);

        cbConsulta = (CheckBox) findViewById(R.id.cb_consulta);
        cbExame = (CheckBox) findViewById(R.id.cb_exame);
        cbVacina = (CheckBox) findViewById(R.id.cb_vacina);
        cbBolsaFamilia = (CheckBox) findViewById(R.id.cb_cond_bolsa_familia);

        llMotivosVisita = (LinearLayout) findViewById(R.id.ll_motivos_visita);

        cbGestante = (CheckBox) findViewById(R.id.cb_gestante);
        cbPuerpera = (CheckBox) findViewById(R.id.cb_puerpera);
        cbRecemNascido = (CheckBox) findViewById(R.id.cb_recem_nascido);
        cbCrianca = (CheckBox) findViewById(R.id.cb_crianca);
        cbDesnutricao = (CheckBox) findViewById(R.id.cb_desnutricao);
        cbReabilitacao = (CheckBox) findViewById(R.id.cb_reabilitacao_deficiencia);
        cbHipertensao = (CheckBox) findViewById(R.id.cb_hipertencao);
        cbDiabetes = (CheckBox) findViewById(R.id.cb_diabetes);
        cbAsma = (CheckBox) findViewById(R.id.cb_asma);
        cbEnfisema = (CheckBox) findViewById(R.id.cb_dpoc_enfisema);
        cbCancer = (CheckBox) findViewById(R.id.cb_cancer);
        cbOutrasDoencas = (CheckBox) findViewById(R.id.cb_outras_doencas_cronicas);
        cbHanseniase = (CheckBox) findViewById(R.id.cb_hanseniase);
        cbTuberculose = (CheckBox) findViewById(R.id.cb_tuberculose);
        cbSintomaticosRespiratorios = (CheckBox) findViewById(R.id.cb_sintomaticos_respiratorios);
        cbTabagista = (CheckBox) findViewById(R.id.cb_tabagista);
        cbAcamados = (CheckBox) findViewById(R.id.cb_domiciliados_acamados);
        cbVulnerabilidadeSocial = (CheckBox) findViewById(R.id.cb_vulnerabilidade_social);
        cbAcompanhamentoBolsaFamilia = (CheckBox) findViewById(R.id.cb_acompanhamento_cond_bolsa_familia);
        cbSaudeMental = (CheckBox) findViewById(R.id.cb_saude_mental);
        cbUsuarioAlcool = (CheckBox) findViewById(R.id.cb_usuario_alcool);
        cbUsuarioOutrasDrogas = (CheckBox) findViewById(R.id.cb_usuario_outras_drogas);

        cbAcaoEducativa = (CheckBox) findViewById(R.id.cb_acao_educativa);
        cbImovelComFoco = (CheckBox) findViewById(R.id.cb_imovel_foco);
        cbAcaoMecanica = (CheckBox) findViewById(R.id.cb_acao_mecanica);
        cbTratamentoFocal = (CheckBox) findViewById(R.id.cb_tratamento_focal);
        cbEgressoInternacao = (CheckBox) findViewById(R.id.cb_egresso_internacao);
        cbConvite = (CheckBox) findViewById(R.id.cb_convite_atividades);

        cbOrientacao = (CheckBox) findViewById(R.id.cb_orientaçao_prevenção);
        cbOutros = (CheckBox) findViewById(R.id.cb_outros_animais);

        etPeso = (EditText) findViewById(R.id.et_peso);
        etAltura = (EditText) findViewById(R.id.et_altura);

        rgDesfecho = (RadioGroup) findViewById(R.id.rg_desfecho);
        rbVisitaRealizada = (RadioButton) findViewById(R.id.rb_visita_realizada);
        rbVisitaRecusada = (RadioButton) findViewById(R.id.rb_visita_recusada);
        rbAusente = (RadioButton) findViewById(R.id.rb_ausente);

        fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);

        rodape = (LinearLayout) findViewById(R.id.include_rodape);


    }

    private void configDatas() {

        this.configDatePicker(FichaVisitaDTActivity.this, etDataRegistro.getText().toString(), etDataRegistro);

        this.configDatePicker(FichaVisitaDTActivity.this, etNascimento.getText().toString(), etNascimento);

    }

    private void configToolbar() {

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Visita Domiciliar/Territorial");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FichaVisitaDTActivity.this, MainActivity.class);
                intent.putExtra("fragment", "FichaVisitaDTFragment");
                startActivity(intent);
                finish();
            }
        });

    }

    private void carregarSpinners() {

        /*ProfissionalBS profissionalBS = new ProfissionalBS(this);
        this.profissionais = profissionalBS.pesquisarAtivos();
        ArrayAdapter<ProfissionalModel> adapterProfissional = new ArrayAdapter<>(this, R.layout.spinner_item, this.profissionais);
        spinnerProfissional.setAdapter(adapterProfissional);
        adapterProfissional.setDropDownViewResource(R.layout.spinner_dropdown_item);

        CNESBS cnesBS = new CNESBS(this);
        this.hospitais = cnesBS.pesquisarAtivos();
        ArrayAdapter<CNESModel> adapterHospital = new ArrayAdapter<>(this, R.layout.spinner_item, this.hospitais);
        spinnerHospital.setAdapter(adapterHospital);
        adapterHospital.setDropDownViewResource(R.layout.spinner_dropdown_item);*/

        this.carregarSpinnerTipoImovel(spinnerTipoImovel);

    }

    private void instanciarFichaVisitaDTModel() {

        this.fichaVisitaDTModel = (FichaVisitaDTModel) getIntent().getSerializableExtra("fichaVisitaDT");

        if (this.fichaVisitaDTModel == null) {
            this.fichaVisitaDTModel = new FichaVisitaDTModel();
        } else {
            this.setModelToActivity();
        }

    }

    private void gravar() {

        if (!validaCampos()) {
            return;
        }

        this.setActivityToModel();

        this.fichaVisitaDTBS.gravar(this.fichaVisitaDTModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaVisitaDTFragment");
        startActivity(intent);

        finish();

    }

    private boolean flagPossuiOpcaoGrupoAcompanhamento() {
        return cbGestante.isChecked() || cbPuerpera.isChecked() || cbRecemNascido.isChecked()
                || cbCrianca.isChecked() || cbDesnutricao.isChecked() || cbReabilitacao.isChecked()
                || cbHipertensao.isChecked() || cbDiabetes.isChecked() || cbAsma.isChecked()
                || cbEnfisema.isChecked() || cbCancer.isChecked() || cbOutrasDoencas.isChecked()
                || cbHanseniase.isChecked() || cbTuberculose.isChecked() || cbSintomaticosRespiratorios.isChecked()
                || cbTabagista.isChecked() || cbAcamados.isChecked() || cbVulnerabilidadeSocial.isChecked()
                || cbBolsaFamilia.isChecked() || cbSaudeMental.isChecked() || cbUsuarioAlcool.isChecked() || cbUsuarioOutrasDrogas.isChecked();
    }

    private boolean flagPossuiOpcaoGrupoBuscaAtiva() {
        return cbConsulta.isChecked() || cbExame.isChecked() || cbVacina.isChecked() || cbBolsaFamilia.isChecked();
    }

    private void configListeners() {

        rgDesfecho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                desabilitaMotivosVisita(rgDesfecho.indexOfChild(findViewById(rgDesfecho.getCheckedRadioButtonId())));
            }
        });

        spinnerTipoImovel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                validaHabilitacaoCheckBoxesMotivosVisita(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinnerTipoImovel.setSelection(0);
            }
        });

        this.desabilitaEditText(cbForaDeArea, etMicroarea);

    }

    private void desmarcarCheckBoxesMotivoVisita() {

        this.cbCadastramentoAtt.setChecked(false);
        this.cbVisitaPeriodica.setChecked(false);

        this.cbConsulta.setChecked(false);
        this.cbExame.setChecked(false);
        this.cbVacina.setChecked(false);
        this.cbBolsaFamilia.setChecked(false);

        this.cbGestante.setChecked(false);
        this.cbPuerpera.setChecked(false);
        this.cbRecemNascido.setChecked(false);
        this.cbCrianca.setChecked(false);

        this.cbDesnutricao.setChecked(false);
        this.cbReabilitacao.setChecked(false);
        this.cbHipertensao.setChecked(false);
        this.cbDiabetes.setChecked(false);
        this.cbAsma.setChecked(false);
        this.cbEnfisema.setChecked(false);
        this.cbCancer.setChecked(false);
        this.cbOutrasDoencas.setChecked(false);
        this.cbHanseniase.setChecked(false);
        this.cbTuberculose.setChecked(false);
        this.cbSintomaticosRespiratorios.setChecked(false);

        this.cbTabagista.setChecked(false);
        this.cbAcamados.setChecked(false);
        this.cbVulnerabilidadeSocial.setChecked(false);
        this.cbAcompanhamentoBolsaFamilia.setChecked(false);
        this.cbSaudeMental.setChecked(false);

        this.cbUsuarioAlcool.setChecked(false);
        this.cbUsuarioOutrasDrogas.setChecked(false);

        this.cbAcaoEducativa.setChecked(false);
        this.cbImovelComFoco.setChecked(false);
        this.cbAcaoMecanica.setChecked(false);
        this.cbTratamentoFocal.setChecked(false);

        this.cbEgressoInternacao.setChecked(false);
        this.cbConvite.setChecked(false);
        this.cbOrientacao.setChecked(false);
        this.cbOutros.setChecked(false);

    }

    private void desabilitaMotivosVisita(Integer posicaoDesfecho) {

        List<Integer> tipos = new ArrayList<>(Arrays.asList(1, 2));

        boolean desaparecer = tipos.contains(posicaoDesfecho);

        if (desaparecer) {

            this.llMotivosVisita.setVisibility(View.GONE);

            desmarcarCheckBoxesMotivoVisita();

        } else {
            this.llMotivosVisita.setVisibility(View.VISIBLE);
        }

    }

    private void validaHabilitacaoCheckBoxesMotivosVisita(int posicaoTipoImovel) {

        List<Integer> tipos = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 12));

        boolean desabilitar = tipos.contains(posicaoTipoImovel);

        this.cbVisitaPeriodica.setEnabled(!desabilitar);
        this.cbConsulta.setEnabled(!desabilitar);
        this.cbExame.setEnabled(!desabilitar);
        this.cbVacina.setEnabled(!desabilitar);
        this.cbBolsaFamilia.setEnabled(!desabilitar);
        this.cbGestante.setEnabled(!desabilitar);
        this.cbPuerpera.setEnabled(!desabilitar);
        this.cbRecemNascido.setEnabled(!desabilitar);
        this.cbCrianca.setEnabled(!desabilitar);
        this.cbDesnutricao.setEnabled(!desabilitar);
        this.cbReabilitacao.setEnabled(!desabilitar);
        this.cbHipertensao.setEnabled(!desabilitar);
        this.cbDiabetes.setEnabled(!desabilitar);
        this.cbAsma.setEnabled(!desabilitar);
        this.cbEnfisema.setEnabled(!desabilitar);
        this.cbCancer.setEnabled(!desabilitar);
        this.cbOutrasDoencas.setEnabled(!desabilitar);
        this.cbHanseniase.setEnabled(!desabilitar);
        this.cbTuberculose.setEnabled(!desabilitar);
        this.cbSintomaticosRespiratorios.setEnabled(!desabilitar);
        this.cbTabagista.setEnabled(!desabilitar);
        this.cbAcamados.setEnabled(!desabilitar);
        this.cbVulnerabilidadeSocial.setEnabled(!desabilitar);
        this.cbAcompanhamentoBolsaFamilia.setEnabled(!desabilitar);
        this.cbSaudeMental.setEnabled(!desabilitar);
        this.cbUsuarioAlcool.setEnabled(!desabilitar);
        this.cbUsuarioOutrasDrogas.setEnabled(!desabilitar);
        this.cbEgressoInternacao.setEnabled(!desabilitar);

        if (desabilitar) {
            this.cbVisitaPeriodica.setChecked(false);
            this.cbConsulta.setChecked(false);
            this.cbExame.setChecked(false);
            this.cbVacina.setChecked(false);
            this.cbBolsaFamilia.setChecked(false);
            this.cbGestante.setChecked(false);
            this.cbPuerpera.setChecked(false);
            this.cbRecemNascido.setChecked(false);
            this.cbCrianca.setChecked(false);
            this.cbDesnutricao.setChecked(false);
            this.cbReabilitacao.setChecked(false);
            this.cbHipertensao.setChecked(false);
            this.cbDiabetes.setChecked(false);
            this.cbAsma.setChecked(false);
            this.cbEnfisema.setChecked(false);
            this.cbCancer.setChecked(false);
            this.cbOutrasDoencas.setChecked(false);
            this.cbHanseniase.setChecked(false);
            this.cbTuberculose.setChecked(false);
            this.cbSintomaticosRespiratorios.setChecked(false);
            this.cbTabagista.setChecked(false);
            this.cbAcamados.setChecked(false);
            this.cbVulnerabilidadeSocial.setChecked(false);
            this.cbAcompanhamentoBolsaFamilia.setChecked(false);
            this.cbSaudeMental.setChecked(false);
            this.cbUsuarioAlcool.setChecked(false);
            this.cbUsuarioOutrasDrogas.setChecked(false);
            this.cbEgressoInternacao.setChecked(false);
        }

    }


    private boolean validaCampos() {

        boolean valido = true;

        String aviso = "";

        String cboProfissional = prefs.getString("cbo", "");

        if (!(cboProfissional.equals("515105") || cboProfissional.equals("515120") || cboProfissional.equals("515310") || cboProfissional.equals("51514"))) {
            aviso = Utilitario.addAviso("Sua ocupação não permite registrar esta ficha.", aviso);
            valido = false;
        } else {

            if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
                aviso = Utilitario.addAviso("Preencha a data de registro.", aviso);
                valido = false;
            }

            if (!Utilitario.isEmpty(etDataRegistro.getText().toString()) && !Utilitario.dataValida(etDataRegistro.getText().toString())) {
                aviso = Utilitario.addAviso("A data de registro não é válida.", aviso);
                valido = false;
            }

            if (!rbTurnoM.isChecked() && !rbTurnoT.isChecked() && !rbTurnoN.isChecked()) {
                aviso = Utilitario.addAviso("Preencha o turno da visita.", aviso);
                valido = false;
            }

            if (Utilitario.isEmpty(etMicroarea.getText().toString()) && !cbForaDeArea.isChecked()) {
                aviso = Utilitario.addAviso("Preencha a microarea.", aviso);
                valido = false;
            }

            if (Utilitario.isEmpty((((TipoModel) spinnerTipoImovel.getSelectedItem()).getCodigo()))) {
                aviso = Utilitario.addAviso("Preencha o tipo de imóvel.", aviso);
                valido = false;

            } else {

                if (!new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 12)).contains(((TipoModel) spinnerTipoImovel.getSelectedItem()).getCodigo())) {

                    if (Utilitario.isEmpty(etProntuario.getText().toString())) {
                        aviso = Utilitario.addAviso("Preencha o prontuário.", aviso);
                        valido = false;
                    }

                    if (!Utilitario.isEmpty(etCnsCidadao.getText().toString())) {

                        if (!Utilitario.isCNSValido(etCnsCidadao.getText().toString())) {
                            aviso = Utilitario.addAviso("CNS do cidadão inválido.", aviso);
                            valido = false;
                        }

                    } else {
                        aviso = Utilitario.addAviso("Preencha a CNS do cidadão.", aviso);
                        valido = false;
                    }

                    if (flagPossuiOpcaoGrupoBuscaAtiva() || flagPossuiOpcaoGrupoAcompanhamento() || cbEgressoInternacao.isChecked() || cbOrientacao.isChecked() || !Utilitario.isEmpty(etPeso.getText().toString()) || !Utilitario.isEmpty(etAltura.getText().toString())) {

                        if (Utilitario.isEmpty(etNascimento.getText().toString())) {
                            aviso = Utilitario.addAviso("Preencha a data de nascimento.", aviso);
                            valido = false;
                        }

                        if (!Utilitario.isEmpty(etNascimento.getText().toString()) && !Utilitario.dataValida(etNascimento.getText().toString())) {
                            aviso = Utilitario.addAviso("A data de nascimento não é válida.", aviso);
                            valido = false;
                        }

                        if (!rbSexoM.isChecked() && !rbSexoF.isChecked()) {
                            aviso = Utilitario.addAviso("Preencha o sexo.", aviso);
                            valido = false;
                        }
                    }
                }
            }
        }

        if (!aviso.isEmpty()) {
            Utilitario.alertar(FichaVisitaDTActivity.this, aviso);
        }

        return valido;

    }

    private void setModelToActivity() {

        etDataRegistro.setText(Utilitario.getDataFormatada(this.fichaVisitaDTModel.getDataRegistro()));
        if (!Utilitario.isEmpty(this.fichaVisitaDTModel.getTurno())) {
            rbTurnoM.setChecked(this.fichaVisitaDTModel.getTurno().equals("M"));
            rbTurnoT.setChecked(this.fichaVisitaDTModel.getTurno().equals("T"));
            rbTurnoN.setChecked(this.fichaVisitaDTModel.getTurno().equals("N"));
        }
        etMicroarea.setText(this.fichaVisitaDTModel.getMicroArea());
        cbForaDeArea.setChecked(this.fichaVisitaDTModel.getFlagForaArea());

        if (!Utilitario.isEmpty(this.fichaVisitaDTModel.getTipoImovelModel()) && this.fichaVisitaDTModel.getTipoImovelModel().getCodigo() > 0) {
            spinnerTipoImovel.setSelection(new TipoModel().getComboTipoImovel().indexOf(this.fichaVisitaDTModel.getTipoImovelModel()));
        }

        etProntuario.setText(this.fichaVisitaDTModel.getProntuario());
        etCnsCidadao.setText(this.fichaVisitaDTModel.getCnsCidadao());
        etNascimento.setText(Utilitario.getDataFormatada(this.fichaVisitaDTModel.getDataNascimento()));
        rbSexoM.setChecked(!Utilitario.isEmpty(this.fichaVisitaDTModel.getSexo()) && this.fichaVisitaDTModel.getSexo().equals("M"));
        rbSexoF.setChecked(!Utilitario.isEmpty(this.fichaVisitaDTModel.getSexo()) && this.fichaVisitaDTModel.getSexo().equals("F"));
        cbVisitaCompartilhada.setChecked(this.fichaVisitaDTModel.getFlagVisitaCompartilhada());

        cbCadastramentoAtt.setChecked(this.fichaVisitaDTModel.getFlagCadastramento());
        cbVisitaPeriodica.setChecked(this.fichaVisitaDTModel.getFlagVisitaPeriodica());

        cbConsulta.setChecked(this.fichaVisitaDTModel.getFlagConsulta());
        cbExame.setChecked(this.fichaVisitaDTModel.getFlagExame());
        cbVacina.setChecked(this.fichaVisitaDTModel.getFlagVacina());
        cbBolsaFamilia.setChecked(this.fichaVisitaDTModel.getFlagBolsaFamilia());

        cbGestante.setChecked(this.fichaVisitaDTModel.getFlagGestante());
        cbPuerpera.setChecked(this.fichaVisitaDTModel.getFlagPuerpera());
        cbRecemNascido.setChecked(this.fichaVisitaDTModel.getFlagRecemNascido());
        cbCrianca.setChecked(this.fichaVisitaDTModel.getFlagCrianca());
        cbDesnutricao.setChecked(this.fichaVisitaDTModel.getFlagDesnutricao());
        cbReabilitacao.setChecked(this.fichaVisitaDTModel.getFlagReabilitacao());
        cbHipertensao.setChecked(this.fichaVisitaDTModel.getFlagHipertensao());
        cbDiabetes.setChecked(this.fichaVisitaDTModel.getFlagDiabetes());
        cbAsma.setChecked(this.fichaVisitaDTModel.getFlagAsma());
        cbEnfisema.setChecked(this.fichaVisitaDTModel.getFlagEnfisema());
        cbCancer.setChecked(this.fichaVisitaDTModel.getFlagCancer());
        cbOutrasDoencas.setChecked(this.fichaVisitaDTModel.getFlagDoencasCronicas());
        cbHanseniase.setChecked(this.fichaVisitaDTModel.getFlagHanseniase());
        cbTuberculose.setChecked(this.fichaVisitaDTModel.getFlagTuberculose());
        cbSintomaticosRespiratorios.setChecked(this.fichaVisitaDTModel.getFlagSintomaticosRespiratorios());
        cbTabagista.setChecked(this.fichaVisitaDTModel.getFlagTabagista());
        cbAcamados.setChecked(this.fichaVisitaDTModel.getFlagAcamado());
        cbVulnerabilidadeSocial.setChecked(this.fichaVisitaDTModel.getFlagVunerabilidadeSocial());
        cbAcompanhamentoBolsaFamilia.setChecked(this.fichaVisitaDTModel.getFlagAcompanhamentoBolsaFamilia());
        cbSaudeMental.setChecked(this.fichaVisitaDTModel.getFlagSaudeMental());
        cbUsuarioAlcool.setChecked(this.fichaVisitaDTModel.getFlagUsuarioAlcool());
        cbUsuarioOutrasDrogas.setChecked(this.fichaVisitaDTModel.getFlagOutrasDrogas());

        cbAcaoEducativa.setChecked(this.fichaVisitaDTModel.getFlagAcaoEducativa());
        cbImovelComFoco.setChecked(this.fichaVisitaDTModel.getFlagImovelComFoco());
        cbAcaoMecanica.setChecked(this.fichaVisitaDTModel.getFlagAcaoMecanica());
        cbTratamentoFocal.setChecked(this.fichaVisitaDTModel.getFlagTratamentoFocal());

        cbEgressoInternacao.setChecked(this.fichaVisitaDTModel.getFlagEgressoInternacao());
        cbConvite.setChecked(this.fichaVisitaDTModel.getFlagConvite());
        cbOrientacao.setChecked(this.fichaVisitaDTModel.getFlagOrientacao());
        cbOutros.setChecked(this.fichaVisitaDTModel.getFlagOutros());

        if (this.fichaVisitaDTModel.getPeso() > 0) {
            etPeso.setText(this.fichaVisitaDTModel.getPeso().toString());
        }

        if (this.fichaVisitaDTModel.getAltura() > 0) {
            etAltura.setText(this.fichaVisitaDTModel.getAltura().toString());
        }

        rbVisitaRealizada.setChecked(this.fichaVisitaDTModel.getDesfecho() == 1);
        rbVisitaRecusada.setChecked(this.fichaVisitaDTModel.getDesfecho() == 2);
        rbAusente.setChecked(this.fichaVisitaDTModel.getDesfecho() == 3);
    }

    private void setActivityToModel() {

        this.fichaVisitaDTModel.setProfissionalModel(new ProfissionalModel(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getLong("id", 0)));
        this.fichaVisitaDTModel.setDataRegistro(Utilitario.getDate(etDataRegistro.getText().toString()));

        this.fichaVisitaDTModel.setTipoImovelModel((TipoModel) spinnerTipoImovel.getSelectedItem());
        this.fichaVisitaDTModel.setTurno(rbTurnoM.isChecked() ? "M" : rbTurnoT.isChecked() ? "T" : rbTurnoN.isChecked() ? "N" : null);
        this.fichaVisitaDTModel.setMicroArea(etMicroarea.getText().toString());
        this.fichaVisitaDTModel.setFlagForaArea(cbForaDeArea.isChecked());

        this.fichaVisitaDTModel.setProntuario(etProntuario.getText().toString());
        this.fichaVisitaDTModel.setCnsCidadao(etCnsCidadao.getText().toString());
        this.fichaVisitaDTModel.setDataNascimento(Utilitario.getDate(etNascimento.getText().toString()));
        this.fichaVisitaDTModel.setSexo(rbSexoM.isChecked() ? "M" : rbSexoF.isChecked() ? "F" : null);
        this.fichaVisitaDTModel.setFlagVisitaCompartilhada(cbVisitaCompartilhada.isChecked());

        this.fichaVisitaDTModel.setFlagCadastramento(cbCadastramentoAtt.isChecked());
        this.fichaVisitaDTModel.setFlagVisitaPeriodica(cbVisitaPeriodica.isChecked());

        this.fichaVisitaDTModel.setFlagConsulta(cbConsulta.isChecked());
        this.fichaVisitaDTModel.setFlagExame(cbExame.isChecked());
        this.fichaVisitaDTModel.setFlagVacina(cbVacina.isChecked());
        this.fichaVisitaDTModel.setFlagBolsaFamilia(cbBolsaFamilia.isChecked());

        this.fichaVisitaDTModel.setFlagGestante(cbGestante.isChecked());
        this.fichaVisitaDTModel.setFlagPuerpera(cbPuerpera.isChecked());
        this.fichaVisitaDTModel.setFlagRecemNascido(cbRecemNascido.isChecked());
        this.fichaVisitaDTModel.setFlagCrianca(cbCrianca.isChecked());
        this.fichaVisitaDTModel.setFlagDesnutricao(cbDesnutricao.isChecked());
        this.fichaVisitaDTModel.setFlagReabilitacao(cbReabilitacao.isChecked());
        this.fichaVisitaDTModel.setFlagHipertensao(cbHipertensao.isChecked());
        this.fichaVisitaDTModel.setFlagDiabetes(cbDiabetes.isChecked());
        this.fichaVisitaDTModel.setFlagAsma(cbAsma.isChecked());
        this.fichaVisitaDTModel.setFlagEnfisema(cbEnfisema.isChecked());
        this.fichaVisitaDTModel.setFlagCancer(cbCancer.isChecked());
        this.fichaVisitaDTModel.setFlagDoencasCronicas(cbOutrasDoencas.isChecked());
        this.fichaVisitaDTModel.setFlagHanseniase(cbHanseniase.isChecked());
        this.fichaVisitaDTModel.setFlagTuberculose(cbTuberculose.isChecked());
        this.fichaVisitaDTModel.setFlagSintomaticosRespiratorios(cbSintomaticosRespiratorios.isChecked());
        this.fichaVisitaDTModel.setFlagTabagista(cbTabagista.isChecked());
        this.fichaVisitaDTModel.setFlagAcamado(cbAcamados.isChecked());
        this.fichaVisitaDTModel.setFlagVunerabilidadeSocial(cbVulnerabilidadeSocial.isChecked());
        this.fichaVisitaDTModel.setFlagAcompanhamentoBolsaFamilia(cbAcompanhamentoBolsaFamilia.isChecked());
        this.fichaVisitaDTModel.setFlagSaudeMental(cbSaudeMental.isChecked());
        this.fichaVisitaDTModel.setFlagUsuarioAlcool(cbUsuarioAlcool.isChecked());
        this.fichaVisitaDTModel.setFlagOutrasDrogas(cbUsuarioOutrasDrogas.isChecked());

        this.fichaVisitaDTModel.setFlagAcaoEducativa(cbAcaoEducativa.isChecked());
        this.fichaVisitaDTModel.setFlagImovelComFoco(cbImovelComFoco.isChecked());
        this.fichaVisitaDTModel.setFlagAcaoMecanica(cbAcaoMecanica.isChecked());
        this.fichaVisitaDTModel.setFlagTratamentoFocal(cbTratamentoFocal.isChecked());

        this.fichaVisitaDTModel.setFlagEgressoInternacao(cbEgressoInternacao.isChecked());
        this.fichaVisitaDTModel.setFlagConvite(cbConvite.isChecked());
        this.fichaVisitaDTModel.setFlagOrientacao(cbOrientacao.isChecked());
        this.fichaVisitaDTModel.setFlagOutros(cbOutros.isChecked());

        if (etPeso.getText().length() > 0) {
            this.fichaVisitaDTModel.setPeso(new Double(etPeso.getText().toString()));
        }

        if (etAltura.getText().length() > 0) {
            this.fichaVisitaDTModel.setAltura(new Integer(etAltura.getText().toString()));
        }

        this.fichaVisitaDTModel.setDesfecho(rbVisitaRealizada.isChecked() ? 1 : rbVisitaRecusada.isChecked() ? 2 : rbAusente.isChecked() ? 3 : 0);

    }

    private void configMascaras() {

        String mascaraData = "##/##/####";

        etDataRegistro.addTextChangedListener(Mascara.insert(mascaraData, etDataRegistro));
        etDataRegistro.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etDataRegistro));
        etNascimento.addTextChangedListener(Mascara.insert(mascaraData, etNascimento));
        etNascimento.setOnFocusChangeListener(Mascara.onBlurValidaMascara(mascaraData, etNascimento));

    }

}
