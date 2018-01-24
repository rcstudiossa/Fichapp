package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class CNESDAO {

    SQLiteDatabase db;

    public CNESDAO() {
    }

    public CNESDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
    }

    public void alterar(CNESModel cnesModel) {

        Object[] args = {cnesModel.getCodigo(), cnesModel.getNome(), cnesModel.getFlagAtivo(), cnesModel.getId()};

        db.execSQL("UPDATE cnes set codigo = ?, nome = ?, flag_ativo = ? WHERE id = ?;", args);

    }

    public void inserir(CNESModel cnesModel) {

        Object[] args = {cnesModel.getCodigo(), cnesModel.getNome(), Boolean.TRUE};

        db.execSQL("INSERT INTO cnes (codigo, nome, flag_ativo) VALUES(?, ?, ?);", args);
    }

    public void excluir(CNESModel cnesModel) {

        Object[] args = {Boolean.FALSE, cnesModel.getId()};

        db.execSQL("UPDATE cnes SET flag_ativo = ? where id = ? ", args);

    }

    public List<CNESModel> pesquisar() {

        List<CNESModel> cnesList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM cnes order by id;", null);

        if (c.moveToFirst()) {
            do {
                cnesList.add(new CNESModel(c.getLong(0), c.getString(1), c.getString(2), c.getInt(3) > 0));
            } while (c.moveToNext());
        }

        c.close();

        return cnesList;

    }

    public List<CNESModel> pesquisarAtivos() {

        List<CNESModel> cnesList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM cnes where flag_ativo = 1 order by id;", null);

        if (c.moveToFirst()) {
            do {
                cnesList.add(new CNESModel(c.getLong(0), c.getString(1), c.getString(2), c.getInt(3) > 0));
            } while (c.moveToNext());
        }

        c.close();

        return cnesList;

    }

    public List<CNESModel> pesquisarAtivos(String query) {

        List<CNESModel> cnesList = new ArrayList<>();

        String s = "%" + query.toUpperCase() + "%";

        String[] args = {s, s};

        Cursor c = db.rawQuery("SELECT * FROM cnes where flag_ativo = 1 and (upper(codigo) like ? or upper(nome) like ?) order by id;", args);

        if (c.moveToFirst()) {
            do {
                cnesList.add(new CNESModel(c.getLong(0), c.getString(1), c.getString(2), c.getInt(3) > 0));
            } while (c.moveToNext());
        }

        c.close();

        return cnesList;

    }

}
