package br.com.project.horus.enums;

public enum Turno {

	MANHA("Manhã"), TARDE("tarde"), NOITE("Noite"), VIRTUAL("Virtual");

	private String descricao;

	Turno (String descrição) {
		this.descricao = descrição;
	}

	public String getDescrição() {
		return descricao;
	}

}
