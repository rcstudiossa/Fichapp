package com.fichapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.fichapp.Model.CNESModel;
import com.fichapp.Model.FichaVisitaDTModel;
import com.fichapp.R;
import com.fichapp.business.FichaVisitaDTBS;

public class FichaVisitaDTActivity extends AppCompatActivity {

    private FichaVisitaDTModel fichaVisitaDTModel;
    private FichaVisitaDTBS fichaVisitaDTBS;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_visita_dt);

        spinnerProfissional = (Spinner) findViewById(R.id.spinner_profissional);
        spinnerHospital = (Spinner) findViewById(R.id.spinner_hospital);
        etINE = (EditText) findViewById(R.id.et_ine);
        etDataRegistro = (EditText) findViewById(R.id.et_data_registro);
        rbTurnoM = (RadioButton) findViewById(R.id.rb_turno_m);
        rbTurnoT = (RadioButton) findViewById(R.id.rb_turno_t);
        rbTurnoN = (RadioButton) findViewById(R.id.rb_turno_n);
        etMicroarea = (EditText) findViewById(R.id.et_microarea);
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
        cbOrientacao = (CheckBox) findViewById(R.id.cb_orientaçao_prevenção);
        cbOutros = (CheckBox) findViewById(R.id.cb_outros);

        etPeso = (EditText) findViewById(R.id.et_peso);
        etAltura = (EditText) findViewById(R.id.et_altura);

        rbVisitaRealizada = (RadioButton) findViewById(R.id.rb_visita_realizada);
        rbVisitaRecusada = (RadioButton) findViewById(R.id.rb_visita_recusada);
        rbAusente = (RadioButton) findViewById(R.id.rb_ausente);

        btnGravar = (Button) findViewById(R.id.btn_gravar);






        ArrayAdapter adapterProfissional = ArrayAdapter.createFromResource(this, R.array.profissionais, android.R.layout.simple_spinner_item);
        spinnerProfissional.setAdapter(adapterProfissional);
        spinnerProfissional.setSelection(adapterProfissional.getPosition(1));

        ArrayAdapter adapterHospital = ArrayAdapter.createFromResource(this, R.array.hospitais, android.R.layout.simple_spinner_item);
        spinnerHospital.setAdapter(adapterHospital);
        spinnerHospital.setSelection(adapterHospital.getPosition(1));

        ArrayAdapter adapterTipoImovel = ArrayAdapter.createFromResource(this, R.array.tipoImovel, android.R.layout.simple_spinner_item);
        spinnerTipoImovel.setAdapter(adapterTipoImovel);
        spinnerTipoImovel.setSelection(adapterTipoImovel.getPosition(1));

        this.instanciarFichaVisitaDTModel();

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }

    private void instanciarFichaVisitaDTModel() {

        this.fichaVisitaDTModel = (FichaVisitaDTModel) getIntent().getSerializableExtra("fichaVisitaDT");

        if (this.fichaVisitaDTModel == null) {
            this.fichaVisitaDTModel = new FichaVisitaDTModel();
            mFlagAtivo.setChecked(Boolean.TRUE);
        } else {
            mCodigo.setText(this.cnesModel.getCodigo());
            mNome.setText(this.cnesModel.getNome());
            mFlagAtivo.setChecked(this.cnesModel.getFlagAtivo());
        }

    }

    private void gravar() {

        this.cnesModel.setCodigo(mCodigo.getText().toString());
        this.cnesModel.setNome(mNome.getText().toString());
        this.cnesModel.setFlagAtivo(mFlagAtivo.isChecked());

        fichaVisitaDTBS.gravar(this.fichaVisitaDTModel);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Fragment", "FichaVisitaDTFragment");
        startActivity(intent);


    }

}
