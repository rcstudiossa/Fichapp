package com.fichapp.model;

import java.io.Serializable;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class ProfissionalModel implements Serializable{

    private Long id;
    private String cbo;
    private String cns;
    private String nome;
    private CNESModel cnesModel;
    private String usuario;
    private String senha;
    private Boolean flagAtivo;
    private Boolean flagAdministrador;

    public ProfissionalModel() {}

    public ProfissionalModel(Long id) {
        this.id = id;
    }

    public ProfissionalModel(Long id, String cbo, String cns, String nome, Boolean flagAtivo, Long cnesId) {
        this.id = id;
        this.cbo = cbo;
        this.cns = cns;
        this.nome = nome;
        this.flagAtivo = flagAtivo;
        this.cnesModel = new CNESModel(cnesId);
    }

    public ProfissionalModel(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public CNESModel getCnesModel() {
        return cnesModel;
    }

    public void setCnesModel(CNESModel cnesModel) {
        this.cnesModel = cnesModel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getFlagAdministrador() {
        return flagAdministrador;
    }

    public void setFlagAdministrador(Boolean flagAdministrador) {
        this.flagAdministrador = flagAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfissionalModel that = (ProfissionalModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cbo != null ? !cbo.equals(that.cbo) : that.cbo != null) return false;
        if (cns != null ? !cns.equals(that.cns) : that.cns != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (cnesModel != null ? !cnesModel.equals(that.cnesModel) : that.cnesModel != null)
            return false;
        return flagAtivo != null ? flagAtivo.equals(that.flagAtivo) : that.flagAtivo == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cbo != null ? cbo.hashCode() : 0);
        result = 31 * result + (cns != null ? cns.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cnesModel != null ? cnesModel.hashCode() : 0);
        result = 31 * result + (flagAtivo != null ? flagAtivo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return nome + ", CBO: " + cbo;
    }
}