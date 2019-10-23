package br.com.hackingrio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackingrio.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
