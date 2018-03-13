package com.fichapp.model.integracao;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FichaCadastroIndividualSituacaoRuaEsusModel implements Serializable {

	private String grauParentescoFamiliarFrequentado;
	
	private String higienePessoalSituacaoRua;
	
	private String origemAlimentoSituacaoRua;
	
	private String outraInstituicaoQueAcompanha;
	
	private Long quantidadeAlimentacoesAoDiaSituacaoRua;
	
	private Boolean flagStatusAcompanhadoPorOutraInstituicao;
	
	private Boolean flagStatusPossuiReferenciaFamiliar;
	
	private Boolean flagStatusRecebeBeneficio;
	
	private Boolean flagStatusSituacaoRua;
	
	private Boolean flagStatusTemAcessoHigienePessoalSituacaoRua;
	
	private Boolean flagStatusVisitaFamiliarFrequentemente;
	
	private Long tempoSituacaoRua;

	public String getGrauParentescoFamiliarFrequentado() {
		return grauParentescoFamiliarFrequentado;
	}

	public void setGrauParentescoFamiliarFrequentado(String grauParentescoFamiliarFrequentado) {
		this.grauParentescoFamiliarFrequentado = grauParentescoFamiliarFrequentado;
	}

	public String getHigienePessoalSituacaoRua() {
		return higienePessoalSituacaoRua;
	}

	public void setHigienePessoalSituacaoRua(String higienePessoalSituacaoRua) {
		this.higienePessoalSituacaoRua = higienePessoalSituacaoRua;
	}

	public String getOrigemAlimentoSituacaoRua() {
		return origemAlimentoSituacaoRua;
	}

	public void setOrigemAlimentoSituacaoRua(String origemAlimentoSituacaoRua) {
		this.origemAlimentoSituacaoRua = origemAlimentoSituacaoRua;
	}

	public String getOutraInstituicaoQueAcompanha() {
		return outraInstituicaoQueAcompanha;
	}

	public void setOutraInstituicaoQueAcompanha(String outraInstituicaoQueAcompanha) {
		this.outraInstituicaoQueAcompanha = outraInstituicaoQueAcompanha;
	}

	public Long getQuantidadeAlimentacoesAoDiaSituacaoRua() {
		return quantidadeAlimentacoesAoDiaSituacaoRua;
	}

	public void setQuantidadeAlimentacoesAoDiaSituacaoRua(Long quantidadeAlimentacoesAoDiaSituacaoRua) {
		this.quantidadeAlimentacoesAoDiaSituacaoRua = quantidadeAlimentacoesAoDiaSituacaoRua;
	}

	public Boolean getFlagStatusAcompanhadoPorOutraInstituicao() {
		return flagStatusAcompanhadoPorOutraInstituicao;
	}

	public void setFlagStatusAcompanhadoPorOutraInstituicao(Boolean flagStatusAcompanhadoPorOutraInstituicao) {
		this.flagStatusAcompanhadoPorOutraInstituicao = flagStatusAcompanhadoPorOutraInstituicao;
	}

	public Boolean getFlagStatusPossuiReferenciaFamiliar() {
		return flagStatusPossuiReferenciaFamiliar;
	}

	public void setFlagStatusPossuiReferenciaFamiliar(Boolean flagStatusPossuiReferenciaFamiliar) {
		this.flagStatusPossuiReferenciaFamiliar = flagStatusPossuiReferenciaFamiliar;
	}

	public Boolean getFlagStatusRecebeBeneficio() {
		return flagStatusRecebeBeneficio;
	}

	public void setFlagStatusRecebeBeneficio(Boolean flagStatusRecebeBeneficio) {
		this.flagStatusRecebeBeneficio = flagStatusRecebeBeneficio;
	}

	public Boolean getFlagStatusSituacaoRua() {
		return flagStatusSituacaoRua;
	}

	public void setFlagStatusSituacaoRua(Boolean flagStatusSituacaoRua) {
		this.flagStatusSituacaoRua = flagStatusSituacaoRua;
	}

	public Boolean getFlagStatusTemAcessoHigienePessoalSituacaoRua() {
		return flagStatusTemAcessoHigienePessoalSituacaoRua;
	}

	public void setFlagStatusTemAcessoHigienePessoalSituacaoRua(Boolean flagStatusTemAcessoHigienePessoalSituacaoRua) {
		this.flagStatusTemAcessoHigienePessoalSituacaoRua = flagStatusTemAcessoHigienePessoalSituacaoRua;
	}

	public Boolean getFlagStatusVisitaFamiliarFrequentemente() {
		return flagStatusVisitaFamiliarFrequentemente;
	}

	public void setFlagStatusVisitaFamiliarFrequentemente(Boolean flagStatusVisitaFamiliarFrequentemente) {
		this.flagStatusVisitaFamiliarFrequentemente = flagStatusVisitaFamiliarFrequentemente;
	}

	public Long getTempoSituacaoRua() {
		return tempoSituacaoRua;
	}

	public void setTempoSituacaoRua(Long tempoSituacaoRua) {
		this.tempoSituacaoRua = tempoSituacaoRua;
	}

}