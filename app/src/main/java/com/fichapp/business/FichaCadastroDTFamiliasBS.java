package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.FichaCadastroDTFamiliasDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaCadastroDTFamiliasBS {

    FichaCadastroDTFamiliasDAO fichaCadastroDTFamiliasDAO;

    public FichaCadastroDTFamiliasBS() {
    }

    public FichaCadastroDTFamiliasBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        fichaCadastroDTFamiliasDAO = new FichaCadastroDTFamiliasDAO(smpepDbHelper);
    }

    public void gravar(List<FamiliaModel> familias) {

        for (FamiliaModel familiaModel: familias) {

            this.gravar(familiaModel);

        }

    }

    public void gravar(FamiliaModel familiaModel) {

        if (familiaModel.getId() != null) {
            fichaCadastroDTFamiliasDAO.alterar(familiaModel);
        } else {
            fichaCadastroDTFamiliasDAO.inserir(familiaModel);
        }

    }

    public void excluir(FamiliaModel familiaModel) {
        fichaCadastroDTFamiliasDAO.excluir(familiaModel);
    }

    public FamiliaModel obter(FamiliaModel FamiliaModel) {
        return this.fichaCadastroDTFamiliasDAO.obter(FamiliaModel);
    }

    public List<FamiliaModel> pesquisar(FichaCadastroDTModel fichaCadastroDTModel) {
        return this.fichaCadastroDTFamiliasDAO.pesquisar(fichaCadastroDTModel);
    }




}
