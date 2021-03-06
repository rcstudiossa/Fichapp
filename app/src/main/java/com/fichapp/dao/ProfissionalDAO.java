package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
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

        Object[] args = {profissionalModel.getCbo().getCodigo(), profissionalModel.getCns(), profissionalModel.getNome(), profissionalModel.getFlagAtivo(), profissionalModel.getCnesModel().getId(), profissionalModel.getUsuario(), profissionalModel.getSenha(), profissionalModel.getIne(), profissionalModel.getId()};

        db.execSQL("UPDATE profissional SET cbo = ?, cns = ?, nome = ?, flag_ativo = ?, cnes_id = ?, usuario = ?, senha = ?, ine = ? WHERE id = ?;", args);

    }

    public void inserir(ProfissionalModel profissionalModel) {

        Object[] args = {profissionalModel.getCbo().getCodigo(), profissionalModel.getCns(), profissionalModel.getNome(), Boolean.TRUE, profissionalModel.getCnesModel().getId(), profissionalModel.getUsuario(), profissionalModel.getSenha(), profissionalModel.getIne()};

        db.execSQL("INSERT INTO profissional (cbo, cns, nome, flag_ativo, cnes_id, usuario, senha, ine) VALUES(?, ?, ?, ?, ?, ?, ?, ?);", args);
    }

    public void excluir(ProfissionalModel profissionalModel) {

        Object[] args = {Boolean.FALSE, profissionalModel.getId()};

        db.execSQL("UPDATE profissional SET flag_ativo = ? where id = ? ", args);

    }

    public void alterarSenha (ProfissionalModel profissionalModel) {

        Object[] args = {profissionalModel.getSenha(), profissionalModel.getId()};

        db.execSQL("UPDATE profissional SET senha = ? where id = ? ", args);

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
            model.setCbo(new TipoModel(c.getInt(c.getColumnIndex("cbo"))));
            model.setUsuario(c.getString(c.getColumnIndex("usuario")));
            model.setCnesModel(new CNESModel(cnesModel.getId(), cnesModel.getCodigo(), cnesModel.getNome(), cnesModel.getFlagAtivo()));
            model.setFlagAdministrador(c.getInt(c.getColumnIndex("flag_administrador")) > 0);

        }

        c.close();

        return model;

    }

    public ProfissionalModel obter(ProfissionalModel profissionalModel) {

        List<String> args = new ArrayList<>();

        args.add(profissionalModel.getId().toString());

        StringBuilder sb = new StringBuilder("SELECT id, nome, cns, cbo, flag_ativo, usuario, senha, flag_ativo, flag_administrador, cnes_id, (select c.nome from cnes c where c.id = p.cnes_id) nome_cnes, (select c.codigo from cnes c where c.id = p.cnes_id) codigo_cnes FROM profissional p WHERE id = ?");

        String[] strings = new String[args.size()];
        strings = (String[]) args.toArray(strings);

        Cursor c = db.rawQuery(sb.toString(), strings);

        ProfissionalModel model = new ProfissionalModel();

        if (c.moveToFirst()) {

            model.setId(c.getLong(c.getColumnIndex("id")));
            model.setNome(c.getString(c.getColumnIndex("nome")));
            model.setCns(c.getString(c.getColumnIndex("cns")));
            model.setCbo(new TipoModel(c.getInt(c.getColumnIndex("cbo"))));
            model.setUsuario(c.getString(c.getColumnIndex("usuario")));
            model.setCnesModel(new CNESModel(c.getLong(c.getColumnIndex("cnes_id")), c.getString(c.getColumnIndex("nome_cnes")), c.getString(c.getColumnIndex("codigo_cnes"))));
            model.setFlagAtivo(c.getInt(c.getColumnIndex("flag_ativo")) > 0);
            model.setFlagAdministrador(c.getInt(c.getColumnIndex("flag_administrador")) > 0);

        }

        c.close();

        return model;

    }

    public ProfissionalModel obterProfissionalLogado(ProfissionalModel profissionalModel) {

        List<String> args = new ArrayList<>();

        args.add(profissionalModel.getUsuario());
        args.add(profissionalModel.getSenha());

        StringBuilder sb = new StringBuilder("SELECT id, nome, cbo, flag_ativo, usuario, senha, flag_ativo, flag_administrador, cnes_id, (select c.nome from cnes c where c.id = p.cnes_id) nome_cnes, (select c.codigo from cnes c where c.id = p.cnes_id) codigo_cnes FROM profissional p WHERE flag_ativo = 1 and usuario = ? and senha = ?");

        if (profissionalModel.getFlagAdministrador()) {
            sb.append(" AND FLAG_ADMINISTRADOR = 1");
        }

        String[] strings = new String[args.size()];
        strings = (String[]) args.toArray(strings);

        Cursor c = db.rawQuery(sb.toString(), strings);

        ProfissionalModel model = new ProfissionalModel();

        if (c.moveToFirst()) {

            model.setId(c.getLong(c.getColumnIndex("id")));
            model.setNome(c.getString(c.getColumnIndex("nome")));
            model.setCbo(new TipoModel(c.getInt(c.getColumnIndex("cbo"))));
            model.setUsuario(c.getString(c.getColumnIndex("usuario")));
            model.setCnesModel(new CNESModel(c.getLong(c.getColumnIndex("cnes_id")), c.getString(c.getColumnIndex("nome_cnes")), c.getString(c.getColumnIndex("codigo_cnes"))));
            model.setFlagAtivo(c.getInt(c.getColumnIndex("flag_ativo")) > 0);
            model.setFlagAdministrador(c.getInt(c.getColumnIndex("flag_administrador")) > 0);

        }

        c.close();

        return model;

    }

    public List<ProfissionalModel> pesquisar() {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT id, nome, cbo, cns, flag_ativo, usuario, senha, flag_ativo, flag_administrador, cnes_id FROM profissional id > 1 and order by id;", null);

        if (c.moveToFirst()) {
            do {
                ProfissionalModel profissionalModel = new ProfissionalModel(c.getLong(c.getColumnIndex("id")), new TipoModel(c.getInt(c.getColumnIndex("cbo"))), c.getString(c.getColumnIndex("cns")), c.getString(c.getColumnIndex("nome")), c.getInt(c.getColumnIndex("flag_ativo")) > 0, c.getLong(c.getColumnIndex("cnes_id")));
                profissionalModel.setUsuario(c.getString(c.getColumnIndex("usuario")));
                profissionalList.add(profissionalModel);
            } while (c.moveToNext());
        }

        c.close();

        return profissionalList;

    }

    public List<ProfissionalModel> pesquisarAtivos() {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT id, nome, cbo, cns, flag_ativo, usuario, senha, flag_ativo, flag_administrador, cnes_id, ine FROM profissional where id > 1 and flag_ativo = 1 order by id;", null);

        if (c.moveToFirst()) {
            do {
                ProfissionalModel profissionalModel = new ProfissionalModel(c.getLong(c.getColumnIndex("id")), new TipoModel(c.getInt(c.getColumnIndex("cbo"))), c.getString(c.getColumnIndex("cns")), c.getString(c.getColumnIndex("nome")), c.getInt(c.getColumnIndex("flag_ativo")) > 0, c.getLong(c.getColumnIndex("cnes_id")));
                profissionalModel.setUsuario(c.getString(c.getColumnIndex("usuario")));
                profissionalModel.setSenha(c.getString(c.getColumnIndex("senha")));
                profissionalModel.setIne(c.getString(c.getColumnIndex("ine")));
                profissionalList.add(profissionalModel);
            } while (c.moveToNext());
        }

        c.close();

        return profissionalList;

    }

    public List<ProfissionalModel> pesquisarAtivos(String query) {

        List<ProfissionalModel> profissionalList = new ArrayList<>();

        String s = "%" + query.toUpperCase() + "%";

        String[] args = {s,s,s};

        Cursor c = db.rawQuery("SELECT id, nome, cbo, cns, flag_ativo, usuario, senha, flag_ativo, flag_administrador, cnes_id, ine FROM profissional where id > 1 and flag_ativo = 1 and (upper(nome) like ? or cns like ? or cbo like ?) order by id;", args);

        if (c.moveToFirst()) {
            do {
                ProfissionalModel profissionalModel = new ProfissionalModel(c.getLong(c.getColumnIndex("id")), new TipoModel(c.getInt(c.getColumnIndex("cbo"))), c.getString(c.getColumnIndex("cns")), c.getString(c.getColumnIndex("nome")), c.getInt(c.getColumnIndex("flag_ativo")) > 0, c.getLong(c.getColumnIndex("cnes_id")));
                profissionalModel.setUsuario(c.getString(c.getColumnIndex("usuario")));
                profissionalModel.setSenha(c.getString(c.getColumnIndex("senha")));
                profissionalModel.setIne(c.getString(c.getColumnIndex("ine")));
                profissionalList.add(profissionalModel);
            } while (c.moveToNext());
        }

        c.close();

        return profissionalList;

    }

}
