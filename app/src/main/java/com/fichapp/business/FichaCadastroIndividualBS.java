package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.FichaCadastroIndividualDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FichaCadastroIndividualModel;
import com.fichapp.model.OrigemModel;
import com.fichapp.model.integracao.FichaCabecalhoUnicoEsusModel;
import com.fichapp.model.integracao.FichaCadastroIndividualCondicaoSaudeEsusModel;
import com.fichapp.model.integracao.FichaCadastroIndividualEsusModel;
import com.fichapp.model.integracao.FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel;
import com.fichapp.model.integracao.FichaCadastroIndividualSaidaCidadaoEsusModel;
import com.fichapp.model.integracao.FichaCadastroIndividualSituacaoRuaEsusModel;
import com.fichapp.model.integracao.FichaCadastroInformacaoSocioDemograficaEsusModel;
import com.fichapp.util.Utilitario;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaCadastroIndividualBS {

    FichaCadastroIndividualDAO FichaCadastroIndividualDAO;

    public FichaCadastroIndividualBS() {}

    public FichaCadastroIndividualBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        FichaCadastroIndividualDAO = new FichaCadastroIndividualDAO(smpepDbHelper);
    }

    public void gravar(FichaCadastroIndividualModel fichaModel) {

        if (fichaModel.getId() != null) {
            FichaCadastroIndividualDAO.alterar(fichaModel);
        } else {
            FichaCadastroIndividualDAO.inserir(fichaModel);
        }

    }

    public void excluir(FichaCadastroIndividualModel fichaModel) {
        FichaCadastroIndividualDAO.excluir(fichaModel);
    }

    public void restaurar(FichaCadastroIndividualModel fichaModel) {
        FichaCadastroIndividualDAO.restaurar(fichaModel);
    }

    public FichaCadastroIndividualModel obter(FichaCadastroIndividualModel FichaCadastroIndividualModel) {
        return this.FichaCadastroIndividualDAO.obter(FichaCadastroIndividualModel);
    }

    public List<FichaCadastroIndividualModel> pesquisar() {
        return FichaCadastroIndividualDAO.pesquisar();
    }

    public List<FichaCadastroIndividualModel> pesquisarNaoExportados() {
        return FichaCadastroIndividualDAO.pesquisarNaoExportados();
    }

    public List<FichaCadastroIndividualModel> pesquisarAtivos() {
        return FichaCadastroIndividualDAO.pesquisarAtivos();
    }

    public List<FichaCadastroIndividualModel> pesquisarAtivos(String query) {

        if (Utilitario.isEmpty(query)) {
            return FichaCadastroIndividualDAO.pesquisarAtivos();
        }

        return FichaCadastroIndividualDAO.pesquisarAtivos(query);

    }

    public String getJSONObject(FichaCadastroIndividualModel ficha) {

        FichaCadastroIndividualEsusModel fichaCadastroIndividualEsusModel = new FichaCadastroIndividualEsusModel();
        fichaCadastroIndividualEsusModel.setOrigemModel(new OrigemModel(25L));

        FichaCabecalhoUnicoEsusModel cabecalho = new FichaCabecalhoUnicoEsusModel();
        cabecalho.setProfissionalCNS(ficha.getProfissionalModel().getCns());
        cabecalho.setCboCodigo2002(ficha.getProfissionalModel().getCbo().getCodigo().toString());
        cabecalho.setCnes(ficha.getProfissionalModel().getCnesModel().getCodigo().toString());
        cabecalho.setIne(ficha.getProfissionalModel().getIne());
        cabecalho.setDataAtendimento(ficha.getDataRegistro());
        fichaCadastroIndividualEsusModel.setFichaCabecalhoEsusModel(cabecalho);

        FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel identificacao = new FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel();
        identificacao.setCnsCidadao(ficha.getCnsCidadao());
        identificacao.setFlagStatusEhResponsavel(ficha.getFlagResponsavelFamiliar() == 0);
        identificacao.setCnsResponsavelFamiliar(ficha.getCnsResponsavelFamiliar());
        identificacao.setMicroArea(ficha.getMicroarea());
        identificacao.setFlagSituacaoForaArea(ficha.getFlagForaDeArea());
        identificacao.setNomeCidadao(ficha.getNomeCompleto());
        identificacao.setNomeSocial(ficha.getNomeSocial());
        identificacao.setDataNascimentoCidadao(ficha.getDataNascimento());
        identificacao.setSexoCidadao(ficha.getSexo().longValue());
        identificacao.setRacaCorCidadao(!Utilitario.isEmpty(ficha.getRaca().getCodigo()) ? ficha.getRaca().getCodigo().longValue() : null);
        identificacao.setEtnia(!Utilitario.isEmpty(ficha.getEtnia().getCodigo()) ? ficha.getEtnia().getCodigo().longValue() : null);
        identificacao.setNumeroNisPisPasep(ficha.getNis());
        identificacao.setNomeMaeCidadao(ficha.getNomeMae());
        identificacao.setFlagDesconheceNomeMae(ficha.getFlagMaeDesconhecido());
        identificacao.setNomePaiCidadao(ficha.getNomePai());
        identificacao.setFlagDesconheceNomePai(ficha.getFlagPaiDesconhecido());
        identificacao.setNacionalidadeCidadao(ficha.getNacionalidade().longValue());
        identificacao.setDataEntradaBrasil(ficha.getDataEntrada());
        identificacao.setDataNaturalizacao(ficha.getDataNaturalizacao());
        identificacao.setPortariaNaturalizacao(ficha.getPortariaNaturalizacao());
        identificacao.setPaisNascimento(!Utilitario.isEmpty(ficha.getPaisNascimento().getCodigo()) ? ficha.getPaisNascimento().getCodigo().longValue() : null);
        identificacao.setTelefoneCelular(ficha.getTelefoneCelular());
        identificacao.setEmailCidadao(ficha.getEmailCidadao());
        fichaCadastroIndividualEsusModel.setFichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel(identificacao);


        FichaCadastroInformacaoSocioDemograficaEsusModel socioDemografica = new FichaCadastroInformacaoSocioDemograficaEsusModel();
        socioDemografica.setRelacaoParentescoCidadao(!Utilitario.isEmpty(ficha.getParentescoResponsavelFamiliar().getCodigo()) ? ficha.getParentescoResponsavelFamiliar().getCodigo().longValue() : null);
        socioDemografica.setOcupacaoCodigoCbo2002(ficha.getOcupacao());
        socioDemografica.setFlagStatusFrequentaEscola(ficha.getFlagFrequentaEscola() == 0);
        socioDemografica.setSituacaoMercadoTrabalhoCidadao(!Utilitario.isEmpty(ficha.getSituacaoMercado().getCodigo()) ? ficha.getSituacaoMercado().getCodigo().longValue() : null);
        socioDemografica.setResponsavelPorCrianca(ficha.getResponsavelCrianca());
        socioDemografica.setFlagStatusParticipaGrupoComunitario(ficha.getFlagParticipaGrupoComunitario() == 0);
        socioDemografica.setFlagStatusPossuiPlanoSaudePrivado(ficha.getFlagPossuiPlanoDeSaude() == 0);
        socioDemografica.setFlagStatusMembroPovoComunidadeTradicional(ficha.getFlagMembroDeComunidade() == 0);
        socioDemografica.setPovoComunidadeTradicional(ficha.getQualComunidade());
        socioDemografica.setFlagStatusDesejaInformarOrientacaoSexual(ficha.getFlagInformarOrientacao() == 0);
        socioDemografica.setOrientacaoSexualCidadao(!Utilitario.isEmpty(ficha.getOrientacaoSexual().getCodigo()) ? ficha.getOrientacaoSexual().getCodigo().longValue() : null);
        socioDemografica.setFlagStatusDesejaInformarIdentidadeGenero(ficha.getFlagInformarIdentidadeGenero() == 0);
        socioDemografica.setIdentidadeGeneroCidadao(!Utilitario.isEmpty(ficha.getIdentidadeGenero().getCodigo()) ? ficha.getIdentidadeGenero().getCodigo().longValue() : null);
        socioDemografica.setFlagStatusTemAlgumaDeficiencia(ficha.getFlagDeficiencia() == 0);
        socioDemografica.setDeficienciasCidadao(ficha.getDeficiencias());
        fichaCadastroIndividualEsusModel.setFichaCadastroInformacaoSocioDemograficaEsusModel(socioDemografica);

        FichaCadastroIndividualSaidaCidadaoEsusModel saidaCidadao = new FichaCadastroIndividualSaidaCidadaoEsusModel();
        saidaCidadao.setDataObito(ficha.getDataObito());
        saidaCidadao.setNumeroDO(ficha.getNumeroDO());
        saidaCidadao.setMotivoSaidaCidadao(ficha.getSaidaCadastro().longValue());
        fichaCadastroIndividualEsusModel.setFichaCadastroIndividualSaidaCidadaoEsusModel(saidaCidadao);

        FichaCadastroIndividualCondicaoSaudeEsusModel condicoesSaude = new FichaCadastroIndividualCondicaoSaudeEsusModel();
        condicoesSaude.setFlagStatusEhGestante(ficha.getFlagGestante() == 0);
        condicoesSaude.setMaternidadeDeReferencia(ficha.getQualMaternidade());
        condicoesSaude.setSituacaoPeso(ficha.getPeso().longValue());
        condicoesSaude.setFlagStatusEhFumante(ficha.getFlagFumante() == 0);
        condicoesSaude.setFlagStatusEhDependenteAlcool(ficha.getFlagAlcool() == 0);
        condicoesSaude.setFlagStatusEhDependenteOutrasDrogas(ficha.getFlagOutrasDrogas() == 0);
        condicoesSaude.setFlagStatusTemHipertensaoArterial(ficha.getFlagHipertensao() == 0);
        condicoesSaude.setFlagStatusTemDiabetes(ficha.getFlagDiabetes() == 0);
        condicoesSaude.setFlagStatusTeveAvcDerrame(ficha.getFlagAvcDerrame() == 0);
        condicoesSaude.setFlagStatusTeveInfarto(ficha.getFlagInfarto() == 0);
        condicoesSaude.setFlagStatusTeveDoencaCardiaca(ficha.getFlagDoencaCardiaca() == 0);
        condicoesSaude.setDoencaCardiaca(ficha.getDoencasCardiacas());
        condicoesSaude.setFlagStatusTemTeveDoencasRins(ficha.getFlagProblemaRins() == 0);
        condicoesSaude.setDoencaRins(ficha.getDoencasRins());
        condicoesSaude.setFlagStatusTemDoencaRespiratoria(ficha.getFlagDoencaRespiratoria() == 0);
        condicoesSaude.setDoencaRespiratoria(ficha.getDoencasRespiratorias());
        condicoesSaude.setFlagStatusTemHanseniase(ficha.getFlagHanseniase() == 0);
        condicoesSaude.setFlagStatusTemTuberculose(ficha.getFlagTuberculose() == 0);
        condicoesSaude.setFlagStatusTemTeveCancer(ficha.getFlagCancer() == 0);
        condicoesSaude.setFlagStatusTeveInternadoEm12Meses(ficha.getFlagInternado() == 0);
        condicoesSaude.setDescricaoCausaInternacaoEm12Meses(ficha.getQualMotivoInternamento());
        condicoesSaude.setFlagStatusDiagnosticoMental(ficha.getFlagProblemaMental() == 0);
        condicoesSaude.setFlagStatusEstaAcamado(ficha.getFlagAcamado() == 0);
        condicoesSaude.setFlagStatusEstaDomiciliado(ficha.getFlagDomiciliado() == 0);
        condicoesSaude.setFlagStatusUsaPlantaMedicinais(ficha.getFlagPlantasMedicinais() == 0);
        condicoesSaude.setDescricaoPlantasMedicinaisUsadas(ficha.getQuaisPlantas());
        condicoesSaude.setFlagStatusUsaOutrasPraticasIntegrativasOuComplementares(ficha.getFlagOutrasPraticasIntegrativas() == 0);
        condicoesSaude.setDescricaoOutraCondicao1(ficha.getOutrasCondicoesSaude());
        fichaCadastroIndividualEsusModel.setFichaCadastroIndividualCondicaoSaudeEsusModel(condicoesSaude);

        FichaCadastroIndividualSituacaoRuaEsusModel situacaoRua = new FichaCadastroIndividualSituacaoRuaEsusModel();
        situacaoRua.setFlagStatusSituacaoRua(ficha.getFlagSituacaoRua() == 0);
        situacaoRua.setTempoSituacaoRua(ficha.getTempoSituacaoRua().longValue());
        situacaoRua.setFlagStatusRecebeBeneficio(ficha.getFlagRecebeBeneficio() == 0);
        situacaoRua.setFlagStatusPossuiReferenciaFamiliar(ficha.getFlagReferenciaFamiliar() == 0);
        situacaoRua.setQuantidadeAlimentacoesAoDiaSituacaoRua(ficha.getFrequenciaAlimentacao().longValue());
        situacaoRua.setOrigemAlimentoSituacaoRua(ficha.getOrigemAlimentacao());
        situacaoRua.setFlagStatusAcompanhadoPorOutraInstituicao(ficha.getFlagAcompanhadoInstituicao() == 0);
        situacaoRua.setOutraInstituicaoQueAcompanha(ficha.getQualInstituicao());
        situacaoRua.setFlagStatusVisitaFamiliarFrequentemente(ficha.getFlagVisitaFamiliar() == 0);
        situacaoRua.setFlagStatusTemAcessoHigienePessoalSituacaoRua(ficha.getFlagAcessoHigienePessoal() == 0);
        situacaoRua.setHigienePessoalSituacaoRua(ficha.getHigienePessoal());
        fichaCadastroIndividualEsusModel.setFichaCadastroIndividualSituacaoRuaEsusModel(situacaoRua);

        Gson gson = new Gson();
        String json = gson.toJson(fichaCadastroIndividualEsusModel);

        return json;

    }



}
