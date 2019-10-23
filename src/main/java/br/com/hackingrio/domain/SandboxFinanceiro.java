package br.com.hackingrio.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SandboxFinanceiro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String idAluno;
	private String mesReferencia;
	private Date vencimento;
	private Date pagamento;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(String idAluno) {
		this.idAluno = idAluno;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public Date getPagamento() {
		return pagamento;
	}
	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}
	public String getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
}
