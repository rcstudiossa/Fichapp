package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.FichaCadastroDTDAO;
import com.fichapp.dao.FichaCadastroDTFamiliasDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaCadastroDTBS {

    FichaCadastroDTDAO fichaCadastroDTDAO;
    FichaCadastroDTFamiliasBS fichaCadastroDTFamiliasBS;

    public FichaCadastroDTBS() {
    }

    public FichaCadastroDTBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        fichaCadastroDTDAO = new FichaCadastroDTDAO(smpepDbHelper);
        fichaCadastroDTFamiliasBS = new FichaCadastroDTFamiliasBS(context);
    }

    public void gravar(FichaCadastroDTModel fichaModel) {

        if (fichaModel.getId() != null) {
            fichaCadastroDTDAO.alterar(fichaModel);
        } else {
            fichaCadastroDTDAO.inserir(fichaModel);
        }

        fichaCadastroDTFamiliasBS.gravar(fichaModel.getFamilias());

    }

    public void excluir(FichaCadastroDTModel fichaModel) {
        fichaCadastroDTDAO.excluir(fichaModel);
    }

    public FichaCadastroDTModel obter(FichaCadastroDTModel FichaCadastroDTModel) {

        FichaCadastroDTModel ficha = this.fichaCadastroDTDAO.obter(FichaCadastroDTModel);

        List<FamiliaModel> familias = fichaCadastroDTFamiliasBS.pesquisar(ficha);

        ficha.setFamilias(familias == null ? new ArrayList<FamiliaModel>() : familias);

        return ficha;
    }

    public List<FichaCadastroDTModel> pesquisar() {
        return fichaCadastroDTDAO.pesquisar();
    }

    public List<FichaCadastroDTModel> pesquisarAtivos() {

        return fichaCadastroDTDAO.pesquisarAtivos();
    }

    public List<FichaCadastroDTModel> pesquisarAtivos(String query) {

        if (Utilitario.isEmpty(query)) {
            return fichaCadastroDTDAO.pesquisarAtivos();
        }

        return fichaCadastroDTDAO.pesquisarAtivos(query);

    }



}
