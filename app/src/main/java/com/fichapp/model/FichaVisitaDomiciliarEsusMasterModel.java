package com.fichapp.model;

import java.util.List;

@SuppressWarnings("serial")
public class FichaVisitaDomiciliarEsusMasterModel extends FichaImportacaoEsusModel {

	private Long id;

	private String uuid;

	private List<FichaVisitaDomiciliarEsusChildModel> visitas;

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

	public List<FichaVisitaDomiciliarEsusChildModel> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<FichaVisitaDomiciliarEsusChildModel> visitas) {
		this.visitas = visitas;
	}

}
