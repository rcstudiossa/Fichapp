package com.fichapp.business;

import android.content.Context;

import com.fichapp.Model.CNESModel;
import com.fichapp.dao.CNESDAO;
import com.fichapp.dao.CNESDbHelper;

import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class CNESBS {

    CNESDAO CNESDAO;

    public CNESBS() {
    }

    public CNESBS(Context context) {
        CNESDbHelper CNESDbHelper = new CNESDbHelper(context);
        CNESDAO = new CNESDAO(CNESDbHelper);
    }

    public void gravar(CNESModel CNES) {

        if (CNES.getId() != null) {
            CNESDAO.alterar(CNES);
        } else {
            CNESDAO.inserir(CNES);
        }

    }

    public void excluir(CNESModel CNES) {
        CNESDAO.excluir(CNES);
        CNESDAO.pesquisar();
    }

    public List<CNESModel> pesquisar() {
        return CNESDAO.pesquisar();
    }

    public List<CNESModel> pesquisarAtivo() {
        return CNESDAO.pesquisarAtivos();
    }



}
