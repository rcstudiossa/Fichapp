package com.fichapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fichapp.model.CNESModel;
import com.fichapp.model.FichaCadastroDTModel;
import com.fichapp.model.MunicipioModel;
import com.fichapp.model.ProfissionalModel;
import com.fichapp.model.TipoModel;
import com.fichapp.util.Utilitario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FichaCadastroDTDAO {

    SQLiteDatabase db;

    public FichaCadastroDTDAO() {}

    public FichaCadastroDTDAO(SMPEPDbHelper smpepDbHelper) {
        this.db = smpepDbHelper.getWritableDatabase();
    }

    public void inserir(FichaCadastroDTModel fichaModel) {

        fichaModel.setId(obterSequence());

        Object[] args = {
                fichaModel.getId(),
                fichaModel.getProfissionalModel().getId(),
                fichaModel.getCnesModel().getId(),
                Utilitario.getDataFormatada(fichaModel.getDataRegistro()),
                fichaModel.getCep(),
                fichaModel.getUf().getCodigo(),
                fichaModel.getMunicipio().getCodigo(),
                fichaModel.getBairro(),
                fichaModel.getTipoLogradouro().getCodigo(),
                fichaModel.getNomeLogragouro(),
                fichaModel.getComplemento(),
                fichaModel.getPontoReferencia(),
                fichaModel.getNumero(),
                fichaModel.getFlagSemNumero(),
                fichaModel.getMicroArea(),
                fichaModel.getFlagForaDeArea(),
                fichaModel.getTipoImovel().getCodigo(),
                fichaModel.getTelResidencia(),
                fichaModel.getTelContato(),
                fichaModel.getFlagRecusado(),
                fichaModel.getSituacaoMoradia().getCodigo(),
                fichaModel.getLocalizacao(),
                fichaModel.getTipoDomicilio(),
                fichaModel.getAcessoDomicilio(),
                fichaModel.getCondicaoTerra().getCodigo(),
                fichaModel.getNumMoradores(),
                fichaModel.getNumComodos(),
                fichaModel.getMaterialParedes().getCodigo(),
                fichaModel.getFlagEnergiaEletrica(),
                fichaModel.getAbastecimentoAgua().getCodigo(),
                fichaModel.getAguaConsumo().getCodigo(),
                fichaModel.getEscoamentoBanheiro().getCodigo(),
                fichaModel.getDestinoLixo().getCodigo(),
                fichaModel.getFlagAnimais(),
                fichaModel.getQtdAnimais(),
                fichaModel.getFlagGato(),
                fichaModel.getFlagCachorro(),
                fichaModel.getFlagPassaro(),
                fichaModel.getFlagOutrosAnimais(),
                fichaModel.getNomeInstituicao(),
                fichaModel.getFlagOutrosProfissionais(),
                fichaModel.getNomeResponsavel(),
                fichaModel.getCnsResponsavel(),
                fichaModel.getCargoInstituicao(),
                fichaModel.getTelContatoResponsavel(),

                Boolean.TRUE,
                Boolean.FALSE };

        String query = "insert into ficha_cadastro_domiciliar_territorial (id, profissional_id, cnes_id, data_registro, cep, uf, municipio, bairro, tipo_logradouro, nome_logradouro, complemento" +
                ", ponto_referencia, numero, flag_sem_numero, microarea, flag_fora_de_area, tipo_imovel, tel_residencia, tel_contato, flag_recusado, situacao_moradia, localizacao" +
                ", tipo_domicilio, acesso_domicilio, condicao_terra, num_moradores, num_comodos, material_paredes, flag_energia_eletrica, abastecimento_agua, agua_consumo" +
                ", escoamento_banheiro, destino_lixo, flag_animais, qtd_animais, flag_gato, flag_cachorro, flag_passaro, flag_outros, nome_instituicao" +
                ", flag_outros_profissionais, nome_responsavel, cns_responsavel, cargo_instituicao, tel_contato_responsavel, flag_ativo, flag_exportado)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        db.execSQL(query, args);
    }

    public void alterar (FichaCadastroDTModel fichaModel) throws SQLException {

        Object[] args = {

                fichaModel.getProfissionalModel().getId(),
                fichaModel.getCnesModel().getId(),
                Utilitario.getDataFormatada(fichaModel.getDataRegistro()),
                fichaModel.getCep(),
                fichaModel.getUf().getCodigo(),
                fichaModel.getMunicipio().getCodigo(),
                fichaModel.getBairro(),
                fichaModel.getTipoLogradouro().getCodigo(),
                fichaModel.getNomeLogragouro(),
                fichaModel.getComplemento(),
                fichaModel.getPontoReferencia(),
                fichaModel.getNumero(),
                fichaModel.getFlagSemNumero(),
                fichaModel.getMicroArea(),
                fichaModel.getFlagForaDeArea(),
                fichaModel.getTipoImovel().getCodigo(),
                fichaModel.getTelResidencia(),
                fichaModel.getTelContato(),
                fichaModel.getFlagRecusado(),
                fichaModel.getSituacaoMoradia().getCodigo(),
                fichaModel.getLocalizacao(),
                fichaModel.getTipoDomicilio(),
                fichaModel.getAcessoDomicilio(),
                fichaModel.getCondicaoTerra().getCodigo(),
                fichaModel.getNumMoradores(),
                fichaModel.getNumComodos(),
                fichaModel.getMaterialParedes().getCodigo(),
                fichaModel.getFlagEnergiaEletrica(),
                fichaModel.getAbastecimentoAgua().getCodigo(),
                fichaModel.getAguaConsumo().getCodigo(),
                fichaModel.getEscoamentoBanheiro().getCodigo(),
                fichaModel.getDestinoLixo().getCodigo(),
                fichaModel.getFlagAnimais(),
                fichaModel.getQtdAnimais(),
                fichaModel.getFlagGato(),
                fichaModel.getFlagCachorro(),
                fichaModel.getFlagPassaro(),
                fichaModel.getFlagOutrosAnimais(),
                fichaModel.getNomeInstituicao(),
                fichaModel.getFlagOutrosProfissionais(),
                fichaModel.getNomeResponsavel(),
                fichaModel.getCnsResponsavel(),
                fichaModel.getCargoInstituicao(),
                fichaModel.getTelContatoResponsavel(),

                fichaModel.getFlagAtivo(),
                fichaModel.getFlagExportado(),
                fichaModel.getId()};


        String query = "update ficha_cadastro_domiciliar_territorial set profissional_id   = ?, cnes_id = ?, data_registro = ?, cep = ?, uf = ?, municipio = ?, bairro = ?, tipo_logradouro = ?, nome_logradouro = ?, complemento = ?" +
                ", ponto_referencia = ?, numero = ?, flag_sem_numero = ?, microarea = ?, flag_fora_de_area = ?, tipo_imovel = ?, tel_residencia = ?, tel_contato = ?, flag_recusado = ?, situacao_moradia = ?, localizacao = ?" +
                ", tipo_domicilio = ?, acesso_domicilio = ?, condicao_terra = ?, num_moradores = ?, num_comodos = ?, material_paredes = ?, flag_energia_eletrica = ?, abastecimento_agua = ?, agua_consumo = ?" +
                ", escoamento_banheiro = ?, destino_lixo = ?, flag_animais = ?, qtd_animais = ?, flag_gato = ?, flag_cachorro = ?, flag_passaro = ?, flag_outros = ?, nome_instituicao = ?" +
                ", flag_outros_profissionais = ?, nome_responsavel = ?, cns_responsavel = ?, cargo_instituicao = ?, tel_contato_responsavel = ?, flag_ativo = ?, flag_exportado = ? where id = ?";

        db.execSQL(query, args);

    }


    public void excluir(FichaCadastroDTModel fichaCadastroDTModel) {

        Object[] args = {Boolean.FALSE, fichaCadastroDTModel.getId()};

        db.execSQL("UPDATE ficha_cadastro_domiciliar_territorial SET flag_ativo = ? where id = ? ", args);

    }

    public void restaurar(FichaCadastroDTModel fichaCadastroDTModel) {

        Object[] args = {Boolean.TRUE, fichaCadastroDTModel.getId()};

        db.execSQL("UPDATE ficha_cadastro_domiciliar_territorial SET flag_ativo = ? where id = ? ", args);

    }

    public List<FichaCadastroDTModel> pesquisar() {

        List<FichaCadastroDTModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_domiciliar_territorial order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaCadastroDTModel> pesquisarNaoExportados() {

        List<FichaCadastroDTModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_domiciliar_territorial where flag_ativo = 1 and flag_exportado = 0 order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaCadastroDTModel> pesquisarAtivos() {

        List<FichaCadastroDTModel> fichas = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT id, data_registro, cep, bairro, numero FROM ficha_cadastro_domiciliar_territorial where flag_ativo = 1 order by id;", null);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public List<FichaCadastroDTModel> pesquisarAtivos(String query) {

        List<FichaCadastroDTModel> fichas = new ArrayList<>();

        String s = "%" + query + "%";

        String[] args = {s,s,s,s};

        Cursor c = db.rawQuery("SELECT id, data_registro, cep, bairro, numero FROM ficha_cadastro_domiciliar_territorial where flag_ativo = 1 and (id = ? or cep like ? or strftime( '%d/%m/%Y', data_registro) like ? or bairro like ?) order by id;", args);

        if (c.moveToFirst()) {
            do {
                fichas.add(getFichaCadastroDTPesquisaModelInstance(c));
            } while (c.moveToNext());
        }

        c.close();

        return fichas;

    }

    public FichaCadastroDTModel obter(FichaCadastroDTModel fichaCadastroDTModel) {

        String[] args = {fichaCadastroDTModel.getId().toString()};

        Cursor c = db.rawQuery("SELECT * FROM ficha_cadastro_domiciliar_territorial where id = ?;", args);

        if (c.moveToFirst()) {
            return getFichaCadastroDTModelInstance(c);
        }
        c.close();

        return null;

    }

    public Long obterSequence() {

        Cursor c = db.rawQuery("select coalesce(max(id),0) + 1 as id from ficha_cadastro_domiciliar_territorial", null);

        if (c.moveToFirst()) {
            return c.getLong(c.getColumnIndex("id"));
        }
        c.close();

        return null;

    }

    private FichaCadastroDTModel getFichaCadastroDTPesquisaModelInstance(Cursor c) {

        FichaCadastroDTModel fichaModel = new FichaCadastroDTModel();
        fichaModel.setId(c.getLong(c.getColumnIndex("id")));
        fichaModel.setDataRegistro(Utilitario.getDate(c.getString(c.getColumnIndex("data_registro"))));
        fichaModel.setCep(c.getString(c.getColumnIndex("cep")));
        fichaModel.setBairro(c.getString(c.getColumnIndex("bairro")));
        fichaModel.setNumero(c.getString(c.getColumnIndex("numero")));

        return fichaModel;
    }

    private FichaCadastroDTModel getFichaCadastroDTModelInstance(Cursor c) {

        FichaCadastroDTModel fichaModel = new FichaCadastroDTModel();
        fichaModel.setId(c.getLong(c.getColumnIndex("id")));
        fichaModel.setProfissionalModel(new ProfissionalModel(c.getLong(c.getColumnIndex("profissional_id"))));
        fichaModel.setCnesModel(new CNESModel(c.getLong(c.getColumnIndex("cnes_id"))));
        fichaModel.setDataRegistro(Utilitario.getDate(c.getString(c.getColumnIndex("data_registro"))));

        fichaModel.setCep(c.getString(c.getColumnIndex("cep")));
        fichaModel.setUf(new TipoModel(c.getInt(c.getColumnIndex("uf"))));
        fichaModel.setMunicipio(new MunicipioModel(c.getInt(c.getColumnIndex("municipio"))));
        fichaModel.setBairro(c.getString(c.getColumnIndex("bairro")));
        fichaModel.setTipoLogradouro(new TipoModel(c.getInt(c.getColumnIndex("tipo_logradouro"))));
        fichaModel.setNomeLogragouro(c.getString(c.getColumnIndex("nome_logradouro")));
        fichaModel.setComplemento(c.getString(c.getColumnIndex("complemento")));
        fichaModel.setPontoReferencia(c.getString(c.getColumnIndex("ponto_referencia")));
        fichaModel.setNumero(c.getString(c.getColumnIndex("numero")));
        fichaModel.setFlagSemNumero(c.getInt(c.getColumnIndex("flag_sem_numero")) > 0);
        fichaModel.setMicroArea(c.getString(c.getColumnIndex("microarea")));
        fichaModel.setFlagForaDeArea(c.getInt(c.getColumnIndex("flag_fora_de_area")) > 0);
        fichaModel.setTipoImovel(new TipoModel(c.getInt(c.getColumnIndex("tipo_imovel"))));
        fichaModel.setTelResidencia(c.getString(c.getColumnIndex("tel_residencia")));
        fichaModel.setTelContato(c.getString(c.getColumnIndex("tel_contato")));
        fichaModel.setFlagRecusado(c.getInt(c.getColumnIndex("flag_recusado")) > 0);

        fichaModel.setSituacaoMoradia(new TipoModel(c.getInt(c.getColumnIndex("situacao_moradia"))));
        fichaModel.setLocalizacao(c.getInt(c.getColumnIndex("localizacao")));
        fichaModel.setTipoDomicilio(c.getInt(c.getColumnIndex("tipo_domicilio")));
        fichaModel.setAcessoDomicilio(c.getInt(c.getColumnIndex("acesso_domicilio")));
        fichaModel.setCondicaoTerra(new TipoModel(c.getInt(c.getColumnIndex("condicao_terra"))));
        fichaModel.setNumMoradores(c.getInt(c.getColumnIndex("num_moradores")));
        fichaModel.setNumComodos(c.getInt(c.getColumnIndex("num_comodos")));
        fichaModel.setMaterialParedes(new TipoModel(c.getInt(c.getColumnIndex("material_paredes"))));
        fichaModel.setFlagEnergiaEletrica(c.getInt(c.getColumnIndex("flag_energia_eletrica")));
        fichaModel.setAguaConsumo(new TipoModel(c.getInt(c.getColumnIndex("agua_consumo"))));
        fichaModel.setEscoamentoBanheiro(new TipoModel(c.getInt(c.getColumnIndex("escoamento_banheiro"))));
        fichaModel.setDestinoLixo(new TipoModel(c.getInt(c.getColumnIndex("destino_lixo"))));
        fichaModel.setFlagAnimais(c.getInt(c.getColumnIndex("flag_animais")));
        fichaModel.setQtdAnimais(c.getInt(c.getColumnIndex("qtd_animais")));

        fichaModel.setFlagGato(c.getInt(c.getColumnIndex("flag_gato")) > 0);
        fichaModel.setFlagCachorro(c.getInt(c.getColumnIndex("flag_cachorro")) > 0);
        fichaModel.setFlagPassaro(c.getInt(c.getColumnIndex("flag_passaro")) > 0);
        fichaModel.setFlagOutrosAnimais(c.getInt(c.getColumnIndex("flag_outros")) > 0);

        fichaModel.setNomeInstituicao(c.getString(c.getColumnIndex("nome_instituicao")));
        fichaModel.setFlagOutrosProfissionais(c.getInt(c.getColumnIndex("flag_outros_profissionais")));
        fichaModel.setNomeResponsavel(c.getString(c.getColumnIndex("nome_responsavel")));
        fichaModel.setCnsResponsavel(c.getString(c.getColumnIndex("cns_responsavel")));
        fichaModel.setCargoInstituicao(c.getString(c.getColumnIndex("cargo_instituicao")));
        fichaModel.setTelContatoResponsavel(c.getString(c.getColumnIndex("tel_contato_responsavel")));

        fichaModel.setFlagAtivo(c.getInt(c.getColumnIndex("flag_ativo")) > 0);
        fichaModel.setFlagExportado(c.getInt(c.getColumnIndex("flag_exportado")) > 0);

        return fichaModel;


    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }
}
