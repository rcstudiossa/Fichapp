package com.fichapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fichapp.util.Constantes;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class SMPEPDbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_CNES = "CREATE TABLE IF NOT EXISTS cnes (id INTEGER PRIMARY KEY, codigo VARCHAR, nome VARCHAR, flag_ativo BOOLEAN);";
    public static final String SQL_DELETE_CNES = "DROP TABLE IF EXISTS cnes;";

    public static final String SQL_CREATE_PROFISSIONAL = "CREATE TABLE IF NOT EXISTS profissional (id INTEGER PRIMARY KEY, cbo VARCHAR, cns VARCHAR, nome VARCHAR, flag_ativo BOOLEAN, usuario VARCHAR UNIQUE, senha VARCHAR, flag_administrador BOOLEAN);";
    public static final String SQL_DELETE_PROFISSIONAL = "DROP TABLE IF EXISTS profissional;";

    public static final String SQL_CREATE_PROFISSIONAL_CNES = "CREATE TABLE IF NOT EXISTS profissional_cnes (id INTEGER PRIMARY KEY, profissional_id INTEGER not null, cnes_id INTEGER not null, flag_ativo BOOLEAN);";
    public static final String SQL_DELETE_PROFISSIONAL_CNES = "DROP TABLE IF EXISTS profissional_cnes;";

    public static final String SQL_CREATE_FICHA_VISITA_DT = "CREATE TABLE IF NOT EXISTS ficha_visita_domiciliar_territorial" +
        " (id INTEGER PRIMARY KEY, profissional_id INTEGER, cnes_id INTEGER, ine VARCHAR, data_registro DATE, turno CHAR(1), microarea CHAR(2), tipo_imovel CHAR(2)" +
        ", prontuario VARCHAR, cns_cidadao VARCHAR, data_nascimento date, sexo char(1), flag_visita_compartilhada boolean, flag_cadastramento  boolean, flag_visita_periodica boolean" +
        ", flag_consulta boolean, flag_exame boolean, flag_vacina boolean, flag_bolsa_familia boolean, flag_gestante boolean, flag_puerpera boolean, flag_recem_nascido boolean, flag_crianca boolean, flag_desnutricao boolean" +
        ", flag_reabilitacao boolean, flag_hipertensao boolean, flag_diabetes boolean, flag_asma boolean, flag_enfisema boolean, flag_cancer boolean, flag_doencas_cronicas boolean, flag_hanseniase boolean, flag_tuberculose boolean" +
        ", flag_sintomaticos_respiratorios boolean, flag_tabagista boolean, flag_acamado boolean, flag_vulnerabilidade_social boolean, flag_acompanhamento_bolsa_familia boolean, flag_saude_mental boolean, flag_usuario_alcool boolean" +
        ", flag_outras_drogas boolean, flag_acao_educativa boolean, flag_imovel_com_foco boolean, flag_acao_mecanica boolean, flag_tratamento_focal boolean, flag_egresso_internacao boolean, flag_convite boolean, flag_orientacao boolean" +
        ", flag_outros boolean, peso DOUBLE, altura INTEGER, desfecho INTEGER, flag_ativo boolean, flag_exportado boolean);";
    public static final String SQL_DELETE_FICHA_VISITA_DT = "DROP TABLE IF EXISTS ficha_visita_domiciliar_territorial;";

    public static final String SQL_CREATE_FICHA_CADASTRO_DT = "CREATE TABLE IF NOT EXISTS ficha_cadastro_domiciliar_territorial" +
            " (id INTEGER PRIMARY KEY, profissional_id INTEGER, cnes_id INTEGER, data_registro DATE, turno CHAR(1), cep VARCHAR, uf VARCHAR(2), municipio VARCHAR, bairro VARCHAR, tipo_logradouro VARCHAR, nome_logradouro VARCHAR, complemento VARCHAR" +
            ", ponto_referencia VARCHAR, numero CHAR, flag_sem_numero BOOLEAN, microarea CHAR(2), flag_fora_de_area BOOLEAN, tipo_imovel CHAR(2), tel_residencia VARCHAR, tel_contato VARCHAR, situacao_moradia INTEGER, localizacao INTEGER" +
            ", tipo_domicilio INTEGER, acesso_domicilio INTEGER, condicao_terra INTEGER, num_moradores INTEGER, num_comodos INTEGER, material_paredes INTEGER, flag_energia_eletrica BOOLEAN, abastecimento_agua INTEGER, agua_consumo INTEGER" +
            ", escoamento_banheiro INTEGER, destino_lixo INTEGER, flag_animais BOOLEAN, qtd_animais INTEGER, flag_gato BOOLEAN, flag_cachorro BOOLEAN, flag_passaro BOOLEAN, flag_outros BOOLEAN, nome_instituicao VARCHAR" +
            ", flag_outros_profissionais BOOLEAN, nome_responsavel VARCHAR, cns_responsavel VARCHAR, cargo_instituicao VARCHAR, tel_contato_responsavel VARCHAR, flag_ativo BOOLEAN, flag_exportado BOOLEAN;";
    public static final String SQL_DELETE_FICHA_CADASTRO_DT = "DROP TABLE IF EXISTS ficha_cadastro_domiciliar_territorial;";



    public static final String SQL_INSERT_PROFISSIONAL = "INSERT INTO profissional (id, nome, flag_ativo, usuario, senha, flag_administrador) values (1, 'smpep', 1, 'smpep', 'topsys', 1);";



    public SMPEPDbHelper(Context context) {
        super(context, Constantes.SMPEP_DB, null, Constantes.DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(SQL_CREATE_CNES);
        //db.execSQL(SQL_CREATE_PROFISSIONAL);
        //db.execSQL(SQL_INSERT_PROFISSIONAL);
        //db.execSQL(SQL_CREATE_PROFISSIONAL_CNES);
        db.execSQL(SQL_CREATE_FICHA_VISITA_DT);
        db.execSQL(SQL_CREATE_FICHA_CADASTRO_DT);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //db.execSQL(SQL_DELETE_CNES);
        //db.execSQL(SQL_DELETE_PROFISSIONAL);
        //db.execSQL(SQL_DELETE_PROFISSIONAL_CNES);
        db.execSQL(SQL_DELETE_FICHA_VISITA_DT);
        db.execSQL(SQL_CREATE_FICHA_CADASTRO_DT);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
