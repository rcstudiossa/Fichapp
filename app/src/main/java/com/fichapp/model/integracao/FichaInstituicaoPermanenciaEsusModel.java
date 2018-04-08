package com.fichapp.model.integracao;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FichaInstituicaoPermanenciaEsusModel implements Serializable {

	  private String nomeInstituicaoPermanencia;
	  
	  private Boolean flagOutrosProfissionaisVinculados;
	  
	  private String nomeResponsavelTecnico;
	  
	  private String cnsResponsavelTecnico;
	  
	  private String cargoInstituicao;
	  
	  private String telefoneResponsavelTecnico;

	public String getNomeInstituicaoPermanencia() {
		return nomeInstituicaoPermanencia;
	}

	public void setNomeInstituicaoPermanencia(String nomeInstituicaoPermanencia) {
		this.nomeInstituicaoPermanencia = nomeInstituicaoPermanencia;
	}

	public Boolean getFlagOutrosProfissionaisVinculados() {
		return flagOutrosProfissionaisVinculados;
	}

	public void setFlagOutrosProfissionaisVinculados(Boolean flagOutrosProfissionaisVinculados) {
		this.flagOutrosProfissionaisVinculados = flagOutrosProfissionaisVinculados;
	}

	public String getNomeResponsavelTecnico() {
		return nomeResponsavelTecnico;
	}

	public void setNomeResponsavelTecnico(String nomeResponsavelTecnico) {
		this.nomeResponsavelTecnico = nomeResponsavelTecnico;
	}

	public String getCnsResponsavelTecnico() {
		return cnsResponsavelTecnico;
	}

	public void setCnsResponsavelTecnico(String cnsResponsavelTecnico) {
		this.cnsResponsavelTecnico = cnsResponsavelTecnico;
	}

	public String getCargoInstituicao() {
		return cargoInstituicao;
	}

	public void setCargoInstituicao(String cargoInstituicao) {
		this.cargoInstituicao = cargoInstituicao;
	}

	public String getTelefoneResponsavelTecnico() {
		return telefoneResponsavelTecnico;
	}

	public void setTelefoneResponsavelTecnico(String telefoneResponsavelTecnico) {
		this.telefoneResponsavelTecnico = telefoneResponsavelTecnico;
	}

}
