package com.fichapp.model.integracao;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FichaFamiliaRowEsusModel implements Serializable {

	private Date dataNascimentoResponsavel;
	
	private String numeroCnsResponsavel;
	
	private Integer numeroMembrosFamilia;
	
	private String numeroProntuario;
	
	private Long rendaFamiliar;
	
	private Date dataInicioReside;
	
	private Boolean flagMudanca;

	public Date getDataNascimentoResponsavel() {
		return dataNascimentoResponsavel;
	}

	public void setDataNascimentoResponsavel(Date dataNascimentoResponsavel) {
		this.dataNascimentoResponsavel = dataNascimentoResponsavel;
	}

	public String getNumeroCnsResponsavel() {
		return numeroCnsResponsavel;
	}

	public void setNumeroCnsResponsavel(String numeroCnsResponsavel) {
		this.numeroCnsResponsavel = numeroCnsResponsavel;
	}

	public Integer getNumeroMembrosFamilia() {
		return numeroMembrosFamilia;
	}

	public void setNumeroMembrosFamilia(Integer numeroMembrosFamilia) {
		this.numeroMembrosFamilia = numeroMembrosFamilia;
	}

	public String getNumeroProntuario() {
		return numeroProntuario;
	}

	public void setNumeroProntuario(String numeroProntuario) {
		this.numeroProntuario = numeroProntuario;
	}

	public Long getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(Long rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

	public Date getDataInicioReside() {
		return dataInicioReside;
	}

	public void setDataInicioReside(Date dataInicioReside) {
		this.dataInicioReside = dataInicioReside;
	}

	public Boolean getFlagMudanca() {
		return flagMudanca;
	}

	public void setFlagMudanca(Boolean flagMudanca) {
		this.flagMudanca = flagMudanca;
	}

}
