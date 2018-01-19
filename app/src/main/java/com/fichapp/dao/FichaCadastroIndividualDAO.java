package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaCadastroIndividualModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.List;

public class FichaCadastroIndividualDAO {

    SQLiteDatabase db;

    public FichaCadastroIndividualDAO() {}

    public FichaCadastroIndividualDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
    }

    //INSERIR
    public void inserir(FichaCadastroIndividualModel fichaModel) {

        Object[] args = {

                fichaModel.getProfissionalModel().getId(),
                fichaModel.getCnesModel().getId(),

                fichaModel.getDataRegistro(),
                fichaModel.getTurno(),

                fichaModel.getCnsCidadao(),
                fichaModel.getFlagResponsavelFamiliar(),
                fichaModel.getCnsResponsavelFamiliar(),
                fichaModel.getMicroarea(),
                fichaModel.getFlagForaDeArea(),
                fichaModel.getNomeCompleto(),
                fichaModel.getNomeSocial(),
                fichaModel.getDataNascimento(),
                fichaModel.getSexo(),
                fichaModel.getRaca(),
                fichaModel.getEtnia(),
                fichaModel.getNis(),

                fichaModel.getNomeMae(),
                fichaModel.getFlagMaeDesconhecido(),
                fichaModel.getNomePai(),
                fichaModel.getFlagPaiDesconhecido(),

                fichaModel.getNascimento(),
                fichaModel.getPaisNascimento(),
                fichaModel.getMunicipioUfNascimento(),
                fichaModel.getPortariaNaturalizacao(),
                fichaModel.getDataNaturalizacao(),
                fichaModel.getDataEntrada(),

                fichaModel.getTelefoneCelular(),
                fichaModel.getEmailCidadao(),

                fichaModel.getParentescoResponsavelFamiliar(),
                fichaModel.getOcupacao(),
                fichaModel.getFlagFrequentaEscola(),
                fichaModel.getCursoMaisElevado(),
                fichaModel.getSituacaoMercado(),

                fichaModel.getFlagFicaComAdultoResponsavel(),
                fichaModel.getFlagFicaComOutrasCriancas(),
                fichaModel.getFlagFicaComAdolescente(),
                fichaModel.getFlagFicaEmCreche(),
                fichaModel.getFlagFicaSozinha(),
                fichaModel.getFlagFicaOutro(),

                fichaModel.getFlagFrequentaCuidador(),
                fichaModel.getFlagParticipaGrupoComunitario(),
                fichaModel.getFlagPossuiPlanoDeSaude(),
                fichaModel.getFlagMembroDeComunidade(),
                fichaModel.getQualComunidade(),

                fichaModel.getFlagInformarOrientacao(),
                fichaModel.getOrientacaoSexual(),
                fichaModel.getFlagInformarIdentidadeGenero(),
                fichaModel.getIdentidadeGenero(),

                fichaModel.getFlagDeficiencia(),
                fichaModel.getFlagDeficienciaAuditiva(),
                fichaModel.getFlagDeficienciaVisual(),
                fichaModel.getFlagDeficienciaIntelectual(),
                fichaModel.getFlagDeficienciaFisica(),
                fichaModel.getFlagOutraDeficiencia(),

                fichaModel.getSaidaCadastro(),
                fichaModel.getNumeroDO(),
                fichaModel.getDataObito(),

                fichaModel.getFlagGestante(),
                fichaModel.getQualMaternidade(),
                fichaModel.getPeso(),

                fichaModel.getFlagFumante(),
                fichaModel.getFlagAlcool(),
                fichaModel.getFlagOutrasDrogas(),
                fichaModel.getFlagHipertensao(),
                fichaModel.getFlagDiabetes(),
                fichaModel.getFlagAvcDerrame(),
                fichaModel.getFlagInfarto(),

                fichaModel.getFlagDoencaCardiaca(),
                fichaModel.getFlagInsuficienciaCardiaca(),
                fichaModel.getFlagOutraDoencaCardiaca(),
                fichaModel.getFlagNaoSabeDoencaCardiaca(),

                fichaModel.getFlagProblemaRins(),
                fichaModel.getFlagInsuficienciaRenal(),
                fichaModel.getFlagOutroProblemaRins(),
                fichaModel.getFlagNaoSabeProblemaRins(),

                fichaModel.getFlagDoencaRespiratoria(),
                fichaModel.getFlagAsma(),
                fichaModel.getFlagEnfisema(),
                fichaModel.getFlagOutraDoencaRespiratoria(),
                fichaModel.getFlagNaoSabeDoencaRespiratoria(),

                fichaModel.getFlagHanseniase(),
                fichaModel.getFlagTuberculose(),
                fichaModel.getFlagCancer(),
                fichaModel.getFlagInternado(),
                fichaModel.getQualMotivoInternamento(),
                fichaModel.getFlagProblemaMental(),
                fichaModel.getFlagAcamado(),
                fichaModel.getFlagDomiciliado(),
                fichaModel.getFlagPlantasMedicinais(),
                fichaModel.getQuaisPlantas(),
                fichaModel.getFlagOutrasPraticasIntegrativas(),
                fichaModel.getOutrasCondicoesSaude(),

                fichaModel.getFlagSituacaoRua(),
                fichaModel.getTempoSituacaoRua(),
                fichaModel.getFlagRecebeBeneficio(),
                fichaModel.getFlagReferenciaFamiliar(),

                fichaModel.getFrequenciaAlimentacao(),
                fichaModel.getFlagAlimentacaoRestaurantePopular(),
                fichaModel.getFlagAlimentacaoDoacaoGrupoReligioso(),
                fichaModel.getFlagAlimentacaoDoacaoRestaurante(),
                fichaModel.getFlagAlimentacaoDoacaoPopular(),
                fichaModel.getFlagAlimentacaoOutras(),

                fichaModel.getFlagAcompanhadoInstituicao(),
                fichaModel.getQualInstituicao(),
                fichaModel.getFlagVisitaFamiliar(),
                fichaModel.getGrauParentesco(),

                fichaModel.getFlagAcessoHigienePessoal(),
                fichaModel.getFlagAcessoBanho(),
                fichaModel.getFlagAcessoSanitario(),
                fichaModel.getFlagAcessoHigieneBucal(),
                fichaModel.getFlagAcessoOutras(),

                Boolean.TRUE,
                Boolean.FALSE };

        String query = "insert into ficha_cadastro_individual" +
                " (profissional_id, cnes_id" +
                ", data_registro, turno" +
                ", cns_cidadao, flag_responsavel_familiar, cns_responsavel_familiar, microarea, flag_fora_de_area, nome_completo, nome_social, data_nascimento, sexo, raca, etnia, nis" +
                ", nome_mae, flag_mae_desconhecido, nome_pai, flag_pai_desconhecido" +
                ", nascimento, pais_nascimento, municipio_uf_nascimento, portaria_naturalizacao, data_naturalizacao, data_entrada" +
                ", telefone_celular, email_cidadao" +
                ", parentesco_responsavel_familiar, ocupacao, flag_frequenta_escola, curso_mais_elevado, situacao_mercado" +
                ", flag_fica_com_adulto_responsavel, flag_fica_com_outras_criancas, flag_fica_com_adolescente, flag_fica_em_creche, flag_fica_sozinha, flag_fica_outro" +
                ", flag_frequenta_cuidador, flag_participa_grupo_comunitario, flag_possui_plano_de_saude, flag_membro_de_comunidade, qual_comunidade" +
                ", flag_informar_orientacao, orientacao_sexual, flag_informar_identidade_genero, identidade_genero" +
                ", flag_deficiencia, flag_deficiencia_auditiva, flag_deficiencia_visual, flag_deficiencia_intelectual, flag_deficiencia_fisica, flag_outra_deficiencia" +
                ", saida_cadastro, numero_do, data_obito" +
                ", flag_gestante, qual_maternidade, peso" +
                ", flag_fumante, flag_alcool, flag_outras_drogas, flag_hipertensao, flag_diabetes, flag_avc_derrame, flag_infarto" +
                ", flag_doenca_cardiaca, flag_insuficiencia_cardiaca, flag_outra_doenca_cardiaca, flag_nao_sabe_doenca_cardiaca" +
                ", flag_problema_rins, flag_insuficiencia_renal, outro_problema_rins, flag_nao_sabe_problema_rins" +
                ", flag_doenca_respiratoria, flag_asma, flag_enfisema, flag_outra_doenca_respiratoria, flag_nao_sabe_doenca_respiratoria" +
                ", flag_hanseniase, flag_tuberculose, flag_cancer, flag_internado, qual_motivo_internamento, flag_problema_mental, flag_acamado, flag_domiciliado, flag_plantas_medicinais, quais_plantas, outras_praticas_integrativas, outras_condicoes_saude" +
                ", flag_situacao_rua, tempo_situacao_rua, flag_recebe_beneficio, flag_referencia_familiar" +
                ", frequencia_alimentacao, flag_alimentacao_restaurante_popular, flag_alimentacao_doacao_grupo_religioso, flag_alimentacao_doacao_restaurante, flag_alimentacao_doacao_popular, flag_alimentacao_outras" +
                ", flag_acompanhado_instituicao, qual_instituicao, flag_visita_familiar, grau_parentesco" +
                ", flag_acesso_higiene_pessoal, flag_acesso_banho, flag_acesso_sanitario, flag_acesso_higiene_bucal, flag_acesso_outras" +
                ", flag_ativo, flag_exportado" +
                ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        db.execSQL(query, args);

    }

    //ALTERAR
    public void alterar (FichaCadastroIndividualModel fichaModel) {

        Object[] args = {

                fichaModel.getProfissionalModel().getId(),
                fichaModel.getCnesModel().getId(),

                fichaModel.getDataRegistro(),
                fichaModel.getTurno(),

                fichaModel.getCnsCidadao(),
                fichaModel.getFlagResponsavelFamiliar(),
                fichaModel.getCnsResponsavelFamiliar(),
                fichaModel.getMicroarea(),
                fichaModel.getFlagForaDeArea(),
                fichaModel.getNomeCompleto(),
                fichaModel.getNomeSocial(),
                fichaModel.getDataNascimento(),
                fichaModel.getSexo(),
                fichaModel.getRaca(),
                fichaModel.getEtnia(),
                fichaModel.getNis(),

                fichaModel.getNomeMae(),
                fichaModel.getFlagMaeDesconhecido(),
                fichaModel.getNomePai(),
                fichaModel.getFlagPaiDesconhecido(),

                fichaModel.getNascimento(),
                fichaModel.getPaisNascimento(),
                fichaModel.getMunicipioUfNascimento(),
                fichaModel.getPortariaNaturalizacao(),
                fichaModel.getDataNaturalizacao(),
                fichaModel.getDataEntrada(),

                fichaModel.getTelefoneCelular(),
                fichaModel.getEmailCidadao(),

                fichaModel.getParentescoResponsavelFamiliar(),
                fichaModel.getOcupacao(),
                fichaModel.getFlagFrequentaEscola(),
                fichaModel.getCursoMaisElevado(),
                fichaModel.getSituacaoMercado(),

                fichaModel.getFlagFicaComAdultoResponsavel(),
                fichaModel.getFlagFicaComOutrasCriancas(),
                fichaModel.getFlagFicaComAdolescente(),
                fichaModel.getFlagFicaEmCreche(),
                fichaModel.getFlagFicaSozinha(),
                fichaModel.getFlagFicaOutro(),

                fichaModel.getFlagFrequentaCuidador(),
                fichaModel.getFlagParticipaGrupoComunitario(),
                fichaModel.getFlagPossuiPlanoDeSaude(),
                fichaModel.getFlagMembroDeComunidade(),
                fichaModel.getQualComunidade(),

                fichaModel.getFlagInformarOrientacao(),
                fichaModel.getOrientacaoSexual(),
                fichaModel.getFlagInformarIdentidadeGenero(),
                fichaModel.getIdentidadeGenero(),

                fichaModel.getFlagDeficiencia(),
                fichaModel.getFlagDeficienciaAuditiva(),
                fichaModel.getFlagDeficienciaVisual(),
                fichaModel.getFlagDeficienciaIntelectual(),
                fichaModel.getFlagDeficienciaFisica(),
                fichaModel.getFlagOutraDeficiencia(),

                fichaModel.getSaidaCadastro(),
                fichaModel.getNumeroDO(),
                fichaModel.getDataObito(),

                fichaModel.getFlagGestante(),
                fichaModel.getQualMaternidade(),
                fichaModel.getPeso(),

                fichaModel.getFlagFumante(),
                fichaModel.getFlagAlcool(),
                fichaModel.getFlagOutrasDrogas(),
                fichaModel.getFlagHipertensao(),
                fichaModel.getFlagDiabetes(),
                fichaModel.getFlagAvcDerrame(),
                fichaModel.getFlagInfarto(),

                fichaModel.getFlagDoencaCardiaca(),
                fichaModel.getFlagInsuficienciaCardiaca(),
                fichaModel.getFlagOutraDoencaCardiaca(),
                fichaModel.getFlagNaoSabeDoencaCardiaca(),

                fichaModel.getFlagProblemaRins(),
                fichaModel.getFlagInsuficienciaRenal(),
                fichaModel.getFlagOutroProblemaRins(),
                fichaModel.getFlagNaoSabeProblemaRins(),

                fichaModel.getFlagDoencaRespiratoria(),
                fichaModel.getFlagAsma(),
                fichaModel.getFlagEnfisema(),
                fichaModel.getFlagOutraDoencaRespiratoria(),
                fichaModel.getFlagNaoSabeDoencaRespiratoria(),

                fichaModel.getFlagHanseniase(),
                fichaModel.getFlagTuberculose(),
                fichaModel.getFlagCancer(),
                fichaModel.getFlagInternado(),
                fichaModel.getQualMotivoInternamento(),
                fichaModel.getFlagProblemaMental(),
                fichaModel.getFlagAcamado(),
                fichaModel.getFlagDomiciliado(),
                fichaModel.getFlagPlantasMedicinais(),
                fichaModel.getQuaisPlantas(),
                fichaModel.getFlagOutrasPraticasIntegrativas(),
                fichaModel.getOutrasCondicoesSaude(),

                fichaModel.getFlagSituacaoRua(),
                fichaModel.getTempoSituacaoRua(),
                fichaModel.getFlagRecebeBeneficio(),
                fichaModel.getFlagReferenciaFamiliar(),

                fichaModel.getFrequenciaAlimentacao(),
                fichaModel.getFlagAlimentacaoRestaurantePopular(),
                fichaModel.getFlagAlimentacaoDoacaoGrupoReligioso(),
                fichaModel.getFlagAlimentacaoDoacaoRestaurante(),
                fichaModel.getFlagAlimentacaoDoacaoPopular(),
                fichaModel.getFlagAlimentacaoOutras(),

                fichaModel.getFlagAcompanhadoInstituicao(),
                fichaModel.getQualInstituicao(),
                fichaModel.getFlagVisitaFamiliar(),
                fichaModel.getGrauParentesco(),

                fichaModel.getFlagAcessoHigienePessoal(),
                fichaModel.getFlagAcessoBanho(),
                fichaModel.getFlagAcessoSanitario(),
                fichaModel.getFlagAcessoHigieneBucal(),
                fichaModel.getFlagAcessoOutras(),

                fichaModel.getFlagAtivo(),
                fichaModel.getFlagExportado(),
                fichaModel.getId() };


        String query = "update ficha_cadastro_individual set profissional_id = ?, cnes_id = ?" +
                ",  data_registro = ?, turno = ?" +
                ",  cns_cidadao = ?, flag_responsavel_familiar = ?, cns_responsavel_familiar = ?, microarea = ?, flag_fora_de_area = ?, nome_completo = ?, nome_social = ?, data_nascimento = ?, sexo = ?, raca = ?, etnia = ?, nis = ?" +
                ",  nome_mae = ?, flag_mae_desconhecido = ?, nome_pai = ?, flag_pai_desconhecido = ?" +
                ",  nascimento = ?, pais_nascimento = ?, municipio_uf_nascimento = ?, portaria_naturalizacao = ?, data_naturalizacao = ?, data_entrada = ?" +
                ",  telefone_celular = ?, email_cidadao = ?" +
                ",  parentesco_responsavel_familiar = ?, ocupacao = ?, flag_frequenta_escola = ?, curso_mais_elevado = ?, situacao_mercado = ?" +
                ",  flag_fica_com_adulto_responsavel = ?, flag_fica_com_outras_criancas = ?, flag_fica_com_adolescente = ?, flag_fica_em_creche = ?, flag_fica_sozinha = ?, flag_fica_outro = ?" +
                ",  flag_frequenta_cuidador = ?, flag_participa_grupo_comunitario = ?, flag_possui_plano_de_saude = ?, flag_membro_de_comunidade = ?, qual_comunidade = ?" +
                ",  flag_informar_orientacao = ?, orientacao_sexual = ?, flag_informar_identidade_genero = ?, identidade_genero = ?" +
                ",  flag_deficiencia = ?, flag_deficiencia_auditiva = ?, flag_deficiencia_visual = ?, flag_deficiencia_intelectual = ?, flag_deficiencia_fisica = ?, flag_outra_deficiencia = ?" +
                ",  saida_cadastro = ?, numero_do = ?, data_obito = ?" +
                ",  flag_gestante = ?, qual_maternidade = ?, peso = ?" +
                ",  flag_fumante = ?, flag_alcool = ?, flag_outras_drogas = ?, flag_hipertensao = ?, flag_diabetes = ?, flag_avc_derrame = ?, flag_infarto = ?" +
                ",  flag_doenca_cardiaca = ?, flag_insuficiencia_cardiaca = ?, flag_outra_doenca_cardiaca = ?, flag_nao_sabe_doenca_cardiaca = ?" +
                ",  flag_problema_rins = ?, flag_insuficiencia_renal = ?, outro_problema_rins = ?, flag_nao_sabe_problema_rins = ?" +
                ",  flag_doenca_respiratoria = ?, flag_asma = ?, flag_enfisema = ?, flag_outra_doenca_respiratoria = ?, flag_nao_sabe_doenca_respiratoria = ?" +
                ",  flag_hanseniase = ?, flag_tuberculose = ?, flag_cancer = ?, flag_internado = ?, qual_motivo_internamento = ?, flag_problema_mental = ?, flag_acamado = ?, flag_domiciliado = ?, flag_plantas_medicinais = ?, quais_plantas = ?, outras_praticas_integrativas = ?, outras_condicoes_saude = ?" +
                ",  flag_situacao_rua = ?, tempo_situacao_rua = ?, flag_recebe_beneficio = ?, flag_referencia_familiar = ?" +
                ",  frequencia_alimentacao = ?, flag_alimentacao_restaurante_popular = ?, flag_alimentacao_doacao_grupo_religioso = ?, flag_alimentacao_doacao_restaurante = ?, flag_alimentacao_doacao_popular = ?, flag_alimentacao_outras = ?" +
                ",  flag_acompanhado_instituicao = ?, qual_instituicao = ?, flag_visita_familiar = ?, grau_parentesco = ?" +
                ",  flag_acesso_higiene_pessoal = ?, flag_acesso_banho = ?, flag_acesso_sanitario = ?, flag_acesso_higiene_bucal = ?, flag_acesso_outras = ?" +
                ",  flag_ativo = ?, flag_exportado = ? where id = ?";

        db.execSQL(query, args);

    }


    public void excluir(FichaCadastroIndividualModel fichaCadastroIndividualModel) {

        Object[] args = {Boolean.FALSE, fichaCadastroIndividualModel.getId()};

        db.execSQL("UPDATE ficha_cadastro_individual SET flag_ativo = ? where id = ? ", args);

    }

    public List<FichaCadastroIndividualModel> pesquisar() {

        List<FichaCadastroIndividualModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_individual order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroIndividualPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaCadastroIndividualModel> pesquisarAtivos() {

        List<FichaCadastroIndividualModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT id, data_registro, nome_completo, cns_cidadao FROM ficha_cadastro_individual where flag_ativo = 1 order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroIndividualPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaCadastroIndividualModel> pesquisarAtivos(String query) {

        List<FichaCadastroIndividualModel> fichas = new ArrayList<>();

        String s = "%" + query + "%";

        String[] args = {s,s,s};

        Cursor c = db.rawQuery("SELECT id, data_registro, nome_completo, cns_cidadao FROM ficha_cadastro_individual where flag_ativo = 1 and (nome_completo like ? or strftime( '%d/%m/%Y', data_registro) like ? or cns_cidadao like ?) order by id;", args);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroIndividualPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public FichaCadastroIndividualModel obter(FichaCadastroIndividualModel fichaCadastroIndividualModel) {

        String[] args = {fichaCadastroIndividualModel.getId().toString()};

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_individual where id = ?;", args);

        if (c.moveToFirst()) {
            return getFichaCadastroIndividualModelInstance(c);
        }
        c.close();

        return null;

    }

    private FichaCadastroIndividualModel getFichaCadastroIndividualPesquisaModelInstance(Cursor c) {

        FichaCadastroIndividualModel fichaModel = new FichaCadastroIndividualModel();
        fichaModel.setId(c.getLong(c.getColumnIndex("id")));
        fichaModel.setDataRegistro(Utilitario.getDataFormatada(c.getString(c.getColumnIndex("data_registro"))));
        fichaModel.setNomeCompleto(c.getString(c.getColumnIndex("nome_completo")));
        fichaModel.setCnsCidadao(c.getString(c.getColumnIndex("cns_cidadao")));


        return fichaModel;
    }

    private FichaCadastroIndividualModel getFichaCadastroIndividualModelInstance(Cursor c) {

        FichaCadastroIndividualModel fichaModel = new FichaCadastroIndividualModel();
        fichaModel.setId(c.getLong(c.getColumnIndex("id")));
        fichaModel.setProfissionalModel(new ProfissionalModel(c.getLong(c.getColumnIndex("profissional_id"))));
        fichaModel.setCnesModel(new CNESModel(c.getLong(c.getColumnIndex("cnes_id"))));

        fichaModel.setDataRegistro(Utilitario.getDataFormatada(c.getString(c.getColumnIndex("data_registro"))));
        fichaModel.setTurno(c.getString(c.getColumnIndex("turno")));

        fichaModel.setCnsCidadao(c.getString(c.getColumnIndex("cns_cidadao")));
        fichaModel.setFlagResponsavelFamiliar(c.getInt(c.getColumnIndex("flag_responsavel_familiar")) < 1);
        fichaModel.setCnsResponsavelFamiliar(c.getString(c.getColumnIndex("cns_responsavel_familiar")));
        fichaModel.setMicroarea(c.getString(c.getColumnIndex("microarea")));
        fichaModel.setFlagForaDeArea(c.getInt(c.getColumnIndex("flag_fora_de_area")) > 0);
        fichaModel.setNomeCompleto(c.getString(c.getColumnIndex("nome_completo")));
        fichaModel.setNomeSocial(c.getString(c.getColumnIndex("nome_social")));
        fichaModel.setDataNascimento(Utilitario.getDataFormatada(c.getString(c.getColumnIndex("data_nascimento"))));
        fichaModel.setSexo(c.getInt(c.getColumnIndex("sexo")));
        fichaModel.setRaca(c.getInt(c.getColumnIndex("raca")));
        fichaModel.setEtnia(c.getString(c.getColumnIndex("etnia")));
        fichaModel.setNis(c.getString(c.getColumnIndex("nis")));

        fichaModel.setNomeMae(c.getString(c.getColumnIndex("nome_mae")));
        fichaModel.setFlagMaeDesconhecido(c.getInt(c.getColumnIndex("flag_mae_desconhecido")) > 0);
        fichaModel.setNomePai(c.getString(c.getColumnIndex("nome_pai")));
        fichaModel.setFlagPaiDesconhecido(c.getInt(c.getColumnIndex("flag_pai_desconhecido")) > 0);

        fichaModel.setNascimento(c.getInt(c.getColumnIndex("nascimento")));
        fichaModel.setPaisNascimento(c.getString(c.getColumnIndex("pais_nascimento")));
        fichaModel.setMunicipioUfNascimento(c.getString(c.getColumnIndex("municipio_uf_nascimento")));
        fichaModel.setPortariaNaturalizacao(c.getString(c.getColumnIndex("portaria_naturalizacao")));
        fichaModel.setDataNaturalizacao(Utilitario.getDataFormatada(c.getString(c.getColumnIndex("data_naturalizacao"))));
        fichaModel.setDataEntrada(Utilitario.getDataFormatada(c.getString(c.getColumnIndex("data_entrada"))));

        fichaModel.setTelefoneCelular(c.getString(c.getColumnIndex("telefone_celular")));
        fichaModel.setEmailCidadao(c.getString(c.getColumnIndex("email_cidadao")));

        fichaModel.setParentescoResponsavelFamiliar(c.getInt(c.getColumnIndex("parentesco_responsavel_familiar")));
        fichaModel.setOcupacao(c.getString(c.getColumnIndex("ocupacao")));
        fichaModel.setFlagFrequentaEscola(c.getInt(c.getColumnIndex("flag_frequenta_escola")) < 1);
        fichaModel.setCursoMaisElevado(c.getInt(c.getColumnIndex("curso_mais_elevado")));
        fichaModel.setSituacaoMercado(c.getInt(c.getColumnIndex("situacao_mercado")));

        fichaModel.setFlagFicaComAdultoResponsavel(c.getInt(c.getColumnIndex("flag_fica_com_adulto_responsavel")) > 0);
        fichaModel.setFlagFicaComOutrasCriancas(c.getInt(c.getColumnIndex("flag_fica_com_outras_criancas")) > 0);
        fichaModel.setFlagFicaComAdolescente(c.getInt(c.getColumnIndex("flag_fica_com_addolescente")) > 0);
        fichaModel.setFlagFicaEmCreche(c.getInt(c.getColumnIndex("flag_fica_em_creche")) > 0);
        fichaModel.setFlagFicaSozinha(c.getInt(c.getColumnIndex("flag_fica_sozinha")) > 0);
        fichaModel.setFlagFicaOutro(c.getInt(c.getColumnIndex("flag_fica_outro")) > 0);

        fichaModel.setFlagFrequentaCuidador(c.getInt(c.getColumnIndex("flag_frequenta_cuidador")) < 1);
        fichaModel.setFlagParticipaGrupoComunitario(c.getInt(c.getColumnIndex("flag_participa_grupo_comunitario")) < 1);
        fichaModel.setFlagPossuiPlanoDeSaude(c.getInt(c.getColumnIndex("flag_possui_plano_de_saude")) < 1);
        fichaModel.setFlagMembroDeComunidade(c.getInt(c.getColumnIndex("flag_membro_de_comunidade")) < 1);
        fichaModel.setQualComunidade(c.getString(c.getColumnIndex("qual_comunidade")));

        fichaModel.setFlagInformarOrientacao(c.getInt(c.getColumnIndex("flag_informar_orientacao")) < 1);
        fichaModel.setOrientacaoSexual(c.getInt(c.getColumnIndex("orientacao_sexual")));
        fichaModel.setFlagInformarIdentidadeGenero(c.getInt(c.getColumnIndex("flag_informar_identidade_genero")) < 1);
        fichaModel.setIdentidadeGenero(c.getInt(c.getColumnIndex("identidade_genero")));

        fichaModel.setFlagDeficiencia(c.getInt(c.getColumnIndex("flag_deficiencia")) < 1);
        fichaModel.setFlagDeficienciaAuditiva(c.getInt(c.getColumnIndex("flag_deficiencia_auditiva")) > 0);
        fichaModel.setFlagDeficienciaVisual(c.getInt(c.getColumnIndex("flag_deficiencia_visual")) > 0);
        fichaModel.setFlagDeficienciaIntelectual(c.getInt(c.getColumnIndex("flag_deficiencia_intelectual")) > 0);
        fichaModel.setFlagDeficienciaFisica(c.getInt(c.getColumnIndex("flag_deficiencia_fisica")) > 0);
        fichaModel.setFlagOutraDeficiencia(c.getInt(c.getColumnIndex("flag_outra_deficiencia")) > 0);

        fichaModel.setSaidaCadastro(c.getInt(c.getColumnIndex("saida_cadastro")));
        fichaModel.setNumeroDO(c.getString(c.getColumnIndex("numero_do")));
        fichaModel.setDataObito(Utilitario.getDataFormatada(c.getString(c.getColumnIndex("data_obito"))));

        fichaModel.setFlagGestante(c.getInt(c.getColumnIndex("flag_gestante")) < 1);
        fichaModel.setQualMaternidade(c.getString(c.getColumnIndex("qual_maternidade")));
        fichaModel.setPeso(c.getInt(c.getColumnIndex("peso")));

        fichaModel.setFlagFumante(c.getInt(c.getColumnIndex("flag_fumante")) < 1);
        fichaModel.setFlagAlcool(c.getInt(c.getColumnIndex("flag_alcool")) < 1);
        fichaModel.setFlagOutrasDrogas(c.getInt(c.getColumnIndex("flag_outras_drogas")) < 1);
        fichaModel.setFlagHipertensao(c.getInt(c.getColumnIndex("flag_hipertensao")) < 1);
        fichaModel.setFlagDiabetes(c.getInt(c.getColumnIndex("flag_diabetes")) < 1);
        fichaModel.setFlagAvcDerrame(c.getInt(c.getColumnIndex("flag_avc_derrame")) < 1);
        fichaModel.setFlagInfarto(c.getInt(c.getColumnIndex("flag_infarto")) < 1);

        fichaModel.setFlagDoencaCardiaca(c.getInt(c.getColumnIndex("flag_doenca_cardiaca")) < 1);
        fichaModel.setFlagInsuficienciaCardiaca(c.getInt(c.getColumnIndex("flag_insuficiencia_cardiaca")) > 0);
        fichaModel.setFlagOutraDoencaCardiaca(c.getInt(c.getColumnIndex("flag_outra_doenca_cardiaca")) > 0);
        fichaModel.setFlagNaoSabeDoencaCardiaca(c.getInt(c.getColumnIndex("flag_nao_sabe_doenca_cardiaca")) > 0);

        fichaModel.setFlagProblemaRins(c.getInt(c.getColumnIndex("flag_problema_rins")) < 1);
        fichaModel.setFlagInsuficienciaRenal(c.getInt(c.getColumnIndex("flag_insuficiencia_renal")) > 0);
        fichaModel.setFlagOutroProblemaRins(c.getInt(c.getColumnIndex("flag_outro_problema_rins")) > 0);
        fichaModel.setFlagNaoSabeProblemaRins(c.getInt(c.getColumnIndex("flag_nao_sabe_problema_rins")) > 0);

        fichaModel.setFlagDoencaRespiratoria(c.getInt(c.getColumnIndex("flag_doenca_respiratoria")) < 1);
        fichaModel.setFlagAsma(c.getInt(c.getColumnIndex("flag_asma")) > 0);
        fichaModel.setFlagEnfisema(c.getInt(c.getColumnIndex("flag_enfisema")) > 0);
        fichaModel.setFlagOutraDoencaRespiratoria(c.getInt(c.getColumnIndex("flag_outra_doenca_respiratoria")) > 0);
        fichaModel.setFlagNaoSabeDoencaRespiratoria(c.getInt(c.getColumnIndex("flag_nao_sabe_doenca_respiratoria")) > 0);

        fichaModel.setFlagHanseniase(c.getInt(c.getColumnIndex("flag_hanseniase")) < 1);
        fichaModel.setFlagTuberculose(c.getInt(c.getColumnIndex("flag_tuberculose")) < 1);
        fichaModel.setFlagCancer(c.getInt(c.getColumnIndex("flag_cancer")) < 1);
        fichaModel.setFlagInternado(c.getInt(c.getColumnIndex("flag_internado")) < 1);
        fichaModel.setQualMotivoInternamento(c.getString(c.getColumnIndex("qual_motivo_internamento")));
        fichaModel.setFlagProblemaMental(c.getInt(c.getColumnIndex("flag_problema_mental")) < 1);
        fichaModel.setFlagAcamado(c.getInt(c.getColumnIndex("flag_acamado")) < 1);
        fichaModel.setFlagDomiciliado(c.getInt(c.getColumnIndex("flag_domiciliado")) < 1);
        fichaModel.setFlagPlantasMedicinais(c.getInt(c.getColumnIndex("flag_plantas_medicinais")) < 1);
        fichaModel.setQuaisPlantas(c.getString(c.getColumnIndex("quais_plantas")));
        fichaModel.setFlagOutrasPraticasIntegrativas(c.getInt(c.getColumnIndex("outras_praticas_integrativas")) < 1);
        fichaModel.setOutrasCondicoesSaude(c.getString(c.getColumnIndex("outras_condicoes_saude")));

        fichaModel.setFlagSituacaoRua(c.getInt(c.getColumnIndex("flag_situacao_rua")) < 1);
        fichaModel.setTempoSituacaoRua(c.getInt(c.getColumnIndex("tempo_situacao_rua")));
        fichaModel.setFlagRecebeBeneficio(c.getInt(c.getColumnIndex("flag_recebe_beneficio")) < 1);
        fichaModel.setFlagReferenciaFamiliar(c.getInt(c.getColumnIndex("flag_referencia_familiar")) < 1);

        fichaModel.setFrequenciaAlimentacao(c.getInt(c.getColumnIndex("frequencia_alimentacao")));
        fichaModel.setFlagAlimentacaoRestaurantePopular(c.getInt(c.getColumnIndex("flag_alimentacao_restaurante_popular")) > 0);
        fichaModel.setFlagAlimentacaoDoacaoGrupoReligioso(c.getInt(c.getColumnIndex("flag_alimentacao_grupo_religioso")) > 0);
        fichaModel.setFlagAlimentacaoDoacaoRestaurante(c.getInt(c.getColumnIndex("flag_alimentacao_doacao_restaurante")) > 0);
        fichaModel.setFlagAlimentacaoDoacaoPopular(c.getInt(c.getColumnIndex("flag_alimentacao_doacao_popular")) > 0);
        fichaModel.setFlagAlimentacaoOutras(c.getInt(c.getColumnIndex("flag_alimentacao_outras")) > 0);

        fichaModel.setFlagAcompanhadoInstituicao(c.getInt(c.getColumnIndex("flag_acompanhado_instituicao")) < 1);
        fichaModel.setQualInstituicao(c.getString(c.getColumnIndex("qual_instituicao")));
        fichaModel.setFlagVisitaFamiliar(c.getInt(c.getColumnIndex("flag_visita_familiar")) < 1);
        fichaModel.setGrauParentesco(c.getInt(c.getColumnIndex("grau_parentesco")));

        fichaModel.setFlagAcessoHigienePessoal(c.getInt(c.getColumnIndex("flag_acesso_higiene_pessoal")) < 1);
        fichaModel.setFlagAcessoBanho(c.getInt(c.getColumnIndex("flag_acesso_banho")) > 0);
        fichaModel.setFlagAcessoSanitario(c.getInt(c.getColumnIndex("flag_acesso_sanitario")) > 0);
        fichaModel.setFlagAcessoHigieneBucal(c.getInt(c.getColumnIndex("flag_acesso_higiene_bucal")) > 0);
        fichaModel.setFlagAcessoOutras(c.getInt(c.getColumnIndex("flag_acesso_outras")) > 0);

        fichaModel.setFlagAtivo(c.getInt(c.getColumnIndex("flag_ativo")) < 1);
        fichaModel.setFlagExportado(c.getInt(c.getColumnIndex("flag_exportado")) < 1);


        return fichaModel;


    }


}
