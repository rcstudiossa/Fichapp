package com.fichapp.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaVisitaDTModel implements Serializable{

    private Long id;
    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;
    private String ine;
    private Date dataRegistro;
    private String turno;
    private String microArea;
    private TipoImovelModel tipoImovelModel;

    private String prontuario;
    private String cnsCidadao;
    private Date dataNascimento;
    private String sexo;

    private Boolean flagVisitaCompartilhada;

    private Boolean flagCadastramento;
    private Boolean flagVisitaPeriodica;

    private Boolean flagConsulta;
    private Boolean flagExame;
    private Boolean flagVacina;
    private Boolean flagBolsaFamilia;

    private Boolean flagGestante;
    private Boolean flagPuerpera;
    private Boolean flagRecemNascido;
    private Boolean flagCrianca;
    private Boolean flagDesnutricao;
    private Boolean flagReabilitacao;
    private Boolean flagHipertensao;
    private Boolean flagDiabetes;
    private Boolean flagAsma;
    private Boolean flagEnfisema;
    private Boolean flagCancer;
    private Boolean flagDoencasCronicas;
    private Boolean flagHanseniase;
    private Boolean flagTuberculose;
    private Boolean flagSintomaticosRespiratorios;
    private Boolean flagTabagista;
    private Boolean flagAcamado;
    private Boolean flagVunerabilidadeSocial;
    private Boolean flagAcompanhamentoBolsaFamilia;
    private Boolean flagSaudeMental;
    private Boolean flagUsuarioAlcool;
    private Boolean flagOutrasDrogas;

    private Boolean flagAcaoEducativa;
    private Boolean flagImovelComFoco;
    private Boolean flagAcaoMecanica;
    private Boolean flagTratamentoFocal;

    private Boolean flagEgressoInternacao;
    private Boolean flagConvite;
    private Boolean flagOrientacao;
    private Boolean flagOutros;

    private Double peso;
    private Integer altura;
    private DesfechoModel desfechoModel;

    private Boolean flagAtivo;
    private Boolean flagExportado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfissionalModel getProfissionalModel() {
        return profissionalModel;
    }

    public void setProfissionalModel(ProfissionalModel profissionalModel) {
        this.profissionalModel = profissionalModel;
    }

    public CNESModel getCnesModel() {
        return cnesModel;
    }

    public void setCnesModel(CNESModel cnesModel) {
        this.cnesModel = cnesModel;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getMicroArea() {
        return microArea;
    }

    public void setMicroArea(String microArea) {
        this.microArea = microArea;
    }

    public TipoImovelModel getTipoImovelModel() {
        return tipoImovelModel;
    }

    public void setTipoImovelModel(TipoImovelModel tipoImovelModel) {
        this.tipoImovelModel = tipoImovelModel;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getFlagVisitaCompartilhada() {
        return flagVisitaCompartilhada;
    }

    public void setFlagVisitaCompartilhada(Boolean flagVisitaCompartilhada) {
        this.flagVisitaCompartilhada = flagVisitaCompartilhada;
    }

    public Boolean getFlagCadastramento() {
        return flagCadastramento;
    }

    public void setFlagCadastramento(Boolean flagCadastramento) {
        this.flagCadastramento = flagCadastramento;
    }

    public Boolean getFlagVisitaPeriodica() {
        return flagVisitaPeriodica;
    }

    public void setFlagVisitaPeriodica(Boolean flagVisitaPeriodica) {
        this.flagVisitaPeriodica = flagVisitaPeriodica;
    }

    public Boolean getFlagConsulta() {
        return flagConsulta;
    }

    public void setFlagConsulta(Boolean flagConsulta) {
        this.flagConsulta = flagConsulta;
    }

    public Boolean getFlagExame() {
        return flagExame;
    }

    public void setFlagExame(Boolean flagExame) {
        this.flagExame = flagExame;
    }

    public Boolean getFlagVacina() {
        return flagVacina;
    }

    public void setFlagVacina(Boolean flagVacina) {
        this.flagVacina = flagVacina;
    }

    public Boolean getFlagBolsaFamilia() {
        return flagBolsaFamilia;
    }

    public void setFlagBolsaFamilia(Boolean flagBolsaFamilia) {
        this.flagBolsaFamilia = flagBolsaFamilia;
    }

    public Boolean getFlagGestante() {
        return flagGestante;
    }

    public void setFlagGestante(Boolean flagGestante) {
        this.flagGestante = flagGestante;
    }

    public Boolean getFlagPuerpera() {
        return flagPuerpera;
    }

    public void setFlagPuerpera(Boolean flagPuerpera) {
        this.flagPuerpera = flagPuerpera;
    }

    public Boolean getFlagRecemNascido() {
        return flagRecemNascido;
    }

    public void setFlagRecemNascido(Boolean flagRecemNascido) {
        this.flagRecemNascido = flagRecemNascido;
    }

    public Boolean getFlagCrianca() {
        return flagCrianca;
    }

    public void setFlagCrianca(Boolean flagCrianca) {
        this.flagCrianca = flagCrianca;
    }

    public Boolean getFlagDesnutricao() {
        return flagDesnutricao;
    }

    public void setFlagDesnutricao(Boolean flagDesnutricao) {
        this.flagDesnutricao = flagDesnutricao;
    }

    public Boolean getFlagReabilitacao() {
        return flagReabilitacao;
    }

    public void setFlagReabilitacao(Boolean flagReabilitacao) {
        this.flagReabilitacao = flagReabilitacao;
    }

    public Boolean getFlagHipertensao() {
        return flagHipertensao;
    }

    public void setFlagHipertensao(Boolean flagHipertensao) {
        this.flagHipertensao = flagHipertensao;
    }

    public Boolean getFlagDiabetes() {
        return flagDiabetes;
    }

    public void setFlagDiabetes(Boolean flagDiabetes) {
        this.flagDiabetes = flagDiabetes;
    }

    public Boolean getFlagAsma() {
        return flagAsma;
    }

    public void setFlagAsma(Boolean flagAsma) {
        this.flagAsma = flagAsma;
    }

    public Boolean getFlagEnfisema() {
        return flagEnfisema;
    }

    public void setFlagEnfisema(Boolean flagEnfisema) {
        this.flagEnfisema = flagEnfisema;
    }

    public Boolean getFlagCancer() {
        return flagCancer;
    }

    public void setFlagCancer(Boolean flagCancer) {
        this.flagCancer = flagCancer;
    }

    public Boolean getFlagDoencasCronicas() {
        return flagDoencasCronicas;
    }

    public void setFlagDoencasCronicas(Boolean flagDoencasCronicas) {
        this.flagDoencasCronicas = flagDoencasCronicas;
    }

    public Boolean getFlagHanseniase() {
        return flagHanseniase;
    }

    public void setFlagHanseniase(Boolean flagHanseniase) {
        this.flagHanseniase = flagHanseniase;
    }

    public Boolean getFlagTuberculose() {
        return flagTuberculose;
    }

    public void setFlagTuberculose(Boolean flagTuberculose) {
        this.flagTuberculose = flagTuberculose;
    }

    public Boolean getFlagSintomaticosRespiratorios() {
        return flagSintomaticosRespiratorios;
    }

    public void setFlagSintomaticosRespiratorios(Boolean flagSintomaticosRespiratorios) {
        this.flagSintomaticosRespiratorios = flagSintomaticosRespiratorios;
    }

    public Boolean getFlagTabagista() {
        return flagTabagista;
    }

    public void setFlagTabagista(Boolean flagTabagista) {
        this.flagTabagista = flagTabagista;
    }

    public Boolean getFlagAcamado() {
        return flagAcamado;
    }

    public void setFlagAcamado(Boolean flagAcamado) {
        this.flagAcamado = flagAcamado;
    }

    public Boolean getFlagVunerabilidadeSocial() {
        return flagVunerabilidadeSocial;
    }

    public void setFlagVunerabilidadeSocial(Boolean flagVunerabilidadeSocial) {
        this.flagVunerabilidadeSocial = flagVunerabilidadeSocial;
    }

    public Boolean getFlagAcompanhamentoBolsaFamilia() {
        return flagAcompanhamentoBolsaFamilia;
    }

    public void setFlagAcompanhamentoBolsaFamilia(Boolean flagAcompanhamentoBolsaFamilia) {
        this.flagAcompanhamentoBolsaFamilia = flagAcompanhamentoBolsaFamilia;
    }

    public Boolean getFlagSaudeMental() {
        return flagSaudeMental;
    }

    public void setFlagSaudeMental(Boolean flagSaudeMental) {
        this.flagSaudeMental = flagSaudeMental;
    }

    public Boolean getFlagUsuarioAlcool() {
        return flagUsuarioAlcool;
    }

    public void setFlagUsuarioAlcool(Boolean flagUsuarioAlcool) {
        this.flagUsuarioAlcool = flagUsuarioAlcool;
    }

    public Boolean getFlagOutrasDrogas() {
        return flagOutrasDrogas;
    }

    public void setFlagOutrasDrogas(Boolean flagOutrasDrogas) {
        this.flagOutrasDrogas = flagOutrasDrogas;
    }

    public Boolean getFlagAcaoEducativa() {
        return flagAcaoEducativa;
    }

    public void setFlagAcaoEducativa(Boolean flagAcaoEducativa) {
        this.flagAcaoEducativa = flagAcaoEducativa;
    }

    public Boolean getFlagImovelComFoco() {
        return flagImovelComFoco;
    }

    public void setFlagImovelComFoco(Boolean flagImovelComFoco) {
        this.flagImovelComFoco = flagImovelComFoco;
    }

    public Boolean getFlagAcaoMecanica() {
        return flagAcaoMecanica;
    }

    public void setFlagAcaoMecanica(Boolean flagAcaoMecanica) {
        this.flagAcaoMecanica = flagAcaoMecanica;
    }

    public Boolean getFlagTratamentoFocal() {
        return flagTratamentoFocal;
    }

    public void setFlagTratamentoFocal(Boolean flagTratamentoFocal) {
        this.flagTratamentoFocal = flagTratamentoFocal;
    }

    public Boolean getFlagEgressoInternacao() {
        return flagEgressoInternacao;
    }

    public void setFlagEgressoInternacao(Boolean flagEgressoInternacao) {
        this.flagEgressoInternacao = flagEgressoInternacao;
    }

    public Boolean getFlagConvite() {
        return flagConvite;
    }

    public void setFlagConvite(Boolean flagConvite) {
        this.flagConvite = flagConvite;
    }

    public Boolean getFlagOrientacao() {
        return flagOrientacao;
    }

    public void setFlagOrientacao(Boolean flagOrientacao) {
        this.flagOrientacao = flagOrientacao;
    }

    public Boolean getFlagOutros() {
        return flagOutros;
    }

    public void setFlagOutros(Boolean flagOutros) {
        this.flagOutros = flagOutros;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public DesfechoModel getDesfechoModel() {
        return desfechoModel;
    }

    public void setDesfechoModel(DesfechoModel desfechoModel) {
        this.desfechoModel = desfechoModel;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Boolean getFlagExportado() {
        return flagExportado;
    }

    public void setFlagExportado(Boolean flagExportado) {
        this.flagExportado = flagExportado;
    }
}
