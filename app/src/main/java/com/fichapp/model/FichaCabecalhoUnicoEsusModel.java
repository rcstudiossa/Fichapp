package com.fichapp.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FichaCabecalhoUnicoEsusModel implements Serializable {

	private String profissionalCNS;
	
	private String cboCodigo2002;
	
	private String cnes;
	
	private String ine;
	
	private Date dataAtendimento;
	
	public String getProfissionalCNS() {
		return profissionalCNS;
	}

	public void setProfissionalCNS(String profissionalCNS) {
		this.profissionalCNS = profissionalCNS;
	}

	public String getCboCodigo2002() {
		return cboCodigo2002;
	}

	public void setCboCodigo2002(String cboCodigo2002) {
		this.cboCodigo2002 = cboCodigo2002;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getIne() {
		return ine;
	}

	public void setIne(String ine) {
		this.ine = ine;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

}
