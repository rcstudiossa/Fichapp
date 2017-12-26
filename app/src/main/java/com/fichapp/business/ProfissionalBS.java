package com.fichapp.business;

import android.content.Context;

import com.fichapp.Model.ProfissionalModel;
import com.fichapp.dao.ProfissionalDAO;
import com.fichapp.dao.SMPEPDbHelper;

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
        profissionalDAO = new ProfissionalDAO(smpepDbHelper);
    }

    public void gravar(ProfissionalModel profissionalModel) {

        if (profissionalModel.getId() != null) {
            profissionalDAO.alterar(profissionalModel);
        } else {
            profissionalDAO.inserir(profissionalModel);
        }

    }

    public void excluir(ProfissionalModel profissionalModel) {
        profissionalDAO.excluir(profissionalModel);
        //profissionalDAO.pesquisar();
    }

    public List<ProfissionalModel> pesquisar() {
        return profissionalDAO.pesquisar();
    }

    public List<ProfissionalModel> pesquisarAtivos() {
        return profissionalDAO.pesquisarAtivos();
    }

}
