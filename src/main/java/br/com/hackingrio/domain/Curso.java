package br.com.hackingrio.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.project.horus.enums.Modalidade;
import br.com.project.horus.enums.Turno;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private int duracaoEmMeses;
	private Turno turno;
	private Modalidade modalidade;
	private Collection<Disciplina> disciplinas;
	
	@ManyToMany
	private Aluno aluno;

	public Curso() {
	}

	public Curso(Integer id, String nome, int duracaoEmMeses, Turno turno, Modalidade modalidade,
			Collection<Disciplina> disciplinas, Aluno aluno) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracaoEmMeses = duracaoEmMeses;
		this.turno = turno;
		this.modalidade = modalidade;
		this.disciplinas = disciplinas;
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", duracaoEmMeses=" + duracaoEmMeses + ", turno=" + turno
				+ ", modalidade=" + modalidade + ", disciplinas=" + disciplinas + ", aluno=" + aluno + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracaoEmMeses() {
		return duracaoEmMeses;
	}

	public void setDuracaoEmMeses(int duracaoEmMeses) {
		this.duracaoEmMeses = duracaoEmMeses;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Collection<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
