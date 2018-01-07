package com.fichapp.activity;

import android.app.DatePickerDialog;
import android.app.Service;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoImovelModel;
import com.fichapp.R;
import com.fichapp.business.CNESBS;
import com.fichapp.business.FichaVisitaDTBS;
import com.fichapp.business.ProfissionalBS;
import com.fichapp.util.Utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FichaVisitaDTActivity extends AppCompatActivity {

    private FichaVisitaDTModel fichaVisitaDTModel;
    private FichaVisitaDTBS fichaVisitaDTBS;

    private List<ProfissionalModel> profissionais;
    private List<CNESModel> hospitais;

    private Spinner spinnerProfissional;
    private Spinner spinnerHospital;
    private EditText etINE;
    private EditText etDataRegistro;
    private RadioButton rbTurnoM;
    private RadioButton rbTurnoT;
    private RadioButton rbTurnoN;
    private EditText etMicroarea;
    private Spinner spinnerTipoImovel;

    private EditText etProntuario;
    private EditText etCnsCidadao;
    private EditText etNascimento;
    private RadioButton rbSexoM;
    private RadioButton rbSexoF;
    private CheckBox cbVisitaCompartilhada;

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

    private RadioButton rbVisitaRealizada;
    private RadioButton rbVisitaRecusada;
    private RadioButton rbAusente;

    private Button btnGravar;

    private LinearLayout rodape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_visita_dt);

        getSupportActionBar().setTitle("Cadastro de Ficha");

        final Calendar registroCalendar = Calendar.getInstance();
        final Calendar nascimentoCalendar = Calendar.getInstance();

        spinnerProfissional = (Spinner) findViewById(R.id.spinner_profissional);
        spinnerHospital = (Spinner) findViewById(R.id.spinner_hospital);
        etINE = (EditText) findViewById(R.id.et_ine);

        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);

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
                // TODO Auto-generated method stub
                new DatePickerDialog(FichaVisitaDTActivity.this, dataRegistro, registroCalendar
                        .get(Calendar.YEAR), registroCalendar.get(Calendar.MONTH),
                        registroCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        rbTurnoM = (RadioButton) findViewById(R.id.rb_turno_m);
        rbTurnoT = (RadioButton) findViewById(R.id.rb_turno_t);
        rbTurnoN = (RadioButton) findViewById(R.id.rb_turno_n);
        etMicroarea = (EditText) findViewById(R.id.et_microarea);
        spinnerTipoImovel = (Spinner) findViewById(R.id.spinner_tipo_imovel);

        etProntuario = (EditText) findViewById(R.id.et_prontuario);
        etCnsCidadao = (EditText) findViewById(R.id.et_cns);


        etNascimento = (EditText) findViewById(R.id.et_data_nascimento);

        final DatePickerDialog.OnDateSetListener dataNascimento = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                registroCalendar.set(Calendar.YEAR, year);
                registroCalendar.set(Calendar.MONTH, monthOfYear);
                registroCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(etNascimento, nascimentoCalendar);
            }
        };

        etNascimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(FichaVisitaDTActivity.this, dataNascimento, nascimentoCalendar
                        .get(Calendar.YEAR), nascimentoCalendar.get(Calendar.MONTH),
                        nascimentoCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        rbSexoM = (RadioButton) findViewById(R.id.rb_sexo_m);
        rbSexoF = (RadioButton) findViewById(R.id.rb_sexo_f);
        cbVisitaCompartilhada = (CheckBox) findViewById(R.id.visita_outro_profissional);

        cbCadastramentoAtt = (CheckBox) findViewById(R.id.cb_cadastramento_atualizacao);
        cbVisitaPeriodica = (CheckBox) findViewById(R.id.cb_visita_periodica);

        cbConsulta = (CheckBox) findViewById(R.id.cb_consulta);
        cbExame = (CheckBox) findViewById(R.id.cb_exame);
        cbVacina = (CheckBox) findViewById(R.id.cb_vacina);
        cbBolsaFamilia = (CheckBox) findViewById(R.id.cb_cond_bolsa_familia);

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
        cbOutros = (CheckBox) findViewById(R.id.cb_outros);

        etPeso = (EditText) findViewById(R.id.et_peso);
        etAltura = (EditText) findViewById(R.id.et_altura);

        rbVisitaRealizada = (RadioButton) findViewById(R.id.rb_visita_realizada);
        rbVisitaRecusada = (RadioButton) findViewById(R.id.rb_visita_recusada);
        rbAusente = (RadioButton) findViewById(R.id.rb_ausente);

        btnGravar = (Button) findViewById(R.id.btn_gravar);

        rodape = (LinearLayout) findViewById(R.id.include_rodape);

        rodape.setVisibility(View.GONE);

        this.fichaVisitaDTBS = new FichaVisitaDTBS(getApplication());

        carregarCombos();

        this.instanciarFichaVisitaDTModel();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    private void carregarCombos() {

        ProfissionalBS profissionalBS = new ProfissionalBS(this);
        this.profissionais = profissionalBS.pesquisarAtivos();
        ArrayAdapter<ProfissionalModel> adapterProfissional = new ArrayAdapter<>(this, R.layout.spinner_item, this.profissionais);
        spinnerProfissional.setAdapter(adapterProfissional);
        adapterProfissional.setDropDownViewResource(R.layout.spinner_dropdown_item);

        CNESBS cnesBS = new CNESBS(this);
        this.hospitais = cnesBS.pesquisarAtivos();
        ArrayAdapter<CNESModel> adapterHospital = new ArrayAdapter<>(this, R.layout.spinner_item, this.hospitais);
        spinnerHospital.setAdapter(adapterHospital);
        adapterHospital.setDropDownViewResource(R.layout.spinner_dropdown_item);

        ArrayAdapter adapterTipoImovel = ArrayAdapter.createFromResource(this, R.array.tipoImovel, R.layout.spinner_item);
        spinnerTipoImovel.setAdapter(adapterTipoImovel);
        adapterTipoImovel.setDropDownViewResource(R.layout.spinner_dropdown_item);

    }

    private void instanciarFichaVisitaDTModel() {

        this.fichaVisitaDTModel = (FichaVisitaDTModel) getIntent().getSerializableExtra("fichaVisitaDT");

        if (this.fichaVisitaDTModel == null) {
            this.fichaVisitaDTModel = new FichaVisitaDTModel();
        } else {
            setModelToActivity();
        }

    }

    private void gravar() {

        if (!validaCampos()) {
            return;
        }

        setActivityToModel();

        this.fichaVisitaDTBS.gravar(this.fichaVisitaDTModel);

        Utilitario.avisoSucesso(getApplicationContext());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("fragment", "FichaVisitaDTFragment");
        startActivity(intent);

        finish();

    }

    private boolean validaCampos() {

        boolean valido = true;

        if (!Utilitario.isEmpty(etCnsCidadao.getText().toString())) {

            if (!Utilitario.isCNSValido(etCnsCidadao.getText().toString())) {
                Snackbar.make(getCurrentFocus(), "CNS do cidadão inválido.", Snackbar.LENGTH_LONG).show();
                valido = false;
            }

        } else {
            Snackbar.make(getCurrentFocus(), "Preencha a CNS do cidadão.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        if (Utilitario.isEmpty(etDataRegistro.getText().toString())) {
            Snackbar.make(getCurrentFocus(), "Preencha a data de registro.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        if (rbVisitaRealizada.isChecked() && Utilitario.isEmpty(etNascimento.getText().toString())) {
            Snackbar.make(getCurrentFocus(), "Preencha a data de nascimento.", Snackbar.LENGTH_LONG).show();
            valido = false;
        }

        return valido;

    }

    private void setModelToActivity() {

        spinnerProfissional.setSelection(this.profissionais.indexOf(this.fichaVisitaDTModel.getProfissionalModel()));
        etINE.setText(this.fichaVisitaDTModel.getIne());
        etDataRegistro.setText(this.fichaVisitaDTModel.getDataRegistro().toString());
        rbTurnoM.setChecked(this.fichaVisitaDTModel.getTurno().equals("M"));
        rbTurnoT.setChecked(this.fichaVisitaDTModel.getTurno().equals("T"));
        rbTurnoN.setChecked(this.fichaVisitaDTModel.getTurno().equals("N"));
        etMicroarea.setText(this.fichaVisitaDTModel.getMicroArea());


        etProntuario.setText(this.fichaVisitaDTModel.getProntuario());
        etCnsCidadao.setText(this.fichaVisitaDTModel.getCnsCidadao());
        etNascimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(this.fichaVisitaDTModel.getDataNascimento()));
        rbSexoM.setChecked(this.fichaVisitaDTModel.getSexo().equals("M"));
        rbSexoF.setChecked(this.fichaVisitaDTModel.getSexo().equals("F"));
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

        etPeso.setText(this.fichaVisitaDTModel.getPeso().toString());
        etAltura.setText(this.fichaVisitaDTModel.getAltura().toString());

        rbVisitaRealizada.setChecked(this.fichaVisitaDTModel.getDesfecho() == 1);
        rbVisitaRecusada.setChecked(this.fichaVisitaDTModel.getDesfecho() == 2);
        rbAusente.setChecked(this.fichaVisitaDTModel.getDesfecho() == 3);
    }

    private void setActivityToModel() {

        this.fichaVisitaDTModel.setProfissionalModel((ProfissionalModel) spinnerProfissional.getSelectedItem());
        this.fichaVisitaDTModel.setCnesModel((CNESModel) spinnerHospital.getSelectedItem());
        this.fichaVisitaDTModel.setTipoImovelModel(new TipoImovelModel());

        this.fichaVisitaDTModel.setIne(etINE.getText().toString());
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fichaVisitaDTModel.setDataRegistro(formato.parse(etDataRegistro.getText().toString()));
        } catch (ParseException e) {
            Toast.makeText(getApplication(), "Data de registro cadastrada errada.", Toast.LENGTH_LONG).show();
        }
        this.fichaVisitaDTModel.setTurno(rbTurnoM.isChecked() ? "M" : rbTurnoT.isChecked() ? "T" : rbTurnoN.isChecked() ? "N" : null);
        this.fichaVisitaDTModel.setMicroArea(etMicroarea.getText().toString());

        this.fichaVisitaDTModel.setProntuario(etProntuario.getText().toString());
        this.fichaVisitaDTModel.setCnsCidadao(etCnsCidadao.getText().toString());
        this.fichaVisitaDTModel.setDataNascimento(new Date(etNascimento.getText().toString()));
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

    private void updateLabel(EditText editText, Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText.setText(sdf.format(calendar.getTime()));
    }

}
