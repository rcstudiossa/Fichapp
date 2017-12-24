package com.fichapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fichapp.util.Constantes;

/**
 * Created by Rodrigo Costa on 11/12/2017.
 */

public class FichaVisitaDTDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    //public static final String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS profissional (id INTEGER PRIMARY KEY, profissional_id INTEGER NOT NULL, cnes_id INTEGER not null, data_registro DATE not null, turno CHAR(1) not null, microarea CHAR(2) not null, tipo_imovel CHAR(2), );";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ficha_visita_domiciliar_territorial;";

    public FichaVisitaDTDbHelper(Context context) {
        super(context, Constantes.PROFISSIONAL_DB, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getScriptCreateTable());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public String getScriptCreateTable() {

        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ficha_visita_domiciliar_territorial");

        sb.append(" (id INTEGER PRIMARY KEY, profissional_id INTEGER NOT NULL, cnes_id INTEGER not null, ine VARCHAR not null, data_registro DATE not null, turno CHAR(1) not null, microarea CHAR(2) not null, tipo_imovel CHAR(2)");
        sb.append(", prontuario VARCHAR not null, cns_cidadao VARCHAR not null, data_nascimento date not null, sexo char(1) not null, flag_visita_compartilhada boolean, flag_cadastramento  boolean, flag_visita_periodica boolean");
        sb.append(", flag_consulta boolean, flag_exame boolean, flag_vacina boolean, flag_bolsa_familia boolean, flag_gestante boolean, flag_puerpera boolean, flag_recem_nascido boolean, flag_crianca boolean, flag_desnutricao boolean");
        sb.append(", flag_reabilitacao boolean, flag_hipertensao boolean, flag_diabetes boolean, flag_asma boolean, flag_enfisema boolean, flag_doencas_cronicas boolean, flag_hanseniase boolean, flag_tuberculose boolean");
        sb.append(", flag_sintomaticos_respiratorios boolean, flag_tabagista boolean, flag_acamado boolean, flag_vulnerabilidade_social boolean, flag_acompanhamento_bolsa_familia boolean, flag_saude_mental boolean, flag_usuario_alcool boolean");
        sb.append(", flag_outras_drogas boolean, flag_acao_educativa boolean, flag_imovel_com_foco boolean, flag_acao_mecanica boolean, flag_tratamento_focal boolean, flag_egresso_internacao boolean, flag_convite boolean, flag_orientacao boolean");
        sb.append(", flag_outros boolean, peso DOUBLE, altura INTEGER, desfecho INTEGER, flag_ativo boolean, flag_exportado boolean");

        return  sb.toString();

    }
}
