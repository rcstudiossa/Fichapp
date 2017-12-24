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

    public void gravar(ProfissionalModel Profissional) {

        if (Profissional.getId() != null) {
            profissionalDAO.alterar(Profissional);
        } else {
            profissionalDAO.inserir(Profissional);
        }

    }

    public void excluir(ProfissionalModel Profissional) {
        profissionalDAO.excluir(Profissional);
        //profissionalDAO.pesquisar();
    }

    public List<ProfissionalModel> pesquisar() {
        return profissionalDAO.pesquisar();
    }

    public List<ProfissionalModel> pesquisarAtivo() {
        return profissionalDAO.pesquisarAtivos();
    }



}
