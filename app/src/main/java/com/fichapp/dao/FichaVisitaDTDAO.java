package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoImovelModel;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaVisitaDTDAO {

    SQLiteDatabase db;

    public FichaVisitaDTDAO() {}

    public FichaVisitaDTDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
    }

    public void alterar(FichaVisitaDTModel fichaModel) {

        Object[] args = {fichaModel.getProfissionalModel().getId(),
                         Utilitario.getDataFormatada(fichaModel.getDataRegistro()),
                         fichaModel.getTurno(),
                         fichaModel.getMicroArea(),
                         fichaModel.getTipoImovelModel().getCodigo(),
                         fichaModel.getProntuario(),
                         fichaModel.getCnsCidadao(),
                         Utilitario.getDataFormatada(fichaModel.getDataNascimento()),
                         fichaModel.getSexo(),
                         fichaModel.getFlagVisitaCompartilhada(),
                         fichaModel.getFlagCadastramento(),
                         fichaModel.getFlagVisitaPeriodica(),
                         fichaModel.getFlagConsulta(),
                         fichaModel.getFlagExame(),
                         fichaModel.getFlagVacina(),
                         fichaModel.getFlagBolsaFamilia(),
                         fichaModel.getFlagGestante(),
                         fichaModel.getFlagPuerpera(),
                         fichaModel.getFlagRecemNascido(),
                         fichaModel.getFlagCrianca(),
                         fichaModel.getFlagDesnutricao(),
                         fichaModel.getFlagReabilitacao(),
                         fichaModel.getFlagHipertensao(),
                         fichaModel.getFlagDiabetes(),
                         fichaModel.getFlagAsma(),
                         fichaModel.getFlagEnfisema(),
                         fichaModel.getFlagDoencasCronicas(),
                         fichaModel.getFlagHanseniase(),
                         fichaModel.getFlagTuberculose(),
                         fichaModel.getFlagSintomaticosRespiratorios(),
                         fichaModel.getFlagTabagista(),
                         fichaModel.getFlagAcamado(),
                         fichaModel.getFlagVunerabilidadeSocial(),
                         fichaModel.getFlagAcompanhamentoBolsaFamilia(),
                         fichaModel.getFlagSaudeMental(),
                         fichaModel.getFlagUsuarioAlcool(),
                         fichaModel.getFlagOutrasDrogas(),
                         fichaModel.getFlagAcaoEducativa(),
                         fichaModel.getFlagImovelComFoco(),
                         fichaModel.getFlagAcaoMecanica(),
                         fichaModel.getFlagTratamentoFocal(),
                         fichaModel.getFlagEgressoInternacao(),
                         fichaModel.getFlagConvite(),
                         fichaModel.getFlagOrientacao(),
                         fichaModel.getFlagOutros(),
                         fichaModel.getPeso(),
                         fichaModel.getAltura(),
                         fichaModel.getDesfecho(),
                         fichaModel.getFlagAtivo(),
                         fichaModel.getFlagExportado(),
                         fichaModel.getId()};

        String query = "update ficha_visita_domiciliar_territorial set profissional_id = ?, data_registro = ?, turno = ?, microarea = ?, tipo_imovel = ?" +
                   ", prontuario = ?, cns_cidadao = ?, data_nascimento = ?, sexo = ?, flag_visita_compartilhada = ?, flag_cadastramento  = ?, flag_visita_periodica = ?" +
                   ", flag_consulta  = ?, flag_exame  = ?, flag_vacina  = ?, flag_bolsa_familia  = ?, flag_gestante  = ?, flag_puerpera  = ?, flag_recem_nascido  = ?, flag_crianca  = ?, flag_desnutricao  = ?" +
                   ", flag_reabilitacao  = ?, flag_hipertensao  = ?, flag_diabetes  = ?, flag_asma  = ?, flag_enfisema  = ?, flag_doencas_cronicas  = ?, flag_hanseniase  = ?, flag_tuberculose  = ?" +
                   ", flag_sintomaticos_respiratorios  = ?, flag_tabagista  = ?, flag_acamado  = ?, flag_vulnerabilidade_social  = ?, flag_acompanhamento_bolsa_familia  = ?, flag_saude_mental  = ?, flag_usuario_alcool  = ?" +
                   ", flag_outras_drogas  = ?, flag_acao_educativa  = ?, flag_imovel_com_foco  = ?, flag_acao_mecanica  = ?, flag_tratamento_focal  = ?, flag_egresso_internacao  = ?, flag_convite  = ?, flag_orientacao  = ?" +
                   ", flag_outros  = ?, peso = ?, altura = ?, desfecho = ?, flag_ativo  = ?, flag_exportado  = ? where id = ?;";

        db.execSQL(query, args);

    }

    public void inserir(FichaVisitaDTModel fichaModel) {

        Object[] args = {fichaModel.getProfissionalModel().getId(),
                Utilitario.getDataFormatada(fichaModel.getDataRegistro()),
                fichaModel.getTurno(),
                fichaModel.getMicroArea(),
                fichaModel.getTipoImovelModel().getCodigo(),
                fichaModel.getProntuario(),
                fichaModel.getCnsCidadao(),
                Utilitario.getDataFormatada(fichaModel.getDataNascimento()),
                fichaModel.getSexo(),
                fichaModel.getFlagVisitaCompartilhada(),
                fichaModel.getFlagCadastramento(),
                fichaModel.getFlagVisitaPeriodica(),
                fichaModel.getFlagConsulta(),
                fichaModel.getFlagExame(),
                fichaModel.getFlagVacina(),
                fichaModel.getFlagBolsaFamilia(),
                fichaModel.getFlagGestante(),
                fichaModel.getFlagPuerpera(),
                fichaModel.getFlagRecemNascido(),
                fichaModel.getFlagCrianca(),
                fichaModel.getFlagDesnutricao(),
                fichaModel.getFlagReabilitacao(),
                fichaModel.getFlagHipertensao(),
                fichaModel.getFlagDiabetes(),
                fichaModel.getFlagAsma(),
                fichaModel.getFlagEnfisema(),
                fichaModel.getFlagDoencasCronicas(),
                fichaModel.getFlagHanseniase(),
                fichaModel.getFlagTuberculose(),
                fichaModel.getFlagSintomaticosRespiratorios(),
                fichaModel.getFlagTabagista(),
                fichaModel.getFlagAcamado(),
                fichaModel.getFlagVunerabilidadeSocial(),
                fichaModel.getFlagAcompanhamentoBolsaFamilia(),
                fichaModel.getFlagSaudeMental(),
                fichaModel.getFlagUsuarioAlcool(),
                fichaModel.getFlagOutrasDrogas(),
                fichaModel.getFlagAcaoEducativa(),
                fichaModel.getFlagImovelComFoco(),
                fichaModel.getFlagAcaoMecanica(),
                fichaModel.getFlagTratamentoFocal(),
                fichaModel.getFlagEgressoInternacao(),
                fichaModel.getFlagConvite(),
                fichaModel.getFlagOrientacao(),
                fichaModel.getFlagOutros(),
                fichaModel.getPeso(),
                fichaModel.getAltura(),
                fichaModel.getDesfecho(),
                Boolean.TRUE,
                Boolean.FALSE};

        String query = "insert into ficha_visita_domiciliar_territorial (profissional_id, data_registro, turno, microarea, tipo_imovel" +
                ", prontuario, cns_cidadao, data_nascimento, sexo, flag_visita_compartilhada, flag_cadastramento, flag_visita_periodica" +
                ", flag_consulta, flag_exame, flag_vacina, flag_bolsa_familia, flag_gestante, flag_puerpera, flag_recem_nascido, flag_crianca, flag_desnutricao " +
                ", flag_reabilitacao, flag_hipertensao, flag_diabetes, flag_asma, flag_enfisema, flag_doencas_cronicas, flag_hanseniase, flag_tuberculose " +
                ", flag_sintomaticos_respiratorios, flag_tabagista, flag_acamado, flag_vulnerabilidade_social, flag_acompanhamento_bolsa_familia, flag_saude_mental, flag_usuario_alcool " +
                ", flag_outras_drogas, flag_acao_educativa, flag_imovel_com_foco, flag_acao_mecanica, flag_tratamento_focal, flag_egresso_internacao, flag_convite, flag_orientacao " +
                ", flag_outros, peso, altura, desfecho, flag_ativo, flag_exportado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        db.execSQL(query, args);
    }

    public void excluir(FichaVisitaDTModel fichaVisitaDTModel) {

        Object[] args = {Boolean.FALSE, fichaVisitaDTModel.getId()};

        db.execSQL("UPDATE ficha_visita_domiciliar_territorial SET flag_ativo = ? where id = ? ", args);

    }

    public List<FichaVisitaDTModel> pesquisar() {

        List<FichaVisitaDTModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM ficha_visita_domiciliar_territorial order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaVisitaDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaVisitaDTModel> pesquisarAtivos() {

        List<FichaVisitaDTModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT id, data_registro, prontuario, cns_cidadao FROM ficha_visita_domiciliar_territorial where flag_ativo = 1 order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaVisitaDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaVisitaDTModel> pesquisarAtivos(String query) {

        List<FichaVisitaDTModel> fichas = new ArrayList<>();

        String s = "%" + query + "%";

        String[] args = {s,s,s};

        Cursor c = db.rawQuery("SELECT id, data_registro, prontuario, cns_cidadao FROM ficha_visita_domiciliar_territorial where flag_ativo = 1 and (prontuario like ? or strftime( '%d/%m/%Y', data_registro) like ? or cns_cidadao like ?) order by id;", args);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaVisitaDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public FichaVisitaDTModel obter(FichaVisitaDTModel fichaVisitaDTModel) {

        String[] args = {fichaVisitaDTModel.getId().toString()};

        Cursor c = db.rawQuery("SELECT * FROM ficha_visita_domiciliar_territorial where id = ?;", args);

        if (c.moveToFirst()) {
            return getFichaVisitaDTModelInstance(c);
        }
        c.close();

        return null;

    }

    private FichaVisitaDTModel getFichaVisitaDTPesquisaModelInstance(Cursor c) {

        FichaVisitaDTModel fichaModel = new FichaVisitaDTModel();
        fichaModel.setId(c.getLong(c.getColumnIndex("id")));
        fichaModel.setDataRegistro(Utilitario.getDate(c.getString(c.getColumnIndex("data_registro"))));
        fichaModel.setProntuario(c.getString(c.getColumnIndex("prontuario")));
        fichaModel.setCnsCidadao(c.getString(c.getColumnIndex("cns_cidadao")));

        return fichaModel;
    }

    private FichaVisitaDTModel getFichaVisitaDTModelInstance(Cursor c) {

        FichaVisitaDTModel fichaModel = new FichaVisitaDTModel();
        fichaModel.setId(c.getLong(c.getColumnIndex("id")));
        fichaModel.setProfissionalModel(new ProfissionalModel(c.getLong(c.getColumnIndex("profissional_id"))));
        fichaModel.setDataRegistro(Utilitario.getDate(c.getString(c.getColumnIndex("data_registro"))));
        fichaModel.setTurno(c.getString(c.getColumnIndex("turno")));
        fichaModel.setMicroArea(c.getString(c.getColumnIndex("microarea")));
        fichaModel.setTipoImovelModel(new TipoImovelModel(c.getString(c.getColumnIndex("tipo_imovel"))));
        fichaModel.setProntuario(c.getString(c.getColumnIndex("prontuario")));
        fichaModel.setCnsCidadao(c.getString(c.getColumnIndex("cns_cidadao")));
        fichaModel.setDataNascimento(Utilitario.getDate(c.getString(c.getColumnIndex("data_nascimento"))));
        fichaModel.setSexo(c.getString(c.getColumnIndex("sexo")));
        fichaModel.setFlagVisitaCompartilhada(c.getInt(c.getColumnIndex("flag_visita_compartilhada")) > 0);
        fichaModel.setFlagCadastramento(c.getInt(c.getColumnIndex("flag_cadastramento")) > 0);
        fichaModel.setFlagVisitaPeriodica(c.getInt(c.getColumnIndex("flag_visita_periodica")) > 0);
        fichaModel.setFlagConsulta(c.getInt(c.getColumnIndex("flag_consulta")) > 0);
        fichaModel.setFlagExame(c.getInt(c.getColumnIndex("flag_exame")) > 0);
        fichaModel.setFlagVacina(c.getInt(c.getColumnIndex("flag_vacina")) > 0);
        fichaModel.setFlagBolsaFamilia(c.getInt(c.getColumnIndex("flag_bolsa_familia")) > 0);
        fichaModel.setFlagGestante(c.getInt(c.getColumnIndex("flag_gestante")) > 0);
        fichaModel.setFlagPuerpera(c.getInt(c.getColumnIndex("flag_puerpera")) > 0);
        fichaModel.setFlagRecemNascido(c.getInt(c.getColumnIndex("flag_recem_nascido")) > 0);
        fichaModel.setFlagCrianca(c.getInt(c.getColumnIndex("flag_crianca")) > 0);
        fichaModel.setFlagDesnutricao(c.getInt(c.getColumnIndex("flag_desnutricao")) > 0);
        fichaModel.setFlagReabilitacao(c.getInt(c.getColumnIndex("flag_reabilitacao")) > 0);
        fichaModel.setFlagHipertensao(c.getInt(c.getColumnIndex("flag_hipertensao")) > 0);
        fichaModel.setFlagDiabetes(c.getInt(c.getColumnIndex("flag_diabetes")) > 0);
        fichaModel.setFlagAsma(c.getInt(c.getColumnIndex("flag_asma")) > 0);
        fichaModel.setFlagEnfisema(c.getInt(c.getColumnIndex("flag_enfisema")) > 0);
        fichaModel.setFlagCancer(c.getInt(c.getColumnIndex("flag_cancer")) > 0);
        fichaModel.setFlagDoencasCronicas(c.getInt(c.getColumnIndex("flag_doencas_cronicas")) > 0);
        fichaModel.setFlagHanseniase(c.getInt(c.getColumnIndex("flag_hanseniase")) > 0);
        fichaModel.setFlagTuberculose(c.getInt(c.getColumnIndex("flag_tuberculose")) > 0);
        fichaModel.setFlagSintomaticosRespiratorios(c.getInt(c.getColumnIndex("flag_sintomaticos_respiratorios")) > 0);
        fichaModel.setFlagTabagista(c.getInt(c.getColumnIndex("flag_tabagista")) > 0);
        fichaModel.setFlagAcamado(c.getInt(c.getColumnIndex("flag_acamado")) > 0);
        fichaModel.setFlagVunerabilidadeSocial(c.getInt(c.getColumnIndex("flag_vulnerabilidade_social")) > 0);
        fichaModel.setFlagAcompanhamentoBolsaFamilia(c.getInt(c.getColumnIndex("flag_acompanhamento_bolsa_familia")) > 0);
        fichaModel.setFlagSaudeMental(c.getInt(c.getColumnIndex("flag_saude_mental")) > 0);
        fichaModel.setFlagUsuarioAlcool(c.getInt(c.getColumnIndex("flag_usuario_alcool")) > 0);
        fichaModel.setFlagOutrasDrogas(c.getInt(c.getColumnIndex("flag_outras_drogas")) > 0);
        fichaModel.setFlagAcaoEducativa(c.getInt(c.getColumnIndex("flag_acao_educativa")) > 0);
        fichaModel.setFlagImovelComFoco(c.getInt(c.getColumnIndex("flag_imovel_com_foco")) > 0);
        fichaModel.setFlagAcaoMecanica(c.getInt(c.getColumnIndex("flag_acao_mecanica")) > 0);
        fichaModel.setFlagTratamentoFocal(c.getInt(c.getColumnIndex("flag_tratamento_focal")) > 0);
        fichaModel.setFlagEgressoInternacao(c.getInt(c.getColumnIndex("flag_egresso_internacao")) > 0);
        fichaModel.setFlagConvite(c.getInt(c.getColumnIndex("flag_convite")) > 0);
        fichaModel.setFlagOrientacao(c.getInt(c.getColumnIndex("flag_orientacao")) > 0);
        fichaModel.setFlagOutros(c.getInt(c.getColumnIndex("flag_outros")) > 0);
        fichaModel.setPeso(c.getDouble(c.getColumnIndex("peso")));
        fichaModel.setAltura(c.getInt(c.getColumnIndex("altura")));
        fichaModel.setDesfecho(c.getInt(c.getColumnIndex("desfecho")));
        fichaModel.setFlagAtivo(c.getInt(c.getColumnIndex("flag_ativo")) > 0);
        fichaModel.setFlagExportado(c.getInt(c.getColumnIndex("flag_exportado")) > 0);

        return fichaModel;


    }


}
