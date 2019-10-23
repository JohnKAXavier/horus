package br.com.project.horus.enums;

public enum Modalidade {

	EAD("EAD"), PRESENCIAL("Presencial"), SEMIPRESENCIAL("Semi-Presencial");
	
	private String descricao;

	Modalidade (String descrição) {
		this.descricao = descrição;
	}

	public String getDescrição() {
		return descricao;
	}
	
	
	
	
	
}
