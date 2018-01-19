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
    private Boolean flagResponsavelFamiliar;
    private String cnsResponsavelFamiliar;
    private String microarea;
    private Boolean flagForaDeArea;
    private String nomeCompleto;
    private String nomeSocial;
    private Date dataNascimento;
    private Integer sexo;
    private Integer raca;
    private String etnia;
    private String nis;

    private String nomeMae;
    private Boolean flagMaeDesconhecido;
    private String nomePai;
    private Boolean flagPaiDesconhecido;

    private Integer nascimento;
    private String paisNascimento;
    private String municipioUfNascimento;
    private String portariaNaturalizacao;
    private Date dataNaturalizacao;
    private Date dataEntrada;

    private String telefoneCelular;
    private String emailCidadao;

    private Integer parentescoResponsavelFamiliar;
    private String ocupacao;
    private Boolean flagFrequentaEscola;
    private Integer cursoMaisElevado;
    private Integer situacaoMercado;

    private Boolean flagFicaComAdultoResponsavel;
    private Boolean flagFicaComOutrasCriancas;
    private Boolean flagFicaComAdolescente;
    private Boolean flagFicaEmCreche;
    private Boolean flagFicaSozinha;
    private Boolean flagFicaOutro;

    private Boolean flagFrequentaCuidador;
    private Boolean flagParticipaGrupoComunitario;
    private Boolean flagPossuiPlanoDeSaude;
    private Boolean flagMembroDeComunidade;
    private String qualComunidade;

    private Boolean flagInformarOrientacao;
    private Integer orientacaoSexual;
    private Boolean flagInformarIdentidadeGenero;
    private Integer identidadeGenero;

    private Boolean flagDeficiencia;
    private Boolean flagDeficienciaAuditiva;
    private Boolean flagDeficienciaVisual;
    private Boolean flagDeficienciaIntelectual;
    private Boolean flagDeficienciaFisica;
    private Boolean flagOutraDeficiencia;

    private Integer saidaCadastro;
    private String numeroDO;
    private Date dataObito;

    private Boolean flagGestante;
    private String qualMaternidade;
    private Integer peso;

    private Boolean flagFumante;
    private Boolean flagAlcool;
    private Boolean flagOutrasDrogas;
    private Boolean flagHipertensao;
    private Boolean flagDiabetes;
    private Boolean flagAvcDerrame;
    private Boolean flagInfarto;

    private Boolean flagDoencaCardiaca;
    private Boolean flagInsuficienciaCardiaca;
    private Boolean flagOutraDoencaCardiaca;
    private Boolean flagNaoSabeDoencaCardiaca;

    private Boolean flagProblemaRins;
    private Boolean flagInsuficienciaRenal;
    private Boolean flagOutroProblemaRins;
    private Boolean flagNaoSabeProblemaRins;

    private Boolean flagDoencaRespiratoria;
    private Boolean flagAsma;
    private Boolean flagEnfisema;
    private Boolean flagOutraDoencaRespiratoria;
    private Boolean flagNaoSabeDoencaRespiratoria;

    private Boolean flagHanseniase;
    private Boolean flagTuberculose;
    private Boolean flagCancer;
    private Boolean flagInternado;
    private String qualMotivoInternamento;
    private Boolean flagProblemaMental;
    private Boolean flagAcamado;
    private Boolean flagDomiciliado;
    private Boolean flagPlantasMedicinais;
    private String quaisPlantas;
    private Boolean flagOutrasPraticasIntegrativas;
    private String outrasCondicoesSaude;

    private Boolean flagSituacaoRua;
    private Integer tempoSituacaoRua;
    private Boolean flagRecebeBeneficio;
    private Boolean flagReferenciaFamiliar;

    private Integer frequenciaAlimentacao;
    private Boolean flagAlimentacaoRestaurantePopular;
    private Boolean flagAlimentacaoDoacaoGrupoReligioso;
    private Boolean flagAlimentacaoDoacaoRestaurante;
    private Boolean flagAlimentacaoDoacaoPopular;
    private Boolean flagAlimentacaoOutras;

    private Boolean flagAcompanhadoInstituicao;
    private String qualInstituicao;
    private Boolean flagVisitaFamiliar;
    private Integer grauParentesco;

    private Boolean flagAcessoHigienePessoal;
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

    public Boolean getFlagResponsavelFamiliar() {
        return flagResponsavelFamiliar;
    }
    public void setFlagResponsavelFamiliar(Boolean flagResponsavelFamiliar) {
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

    public Integer getRaca() {
        return raca;
    }
    public void setRaca(Integer raca) {
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

    public Integer getNascimento() {
        return nascimento;
    }
    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
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

    public Integer getParentescoResponsavelFamiliar() {
        return parentescoResponsavelFamiliar;
    }
    public void setParentescoResponsavelFamiliar(Integer parentescoResponsavelFamiliar) {
        this.parentescoResponsavelFamiliar = parentescoResponsavelFamiliar;
    }

    public String getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Boolean getFlagFrequentaEscola() {
        return flagFrequentaEscola;
    }
    public void setFlagFrequentaEscola(Boolean flagFrequentaEscola) {
        this.flagFrequentaEscola = flagFrequentaEscola;
    }

    public Integer getCursoMaisElevado() {
        return cursoMaisElevado;
    }
    public void setCursoMaisElevado(Integer cursoMaisElevado) {
        this.cursoMaisElevado = cursoMaisElevado;
    }

    public Integer getSituacaoMercado() {
        return situacaoMercado;
    }
    public void setSituacaoMercado(Integer situacaoMercado) {
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

    public Boolean getFlagFrequentaCuidador() {
        return flagFrequentaCuidador;
    }
    public void setFlagFrequentaCuidador(Boolean flagFrequentaCuidador) {
        this.flagFrequentaCuidador = flagFrequentaCuidador;
    }

    public Boolean getFlagParticipaGrupoComunitario() {
        return flagParticipaGrupoComunitario;
    }
    public void setFlagParticipaGrupoComunitario(Boolean flagParticipaGrupoComunitario) {
        this.flagParticipaGrupoComunitario = flagParticipaGrupoComunitario;
    }

    public Boolean getFlagPossuiPlanoDeSaude() {
        return flagPossuiPlanoDeSaude;
    }
    public void setFlagPossuiPlanoDeSaude(Boolean flagPossuiPlanoDeSaude) {
        this.flagPossuiPlanoDeSaude = flagPossuiPlanoDeSaude;
    }

    public Boolean getFlagMembroDeComunidade() {
        return flagMembroDeComunidade;
    }
    public void setFlagMembroDeComunidade(Boolean flagMembroDeComunidade) {
        this.flagMembroDeComunidade = flagMembroDeComunidade;
    }

    public String getQualComunidade() {
        return qualComunidade;
    }
    public void setQualComunidade(String qualComunidade) {
        this.qualComunidade = qualComunidade;
    }

    public Boolean getFlagInformarOrientacao() {
        return flagInformarOrientacao;
    }
    public void setFlagInformarOrientacao(Boolean flagInformarOrientacao) {
        this.flagInformarOrientacao = flagInformarOrientacao;
    }

    public Integer getOrientacaoSexual() {
        return orientacaoSexual;
    }
    public void setOrientacaoSexual(Integer orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }

    public Boolean getFlagInformarIdentidadeGenero() {
        return flagInformarIdentidadeGenero;
    }
    public void setFlagInformarIdentidadeGenero(Boolean flagInformarIdentidadeGenero) {
        this.flagInformarIdentidadeGenero = flagInformarIdentidadeGenero;
    }

    public Integer getIdentidadeGenero() {
        return identidadeGenero;
    }
    public void setIdentidadeGenero(Integer identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public Boolean getFlagDeficiencia() {
        return flagDeficiencia;
    }
    public void setFlagDeficiencia(Boolean flagDeficiencia) {
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

    public Boolean getFlagGestante() {
        return flagGestante;
    }
    public void setFlagGestante(Boolean flagGestante) {
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

    public Boolean getFlagFumante() {
        return flagFumante;
    }
    public void setFlagFumante(Boolean flagFumante) {
        this.flagFumante = flagFumante;
    }

    public Boolean getFlagAlcool() {
        return flagAlcool;
    }
    public void setFlagAlcool(Boolean flagAlcool) {
        this.flagAlcool = flagAlcool;
    }

    public Boolean getFlagOutrasDrogas() {
        return flagOutrasDrogas;
    }
    public void setFlagOutrasDrogas(Boolean flagOutrasDrogas) {
        this.flagOutrasDrogas = flagOutrasDrogas;
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

    public Boolean getFlagAvcDerrame() {
        return flagAvcDerrame;
    }
    public void setFlagAvcDerrame(Boolean flagAvcDerrame) {
        this.flagAvcDerrame = flagAvcDerrame;
    }

    public Boolean getFlagInfarto() {
        return flagInfarto;
    }
    public void setFlagInfarto(Boolean flagInfarto) {
        this.flagInfarto = flagInfarto;
    }

    public Boolean getFlagDoencaCardiaca() {
        return flagDoencaCardiaca;
    }
    public void setFlagDoencaCardiaca(Boolean flagDoencaCardiaca) {
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

    public Boolean getFlagProblemaRins() {
        return flagProblemaRins;
    }
    public void setFlagProblemaRins(Boolean flagProblemaRins) {
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

    public Boolean getFlagDoencaRespiratoria() {
        return flagDoencaRespiratoria;
    }
    public void setFlagDoencaRespiratoria(Boolean flagDoencaRespiratoria) {
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

    public Boolean getFlagCancer() {
        return flagCancer;
    }
    public void setFlagCancer(Boolean flagCancer) {
        this.flagCancer = flagCancer;
    }

    public Boolean getFlagInternado() {
        return flagInternado;
    }
    public void setFlagInternado(Boolean flagInternado) {
        this.flagInternado = flagInternado;
    }

    public String getQualMotivoInternamento() {
        return qualMotivoInternamento;
    }
    public void setQualMotivoInternamento(String qualMotivoInternamento) {
        this.qualMotivoInternamento = qualMotivoInternamento;
    }

    public Boolean getFlagProblemaMental() {
        return flagProblemaMental;
    }
    public void setFlagProblemaMental(Boolean flagProblemaMental) {
        this.flagProblemaMental = flagProblemaMental;
    }

    public Boolean getFlagAcamado() {
        return flagAcamado;
    }
    public void setFlagAcamado(Boolean flagAcamado) {
        this.flagAcamado = flagAcamado;
    }

    public Boolean getFlagDomiciliado() {
        return flagDomiciliado;
    }
    public void setFlagDomiciliado(Boolean flagDomiciliado) {
        this.flagDomiciliado = flagDomiciliado;
    }

    public Boolean getFlagPlantasMedicinais() {
        return flagPlantasMedicinais;
    }
    public void setFlagPlantasMedicinais(Boolean flagPlantasMedicinais) {
        this.flagPlantasMedicinais = flagPlantasMedicinais;
    }

    public String getQuaisPlantas() {
        return quaisPlantas;
    }
    public void setQuaisPlantas(String quaisPlantas) {
        this.quaisPlantas = quaisPlantas;
    }

    public Boolean getFlagOutrasPraticasIntegrativas() {
        return flagOutrasPraticasIntegrativas;
    }
    public void setFlagOutrasPraticasIntegrativas(Boolean flagOutrasPraticasIntegrativas) {
        this.flagOutrasPraticasIntegrativas = flagOutrasPraticasIntegrativas;
    }

    public String getOutrasCondicoesSaude() {
        return outrasCondicoesSaude;
    }
    public void setOutrasCondicoesSaude(String outrasCondicoesSaude) {
        this.outrasCondicoesSaude = outrasCondicoesSaude;
    }

    public Boolean getFlagSituacaoRua() {
        return flagSituacaoRua;
    }
    public void setFlagSituacaoRua(Boolean flagSituacaoRua) {
        this.flagSituacaoRua = flagSituacaoRua;
    }

    public Integer getTempoSituacaoRua() {
        return tempoSituacaoRua;
    }
    public void setTempoSituacaoRua(Integer tempoSituacaoRua) {
        this.tempoSituacaoRua = tempoSituacaoRua;
    }

    public Boolean getFlagRecebeBeneficio() {
        return flagRecebeBeneficio;
    }
    public void setFlagRecebeBeneficio(Boolean flagRecebeBeneficio) {
        this.flagRecebeBeneficio = flagRecebeBeneficio;
    }

    public Boolean getFlagReferenciaFamiliar() {
        return flagReferenciaFamiliar;
    }
    public void setFlagReferenciaFamiliar(Boolean flagReferenciaFamiliar) {
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

    public Boolean getFlagAcompanhadoInstituicao() {
        return flagAcompanhadoInstituicao;
    }
    public void setFlagAcompanhadoInstituicao(Boolean flagAcompanhadoInstituicao) {
        this.flagAcompanhadoInstituicao = flagAcompanhadoInstituicao;
    }

    public String getQualInstituicao() {
        return qualInstituicao;
    }
    public void setQualInstituicao(String qualInstituicao) {
        this.qualInstituicao = qualInstituicao;
    }

    public Boolean getFlagVisitaFamiliar() {
        return flagVisitaFamiliar;
    }
    public void setFlagVisitaFamiliar(Boolean flagVisitaFamiliar) {
        this.flagVisitaFamiliar = flagVisitaFamiliar;
    }

    public Integer getGrauParentesco() {
        return grauParentesco;
    }
    public void setGrauParentesco(Integer grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Boolean getFlagAcessoHigienePessoal() {
        return flagAcessoHigienePessoal;
    }
    public void setFlagAcessoHigienePessoal(Boolean flagAcessoHigienePessoal) {
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
