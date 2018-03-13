package com.fichapp.model.integracao;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FichaCadastroIndividualCondicaoSaudeEsusModel implements Serializable {

	private String descricaoCausaInternacaoEm12Meses;
	
	private String descricaoOutraCondicao1;
	
	private String descricaoOutraCondicao2;
	
	private String descricaoOutraCondicao3;
	
	private String descricaoPlantasMedicinaisUsadas;
	
	private String doencaCardiaca;
	
	private String doencaRespiratoria;
	
	private String doencaRins;
	
	private String maternidadeDeReferencia;
	
	private Long situacaoPeso;
	
	private Boolean flagStatusEhDependenteAlcool;
	
	private Boolean flagStatusEhDependenteOutrasDrogas;
	
	private Boolean flagStatusEhFumante;
	
	private Boolean flagStatusEhGestante;
	
	private Boolean flagStatusEstaAcamado;
	
	private Boolean flagStatusEstaDomiciliado;
	
	private Boolean flagStatusTemDiabetes;
	
	private Boolean flagStatusTemDoencaRespiratoria;
	
	private Boolean flagStatusTemHanseniase;
	
	private Boolean flagStatusTemHipertensaoArterial;
	
	private Boolean flagStatusTemTeveCancer;
	
	private Boolean flagStatusTemTeveDoencasRins;
	
	private Boolean flagStatusTemTuberculose;
	
	private Boolean flagStatusTeveAvcDerrame;
	
	private Boolean flagStatusTeveDoencaCardiaca;
	
	private Boolean flagStatusTeveInfarto;
	
	private Boolean flagStatusTeveInternadoEm12Meses;
	
	private Boolean flagStatusUsaOutrasPraticasIntegrativasOuComplementares;
	
	private Boolean flagStatusUsaPlantaMedicinais;
	
	private Boolean flagStatusDiagnosticoMental;

	public String getDescricaoCausaInternacaoEm12Meses() {
		return descricaoCausaInternacaoEm12Meses;
	}

	public void setDescricaoCausaInternacaoEm12Meses(String descricaoCausaInternacaoEm12Meses) {
		this.descricaoCausaInternacaoEm12Meses = descricaoCausaInternacaoEm12Meses;
	}

	public String getDescricaoOutraCondicao1() {
		return descricaoOutraCondicao1;
	}

	public void setDescricaoOutraCondicao1(String descricaoOutraCondicao1) {
		this.descricaoOutraCondicao1 = descricaoOutraCondicao1;
	}

	public String getDescricaoOutraCondicao2() {
		return descricaoOutraCondicao2;
	}

	public void setDescricaoOutraCondicao2(String descricaoOutraCondicao2) {
		this.descricaoOutraCondicao2 = descricaoOutraCondicao2;
	}

	public String getDescricaoOutraCondicao3() {
		return descricaoOutraCondicao3;
	}

	public void setDescricaoOutraCondicao3(String descricaoOutraCondicao3) {
		this.descricaoOutraCondicao3 = descricaoOutraCondicao3;
	}

	public String getDescricaoPlantasMedicinaisUsadas() {
		return descricaoPlantasMedicinaisUsadas;
	}

	public void setDescricaoPlantasMedicinaisUsadas(String descricaoPlantasMedicinaisUsadas) {
		this.descricaoPlantasMedicinaisUsadas = descricaoPlantasMedicinaisUsadas;
	}

	public String getDoencaCardiaca() {
		return doencaCardiaca;
	}

	public void setDoencaCardiaca(String doencaCardiaca) {
		this.doencaCardiaca = doencaCardiaca;
	}

	public String getDoencaRespiratoria() {
		return doencaRespiratoria;
	}

	public void setDoencaRespiratoria(String doencaRespiratoria) {
		this.doencaRespiratoria = doencaRespiratoria;
	}

	public String getDoencaRins() {
		return doencaRins;
	}

	public void setDoencaRins(String doencaRins) {
		this.doencaRins = doencaRins;
	}

	public String getMaternidadeDeReferencia() {
		return maternidadeDeReferencia;
	}

	public void setMaternidadeDeReferencia(String maternidadeDeReferencia) {
		this.maternidadeDeReferencia = maternidadeDeReferencia;
	}

	public Long getSituacaoPeso() {
		return situacaoPeso;
	}

	public void setSituacaoPeso(Long situacaoPeso) {
		this.situacaoPeso = situacaoPeso;
	}

	public Boolean getFlagStatusEhDependenteAlcool() {
		return flagStatusEhDependenteAlcool;
	}

	public void setFlagStatusEhDependenteAlcool(Boolean flagStatusEhDependenteAlcool) {
		this.flagStatusEhDependenteAlcool = flagStatusEhDependenteAlcool;
	}

	public Boolean getFlagStatusEhDependenteOutrasDrogas() {
		return flagStatusEhDependenteOutrasDrogas;
	}

	public void setFlagStatusEhDependenteOutrasDrogas(Boolean flagStatusEhDependenteOutrasDrogas) {
		this.flagStatusEhDependenteOutrasDrogas = flagStatusEhDependenteOutrasDrogas;
	}

	public Boolean getFlagStatusEhFumante() {
		return flagStatusEhFumante;
	}

	public void setFlagStatusEhFumante(Boolean flagStatusEhFumante) {
		this.flagStatusEhFumante = flagStatusEhFumante;
	}

	public Boolean getFlagStatusEhGestante() {
		return flagStatusEhGestante;
	}

	public void setFlagStatusEhGestante(Boolean flagStatusEhGestante) {
		this.flagStatusEhGestante = flagStatusEhGestante;
	}

	public Boolean getFlagStatusEstaAcamado() {
		return flagStatusEstaAcamado;
	}

	public void setFlagStatusEstaAcamado(Boolean flagStatusEstaAcamado) {
		this.flagStatusEstaAcamado = flagStatusEstaAcamado;
	}

	public Boolean getFlagStatusEstaDomiciliado() {
		return flagStatusEstaDomiciliado;
	}

	public void setFlagStatusEstaDomiciliado(Boolean flagStatusEstaDomiciliado) {
		this.flagStatusEstaDomiciliado = flagStatusEstaDomiciliado;
	}

	public Boolean getFlagStatusTemDiabetes() {
		return flagStatusTemDiabetes;
	}

	public void setFlagStatusTemDiabetes(Boolean flagStatusTemDiabetes) {
		this.flagStatusTemDiabetes = flagStatusTemDiabetes;
	}

	public Boolean getFlagStatusTemDoencaRespiratoria() {
		return flagStatusTemDoencaRespiratoria;
	}

	public void setFlagStatusTemDoencaRespiratoria(Boolean flagStatusTemDoencaRespiratoria) {
		this.flagStatusTemDoencaRespiratoria = flagStatusTemDoencaRespiratoria;
	}

	public Boolean getFlagStatusTemHanseniase() {
		return flagStatusTemHanseniase;
	}

	public void setFlagStatusTemHanseniase(Boolean flagStatusTemHanseniase) {
		this.flagStatusTemHanseniase = flagStatusTemHanseniase;
	}

	public Boolean getFlagStatusTemHipertensaoArterial() {
		return flagStatusTemHipertensaoArterial;
	}

	public void setFlagStatusTemHipertensaoArterial(Boolean flagStatusTemHipertensaoArterial) {
		this.flagStatusTemHipertensaoArterial = flagStatusTemHipertensaoArterial;
	}

	public Boolean getFlagStatusTemTeveCancer() {
		return flagStatusTemTeveCancer;
	}

	public void setFlagStatusTemTeveCancer(Boolean flagStatusTemTeveCancer) {
		this.flagStatusTemTeveCancer = flagStatusTemTeveCancer;
	}

	public Boolean getFlagStatusTemTeveDoencasRins() {
		return flagStatusTemTeveDoencasRins;
	}

	public void setFlagStatusTemTeveDoencasRins(Boolean flagStatusTemTeveDoencasRins) {
		this.flagStatusTemTeveDoencasRins = flagStatusTemTeveDoencasRins;
	}

	public Boolean getFlagStatusTemTuberculose() {
		return flagStatusTemTuberculose;
	}

	public void setFlagStatusTemTuberculose(Boolean flagStatusTemTuberculose) {
		this.flagStatusTemTuberculose = flagStatusTemTuberculose;
	}

	public Boolean getFlagStatusTeveAvcDerrame() {
		return flagStatusTeveAvcDerrame;
	}

	public void setFlagStatusTeveAvcDerrame(Boolean flagStatusTeveAvcDerrame) {
		this.flagStatusTeveAvcDerrame = flagStatusTeveAvcDerrame;
	}

	public Boolean getFlagStatusTeveDoencaCardiaca() {
		return flagStatusTeveDoencaCardiaca;
	}

	public void setFlagStatusTeveDoencaCardiaca(Boolean flagStatusTeveDoencaCardiaca) {
		this.flagStatusTeveDoencaCardiaca = flagStatusTeveDoencaCardiaca;
	}

	public Boolean getFlagStatusTeveInfarto() {
		return flagStatusTeveInfarto;
	}

	public void setFlagStatusTeveInfarto(Boolean flagStatusTeveInfarto) {
		this.flagStatusTeveInfarto = flagStatusTeveInfarto;
	}

	public Boolean getFlagStatusTeveInternadoEm12Meses() {
		return flagStatusTeveInternadoEm12Meses;
	}

	public void setFlagStatusTeveInternadoEm12Meses(Boolean flagStatusTeveInternadoEm12Meses) {
		this.flagStatusTeveInternadoEm12Meses = flagStatusTeveInternadoEm12Meses;
	}

	public Boolean getFlagStatusUsaOutrasPraticasIntegrativasOuComplementares() {
		return flagStatusUsaOutrasPraticasIntegrativasOuComplementares;
	}

	public void setFlagStatusUsaOutrasPraticasIntegrativasOuComplementares(Boolean flagStatusUsaOutrasPraticasIntegrativasOuComplementares) {
		this.flagStatusUsaOutrasPraticasIntegrativasOuComplementares = flagStatusUsaOutrasPraticasIntegrativasOuComplementares;
	}

	public Boolean getFlagStatusUsaPlantaMedicinais() {
		return flagStatusUsaPlantaMedicinais;
	}

	public void setFlagStatusUsaPlantaMedicinais(Boolean flagStatusUsaPlantaMedicinais) {
		this.flagStatusUsaPlantaMedicinais = flagStatusUsaPlantaMedicinais;
	}

	public Boolean getFlagStatusDiagnosticoMental() {
		return flagStatusDiagnosticoMental;
	}

	public void setFlagStatusDiagnosticoMental(Boolean flagStatusDiagnosticoMental) {
		this.flagStatusDiagnosticoMental = flagStatusDiagnosticoMental;
	}

}