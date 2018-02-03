package com.fichapp.model;

import java.util.Date;

/**
 * Created by Rodrigo Costa on 31/01/2018.
 */

public class FamiliaModel {

    private Long id;
    private FichaCadastroDTModel fichaCadastroDTModel;

    private String prontuario;
    private String cnsResponsavel;
    private Date dataNascimentoResponsavel;
    private TipoModel rendaFamiliar;
    private Integer numeroMembros;
    private Integer resideMes;
    private Integer resideAno;
    private Boolean flagMudou;

    private Boolean flagAtivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FichaCadastroDTModel getFichaCadastroDTModel() {
        return fichaCadastroDTModel;
    }

    public void setFichaCadastroDTModel(FichaCadastroDTModel fichaCadastroDTModel) {
        this.fichaCadastroDTModel = fichaCadastroDTModel;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getCnsResponsavel() {
        return cnsResponsavel;
    }

    public void setCnsResponsavel(String cnsResponsavel) {
        this.cnsResponsavel = cnsResponsavel;
    }

    public Date getDataNascimentoResponsavel() {
        return dataNascimentoResponsavel;
    }

    public void setDataNascimentoResponsavel(Date dataNascimentoResponsavel) {
        this.dataNascimentoResponsavel = dataNascimentoResponsavel;
    }

    public TipoModel getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(TipoModel rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public Integer getNumeroMembros() {
        return numeroMembros;
    }

    public void setNumeroMembros(Integer numeroMembros) {
        this.numeroMembros = numeroMembros;
    }

    public Integer getResideMes() {
        return resideMes;
    }

    public void setResideMes(Integer resideMes) {
        this.resideMes = resideMes;
    }

    public Integer getResideAno() {
        return resideAno;
    }

    public void setResideAno(Integer resideAno) {
        this.resideAno = resideAno;
    }

    public Boolean getFlagMudou() {
        return flagMudou;
    }

    public void setFlagMudou(Boolean flagMudou) {
        this.flagMudou = flagMudou;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamiliaModel that = (FamiliaModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fichaCadastroDTModel != null ? !fichaCadastroDTModel.equals(that.fichaCadastroDTModel) : that.fichaCadastroDTModel != null)
            return false;
        if (prontuario != null ? !prontuario.equals(that.prontuario) : that.prontuario != null)
            return false;
        if (cnsResponsavel != null ? !cnsResponsavel.equals(that.cnsResponsavel) : that.cnsResponsavel != null)
            return false;
        if (dataNascimentoResponsavel != null ? !dataNascimentoResponsavel.equals(that.dataNascimentoResponsavel) : that.dataNascimentoResponsavel != null)
            return false;
        if (rendaFamiliar != null ? !rendaFamiliar.equals(that.rendaFamiliar) : that.rendaFamiliar != null)
            return false;
        if (numeroMembros != null ? !numeroMembros.equals(that.numeroMembros) : that.numeroMembros != null)
            return false;
        if (resideMes != null ? !resideMes.equals(that.resideMes) : that.resideMes != null)
            return false;
        if (resideAno != null ? !resideAno.equals(that.resideAno) : that.resideAno != null)
            return false;
        if (flagMudou != null ? !flagMudou.equals(that.flagMudou) : that.flagMudou != null)
            return false;
        return flagAtivo != null ? flagAtivo.equals(that.flagAtivo) : that.flagAtivo == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fichaCadastroDTModel != null ? fichaCadastroDTModel.hashCode() : 0);
        result = 31 * result + (prontuario != null ? prontuario.hashCode() : 0);
        result = 31 * result + (cnsResponsavel != null ? cnsResponsavel.hashCode() : 0);
        result = 31 * result + (dataNascimentoResponsavel != null ? dataNascimentoResponsavel.hashCode() : 0);
        result = 31 * result + (rendaFamiliar != null ? rendaFamiliar.hashCode() : 0);
        result = 31 * result + (numeroMembros != null ? numeroMembros.hashCode() : 0);
        result = 31 * result + (resideMes != null ? resideMes.hashCode() : 0);
        result = 31 * result + (resideAno != null ? resideAno.hashCode() : 0);
        result = 31 * result + (flagMudou != null ? flagMudou.hashCode() : 0);
        result = 31 * result + (flagAtivo != null ? flagAtivo.hashCode() : 0);
        return result;
    }
}
