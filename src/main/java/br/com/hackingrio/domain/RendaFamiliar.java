package br.com.hackingrio.domain;

public class RendaFamiliar {

	private Integer id;
	private Double valorMedio;
	private String fonteRenda;
	private Integer numeroMembros;

	public RendaFamiliar() {
	}

	public RendaFamiliar(Integer id, Double valorMedio, String fonteRenda, Integer numeroMembros) {
		this.id = id;
		this.valorMedio = valorMedio;
		this.fonteRenda = fonteRenda;
		this.numeroMembros = numeroMembros;
	}

	@Override
	public String toString() {
		return "RendaFamiliar [id=" + id + ", valorMedio=" + valorMedio + ", fonteRenda=" + fonteRenda
				+ ", numeroMembros=" + numeroMembros + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorMedio() {
		return valorMedio;
	}

	public void setValorMedio(Double valorMedio) {
		this.valorMedio = valorMedio;
	}

	public String getFonteRenda() {
		return fonteRenda;
	}

	public void setFonteRenda(String fonteRenda) {
		this.fonteRenda = fonteRenda;
	}

	public Integer getNumeroMembros() {
		return numeroMembros;
	}

	public void setNumeroMembros(Integer numeroMembros) {
		this.numeroMembros = numeroMembros;
	}

}
