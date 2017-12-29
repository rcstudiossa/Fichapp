package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class ProfissionalDAO {

    SQLiteDatabase db;

    public ProfissionalDAO() {
    }

    public ProfissionalDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
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

    public ProfissionalModel obterProfissionalLogado(ProfissionalModel profissionalModel, CNESModel cnesModel) {

        List<String> args = new ArrayList<>();

        args.add(profissionalModel.getUsuario());
        args.add(profissionalModel.getSenha());

        StringBuilder sb = new StringBuilder("SELECT * FROM profissional p WHERE flag_ativo = 1 and usuario = ? and senha = ?");

        if (!Utilitario.isEmpty(cnesModel.getId())) {
            args.add(cnesModel.getId().toString());
            sb.append(" AND EXISTS (SELECT 1 FROM profissional_cnes pc where flag_ativo = 1 and pc.profissional_id = p.id and pc.cnes_id = ?)");
        } else {
            sb.append(" AND FLAG_ADMINISTRADOR = 1");
        }

        String[] strings = new String[args.size()];
        strings = (String[]) args.toArray(strings);

        Cursor c = db.rawQuery(sb.toString(), strings);

        ProfissionalModel model = new ProfissionalModel();

        if (c.moveToFirst()) {

            model.setId(c.getLong(c.getColumnIndex("id")));
            model.setNome(c.getString(c.getColumnIndex("nome")));
            model.setCbo(c.getString(c.getColumnIndex("cbo")));
            model.setCnesModel(new CNESModel(cnesModel.getId(), cnesModel.getCodigo(), cnesModel.getNome(), cnesModel.getFlagAtivo()));
            model.setFlagAdministrador(c.getInt(c.getColumnIndex("flag_administrador")) > 0);

        }

        c.close();

        return model;

    }

    public List<ProfissionalModel> pesquisar() {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM profissional order by id;", null);

        if (c.moveToFirst()) {
            do {
                profissionalList.add(new ProfissionalModel(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4) > 0));
            } while (c.moveToNext());
        }

        c.close();

        return profissionalList;

    }

    public List<ProfissionalModel> pesquisarAtivos() {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM profissional where flag_ativo = 1 order by id;", null);

        if (c.moveToFirst()) {
            do {
                profissionalList.add(new ProfissionalModel(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4) > 0));
            } while (c.moveToNext());
        }

        c.close();

        return profissionalList;

    }

}
