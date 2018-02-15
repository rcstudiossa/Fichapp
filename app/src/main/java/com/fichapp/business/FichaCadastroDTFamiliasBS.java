package com.fichapp.business;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public void gravar(SQLiteDatabase db, List<FamiliaModel> familias) {

        for (FamiliaModel familiaModel: familias) {

            this.gravar(db, familiaModel);

        }

    }

    public void gravar(SQLiteDatabase db, FamiliaModel familiaModel) {

        if (familiaModel.getId() != null && familiaModel.getId() > 0) {
            fichaCadastroDTFamiliasDAO.alterar(db, familiaModel);
        } else {
            fichaCadastroDTFamiliasDAO.inserir(db, familiaModel);
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
