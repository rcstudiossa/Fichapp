package com.fichapp.model;

import com.fichapp.util.Utilitario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 26/01/2018.
 */

public class SpSalarioFamiliarModel {

    private String codigo;
    private String descricao;

    public SpSalarioFamiliarModel() {

    }

    public SpSalarioFamiliarModel(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public SpSalarioFamiliarModel(String codigo) {
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

    
    public List<SpSalarioFamiliarModel> getSalarios() {

        List<SpSalarioFamiliarModel> salarios = new ArrayList<>();
        salarios.add(new SpSalarioFamiliarModel("01", "1/4 sal. mínimo"));
        salarios.add(new SpSalarioFamiliarModel("02", "1/2 sal. mínimo"));
        salarios.add(new SpSalarioFamiliarModel("03", "01 sal. mínimo"));
        salarios.add(new SpSalarioFamiliarModel("04", "02 sal. mínimos"));
        salarios.add(new SpSalarioFamiliarModel("05", "03 sal. mínimos"));
        salarios.add(new SpSalarioFamiliarModel("06", "04 sal. mínimos"));
        salarios.add(new SpSalarioFamiliarModel("07", "Mais que 4 sal. mínimos"));

        return salarios;

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

        SpSalarioFamiliarModel that = (SpSalarioFamiliarModel) o;

        return codigo != null ? codigo.equals(that.codigo) : that.codigo == null;

    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
