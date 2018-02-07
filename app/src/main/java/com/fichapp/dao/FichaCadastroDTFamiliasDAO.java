package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;
import com.fichapp.model.FamiliaModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.List;

public class FichaCadastroDTFamiliasDAO {

    SQLiteDatabase db;

    public FichaCadastroDTFamiliasDAO() {}

    public FichaCadastroDTFamiliasDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
    }

    //INSERIR
    public void inserir(FamiliaModel familiaModel) {

        Object[] args = {

                familiaModel.getFichaCadastroDTModel().getId(),

                familiaModel.getProntuario(),
                familiaModel.getCnsResponsavel(),
                familiaModel.getDataNascimentoResponsavel(),
                familiaModel.getRendaFamiliar(),
                familiaModel.getNumeroMembros(),
                familiaModel.getResideAno(),
                familiaModel.getResideMes(),
                familiaModel.getFlagMudou(),
                Boolean.TRUE

        };

        String query = "insert into ficha_cadastro_domiciliar_territorial_familia" +
                " (ficha_cadastro_domiciliar_territorial_id, prontuario, cns_responsavel, data_nascimento_responsavel, renda_familiar, numero_membros_familia, ano_reside, mes_reside, flag_mudou, flag_ativo)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        db.execSQL(query, args);
    }

    //ALTERAR
    public void alterar (FamiliaModel familiaModel) {

        Object[] args = {

                familiaModel.getProntuario(),
                familiaModel.getCnsResponsavel(),
                familiaModel.getDataNascimentoResponsavel(),
                familiaModel.getRendaFamiliar(),
                familiaModel.getNumeroMembros(),
                familiaModel.getResideAno(),
                familiaModel.getResideMes(),
                familiaModel.getFlagMudou(),
                familiaModel.getFlagAtivo(),

                familiaModel.getId()};


        String query = "update ficha_cadastro_domiciliar_territorial_familia" +
                " set prontuario = ?, cns_responsavel = ?, data_nascimento_responsavel = ?, renda_familiar = ?, numero_membros_familia = ?, ano_reside = ?, mes_reside = ?, flag_mudou = ?, flag_ativo = ?" +
                " WHERE id = ?";

        db.execSQL(query, args);

    }


    public FamiliaModel obter(FamiliaModel familiaModel) {

        String[] args = {familiaModel.getId().toString()};

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_domiciliar_territorial_familia where id = ?;", args);

        if (c.moveToFirst()) {
            return getFamiliaModelInstance(c);
        }
        c.close();

        return null;

    }

    public List<FamiliaModel> pesquisar(FichaCadastroDTModel fichaCadastroDTModel) {

        String[] args = {fichaCadastroDTModel.getId().toString()};

        List<FamiliaModel> membros = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_domiciliar_territorial_familia where ficha_cadastro_domiciliar_territorial_id = ? and flag_ativo = 1;", args);

        if (c.moveToFirst()) {
            do {
                membros.add(getFamiliaModelInstance(c));
            } while (c.moveToNext());
        }
        c.close();

        return membros;

    }

    public void excluir(FamiliaModel familiaModel) {

        Object[] args = {Boolean.FALSE, familiaModel.getId()};

        db.execSQL("UPDATE ficha_cadastro_domiciliar_territorial SET flag_ativo = ? where id = ? ", args);

    }

    private FamiliaModel getFamiliaModelInstance(Cursor c) {

        FamiliaModel familiaModel = new FamiliaModel();

        familiaModel.setId(c.getLong(c.getColumnIndex("id")));
        familiaModel.setFichaCadastroDTModel(new FichaCadastroDTModel(c.getLong(c.getColumnIndex("ficha_cadastro_domiciliar_territorial_id"))));

        familiaModel.setProntuario(c.getString(c.getColumnIndex("prontuario")));
        familiaModel.setCnsResponsavel(c.getString(c.getColumnIndex("cns_responsavel")));
        familiaModel.setDataNascimentoResponsavel(Utilitario.getDate(c.getString(c.getColumnIndex("data_nascimento_responsavel"))));
        familiaModel.setRendaFamiliar(new TipoModel(c.getInt(c.getColumnIndex("renda_familiar"))));
        familiaModel.setNumeroMembros(c.getInt(c.getColumnIndex("numero_membros_familia")));
        familiaModel.setResideAno(c.getInt(c.getColumnIndex("ano_reside")));
        familiaModel.setResideMes(c.getInt(c.getColumnIndex("mes_reside")));
        familiaModel.setFlagMudou(c.getInt(c.getColumnIndex("flag_mudou")) > 0);
        familiaModel.setFlagAtivo(c.getInt(c.getColumnIndex("flag_ativo")) > 0);

        return familiaModel;

    }


}
