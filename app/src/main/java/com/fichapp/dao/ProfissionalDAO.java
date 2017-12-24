package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.Model.ProfissionalModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class ProfissionalDAO {

    SQLiteDatabase db;

    public ProfissionalDAO() {
    }

    public ProfissionalDAO(ProfissionalDbHelper profissionalDbHelper) {
        this.db = profissionalDbHelper.getWritableDatabase();
    }

    public void alterar(ProfissionalModel profissionalModel) {

        Object[] args = {profissionalModel.getCbo(), profissionalModel.getCns(), profissionalModel.getNome(), profissionalModel.getFlagAtivo(), profissionalModel.getId()};

        db.execSQL("UPDATE profissional set cbo = ?, cns = ?, nome = ?, flag_ativo = ? WHERE id = ?;", args);

    }

    public void inserir(ProfissionalModel profissionalModel) {

        Object[] args = {profissionalModel.getCbo(), profissionalModel.getCns(), profissionalModel.getNome(), Boolean.TRUE};

        db.execSQL("INSERT INTO profissional (cbo, cns, nome, flag_ativo) VALUES(?, ?, ?, ?);", args);
    }

    public void excluir(ProfissionalModel profissionalModel) {

        Object[] args = {Boolean.FALSE, profissionalModel.getId()};

        db.execSQL("UPDATE profissional SET flag_ativo = ? where id = ? ", args);

    }

    public List<ProfissionalModel> pesquisar() {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM profissional order by id;", null);

        if (c.getCount() > 0) {
            c.moveToFirst();
            profissionalList.add(new ProfissionalModel(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4) > 0));
            while (c.moveToNext()) {
                profissionalList.add(new ProfissionalModel(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4) > 0));
            }
        }

        return profissionalList;

    }

    public List<ProfissionalModel> pesquisarAtivos() {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM profissional where flag_ativo = 1 order by id;", null);

        if (c.getCount() > 0) {
            c.moveToFirst();
            profissionalList.add(new ProfissionalModel(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4) > 0));
            while (c.moveToNext()) {
                profissionalList.add(new ProfissionalModel(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4) > 0));
            }
        }

        return profissionalList;

    }


}
