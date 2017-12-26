package com.fichapp.business;

import android.content.Context;

import com.fichapp.Model.CNESModel;
import com.fichapp.dao.CNESDAO;
import com.fichapp.dao.SMPEPDbHelper;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class CNESBS {

    CNESDAO cnesDAO;

    public CNESBS() {
    }

    public CNESBS(Context context) {
        SMPEPDbHelper smpepDbHelper = new SMPEPDbHelper(context);
        cnesDAO = new CNESDAO(smpepDbHelper);
    }

    public void gravar(CNESModel CNES) {

        if (CNES.getId() != null) {
            cnesDAO.alterar(CNES);
        } else {
            cnesDAO.inserir(CNES);
        }

    }

    public void excluir(CNESModel CNES) {
        cnesDAO.excluir(CNES);
        //cnesDAO.pesquisar();
    }

    public List<CNESModel> pesquisar() {
        return cnesDAO.pesquisar();
    }

    public List<CNESModel> pesquisarAtivos() {
        return cnesDAO.pesquisarAtivos();
    }

}
