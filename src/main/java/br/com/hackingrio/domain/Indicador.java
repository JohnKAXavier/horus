package br.com.hackingrio.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.hackingrio.vo.Severidade;

@Entity
public class Indicador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Severidade severidade;
	
	private Integer percentualPreenchimento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Severidade getSeveridade() {
		return severidade;
	}
	public void setSeveridade(Severidade severidade) {
		this.severidade = severidade;
	}
	public Integer getPercentualPreenchimento() {
		return percentualPreenchimento;
	}
	public void setPercentualPreenchimento(Integer percentualPreenchimento) {
		this.percentualPreenchimento = percentualPreenchimento;
	}

}
