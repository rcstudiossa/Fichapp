package com.fichapp.Model;

import java.io.Serializable;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class CNESModel implements Serializable {

    private Long id;
    private String codigo;
    private String nome;
    private Boolean flagAtivo;

    public CNESModel(){}

    public CNESModel(Long id, String codigo, String nome, Boolean flagAtivo) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.flagAtivo = flagAtivo;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
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

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }
    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public String getSituacao() {

        return this.flagAtivo ? "Ativo" : "Inativo";

    }
}
