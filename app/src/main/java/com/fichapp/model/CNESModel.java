package com.fichapp.model;

import com.fichapp.util.Utilitario;

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

    public CNESModel(String nome) {
        this.nome = nome;
    }

    public CNESModel(Long id){
        this.id = id;
    }

    public CNESModel(Long id, String codigo, String nome, Boolean flagAtivo) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.flagAtivo = flagAtivo;
    }

    public CNESModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CNESModel cnesModel = (CNESModel) o;

        return id != null ? id.equals(cnesModel.id) : cnesModel.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (!Utilitario.isEmpty(this.codigo)) {
            sb.append(codigo).append(": ");
        }

        sb.append(this.nome);

        return sb.toString();

    }
}
