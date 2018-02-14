package com.fichapp.model;

import com.fichapp.util.Utilitario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 08/02/2018.
 */

public class MunicipioModel implements Serializable {

    Long id;
    String nome;
    String uf;
    Integer codigo;
    
    public MunicipioModel() {
        
    }

    public MunicipioModel(String nome) {
        this.nome = nome;
    }

    public MunicipioModel(Integer codigo) {
        this.codigo = codigo;
    }
    
    public MunicipioModel(String nome, String uf, Integer codigo) {
        
        this.nome = nome;
        this.uf = uf;
        this.codigo = codigo;
        
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MunicipioModel that = (MunicipioModel) o;

        return codigo != null ? codigo.equals(that.codigo) : that.codigo == null;

    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        /*if (!Utilitario.isEmpty(this.codigo)) {
            sb.append(codigo).append(": ");
        }*/

        sb.append(this.nome);

        if (!Utilitario.isEmpty(this.uf)) {
            sb.append(String.format(", %s", this.uf));
        }

        return sb.toString();

    }
}
