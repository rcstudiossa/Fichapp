package com.fichapp.business;

import android.content.Context;

import com.fichapp.dao.FichaCadastroDTFamiliasDAO;
import com.fichapp.dao.SMPEPDbHelper;
import com.fichapp.model.FamiliaModel;
import com.fichapp.util.Utilitario;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaCadastroDTFamiliasBS {

    FichaCadastroDTFamiliasDAO FichaCadastroDTFamiliasDAO;

    public FichaCadastroDTFamiliasBS() {
    }

    public FichaCadastroDTFamiliasBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        FichaCadastroDTFamiliasDAO = new FichaCadastroDTFamiliasDAO(smpepDbHelper);
    }

    public void gravar(FamiliaModel familiaModel) {

        if (familiaModel.getId() != null) {
            FichaCadastroDTFamiliasDAO.alterar(familiaModel);
        } else {
            FichaCadastroDTFamiliasDAO.inserir(familiaModel);
        }

    }

    public void excluir(FamiliaModel familiaModel) {
        FichaCadastroDTFamiliasDAO.excluir(familiaModel);
    }

    public FamiliaModel obter(FamiliaModel FamiliaModel) {
        return this.FichaCadastroDTFamiliasDAO.obter(FamiliaModel);
    }




}
