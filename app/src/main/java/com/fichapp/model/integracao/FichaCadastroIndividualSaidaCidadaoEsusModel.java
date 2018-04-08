package com.fichapp.model.integracao;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FichaCadastroIndividualSaidaCidadaoEsusModel implements Serializable {

	private Long motivoSaidaCidadao;
	
	private Date dataObito;
	
	private String numeroDO;

	public Long getMotivoSaidaCidadao() {
		return motivoSaidaCidadao;
	}

	public void setMotivoSaidaCidadao(Long motivoSaidaCidadao) {
		this.motivoSaidaCidadao = motivoSaidaCidadao;
	}

	public Date getDataObito() {
		return dataObito;
	}

	public void setDataObito(Date dataObito) {
		this.dataObito = dataObito;
	}

	public String getNumeroDO() {
		return numeroDO;
	}

	public void setNumeroDO(String numeroDO) {
		this.numeroDO = numeroDO;
	}

}
