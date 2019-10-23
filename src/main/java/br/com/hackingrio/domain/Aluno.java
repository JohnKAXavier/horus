package br.com.hackingrio.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAluno;
	private String nomeCompleto;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private DadosFinanceiros dadosFinanceiros;
	private DadosAcademicos dadosAcademicos;

	public Aluno() {
	}

	public Aluno(Integer idAluno, String nomeCompleto, String cpf, String rg, Endereco endereco,
			DadosFinanceiros dadosFinanceiros, DadosAcademicos dadosAcademicos) {
		this.idAluno = idAluno;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.dadosFinanceiros = dadosFinanceiros;
		this.dadosAcademicos = dadosAcademicos;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", rg=" + rg
				+ ", endereco=" + endereco + ", dadosFinanceiros=" + dadosFinanceiros + ", dadosAcademicos="
				+ dadosAcademicos + "]";
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public DadosFinanceiros getDadosFinanceiros() {
		return dadosFinanceiros;
	}

	public void setDadosFinanceiros(DadosFinanceiros dadosFinanceiros) {
		this.dadosFinanceiros = dadosFinanceiros;
	}

	public DadosAcademicos getDadosAcademicos() {
		return dadosAcademicos;
	}

	public void setDadosAcademicos(DadosAcademicos dadosAcademicos) {
		this.dadosAcademicos = dadosAcademicos;
	}

}
