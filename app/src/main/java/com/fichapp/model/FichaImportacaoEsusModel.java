package com.fichapp.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FichaImportacaoEsusModel implements Serializable {

	private OrigemModel origemModel;

	private FichaCabecalhoUnicoEsusModel fichaCabecalhoEsusModel;

	public OrigemModel getOrigemModel() {
		return origemModel;
	}

	public void setOrigemModel(OrigemModel origemModel) {
		this.origemModel = origemModel;
	}

	public FichaCabecalhoUnicoEsusModel getFichaCabecalhoEsusModel() {
		return fichaCabecalhoEsusModel;
	}

	public void setFichaCabecalhoEsusModel(FichaCabecalhoUnicoEsusModel fichaCabecalhoEsusModel) {
		this.fichaCabecalhoEsusModel = fichaCabecalhoEsusModel;
	}

}
