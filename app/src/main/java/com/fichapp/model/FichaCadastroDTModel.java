package com.fichapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroDTModel implements Serializable {

    private Long id;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Date dataRegistro;

    private String cep;
    private String uf;
    private String municipio;
    private String bairro;
    private String tipoLogradouro;
    private String nomeLogragouro;
    private String complemento;
    private String pontoReferencia;
    private String numero;
    private Boolean flagSemNumero;
    private String microArea;
    private Boolean flagForaDeArea;
    private String telResidencia;
    private String telContato;

    private TipoModel situacaoMoradia;
    private Integer localizacao;
    private TipoModel tipoImovel;
    private Integer tipoDomicilio;
    private Integer acessoDomicilio;
    private TipoModel condicaoTerra;
    private Integer numMoradores;
    private Integer numComodos;
    private TipoModel materialParedes;
    private Integer flagEnergiaEletrica;
    private TipoModel abastecimentoAgua;
    private TipoModel aguaConsumo;
    private TipoModel escoamentoBanheiro;
    private TipoModel destinoLixo;
    private Integer flagAnimais;
    private Integer qtdAnimais;

    private Boolean flagGato;
    private Boolean flagCachorro;
    private Boolean flagPassaro;
    private Boolean flagOutrosAnimais;

    private String nomeInstituicao;
    private Integer flagOutrosProfissionais;
    private String nomeResponsavel;
    private String cnsResponsavel;
    private String cargoInstituicao;
    private String telContatoResponsavel;

    private List<FamiliaModel> familias;
    private Boolean flagRecusado;

    private Boolean flagAtivo;
    private Boolean flagExportado;

    public FichaCadastroDTModel(long ficha_cadastro_domiciliar_territorial_familia) {}

    public FichaCadastroDTModel() {}

    //-----------GETTERS E SETTERS-----------\\


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfissionalModel getProfissionalModel() {
        return profissionalModel;
    }

    public void setProfissionalModel(ProfissionalModel profissionalModel) {
        this.profissionalModel = profissionalModel;
    }

    public CNESModel getCnesModel() {
        return cnesModel;
    }

    public void setCnesModel(CNESModel cnesModel) {
        this.cnesModel = cnesModel;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getNomeLogragouro() {
        return nomeLogragouro;
    }

    public void setNomeLogragouro(String nomeLogragouro) {
        this.nomeLogragouro = nomeLogragouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getFlagSemNumero() {
        return flagSemNumero;
    }

    public void setFlagSemNumero(Boolean flagSemNumero) {
        this.flagSemNumero = flagSemNumero;
    }

    public String getMicroArea() {
        return microArea;
    }

    public void setMicroArea(String microArea) {
        this.microArea = microArea;
    }

    public Boolean getFlagForaDeArea() {
        return flagForaDeArea;
    }

    public void setFlagForaDeArea(Boolean flagForaDeArea) {
        this.flagForaDeArea = flagForaDeArea;
    }

    public String getTelResidencia() {
        return telResidencia;
    }

    public void setTelResidencia(String telResidencia) {
        this.telResidencia = telResidencia;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public TipoModel getSituacaoMoradia() {
        return situacaoMoradia;
    }

    public void setSituacaoMoradia(TipoModel situacaoMoradia) {
        this.situacaoMoradia = situacaoMoradia;
    }

    public Integer getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Integer localizacao) {
        this.localizacao = localizacao;
    }

    public TipoModel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoModel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Integer getTipoDomicilio() {
        return tipoDomicilio;
    }

    public void setTipoDomicilio(Integer tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }

    public Integer getAcessoDomicilio() {
        return acessoDomicilio;
    }

    public void setAcessoDomicilio(Integer acessoDomicilio) {
        this.acessoDomicilio = acessoDomicilio;
    }

    public TipoModel getCondicaoTerra() {
        return condicaoTerra;
    }

    public void setCondicaoTerra(TipoModel condicaoTerra) {
        this.condicaoTerra = condicaoTerra;
    }

    public Integer getNumMoradores() {
        return numMoradores;
    }

    public void setNumMoradores(Integer numMoradores) {
        this.numMoradores = numMoradores;
    }

    public Integer getNumComodos() {
        return numComodos;
    }

    public void setNumComodos(Integer numComodos) {
        this.numComodos = numComodos;
    }

    public TipoModel getMaterialParedes() {
        return materialParedes;
    }

    public void setMaterialParedes(TipoModel materialParedes) {
        this.materialParedes = materialParedes;
    }

    public Integer getFlagEnergiaEletrica() {
        return flagEnergiaEletrica;
    }

    public void setFlagEnergiaEletrica(Integer flagEnergiaEletrica) {
        this.flagEnergiaEletrica = flagEnergiaEletrica;
    }

    public TipoModel getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(TipoModel abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public TipoModel getAguaConsumo() {
        return aguaConsumo;
    }

    public void setAguaConsumo(TipoModel aguaConsumo) {
        this.aguaConsumo = aguaConsumo;
    }

    public TipoModel getEscoamentoBanheiro() {
        return escoamentoBanheiro;
    }

    public void setEscoamentoBanheiro(TipoModel escoamentoBanheiro) {
        this.escoamentoBanheiro = escoamentoBanheiro;
    }

    public TipoModel getDestinoLixo() {
        return destinoLixo;
    }

    public void setDestinoLixo(TipoModel destinoLixo) {
        this.destinoLixo = destinoLixo;
    }

    public Integer getFlagAnimais() {
        return flagAnimais;
    }

    public void setFlagAnimais(Integer flagAnimais) {
        this.flagAnimais = flagAnimais;
    }

    public Integer getQtdAnimais() {
        return qtdAnimais;
    }

    public void setQtdAnimais(Integer qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }

    public Boolean getFlagGato() {
        return flagGato;
    }

    public void setFlagGato(Boolean flagGato) {
        this.flagGato = flagGato;
    }

    public Boolean getFlagCachorro() {
        return flagCachorro;
    }

    public void setFlagCachorro(Boolean flagCachorro) {
        this.flagCachorro = flagCachorro;
    }

    public Boolean getFlagPassaro() {
        return flagPassaro;
    }

    public void setFlagPassaro(Boolean flagPassaro) {
        this.flagPassaro = flagPassaro;
    }

    public Boolean getFlagOutrosAnimais() {
        return flagOutrosAnimais;
    }

    public void setFlagOutrosAnimais(Boolean flagOutrosAnimais) {
        this.flagOutrosAnimais = flagOutrosAnimais;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public Integer getFlagOutrosProfissionais() {
        return flagOutrosProfissionais;
    }

    public void setFlagOutrosProfissionais(Integer flagOutrosProfissionais) {
        this.flagOutrosProfissionais = flagOutrosProfissionais;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCnsResponsavel() {
        return cnsResponsavel;
    }

    public void setCnsResponsavel(String cnsResponsavel) {
        this.cnsResponsavel = cnsResponsavel;
    }

    public String getCargoInstituicao() {
        return cargoInstituicao;
    }

    public void setCargoInstituicao(String cargoInstituicao) {
        this.cargoInstituicao = cargoInstituicao;
    }

    public String getTelContatoResponsavel() {
        return telContatoResponsavel;
    }

    public void setTelContatoResponsavel(String telContatoResponsavel) {
        this.telContatoResponsavel = telContatoResponsavel;
    }

    public List<FamiliaModel> getFamilias() {
        return familias;
    }

    public void setFamilias(List<FamiliaModel> familias) {
        this.familias = familias;
    }

    public Boolean getFlagRecusado() {
        return flagRecusado;
    }

    public void setFlagRecusado(Boolean flagRecusado) {
        this.flagRecusado = flagRecusado;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Boolean getFlagExportado() {
        return flagExportado;
    }

    public void setFlagExportado(Boolean flagExportado) {
        this.flagExportado = flagExportado;
    }
}