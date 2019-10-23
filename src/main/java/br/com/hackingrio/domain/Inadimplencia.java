package br.com.hackingrio.domain;

public class Inadimplencia {

	private Integer id;
	private Integer período;
	private Integer qtdInadimplencias;
	private Double valorInadimplencia;

	public Inadimplencia() {

	}

	public Inadimplencia(Integer id, Integer período, Integer qtdInadimplencias, Double valorInadimplencia) {
		this.id = id;
		this.período = período;
		this.qtdInadimplencias = qtdInadimplencias;
		this.valorInadimplencia = valorInadimplencia;
	}

	@Override
	public String toString() {
		return "Inadimplencia [id=" + id + ", período=" + período + ", qtdInadimplencias=" + qtdInadimplencias
				+ ", valorInadimplencia=" + valorInadimplencia + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPeríodo() {
		return período;
	}

	public void setPeríodo(Integer período) {
		this.período = período;
	}

	public Integer getQtdInadimplencias() {
		return qtdInadimplencias;
	}

	public void setQtdInadimplencias(Integer qtdInadimplencias) {
		this.qtdInadimplencias = qtdInadimplencias;
	}

	public Double getValorInadimplencia() {
		return valorInadimplencia;
	}

	public void setValorInadimplencia(Double valorInadimplencia) {
		this.valorInadimplencia = valorInadimplencia;
	}

}
