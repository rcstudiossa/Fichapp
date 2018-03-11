package com.fichapp.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FichaVisitaDomiciliarEsusChildModel implements Serializable {

	private Long turno;
	
	private String numProntuario;
	
	private String cnsCidadao;
	
	private Date dataNascimento;
	
	private Long sexo;
	
	private Boolean flagVisitaCompartilhadaOutroProfissional;
	
	private String motivosVisita1;
	
	private String motivosVisitaBuscaAtiva;
	
	private String motivosVisitaAcompanhamento;
	
	private String motivosVisitaControleAmbiental;
	
	private String motivosVisita2;
	
	private Long desfecho;
	
	private String microArea;
	
	private Boolean flagForaArea;
	
	private Long tipoDeImovel;
	
	private Double pesoAcompanhamentoNutricional;
	
	private Double alturaAcompanhamentoNutricional;

	public Long getTurno() {
		return turno;
	}

	public void setTurno(Long turno) {
		this.turno = turno;
	}

	public String getNumProntuario() {
		return numProntuario;
	}

	public void setNumProntuario(String numProntuario) {
		this.numProntuario = numProntuario;
	}

	public String getCnsCidadao() {
		return cnsCidadao;
	}

	public void setCnsCidadao(String cnsCidadao) {
		this.cnsCidadao = cnsCidadao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getSexo() {
		return sexo;
	}

	public void setSexo(Long sexo) {
		this.sexo = sexo;
	}

	public Boolean getFlagVisitaCompartilhadaOutroProfissional() {
		return flagVisitaCompartilhadaOutroProfissional;
	}

	public void setFlagVisitaCompartilhadaOutroProfissional(Boolean flagVisitaCompartilhadaOutroProfissional) {
		this.flagVisitaCompartilhadaOutroProfissional = flagVisitaCompartilhadaOutroProfissional;
	}

	public Long getDesfecho() {
		return desfecho;
	}

	public void setDesfecho(Long desfecho) {
		this.desfecho = desfecho;
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

	public Long getTipoDeImovel() {
		return tipoDeImovel;
	}

	public void setTipoDeImovel(Long tipoDeImovel) {
		this.tipoDeImovel = tipoDeImovel;
	}

	public Double getPesoAcompanhamentoNutricional() {
		return pesoAcompanhamentoNutricional;
	}

	public void setPesoAcompanhamentoNutricional(Double pesoAcompanhamentoNutricional) {
		this.pesoAcompanhamentoNutricional = pesoAcompanhamentoNutricional;
	}

	public Double getAlturaAcompanhamentoNutricional() {
		return alturaAcompanhamentoNutricional;
	}

	public void setAlturaAcompanhamentoNutricional(Double alturaAcompanhamentoNutricional) {
		this.alturaAcompanhamentoNutricional = alturaAcompanhamentoNutricional;
	}

	public String getMotivosVisita1() {
		return motivosVisita1;
	}

	public void setMotivosVisita1(String motivosVisita1) {
		this.motivosVisita1 = motivosVisita1;
	}

	public String getMotivosVisitaBuscaAtiva() {
		return motivosVisitaBuscaAtiva;
	}

	public void setMotivosVisitaBuscaAtiva(String motivosVisitaBuscaAtiva) {
		this.motivosVisitaBuscaAtiva = motivosVisitaBuscaAtiva;
	}

	public String getMotivosVisitaAcompanhamento() {
		return motivosVisitaAcompanhamento;
	}

	public void setMotivosVisitaAcompanhamento(String motivosVisitaAcompanhamento) {
		this.motivosVisitaAcompanhamento = motivosVisitaAcompanhamento;
	}

	public String getMotivosVisitaControleAmbiental() {
		return motivosVisitaControleAmbiental;
	}

	public void setMotivosVisitaControleAmbiental(String motivosVisitaControleAmbiental) {
		this.motivosVisitaControleAmbiental = motivosVisitaControleAmbiental;
	}

	public String getMotivosVisita2() {
		return motivosVisita2;
	}

	public void setMotivosVisita2(String motivosVisita2) {
		this.motivosVisita2 = motivosVisita2;
	}

}
