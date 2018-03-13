package com.fichapp.model.integracao;

import java.util.List;

@SuppressWarnings("serial")
public class FichaCadastroDomiciliarTerritorialEsusModel extends FichaImportacaoEsusModel {

	private Long id;

	private String uuid;

	private Boolean flagFichaAtualizada;

	private String uuidFichaOriginadora;

	private String animaisNoDomicilio;
	
	private FichaCondicaoMoradiaEsusModel condicaoMoradia;
	
	private FichaEnderecoLocalPermanenciaEsusModel enderecoLocalPermanencia;
	
	private List<FichaFamiliaRowEsusModel> familias;
	
	private String quantosAnimaisNoDomicilio;
	
	private Boolean flagAnimaisNoDomicilio;
	
	private Boolean flagStatusTermoRecusa;
	
	private Long tipoDeImovel;
	
	private FichaInstituicaoPermanenciaEsusModel instituicaoPermanencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getFlagFichaAtualizada() {
		return flagFichaAtualizada;
	}

	public void setFlagFichaAtualizada(Boolean flagFichaAtualizada) {
		this.flagFichaAtualizada = flagFichaAtualizada;
	}

	public String getUuidFichaOriginadora() {
		return uuidFichaOriginadora;
	}

	public void setUuidFichaOriginadora(String uuidFichaOriginadora) {
		this.uuidFichaOriginadora = uuidFichaOriginadora;
	}

	public String getAnimaisNoDomicilio() {
		return animaisNoDomicilio;
	}

	public void setAnimaisNoDomicilio(String animaisNoDomicilio) {
		this.animaisNoDomicilio = animaisNoDomicilio;
	}

	public FichaCondicaoMoradiaEsusModel getCondicaoMoradia() {
		return condicaoMoradia;
	}

	public void setCondicaoMoradia(FichaCondicaoMoradiaEsusModel condicaoMoradia) {
		this.condicaoMoradia = condicaoMoradia;
	}

	public FichaEnderecoLocalPermanenciaEsusModel getEnderecoLocalPermanencia() {
		return enderecoLocalPermanencia;
	}

	public void setEnderecoLocalPermanencia(FichaEnderecoLocalPermanenciaEsusModel enderecoLocalPermanencia) {
		this.enderecoLocalPermanencia = enderecoLocalPermanencia;
	}

	public List<FichaFamiliaRowEsusModel> getFamilias() {
		return familias;
	}

	public void setFamilias(List<FichaFamiliaRowEsusModel> familias) {
		this.familias = familias;
	}

	public String getQuantosAnimaisNoDomicilio() {
		return quantosAnimaisNoDomicilio;
	}

	public void setQuantosAnimaisNoDomicilio(String quantosAnimaisNoDomicilio) {
		this.quantosAnimaisNoDomicilio = quantosAnimaisNoDomicilio;
	}

	public Boolean getFlagAnimaisNoDomicilio() {
		return flagAnimaisNoDomicilio;
	}

	public void setFlagAnimaisNoDomicilio(Boolean flagAnimaisNoDomicilio) {
		this.flagAnimaisNoDomicilio = flagAnimaisNoDomicilio;
	}

	public Boolean getFlagStatusTermoRecusa() {
		return flagStatusTermoRecusa;
	}

	public void setFlagStatusTermoRecusa(Boolean flagStatusTermoRecusa) {
		this.flagStatusTermoRecusa = flagStatusTermoRecusa;
	}

	public Long getTipoDeImovel() {
		return tipoDeImovel;
	}

	public void setTipoDeImovel(Long tipoDeImovel) {
		this.tipoDeImovel = tipoDeImovel;
	}

	public FichaInstituicaoPermanenciaEsusModel getInstituicaoPermanencia() {
		return instituicaoPermanencia;
	}

	public void setInstituicaoPermanencia(FichaInstituicaoPermanenciaEsusModel instituicaoPermanencia) {
		this.instituicaoPermanencia = instituicaoPermanencia;
	}

}
