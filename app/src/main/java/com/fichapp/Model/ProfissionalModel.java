package com.fichapp.Model;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class ProfissionalModel {
    private String cboEnome;


    public ProfissionalModel(){}
    public ProfissionalModel(String cbn){
        cboEnome = cbn;
    }

    public String getModel() {
        return cboEnome;
    }
    public void setModel(String model) {
        this.cboEnome = cboEnome;
    }

}