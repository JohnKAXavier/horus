package br.com.hackingrio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DadosFinanceiros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDadosFinanceiros;
	private String valorMensalidade;
	private Double valorTotalPago;
	private Double valoraPagar;
	private boolean Empregado;
	private boolean dependenteFinanceiro;
	private RendaFamiliar rendaFamiliar;

	public DadosFinanceiros() {
	}

	public DadosFinanceiros(Integer idDadosFinanceiros, String valorMensalidade, Double valorTotalPago,
			Double valoraPagar, boolean empregado, boolean dependenteFinanceiro, RendaFamiliar rendaFamiliar) {
		this.idDadosFinanceiros = idDadosFinanceiros;
		this.valorMensalidade = valorMensalidade;
		this.valorTotalPago = valorTotalPago;
		this.valoraPagar = valoraPagar;
		Empregado = empregado;
		this.dependenteFinanceiro = dependenteFinanceiro;
		this.rendaFamiliar = rendaFamiliar;
	}

	@Override
	public String toString() {
		return "DadosFinanceiros [idDadosFinanceiros=" + idDadosFinanceiros + ", valorMensalidade=" + valorMensalidade
				+ ", valorTotalPago=" + valorTotalPago + ", valoraPagar=" + valoraPagar + ", Empregado=" + Empregado
				+ ", dependenteFinanceiro=" + dependenteFinanceiro + ", rendaFamiliar=" + rendaFamiliar + "]";
	}

	public Integer getIdDadosFinanceiros() {
		return idDadosFinanceiros;
	}

	public void setIdDadosFinanceiros(Integer idDadosFinanceiros) {
		this.idDadosFinanceiros = idDadosFinanceiros;
	}

	public String getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(String valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public Double getValorTotalPago() {
		return valorTotalPago;
	}

	public void setValorTotalPago(Double valorTotalPago) {
		this.valorTotalPago = valorTotalPago;
	}

	public Double getValoraPagar() {
		return valoraPagar;
	}

	public void setValoraPagar(Double valoraPagar) {
		this.valoraPagar = valoraPagar;
	}

	public boolean isEmpregado() {
		return Empregado;
	}

	public void setEmpregado(boolean empregado) {
		Empregado = empregado;
	}

	public boolean isDependenteFinanceiro() {
		return dependenteFinanceiro;
	}

	public void setDependenteFinanceiro(boolean dependenteFinanceiro) {
		this.dependenteFinanceiro = dependenteFinanceiro;
	}

	public RendaFamiliar getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(RendaFamiliar rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

}
