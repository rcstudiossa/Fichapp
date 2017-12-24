package com.fichapp.Model;

import java.io.Serializable;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class ProfissionalModel implements Serializable{

    private Long id;
    private String cbo;
    private String cns;
    private String nome;
    private Boolean flagAtivo;

    public ProfissionalModel() {}

    public ProfissionalModel(Long id) {
        this.id = id;
    }

    public ProfissionalModel(Long id, String codigo, String cns, String nome, Boolean flagAtivo) {
        this.id = id;
        this.cbo = codigo;
        this.cns = cns;
        this.nome = nome;
        this.flagAtivo = flagAtivo;
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
}