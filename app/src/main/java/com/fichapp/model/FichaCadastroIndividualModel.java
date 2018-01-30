package com.fichapp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rodrigo Costa on 21/12/2017.
 */

public class FichaCadastroIndividualModel implements Serializable{

    private Long id;

    private ProfissionalModel profissionalModel;
    private CNESModel cnesModel;

    private Date dataRegistro;
    private String turno;

    private String cnsCidadao;
    private Integer flagResponsavelFamiliar;
    private String cnsResponsavelFamiliar;
    private String microarea;
    private Boolean flagForaDeArea;
    private String nomeCompleto;
    private String nomeSocial;
    private Date dataNascimento;
    private Integer sexo;
    private TipoModel raca;
    private String etnia;
    private String nis;

    private String nomeMae;
    private Boolean flagMaeDesconhecido;
    private String nomePai;
    private Boolean flagPaiDesconhecido;

    private Integer nacionalidade;
    private String paisNascimento;
    private String municipioUfNascimento;
    private String portariaNaturalizacao;
    private Date dataNaturalizacao;
    private Date dataEntrada;

    private String telefoneCelular;
    private String emailCidadao;

    private TipoModel parentescoResponsavelFamiliar;
    private String ocupacao;
    private Integer flagFrequentaEscola;
    private TipoModel cursoMaisElevado;
    private TipoModel situacaoMercado;

    private Boolean flagFicaComAdultoResponsavel;
    private Boolean flagFicaComOutrasCriancas;
    private Boolean flagFicaComAdolescente;
    private Boolean flagFicaEmCreche;
    private Boolean flagFicaSozinha;
    private Boolean flagFicaOutro;

    private Integer flagFrequentaCuidador;
    private Integer flagParticipaGrupoComunitario;
    private Integer flagPossuiPlanoDeSaude;
    private Integer flagMembroDeComunidade;
    private String qualComunidade;

    private Integer flagInformarOrientacao;
    private TipoModel orientacaoSexual;
    private Integer flagInformarIdentidadeGenero;
    private TipoModel identidadeGenero;

    private Integer flagDeficiencia;
    private Boolean flagDeficienciaAuditiva;
    private Boolean flagDeficienciaVisual;
    private Boolean flagDeficienciaIntelectual;
    private Boolean flagDeficienciaFisica;
    private Boolean flagOutraDeficiencia;

    private Integer saidaCadastro;
    private String numeroDO;
    private Date dataObito;

    private Integer flagGestante;
    private String qualMaternidade;
    private Integer peso;

    private Integer flagFumante;
    private Integer flagAlcool;
    private Integer flagOutrasDrogas;
    private Integer flagHipertensao;
    private Integer flagDiabetes;
    private Integer flagAvcDerrame;
    private Integer flagInfarto;

    private Integer flagDoencaCardiaca;
    private Boolean flagInsuficienciaCardiaca;
    private Boolean flagOutraDoencaCardiaca;
    private Boolean flagNaoSabeDoencaCardiaca;

    private Integer flagProblemaRins;
    private Boolean flagInsuficienciaRenal;
    private Boolean flagOutroProblemaRins;
    private Boolean flagNaoSabeProblemaRins;

    private Integer flagDoencaRespiratoria;
    private Boolean flagAsma;
    private Boolean flagEnfisema;
    private Boolean flagOutraDoencaRespiratoria;
    private Boolean flagNaoSabeDoencaRespiratoria;

    private Integer flagHanseniase;
    private Integer flagTuberculose;
    private Integer flagCancer;
    private Integer flagInternado;
    private String qualMotivoInternamento;
    private Integer flagProblemaMental;
    private Integer flagAcamado;
    private Integer flagDomiciliado;
    private Integer flagPlantasMedicinais;
    private String quaisPlantas;
    private Integer flagOutrasPraticasIntegrativas;
    private String outrasCondicoesSaude;

    private Integer flagSituacaoRua;
    private Integer tempoSituacaoRua;
    private Integer flagRecebeBeneficio;
    private Integer flagReferenciaFamiliar;

    private Integer frequenciaAlimentacao;
    private Boolean flagAlimentacaoRestaurantePopular;
    private Boolean flagAlimentacaoDoacaoGrupoReligioso;
    private Boolean flagAlimentacaoDoacaoRestaurante;
    private Boolean flagAlimentacaoDoacaoPopular;
    private Boolean flagAlimentacaoOutras;

    private Integer flagAcompanhadoInstituicao;
    private String qualInstituicao;
    private Integer flagVisitaFamiliar;
    private String grauParentesco;

    private Integer flagAcessoHigienePessoal;
    private Boolean flagAcessoBanho;
    private Boolean flagAcessoSanitario;
    private Boolean flagAcessoHigieneBucal;
    private Boolean flagAcessoOutras;

    private Boolean flagAtivo;
    private Boolean flagExportado;



    //--------- GETTERS E SETTERS -----------


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

    public String getCnsCidadao() {
        return cnsCidadao;
    }

    public void setCnsCidadao(String cnsCidadao) {
        this.cnsCidadao = cnsCidadao;
    }

    public Integer getFlagResponsavelFamiliar() {
        return flagResponsavelFamiliar;
    }

    public void setFlagResponsavelFamiliar(Integer flagResponsavelFamiliar) {
        this.flagResponsavelFamiliar = flagResponsavelFamiliar;
    }

    public String getCnsResponsavelFamiliar() {
        return cnsResponsavelFamiliar;
    }

    public void setCnsResponsavelFamiliar(String cnsResponsavelFamiliar) {
        this.cnsResponsavelFamiliar = cnsResponsavelFamiliar;
    }

    public String getMicroarea() {
        return microarea;
    }

    public void setMicroarea(String microarea) {
        this.microarea = microarea;
    }

    public Boolean getFlagForaDeArea() {
        return flagForaDeArea;
    }

    public void setFlagForaDeArea(Boolean flagForaDeArea) {
        this.flagForaDeArea = flagForaDeArea;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public TipoModel getRaca() {
        return raca;
    }

    public void setRaca(TipoModel raca) {
        this.raca = raca;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Boolean getFlagMaeDesconhecido() {
        return flagMaeDesconhecido;
    }

    public void setFlagMaeDesconhecido(Boolean flagMaeDesconhecido) {
        this.flagMaeDesconhecido = flagMaeDesconhecido;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Boolean getFlagPaiDesconhecido() {
        return flagPaiDesconhecido;
    }

    public void setFlagPaiDesconhecido(Boolean flagPaiDesconhecido) {
        this.flagPaiDesconhecido = flagPaiDesconhecido;
    }

    public Integer getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Integer nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(String paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public String getMunicipioUfNascimento() {
        return municipioUfNascimento;
    }

    public void setMunicipioUfNascimento(String municipioUfNascimento) {
        this.municipioUfNascimento = municipioUfNascimento;
    }

    public String getPortariaNaturalizacao() {
        return portariaNaturalizacao;
    }

    public void setPortariaNaturalizacao(String portariaNaturalizacao) {
        this.portariaNaturalizacao = portariaNaturalizacao;
    }

    public Date getDataNaturalizacao() {
        return dataNaturalizacao;
    }

    public void setDataNaturalizacao(Date dataNaturalizacao) {
        this.dataNaturalizacao = dataNaturalizacao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmailCidadao() {
        return emailCidadao;
    }

    public void setEmailCidadao(String emailCidadao) {
        this.emailCidadao = emailCidadao;
    }

    public TipoModel getParentescoResponsavelFamiliar() {
        return parentescoResponsavelFamiliar;
    }

    public void setParentescoResponsavelFamiliar(TipoModel parentescoResponsavelFamiliar) {
        this.parentescoResponsavelFamiliar = parentescoResponsavelFamiliar;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Integer getFlagFrequentaEscola() {
        return flagFrequentaEscola;
    }

    public void setFlagFrequentaEscola(Integer flagFrequentaEscola) {
        this.flagFrequentaEscola = flagFrequentaEscola;
    }

    public TipoModel getCursoMaisElevado() {
        return cursoMaisElevado;
    }

    public void setCursoMaisElevado(TipoModel cursoMaisElevado) {
        this.cursoMaisElevado = cursoMaisElevado;
    }

    public TipoModel getSituacaoMercado() {
        return situacaoMercado;
    }

    public void setSituacaoMercado(TipoModel situacaoMercado) {
        this.situacaoMercado = situacaoMercado;
    }

    public Boolean getFlagFicaComAdultoResponsavel() {
        return flagFicaComAdultoResponsavel;
    }

    public void setFlagFicaComAdultoResponsavel(Boolean flagFicaComAdultoResponsavel) {
        this.flagFicaComAdultoResponsavel = flagFicaComAdultoResponsavel;
    }

    public Boolean getFlagFicaComOutrasCriancas() {
        return flagFicaComOutrasCriancas;
    }

    public void setFlagFicaComOutrasCriancas(Boolean flagFicaComOutrasCriancas) {
        this.flagFicaComOutrasCriancas = flagFicaComOutrasCriancas;
    }

    public Boolean getFlagFicaComAdolescente() {
        return flagFicaComAdolescente;
    }

    public void setFlagFicaComAdolescente(Boolean flagFicaComAdolescente) {
        this.flagFicaComAdolescente = flagFicaComAdolescente;
    }

    public Boolean getFlagFicaEmCreche() {
        return flagFicaEmCreche;
    }

    public void setFlagFicaEmCreche(Boolean flagFicaEmCreche) {
        this.flagFicaEmCreche = flagFicaEmCreche;
    }

    public Boolean getFlagFicaSozinha() {
        return flagFicaSozinha;
    }

    public void setFlagFicaSozinha(Boolean flagFicaSozinha) {
        this.flagFicaSozinha = flagFicaSozinha;
    }

    public Boolean getFlagFicaOutro() {
        return flagFicaOutro;
    }

    public void setFlagFicaOutro(Boolean flagFicaOutro) {
        this.flagFicaOutro = flagFicaOutro;
    }

    public Integer getFlagFrequentaCuidador() {
        return flagFrequentaCuidador;
    }

    public void setFlagFrequentaCuidador(Integer flagFrequentaCuidador) {
        this.flagFrequentaCuidador = flagFrequentaCuidador;
    }

    public Integer getFlagParticipaGrupoComunitario() {
        return flagParticipaGrupoComunitario;
    }

    public void setFlagParticipaGrupoComunitario(Integer flagParticipaGrupoComunitario) {
        this.flagParticipaGrupoComunitario = flagParticipaGrupoComunitario;
    }

    public Integer getFlagPossuiPlanoDeSaude() {
        return flagPossuiPlanoDeSaude;
    }

    public void setFlagPossuiPlanoDeSaude(Integer flagPossuiPlanoDeSaude) {
        this.flagPossuiPlanoDeSaude = flagPossuiPlanoDeSaude;
    }

    public Integer getFlagMembroDeComunidade() {
        return flagMembroDeComunidade;
    }

    public void setFlagMembroDeComunidade(Integer flagMembroDeComunidade) {
        this.flagMembroDeComunidade = flagMembroDeComunidade;
    }

    public String getQualComunidade() {
        return qualComunidade;
    }

    public void setQualComunidade(String qualComunidade) {
        this.qualComunidade = qualComunidade;
    }

    public Integer getFlagInformarOrientacao() {
        return flagInformarOrientacao;
    }

    public void setFlagInformarOrientacao(Integer flagInformarOrientacao) {
        this.flagInformarOrientacao = flagInformarOrientacao;
    }

    public TipoModel getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(TipoModel orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public Integer getFlagInformarIdentidadeGenero() {
        return flagInformarIdentidadeGenero;
    }

    public void setFlagInformarIdentidadeGenero(Integer flagInformarIdentidadeGenero) {
        this.flagInformarIdentidadeGenero = flagInformarIdentidadeGenero;
    }

    public TipoModel getIdentidadeGenero() {
        return identidadeGenero;
    }

    public void setIdentidadeGenero(TipoModel identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public Integer getFlagDeficiencia() {
        return flagDeficiencia;
    }

    public void setFlagDeficiencia(Integer flagDeficiencia) {
        this.flagDeficiencia = flagDeficiencia;
    }

    public Boolean getFlagDeficienciaAuditiva() {
        return flagDeficienciaAuditiva;
    }

    public void setFlagDeficienciaAuditiva(Boolean flagDeficienciaAuditiva) {
        this.flagDeficienciaAuditiva = flagDeficienciaAuditiva;
    }

    public Boolean getFlagDeficienciaVisual() {
        return flagDeficienciaVisual;
    }

    public void setFlagDeficienciaVisual(Boolean flagDeficienciaVisual) {
        this.flagDeficienciaVisual = flagDeficienciaVisual;
    }

    public Boolean getFlagDeficienciaIntelectual() {
        return flagDeficienciaIntelectual;
    }

    public void setFlagDeficienciaIntelectual(Boolean flagDeficienciaIntelectual) {
        this.flagDeficienciaIntelectual = flagDeficienciaIntelectual;
    }

    public Boolean getFlagDeficienciaFisica() {
        return flagDeficienciaFisica;
    }

    public void setFlagDeficienciaFisica(Boolean flagDeficienciaFisica) {
        this.flagDeficienciaFisica = flagDeficienciaFisica;
    }

    public Boolean getFlagOutraDeficiencia() {
        return flagOutraDeficiencia;
    }

    public void setFlagOutraDeficiencia(Boolean flagOutraDeficiencia) {
        this.flagOutraDeficiencia = flagOutraDeficiencia;
    }

    public Integer getSaidaCadastro() {
        return saidaCadastro;
    }

    public void setSaidaCadastro(Integer saidaCadastro) {
        this.saidaCadastro = saidaCadastro;
    }

    public String getNumeroDO() {
        return numeroDO;
    }

    public void setNumeroDO(String numeroDO) {
        this.numeroDO = numeroDO;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    public Integer getFlagGestante() {
        return flagGestante;
    }

    public void setFlagGestante(Integer flagGestante) {
        this.flagGestante = flagGestante;
    }

    public String getQualMaternidade() {
        return qualMaternidade;
    }

    public void setQualMaternidade(String qualMaternidade) {
        this.qualMaternidade = qualMaternidade;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getFlagFumante() {
        return flagFumante;
    }

    public void setFlagFumante(Integer flagFumante) {
        this.flagFumante = flagFumante;
    }

    public Integer getFlagAlcool() {
        return flagAlcool;
    }

    public void setFlagAlcool(Integer flagAlcool) {
        this.flagAlcool = flagAlcool;
    }

    public Integer getFlagOutrasDrogas() {
        return flagOutrasDrogas;
    }

    public void setFlagOutrasDrogas(Integer flagOutrasDrogas) {
        this.flagOutrasDrogas = flagOutrasDrogas;
    }

    public Integer getFlagHipertensao() {
        return flagHipertensao;
    }

    public void setFlagHipertensao(Integer flagHipertensao) {
        this.flagHipertensao = flagHipertensao;
    }

    public Integer getFlagDiabetes() {
        return flagDiabetes;
    }

    public void setFlagDiabetes(Integer flagDiabetes) {
        this.flagDiabetes = flagDiabetes;
    }

    public Integer getFlagAvcDerrame() {
        return flagAvcDerrame;
    }

    public void setFlagAvcDerrame(Integer flagAvcDerrame) {
        this.flagAvcDerrame = flagAvcDerrame;
    }

    public Integer getFlagInfarto() {
        return flagInfarto;
    }

    public void setFlagInfarto(Integer flagInfarto) {
        this.flagInfarto = flagInfarto;
    }

    public Integer getFlagDoencaCardiaca() {
        return flagDoencaCardiaca;
    }

    public void setFlagDoencaCardiaca(Integer flagDoencaCardiaca) {
        this.flagDoencaCardiaca = flagDoencaCardiaca;
    }

    public Boolean getFlagInsuficienciaCardiaca() {
        return flagInsuficienciaCardiaca;
    }

    public void setFlagInsuficienciaCardiaca(Boolean flagInsuficienciaCardiaca) {
        this.flagInsuficienciaCardiaca = flagInsuficienciaCardiaca;
    }

    public Boolean getFlagOutraDoencaCardiaca() {
        return flagOutraDoencaCardiaca;
    }

    public void setFlagOutraDoencaCardiaca(Boolean flagOutraDoencaCardiaca) {
        this.flagOutraDoencaCardiaca = flagOutraDoencaCardiaca;
    }

    public Boolean getFlagNaoSabeDoencaCardiaca() {
        return flagNaoSabeDoencaCardiaca;
    }

    public void setFlagNaoSabeDoencaCardiaca(Boolean flagNaoSabeDoencaCardiaca) {
        this.flagNaoSabeDoencaCardiaca = flagNaoSabeDoencaCardiaca;
    }

    public Integer getFlagProblemaRins() {
        return flagProblemaRins;
    }

    public void setFlagProblemaRins(Integer flagProblemaRins) {
        this.flagProblemaRins = flagProblemaRins;
    }

    public Boolean getFlagInsuficienciaRenal() {
        return flagInsuficienciaRenal;
    }

    public void setFlagInsuficienciaRenal(Boolean flagInsuficienciaRenal) {
        this.flagInsuficienciaRenal = flagInsuficienciaRenal;
    }

    public Boolean getFlagOutroProblemaRins() {
        return flagOutroProblemaRins;
    }

    public void setFlagOutroProblemaRins(Boolean flagOutroProblemaRins) {
        this.flagOutroProblemaRins = flagOutroProblemaRins;
    }

    public Boolean getFlagNaoSabeProblemaRins() {
        return flagNaoSabeProblemaRins;
    }

    public void setFlagNaoSabeProblemaRins(Boolean flagNaoSabeProblemaRins) {
        this.flagNaoSabeProblemaRins = flagNaoSabeProblemaRins;
    }

    public Integer getFlagDoencaRespiratoria() {
        return flagDoencaRespiratoria;
    }

    public void setFlagDoencaRespiratoria(Integer flagDoencaRespiratoria) {
        this.flagDoencaRespiratoria = flagDoencaRespiratoria;
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

    public Boolean getFlagOutraDoencaRespiratoria() {
        return flagOutraDoencaRespiratoria;
    }

    public void setFlagOutraDoencaRespiratoria(Boolean flagOutraDoencaRespiratoria) {
        this.flagOutraDoencaRespiratoria = flagOutraDoencaRespiratoria;
    }

    public Boolean getFlagNaoSabeDoencaRespiratoria() {
        return flagNaoSabeDoencaRespiratoria;
    }

    public void setFlagNaoSabeDoencaRespiratoria(Boolean flagNaoSabeDoencaRespiratoria) {
        this.flagNaoSabeDoencaRespiratoria = flagNaoSabeDoencaRespiratoria;
    }

    public Integer getFlagHanseniase() {
        return flagHanseniase;
    }

    public void setFlagHanseniase(Integer flagHanseniase) {
        this.flagHanseniase = flagHanseniase;
    }

    public Integer getFlagTuberculose() {
        return flagTuberculose;
    }

    public void setFlagTuberculose(Integer flagTuberculose) {
        this.flagTuberculose = flagTuberculose;
    }

    public Integer getFlagCancer() {
        return flagCancer;
    }

    public void setFlagCancer(Integer flagCancer) {
        this.flagCancer = flagCancer;
    }

    public Integer getFlagInternado() {
        return flagInternado;
    }

    public void setFlagInternado(Integer flagInternado) {
        this.flagInternado = flagInternado;
    }

    public String getQualMotivoInternamento() {
        return qualMotivoInternamento;
    }

    public void setQualMotivoInternamento(String qualMotivoInternamento) {
        this.qualMotivoInternamento = qualMotivoInternamento;
    }

    public Integer getFlagProblemaMental() {
        return flagProblemaMental;
    }

    public void setFlagProblemaMental(Integer flagProblemaMental) {
        this.flagProblemaMental = flagProblemaMental;
    }

    public Integer getFlagAcamado() {
        return flagAcamado;
    }

    public void setFlagAcamado(Integer flagAcamado) {
        this.flagAcamado = flagAcamado;
    }

    public Integer getFlagDomiciliado() {
        return flagDomiciliado;
    }

    public void setFlagDomiciliado(Integer flagDomiciliado) {
        this.flagDomiciliado = flagDomiciliado;
    }

    public Integer getFlagPlantasMedicinais() {
        return flagPlantasMedicinais;
    }

    public void setFlagPlantasMedicinais(Integer flagPlantasMedicinais) {
        this.flagPlantasMedicinais = flagPlantasMedicinais;
    }

    public String getQuaisPlantas() {
        return quaisPlantas;
    }

    public void setQuaisPlantas(String quaisPlantas) {
        this.quaisPlantas = quaisPlantas;
    }

    public Integer getFlagOutrasPraticasIntegrativas() {
        return flagOutrasPraticasIntegrativas;
    }

    public void setFlagOutrasPraticasIntegrativas(Integer flagOutrasPraticasIntegrativas) {
        this.flagOutrasPraticasIntegrativas = flagOutrasPraticasIntegrativas;
    }

    public String getOutrasCondicoesSaude() {
        return outrasCondicoesSaude;
    }

    public void setOutrasCondicoesSaude(String outrasCondicoesSaude) {
        this.outrasCondicoesSaude = outrasCondicoesSaude;
    }

    public Integer getFlagSituacaoRua() {
        return flagSituacaoRua;
    }

    public void setFlagSituacaoRua(Integer flagSituacaoRua) {
        this.flagSituacaoRua = flagSituacaoRua;
    }

    public Integer getTempoSituacaoRua() {
        return tempoSituacaoRua;
    }

    public void setTempoSituacaoRua(Integer tempoSituacaoRua) {
        this.tempoSituacaoRua = tempoSituacaoRua;
    }

    public Integer getFlagRecebeBeneficio() {
        return flagRecebeBeneficio;
    }

    public void setFlagRecebeBeneficio(Integer flagRecebeBeneficio) {
        this.flagRecebeBeneficio = flagRecebeBeneficio;
    }

    public Integer getFlagReferenciaFamiliar() {
        return flagReferenciaFamiliar;
    }

    public void setFlagReferenciaFamiliar(Integer flagReferenciaFamiliar) {
        this.flagReferenciaFamiliar = flagReferenciaFamiliar;
    }

    public Integer getFrequenciaAlimentacao() {
        return frequenciaAlimentacao;
    }

    public void setFrequenciaAlimentacao(Integer frequenciaAlimentacao) {
        this.frequenciaAlimentacao = frequenciaAlimentacao;
    }

    public Boolean getFlagAlimentacaoRestaurantePopular() {
        return flagAlimentacaoRestaurantePopular;
    }

    public void setFlagAlimentacaoRestaurantePopular(Boolean flagAlimentacaoRestaurantePopular) {
        this.flagAlimentacaoRestaurantePopular = flagAlimentacaoRestaurantePopular;
    }

    public Boolean getFlagAlimentacaoDoacaoGrupoReligioso() {
        return flagAlimentacaoDoacaoGrupoReligioso;
    }

    public void setFlagAlimentacaoDoacaoGrupoReligioso(Boolean flagAlimentacaoDoacaoGrupoReligioso) {
        this.flagAlimentacaoDoacaoGrupoReligioso = flagAlimentacaoDoacaoGrupoReligioso;
    }

    public Boolean getFlagAlimentacaoDoacaoRestaurante() {
        return flagAlimentacaoDoacaoRestaurante;
    }

    public void setFlagAlimentacaoDoacaoRestaurante(Boolean flagAlimentacaoDoacaoRestaurante) {
        this.flagAlimentacaoDoacaoRestaurante = flagAlimentacaoDoacaoRestaurante;
    }

    public Boolean getFlagAlimentacaoDoacaoPopular() {
        return flagAlimentacaoDoacaoPopular;
    }

    public void setFlagAlimentacaoDoacaoPopular(Boolean flagAlimentacaoDoacaoPopular) {
        this.flagAlimentacaoDoacaoPopular = flagAlimentacaoDoacaoPopular;
    }

    public Boolean getFlagAlimentacaoOutras() {
        return flagAlimentacaoOutras;
    }

    public void setFlagAlimentacaoOutras(Boolean flagAlimentacaoOutras) {
        this.flagAlimentacaoOutras = flagAlimentacaoOutras;
    }

    public Integer getFlagAcompanhadoInstituicao() {
        return flagAcompanhadoInstituicao;
    }

    public void setFlagAcompanhadoInstituicao(Integer flagAcompanhadoInstituicao) {
        this.flagAcompanhadoInstituicao = flagAcompanhadoInstituicao;
    }

    public String getQualInstituicao() {
        return qualInstituicao;
    }

    public void setQualInstituicao(String qualInstituicao) {
        this.qualInstituicao = qualInstituicao;
    }

    public Integer getFlagVisitaFamiliar() {
        return flagVisitaFamiliar;
    }

    public void setFlagVisitaFamiliar(Integer flagVisitaFamiliar) {
        this.flagVisitaFamiliar = flagVisitaFamiliar;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Integer getFlagAcessoHigienePessoal() {
        return flagAcessoHigienePessoal;
    }

    public void setFlagAcessoHigienePessoal(Integer flagAcessoHigienePessoal) {
        this.flagAcessoHigienePessoal = flagAcessoHigienePessoal;
    }

    public Boolean getFlagAcessoBanho() {
        return flagAcessoBanho;
    }

    public void setFlagAcessoBanho(Boolean flagAcessoBanho) {
        this.flagAcessoBanho = flagAcessoBanho;
    }

    public Boolean getFlagAcessoSanitario() {
        return flagAcessoSanitario;
    }

    public void setFlagAcessoSanitario(Boolean flagAcessoSanitario) {
        this.flagAcessoSanitario = flagAcessoSanitario;
    }

    public Boolean getFlagAcessoHigieneBucal() {
        return flagAcessoHigieneBucal;
    }

    public void setFlagAcessoHigieneBucal(Boolean flagAcessoHigieneBucal) {
        this.flagAcessoHigieneBucal = flagAcessoHigieneBucal;
    }

    public Boolean getFlagAcessoOutras() {
        return flagAcessoOutras;
    }

    public void setFlagAcessoOutras(Boolean flagAcessoOutras) {
        this.flagAcessoOutras = flagAcessoOutras;
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
