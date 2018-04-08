package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.ProfissionalDAO;
import com.fichapp.model.integracao.FichaCabecalhoUnicoEsusModel;
import com.fichapp.model.FichaVisitaDTModel;
import com.fichapp.dao.FichaVisitaDTDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.integracao.FichaVisitaDomiciliarEsusChildModel;
import com.fichapp.model.integracao.FichaVisitaDomiciliarEsusMasterModel;
import com.fichapp.model.OrigemModel;

import com.fichapp.util.Utilitario;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaVisitaDTBS {

    FichaVisitaDTDAO fichaVisitaDTDAO;
    ProfissionalDAO profissionalDAO;

    public FichaVisitaDTBS() {
    }

    public FichaVisitaDTBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        fichaVisitaDTDAO = new FichaVisitaDTDAO(smpepDbHelper);
        profissionalDAO = new ProfissionalDAO(smpepDbHelper);
    }

    public void gravar(FichaVisitaDTModel fichaModel) {

        if (fichaModel.getId() != null) {
            fichaVisitaDTDAO.alterar(fichaModel);
        } else {
            fichaVisitaDTDAO.inserir(fichaModel);
        }

    }

    public void excluir(FichaVisitaDTModel fichaModel) {
        fichaVisitaDTDAO.excluir(fichaModel);
    }

    public void restaurar(FichaVisitaDTModel fichaModel) {
        fichaVisitaDTDAO.restaurar(fichaModel);
    }

    public FichaVisitaDTModel obter(FichaVisitaDTModel fichaVisitaDTModel) {

        return this.fichaVisitaDTDAO.obter(fichaVisitaDTModel);
    }

    public List<FichaVisitaDTModel> pesquisar() {
        return fichaVisitaDTDAO.pesquisar();
    }

    public List<FichaVisitaDTModel> pesquisarAtivos() {
        return fichaVisitaDTDAO.pesquisarAtivos();
    }

    public List<FichaVisitaDTModel> pesquisarAtivos(String query) {

        if (Utilitario.isEmpty(query)) {
            return fichaVisitaDTDAO.pesquisarAtivos();
        }

        return fichaVisitaDTDAO.pesquisarAtivos(query);

    }

    public List<FichaVisitaDTModel> pesquisarNaoExportados() {
        return fichaVisitaDTDAO.pesquisarNaoExportados();
    }

    public void alterarStatusExportado(FichaVisitaDTModel fichaModel) {
        fichaVisitaDTDAO.alterarStatusExportado(fichaModel);
    }

    public String getJSONObject(FichaVisitaDTModel ficha) {

        //ficha = fichaVisitaDTDAO.obter(ficha);


        FichaCabecalhoUnicoEsusModel cabecalho = new FichaCabecalhoUnicoEsusModel();
        FichaVisitaDomiciliarEsusMasterModel fichaVisitaDomiciliarEsusMasterModel = new FichaVisitaDomiciliarEsusMasterModel();

        ficha.setProfissionalModel(profissionalDAO.obter(ficha.getProfissionalModel()));

        cabecalho.setProfissionalCNS(ficha.getProfissionalModel().getCns());
        cabecalho.setCboCodigo2002(ficha.getProfissionalModel().getCbo().getCodigo().toString());
        cabecalho.setCnes(ficha.getProfissionalModel().getCnesModel().getCodigo().toString());
        cabecalho.setIne(ficha.getProfissionalModel().getIne());
        cabecalho.setDataAtendimento(ficha.getDataRegistro());

        fichaVisitaDomiciliarEsusMasterModel.setFichaCabecalhoEsusModel(cabecalho);
        fichaVisitaDomiciliarEsusMasterModel.setOrigemModel(new OrigemModel(25L));
        fichaVisitaDomiciliarEsusMasterModel.setVisitas(new ArrayList<FichaVisitaDomiciliarEsusChildModel>());

        FichaVisitaDomiciliarEsusChildModel visita = new FichaVisitaDomiciliarEsusChildModel();

        visita.setTurno(ficha.getTurno() == "M" ? 1L : ficha.getTurno() == "T" ? 2L : 3L);
        visita.setNumProntuario(ficha.getProntuario());
        visita.setCnsCidadao(ficha.getCnsCidadao());
        visita.setDataNascimento(ficha.getDataNascimento());
        visita.setSexo(ficha.getSexo() == "M" ? 0L : ficha.getSexo() == "F" ? 1L : 4L);
        visita.setFlagVisitaCompartilhadaOutroProfissional(ficha.getFlagVisitaCompartilhada());
        visita.setMotivosVisita1(ficha.getMotivosVisitaTipoVisita());
        visita.setMotivosVisitaBuscaAtiva(ficha.getMotivosVisitaBuscaAtiva());
        visita.setMotivosVisitaAcompanhamento(ficha.getMotivosVisitaAcompanhamento());
        visita.setMotivosVisitaControleAmbiental(ficha.getMotivosVisitaControleAmbiental());
        visita.setMotivosVisita2(ficha.getMotivosVisitaOutros());
        visita.setDesfecho(new Long(ficha.getDesfecho()));
        visita.setMicroArea(ficha.getMicroArea());
        visita.setFlagForaArea(ficha.getFlagForaArea());
        visita.setTipoDeImovel(ficha.getTipoImovelModel().getCodigo().longValue());
        visita.setPesoAcompanhamentoNutricional(ficha.getPeso());
        visita.setAlturaAcompanhamentoNutricional(ficha.getAltura().doubleValue());

        fichaVisitaDomiciliarEsusMasterModel.getVisitas().add(visita);

        Gson gson = new Gson();
        String json = gson.toJson(fichaVisitaDomiciliarEsusMasterModel);

        return json;

    }


}
