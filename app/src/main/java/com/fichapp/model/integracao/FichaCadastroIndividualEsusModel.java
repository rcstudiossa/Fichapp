package com.fichapp.model.integracao;

@SuppressWarnings("serial")
public class FichaCadastroIndividualEsusModel extends FichaImportacaoEsusModel {
	
	private Long id;

	private String uuid;

	private FichaCadastroIndividualCondicaoSaudeEsusModel fichaCadastroIndividualCondicaoSaudeEsusModel;

	private FichaCadastroIndividualSituacaoRuaEsusModel fichaCadastroIndividualSituacaoRuaEsusModel;

	private Boolean flagFichaAtualizada;

	private FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel fichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel;

	private FichaCadastroInformacaoSocioDemograficaEsusModel fichaCadastroInformacaoSocioDemograficaEsusModel;

	private Boolean flagStatusTermoRecusaCadastroIndividualAtencaoBasica;

	private Integer tpCdsOrigem;

	private String uuidFichaOriginadora;

	private String uuidCidadao;

	private FichaCadastroIndividualSaidaCidadaoEsusModel fichaCadastroIndividualSaidaCidadaoEsusModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FichaCadastroIndividualCondicaoSaudeEsusModel getFichaCadastroIndividualCondicaoSaudeEsusModel() {
		return fichaCadastroIndividualCondicaoSaudeEsusModel;
	}

	public void setFichaCadastroIndividualCondicaoSaudeEsusModel(FichaCadastroIndividualCondicaoSaudeEsusModel fichaCadastroIndividualCondicaoSaudeEsusModel) {
		this.fichaCadastroIndividualCondicaoSaudeEsusModel = fichaCadastroIndividualCondicaoSaudeEsusModel;
	}

	public FichaCadastroIndividualSituacaoRuaEsusModel getFichaCadastroIndividualSituacaoRuaEsusModel() {
		return fichaCadastroIndividualSituacaoRuaEsusModel;
	}

	public void setFichaCadastroIndividualSituacaoRuaEsusModel(FichaCadastroIndividualSituacaoRuaEsusModel fichaCadastroIndividualSituacaoRuaEsusModel) {
		this.fichaCadastroIndividualSituacaoRuaEsusModel = fichaCadastroIndividualSituacaoRuaEsusModel;
	}

	public Boolean getFlagFichaAtualizada() {
		return flagFichaAtualizada;
	}

	public void setFlagFichaAtualizada(Boolean flagFichaAtualizada) {
		this.flagFichaAtualizada = flagFichaAtualizada;
	}

	public FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel getFichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel() {
		return fichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel;
	}

	public void setFichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel(FichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel fichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel) {
		this.fichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel = fichaCadastroIndividualIdentificacaoUsuarioCidadaoEsusModel;
	}

	public FichaCadastroInformacaoSocioDemograficaEsusModel getFichaCadastroInformacaoSocioDemograficaEsusModel() {
		return fichaCadastroInformacaoSocioDemograficaEsusModel;
	}

	public void setFichaCadastroInformacaoSocioDemograficaEsusModel(FichaCadastroInformacaoSocioDemograficaEsusModel fichaCadastroInformacaoSocioDemograficaEsusModel) {
		this.fichaCadastroInformacaoSocioDemograficaEsusModel = fichaCadastroInformacaoSocioDemograficaEsusModel;
	}

	public Boolean getFlagStatusTermoRecusaCadastroIndividualAtencaoBasica() {
		return flagStatusTermoRecusaCadastroIndividualAtencaoBasica;
	}

	public void setFlagStatusTermoRecusaCadastroIndividualAtencaoBasica(Boolean flagStatusTermoRecusaCadastroIndividualAtencaoBasica) {
		this.flagStatusTermoRecusaCadastroIndividualAtencaoBasica = flagStatusTermoRecusaCadastroIndividualAtencaoBasica;
	}

	public Integer getTpCdsOrigem() {
		return tpCdsOrigem;
	}

	public void setTpCdsOrigem(Integer tpCdsOrigem) {
		this.tpCdsOrigem = tpCdsOrigem;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuidFichaOriginadora() {
		return uuidFichaOriginadora;
	}

	public void setUuidFichaOriginadora(String uuidFichaOriginadora) {
		this.uuidFichaOriginadora = uuidFichaOriginadora;
	}

	public String getUuidCidadao() {
		return uuidCidadao;
	}

	public void setUuidCidadao(String uuidCidadao) {
		this.uuidCidadao = uuidCidadao;
	}

	public FichaCadastroIndividualSaidaCidadaoEsusModel getFichaCadastroIndividualSaidaCidadaoEsusModel() {
		return fichaCadastroIndividualSaidaCidadaoEsusModel;
	}

	public void setFichaCadastroIndividualSaidaCidadaoEsusModel(FichaCadastroIndividualSaidaCidadaoEsusModel fichaCadastroIndividualSaidaCidadaoEsusModel) {
		this.fichaCadastroIndividualSaidaCidadaoEsusModel = fichaCadastroIndividualSaidaCidadaoEsusModel;
	}

}
