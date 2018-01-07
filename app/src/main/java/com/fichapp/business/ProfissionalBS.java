package com.fichapp.business;

import android.content.Context;

import com.fichapp.model.CNESModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.dao.ProfissionalDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.util.Utilitario;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class ProfissionalBS {

    ProfissionalDAO profissionalDAO;

    public ProfissionalBS() {
    }

    public ProfissionalBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        this.profissionalDAO = new ProfissionalDAO(smpepDbHelper);
    }

    public void gravar(ProfissionalModel profissionalModel) {

        if (profissionalModel.getId() != null) {
            this.profissionalDAO.alterar(profissionalModel);
        } else {
            this.profissionalDAO.inserir(profissionalModel);
        }

    }

    public void excluir(ProfissionalModel profissionalModel) {
        this.profissionalDAO.excluir(profissionalModel);
        //profissionalDAO.pesquisar();
    }

    public void alterarSenha (ProfissionalModel profissionalModel) {
        this.profissionalDAO.alterarSenha(profissionalModel);
    }

    public List<ProfissionalModel> pesquisar() {
        return this.profissionalDAO.pesquisar();
    }

    public List<ProfissionalModel> pesquisarAtivos() {
        return this.profissionalDAO.pesquisarAtivos();
    }

    public List<ProfissionalModel> pesquisarAtivos(String query) {

        if (Utilitario.isEmpty(query)) {
            return this.profissionalDAO.pesquisarAtivos();
        }

        return this.profissionalDAO.pesquisarAtivos(query);
    }

    public ProfissionalModel obterProfissionalLogado(ProfissionalModel profissionalModel, CNESModel cnesModel) {
        return this.profissionalDAO.obterProfissionalLogado(profissionalModel, cnesModel);
    }

}
