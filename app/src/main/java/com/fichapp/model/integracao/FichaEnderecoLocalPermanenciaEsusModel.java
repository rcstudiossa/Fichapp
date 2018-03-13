package com.fichapp.model.integracao;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FichaEnderecoLocalPermanenciaEsusModel implements Serializable {

	private String bairro;

	private String cep;

	private String codigoIbgeMunicipio;

	private String complemento;

	private String nomeLogradouro;

	private String numero;

	private String numeroDneUf;

	private String telefoneContato;

	private String telefoneResidencia;

	private String tipoLogradouroNumeroDne;

	private Boolean flagSemNumero;

	private String pontoReferencia;

	private String microArea;
	
	private Boolean flagForaArea;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCodigoIbgeMunicipio() {
		return codigoIbgeMunicipio;
	}

	public void setCodigoIbgeMunicipio(String codigoIbgeMunicipio) {
		this.codigoIbgeMunicipio = codigoIbgeMunicipio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroDneUf() {
		return numeroDneUf;
	}

	public void setNumeroDneUf(String numeroDneUf) {
		this.numeroDneUf = numeroDneUf;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getTelefoneResidencia() {
		return telefoneResidencia;
	}

	public void setTelefoneResidencia(String telefoneResidencia) {
		this.telefoneResidencia = telefoneResidencia;
	}

	public String getTipoLogradouroNumeroDne() {
		return tipoLogradouroNumeroDne;
	}

	public void setTipoLogradouroNumeroDne(String tipoLogradouroNumeroDne) {
		this.tipoLogradouroNumeroDne = tipoLogradouroNumeroDne;
	}

	public Boolean getFlagSemNumero() {
		return flagSemNumero;
	}

	public void setFlagSemNumero(Boolean flagSemNumero) {
		this.flagSemNumero = flagSemNumero;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getMicroArea() {
		return microArea;
	}

	public void setMicroArea(String microArea) {
		this.microArea = microArea;
	}

	public Boolean getFlagForaArea() {
		return flagForaArea;
	}

	public void setFlagForaArea(Boolean flagForaArea) {
		this.flagForaArea = flagForaArea;
	}

}
