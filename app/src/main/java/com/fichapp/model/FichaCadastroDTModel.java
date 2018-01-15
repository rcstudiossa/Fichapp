package com.fichapp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroDTModel implements Serializable {

    private Long id;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Date dataRegistro;
    private String turno;

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
    private TipoImovelModel tipoImovelModel;
    private String telResidencia;
    private String telContato;

    private Integer situacaoMoradia;
    private Integer localizacao;
    private Integer tipoImovel;
    private Integer acessoDomicilio;
    private Integer condicaoTerra;
    private Integer numMoradores;
    private Integer numComodos;
    private Integer materialParedes;
    private Boolean flagEnergiaEletrica;
    private Integer abastecimentoAgua;
    private Integer aguaConsumo;
    private Integer escoamentoBanheiro;
    private Integer destinoLixo;
    private Boolean flagAnimais;
    private Integer qtdAnimais;

    private Boolean flagGato;
    private Boolean flagCachorro;
    private Boolean flagPassaro;
    private Boolean flagOutrosAnimais;

    private String nomeInstituicao;
    private Boolean flagOutrosProfissionais;
    private String nomeResponsavel;
    private String cnsResponsavel;
    private String cargoInstituicao;
    private String telContatoResponsavel;

    private Boolean flagAtivo;
    private Boolean flagExportado;


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

    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
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

    public TipoImovelModel getTipoImovelModel() {
        return tipoImovelModel;
    }
    public void setTipoImovelModel(TipoImovelModel tipoImovelModel) {
        this.tipoImovelModel = tipoImovelModel;
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

    public Integer getSituacaoMoradia() {
        return situacaoMoradia;
    }
    public void setSituacaoMoradia(Integer situacaoMoradia) {
        this.situacaoMoradia = situacaoMoradia;
    }

    public Integer getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(Integer localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getTipoImovel() {
        return tipoImovel;
    }
    public void setTipoImovel(Integer tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Integer getAcessoDomicilio() {
        return acessoDomicilio;
    }
    public void setAcessoDomicilio(Integer acessoDomicilio) {
        this.acessoDomicilio = acessoDomicilio;
    }

    public Integer getCondicaoTerra() {
        return condicaoTerra;
    }
    public void setCondicaoTerra(Integer condicaoTerra) {
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

    public Integer getMaterialParedes() {
        return materialParedes;
    }
    public void setMaterialParedes(Integer materialParedes) {
        this.materialParedes = materialParedes;
    }

    public Boolean getFlagEnergiaEletrica() {
        return flagEnergiaEletrica;
    }
    public void setFlagEnergiaEletrica(Boolean flagEnergiaEletrica) {
        this.flagEnergiaEletrica = flagEnergiaEletrica;
    }

    public Integer getAbastecimentoAgua() {
        return abastecimentoAgua;
    }
    public void setAbastecimentoAgua(Integer abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public Integer getAguaConsumo() {
        return aguaConsumo;
    }
    public void setAguaConsumo(Integer aguaConsumo) {
        this.aguaConsumo = aguaConsumo;
    }

    public Integer getEscoamentoBanheiro() {
        return escoamentoBanheiro;
    }
    public void setEscoamentoBanheiro(Integer escoamentoBanheiro) {
        this.escoamentoBanheiro = escoamentoBanheiro;
    }

    public Integer getDestinoLixo() {
        return destinoLixo;
    }
    public void setDestinoLixo(Integer destinoLixo) {
        this.destinoLixo = destinoLixo;
    }

    public Boolean getFlagAnimais() {
        return flagAnimais;
    }
    public void setFlagAnimais(Boolean flagAnimais) {
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
    public void setFlagOutrosAnimais(Boolean flagOutros) {
        this.flagOutrosAnimais = flagOutros;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public Boolean getFlagOutrosProfissionais() {
        return flagOutrosProfissionais;
    }
    public void setFlagOutrosProfissionais(Boolean flagOutrosProfissionais) {
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