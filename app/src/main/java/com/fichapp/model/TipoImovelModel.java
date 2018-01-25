package com.fichapp.model;

import com.fichapp.util.Utilitario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 24/12/2017.
 */

public class TipoImovelModel implements Serializable {

    private String codigo;
    private String descricao;

    public TipoImovelModel() {

    }

    public TipoImovelModel(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public TipoImovelModel(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<TipoImovelModel> getTiposImovel() {

        List<TipoImovelModel> tipos = new ArrayList<>();
        tipos.add(new TipoImovelModel("01", "Domicílio"));
        tipos.add(new TipoImovelModel("02", "Comércio"));
        tipos.add(new TipoImovelModel("03", "Terreno"));
        tipos.add(new TipoImovelModel("04", "Ponto"));
        tipos.add(new TipoImovelModel("05", "Escola"));
        tipos.add(new TipoImovelModel("06", "Creche"));
        tipos.add(new TipoImovelModel("07", "Abrigo"));
        tipos.add(new TipoImovelModel("08", "Instituição de longa permanência p/ idosos"));
        tipos.add(new TipoImovelModel("09", "Unidade prisional"));
        tipos.add(new TipoImovelModel("10", "Unidade de medida socioeducativa"));
        tipos.add(new TipoImovelModel("11", "Delegacia"));
        tipos.add(new TipoImovelModel("12", "Estabelecimento religioso"));
        tipos.add(new TipoImovelModel("99", "Outros"));

        return tipos;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (!Utilitario.isEmpty(this.codigo)) {
            sb.append(codigo).append(": ");
        }

        sb.append(this.descricao);

        return sb.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoImovelModel that = (TipoImovelModel) o;

        return codigo != null ? codigo.equals(that.codigo) : that.codigo == null;

    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}

