
package br.com.hackingrio.vo;

import java.io.Serializable;

public class IndicadorVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Severidade severiadade;
	private Integer percentualPreenchimento;

	public IndicadorVO(Severidade severidade, Integer percentualPreenchimento) {
		this.severiadade = severidade;
		this.percentualPreenchimento = percentualPreenchimento;
	}

	public Severidade getSeveriadade() {
		return severiadade;
	}

	public void setSeveriadade(Severidade severiadade) {
		this.severiadade = severiadade;
	}

	public Integer getPercentualPreenchimento() {
		return percentualPreenchimento;
	}

	public void setPercentualPreenchimento(Integer percentualPreenchimento) {
		this.percentualPreenchimento = percentualPreenchimento;
	}
}
