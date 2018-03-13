package com.fichapp.model.integracao;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel implements Serializable {

	private String nomeSocial;

	private String codigoIbgeMunicipioNascimento;

	private Date dataNascimentoCidadao;

	private Boolean flagDesconheceNomeMae;

	private String emailCidadao;

	private Long nacionalidadeCidadao;

	private String nomeCidadao;

	private String nomeMaeCidadao;

	private String cnsCidadao;

	private String cnsResponsavelFamiliar;

	private String telefoneCelular;

	private String numeroNisPisPasep;

	private Long paisNascimento;

	private Long racaCorCidadao;

	private Long sexoCidadao;

	private Boolean flagStatusEhResponsavel;

	private Long etnia;

	private String nomePaiCidadao;

	private Boolean flagDesconheceNomePai;

	private Date dataNaturalizacao;

	private String portariaNaturalizacao;

	private Date dataEntradaBrasil;

	private String microArea;

	private Boolean flagSituacaoForaArea;

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getCodigoIbgeMunicipioNascimento() {
		return codigoIbgeMunicipioNascimento;
	}

	public void setCodigoIbgeMunicipioNascimento(String codigoIbgeMunicipioNascimento) {
		this.codigoIbgeMunicipioNascimento = codigoIbgeMunicipioNascimento;
	}

	public Date getDataNascimentoCidadao() {
		return dataNascimentoCidadao;
	}

	public void setDataNascimentoCidadao(Date dataNascimentoCidadao) {
		this.dataNascimentoCidadao = dataNascimentoCidadao;
	}

	public Boolean getFlagDesconheceNomeMae() {
		return flagDesconheceNomeMae;
	}

	public void setFlagDesconheceNomeMae(Boolean flagDesconheceNomeMae) {
		this.flagDesconheceNomeMae = flagDesconheceNomeMae;
	}

	public String getEmailCidadao() {
		return emailCidadao;
	}

	public void setEmailCidadao(String emailCidadao) {
		this.emailCidadao = emailCidadao;
	}

	public Long getNacionalidadeCidadao() {
		return nacionalidadeCidadao;
	}

	public void setNacionalidadeCidadao(Long nacionalidadeCidadao) {
		this.nacionalidadeCidadao = nacionalidadeCidadao;
	}

	public String getNomeCidadao() {
		return nomeCidadao;
	}

	public void setNomeCidadao(String nomeCidadao) {
		this.nomeCidadao = nomeCidadao;
	}

	public String getNomeMaeCidadao() {
		return nomeMaeCidadao;
	}

	public void setNomeMaeCidadao(String nomeMaeCidadao) {
		this.nomeMaeCidadao = nomeMaeCidadao;
	}

	public String getCnsCidadao() {
		return cnsCidadao;
	}

	public void setCnsCidadao(String cnsCidadao) {
		this.cnsCidadao = cnsCidadao;
	}

	public String getCnsResponsavelFamiliar() {
		return cnsResponsavelFamiliar;
	}

	public void setCnsResponsavelFamiliar(String cnsResponsavelFamiliar) {
		this.cnsResponsavelFamiliar = cnsResponsavelFamiliar;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getNumeroNisPisPasep() {
		return numeroNisPisPasep;
	}

	public void setNumeroNisPisPasep(String numeroNisPisPasep) {
		this.numeroNisPisPasep = numeroNisPisPasep;
	}

	public Long getPaisNascimento() {
		return paisNascimento;
	}

	public void setPaisNascimento(Long paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public Long getRacaCorCidadao() {
		return racaCorCidadao;
	}

	public void setRacaCorCidadao(Long racaCorCidadao) {
		this.racaCorCidadao = racaCorCidadao;
	}

	public Long getSexoCidadao() {
		return sexoCidadao;
	}

	public void setSexoCidadao(Long sexoCidadao) {
		this.sexoCidadao = sexoCidadao;
	}

	public Boolean getFlagStatusEhResponsavel() {
		return flagStatusEhResponsavel;
	}

	public void setFlagStatusEhResponsavel(Boolean flagStatusEhResponsavel) {
		this.flagStatusEhResponsavel = flagStatusEhResponsavel;
	}

	public Long getEtnia() {
		return etnia;
	}

	public void setEtnia(Long etnia) {
		this.etnia = etnia;
	}

	public String getNomePaiCidadao() {
		return nomePaiCidadao;
	}

	public void setNomePaiCidadao(String nomePaiCidadao) {
		this.nomePaiCidadao = nomePaiCidadao;
	}

	public Boolean getFlagDesconheceNomePai() {
		return flagDesconheceNomePai;
	}

	public void setFlagDesconheceNomePai(Boolean flagDesconheceNomePai) {
		this.flagDesconheceNomePai = flagDesconheceNomePai;
	}

	public Date getDataNaturalizacao() {
		return dataNaturalizacao;
	}

	public void setDataNaturalizacao(Date dataNaturalizacao) {
		this.dataNaturalizacao = dataNaturalizacao;
	}

	public String getPortariaNaturalizacao() {
		return portariaNaturalizacao;
	}

	public void setPortariaNaturalizacao(String portariaNaturalizacao) {
		this.portariaNaturalizacao = portariaNaturalizacao;
	}

	public Date getDataEntradaBrasil() {
		return dataEntradaBrasil;
	}

	public void setDataEntradaBrasil(Date dataEntradaBrasil) {
		this.dataEntradaBrasil = dataEntradaBrasil;
	}

	public String getMicroArea() {
		return microArea;
	}

	public void setMicroArea(String microArea) {
		this.microArea = microArea;
	}

	public Boolean getFlagSituacaoForaArea() {
		return flagSituacaoForaArea;
	}

	public void setFlagSituacaoForaArea(Boolean flagSituacaoForaArea) {
		this.flagSituacaoForaArea = flagSituacaoForaArea;
	}


}