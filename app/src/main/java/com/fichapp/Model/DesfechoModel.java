package com.fichapp.Model;

/**
 * Created by Rodrigo Costa on 24/12/2017.
 */

public class DesfechoModel {

    private Long id;
    private String descricao;

    public DesfechoModel() {

    }

    public DesfechoModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
