package com.fichapp.business;

import android.content.Context;

import com.fichapp.Model.ProfissionalModel;
import com.fichapp.dao.ProfissionalDAO;
import com.fichapp.dao.ProfissionalDbHelper;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class ProfissionalBS {

    ProfissionalDAO profissionalDAO;

    public ProfissionalBS() {
    }

    public ProfissionalBS(Context context) {
        ProfissionalDbHelper profissionalDbHelper = new ProfissionalDbHelper(context);
        profissionalDAO = new ProfissionalDAO(profissionalDbHelper);
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

    public List<ProfissionalModel> pesquisarAtivo() {
        return profissionalDAO.pesquisarAtivos();
    }



}
