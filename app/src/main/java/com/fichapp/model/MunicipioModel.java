package com.fichapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Costa on 08/02/2018.
 */

public class MunicipioModel {
    
    String nome;
    String uf;
    String codigo;
    
    public MunicipioModel() {
        
    }
    
    public MunicipioModel(String nome, String uf, String codigo) {
        
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
