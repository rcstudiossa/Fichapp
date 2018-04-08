package com.fichapp.model.integracao;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FichaCondicaoMoradiaEsusModel implements Serializable {

	  private Long abastecimentoAgua;
	  
	  private Long areaProducaoRural;
	  
	  private Long destinoLixo;
	  
	  private Long formaEscoamentoBanheiro;
	  
	  private Long localizacao;
	  
	  private Long materialPredominanteParedesExtDomicilio;
	  
	  private String nuComodos;
	  
	  private String nuMoradores;
	  
	  private Long situacaoMoradiaPosseTerra;
	  
	  private Boolean flagDisponibilidadeEnergiaEletrica;
	  
	  private Long tipoAcessoDomicilio;
	  
	  private Long tipoDomicilio;
	  
	  private Long aguaConsumoDomicilio;

	public Long getAbastecimentoAgua() {
		return abastecimentoAgua;
	}

	public void setAbastecimentoAgua(Long abastecimentoAgua) {
		this.abastecimentoAgua = abastecimentoAgua;
	}

	public Long getAreaProducaoRural() {
		return areaProducaoRural;
	}

	public void setAreaProducaoRural(Long areaProducaoRural) {
		this.areaProducaoRural = areaProducaoRural;
	}

	public Long getDestinoLixo() {
		return destinoLixo;
	}

	public void setDestinoLixo(Long destinoLixo) {
		this.destinoLixo = destinoLixo;
	}

	public Long getFormaEscoamentoBanheiro() {
		return formaEscoamentoBanheiro;
	}

	public void setFormaEscoamentoBanheiro(Long formaEscoamentoBanheiro) {
		this.formaEscoamentoBanheiro = formaEscoamentoBanheiro;
	}

	public Long getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Long localizacao) {
		this.localizacao = localizacao;
	}

	public Long getMaterialPredominanteParedesExtDomicilio() {
		return materialPredominanteParedesExtDomicilio;
	}

	public void setMaterialPredominanteParedesExtDomicilio(Long materialPredominanteParedesExtDomicilio) {
		this.materialPredominanteParedesExtDomicilio = materialPredominanteParedesExtDomicilio;
	}

	public String getNuComodos() {
		return nuComodos;
	}

	public void setNuComodos(String nuComodos) {
		this.nuComodos = nuComodos;
	}

	public String getNuMoradores() {
		return nuMoradores;
	}

	public void setNuMoradores(String nuMoradores) {
		this.nuMoradores = nuMoradores;
	}

	public Long getSituacaoMoradiaPosseTerra() {
		return situacaoMoradiaPosseTerra;
	}

	public void setSituacaoMoradiaPosseTerra(Long situacaoMoradiaPosseTerra) {
		this.situacaoMoradiaPosseTerra = situacaoMoradiaPosseTerra;
	}

	public Boolean getFlagDisponibilidadeEnergiaEletrica() {
		return flagDisponibilidadeEnergiaEletrica;
	}

	public void setFlagDisponibilidadeEnergiaEletrica(Boolean flagDisponibilidadeEnergiaEletrica) {
		this.flagDisponibilidadeEnergiaEletrica = flagDisponibilidadeEnergiaEletrica;
	}

	public Long getTipoAcessoDomicilio() {
		return tipoAcessoDomicilio;
	}

	public void setTipoAcessoDomicilio(Long tipoAcessoDomicilio) {
		this.tipoAcessoDomicilio = tipoAcessoDomicilio;
	}

	public Long getTipoDomicilio() {
		return tipoDomicilio;
	}

	public void setTipoDomicilio(Long tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}

	public Long getAguaConsumoDomicilio() {
		return aguaConsumoDomicilio;
	}

	public void setAguaConsumoDomicilio(Long aguaConsumoDomicilio) {
		this.aguaConsumoDomicilio = aguaConsumoDomicilio;
	}
}
