package br.com.hackingrio.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SandboxAluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String idAluno;
	
	private String situacao;
	public String getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(String idAluno) {
		this.idAluno = idAluno;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Date dataEvasao;
	private String unidadeEnsino;
	private String habilitacao;
	private String turno;
	private String modalidade;
	private Double qtdPeriodosCursados;
	private String formacao;
	private Double idade;
	private String sexo;
	private String bairro;
	private Double cep;
	private Double cepUnidade;
	private String turma;
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Integer getId() {
		return id;
	}
	public Double getCep() {
		return cep;
	}
	public void setCep(Double cep) {
		this.cep = cep;
	}
	public Double getCepUnidade() {
		return cepUnidade;
	}
	public void setCepUnidade(Double cepUnidade) {
		this.cepUnidade = cepUnidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataEvasao() {
		return dataEvasao;
	}
	public void setDataEvasao(Date string) {
		this.dataEvasao = string;
	}
	public String getUnidadeEnsino() {
		return unidadeEnsino;
	}
	public void setUnidadeEnsino(String unidadeEnsino) {
		this.unidadeEnsino = unidadeEnsino;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public Double getQtdPeriodosCursados() {
		return qtdPeriodosCursados;
	}
	public void setQtdPeriodosCursados(Double qtdPeriodosCursados) {
		this.qtdPeriodosCursados = qtdPeriodosCursados;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public Double getIdade() {
		return idade;
	}
	public void setIdade(Double idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
