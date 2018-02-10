package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;
import com.fichapp.model.MunicipioModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class MunicipioDAO {

    SQLiteDatabase db;

    public MunicipioDAO() {
    }

    public MunicipioDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
    }

    public List<MunicipioModel> pesquisar(String uf) {

        List<MunicipioModel> lista = new ArrayList<>();

        String[] args = {uf};

        Cursor c = db.rawQuery("SELECT * FROM municipio where uf = ? order by nome;", args);

        lista.add(new MunicipioModel("Não respondido"));

        if (c.moveToFirst()) {
            do {
                lista.add(new MunicipioModel(c.getString(c.getColumnIndex("nome")), c.getString(c.getColumnIndex("uf")), c.getInt(c.getColumnIndex("codigo"))));
            } while (c.moveToNext());
        }

        c.close();

        return lista;

    }

}
