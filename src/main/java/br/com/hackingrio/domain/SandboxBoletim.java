package br.com.hackingrio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SandboxBoletim {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String idAluno;
	private String periodoLetivo;
	private String labelDisciplina;
	private String disciplina;
	private Boolean p1;
	private Boolean p2;
	private Boolean p3;
	private String notaP1;
	private String notaP2;
	private String notaP3;
	private String media;
	private String faltas;
	private String situacao;
	
	public String getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(String idAluno) {
		this.idAluno = idAluno;
	}

	public String getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(String periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public String getLabelDisciplina() {
		return labelDisciplina;
	}

	public void setLabelDisciplina(String labelDisciplina) {
		this.labelDisciplina = labelDisciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Boolean getP1() {
		return p1;
	}

	public void setP1(Boolean p1) {
		this.p1 = p1;
	}

	public Boolean getP2() {
		return p2;
	}

	public void setP2(Boolean p2) {
		this.p2 = p2;
	}

	public Boolean getP3() {
		return p3;
	}

	public void setP3(Boolean p3) {
		this.p3 = p3;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getFaltas() {
		return faltas;
	}

	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNotaP1() {
		return notaP1;
	}

	public void setNotaP1(String notaP1) {
		this.notaP1 = notaP1;
	}

	public String getNotaP2() {
		return notaP2;
	}

	public void setNotaP2(String notaP2) {
		this.notaP2 = notaP2;
	}

	public String getNotaP3() {
		return notaP3;
	}

	public void setNotaP3(String notaP3) {
		this.notaP3 = notaP3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
