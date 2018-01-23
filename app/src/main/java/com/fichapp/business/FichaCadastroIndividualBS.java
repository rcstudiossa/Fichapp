package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.FichaCadastroIndividualDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FichaCadastroIndividualModel;
import com.fichapp.util.Utilitario;

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
        //profissionalDAO.pesquisar();
    }

    public FichaCadastroIndividualModel obter(FichaCadastroIndividualModel FichaCadastroIndividualModel) {

        return this.FichaCadastroIndividualDAO.obter(FichaCadastroIndividualModel);
    }

    public List<FichaCadastroIndividualModel> pesquisar() {
        return FichaCadastroIndividualDAO.pesquisar();
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



}
