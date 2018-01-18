package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.FichaCadastroDTDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.util.Utilitario;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaCadastroIndividualBS {

    FichaCadastroDTDAO FichaCadastroDTDAO;

    public FichaCadastroIndividualBS() {
    }

    public FichaCadastroIndividualBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        FichaCadastroDTDAO = new FichaCadastroDTDAO(smpepDbHelper);
    }

    public void gravar(FichaCadastroDTModel fichaModel) {

        if (fichaModel.getId() != null) {
            FichaCadastroDTDAO.alterar(fichaModel);
        } else {
            FichaCadastroDTDAO.inserir(fichaModel);
        }

    }

    public void excluir(FichaCadastroDTModel fichaModel) {
        FichaCadastroDTDAO.excluir(fichaModel);
        //profissionalDAO.pesquisar();
    }

    public FichaCadastroDTModel obter(FichaCadastroDTModel FichaCadastroDTModel) {

        return this.FichaCadastroDTDAO.obter(FichaCadastroDTModel);
    }

    public List<FichaCadastroDTModel> pesquisar() {
        return FichaCadastroDTDAO.pesquisar();
    }

    public List<FichaCadastroDTModel> pesquisarAtivos() {
        return FichaCadastroDTDAO.pesquisarAtivos();
    }

    public List<FichaCadastroDTModel> pesquisarAtivos(String query) {

        if (Utilitario.isEmpty(query)) {
            return FichaCadastroDTDAO.pesquisarAtivos();
        }

        return FichaCadastroDTDAO.pesquisarAtivos(query);

    }



}
