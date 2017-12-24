package com.fichapp.business;

import android.content.Context;

import com.fichapp.Model.FichaVisitaDTModel;
import com.fichapp.Model.ProfissionalModel;
import com.fichapp.dao.FichaVisitaDTDAO;
import com.fichapp.dao.FichaVisitaDTDbHelper;
import com.fichapp.dao.ProfissionalDAO;
import com.fichapp.dao.ProfissionalDbHelper;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaVisitaDTBS {

    FichaVisitaDTDAO fichaVisitaDTDAO;

    public FichaVisitaDTBS() {
    }

    public FichaVisitaDTBS(Context context) {
        FichaVisitaDTDbHelper fichaVisitaDTDbHelper = new FichaVisitaDTDbHelper(context);
        fichaVisitaDTDAO = new FichaVisitaDTDAO(fichaVisitaDTDbHelper);
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
        //profissionalDAO.pesquisar();
    }

    public List<FichaVisitaDTModel> pesquisar() {
        return fichaVisitaDTDAO.pesquisar();
    }

    public List<FichaVisitaDTModel> pesquisarAtivo() {
        return fichaVisitaDTDAO.pesquisarAtivos();
    }



}
