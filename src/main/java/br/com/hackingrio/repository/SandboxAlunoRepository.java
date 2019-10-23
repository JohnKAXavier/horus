package br.com.hackingrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackingrio.domain.SandboxAluno;

public interface SandboxAlunoRepository extends JpaRepository<SandboxAluno, Integer> {
	List<SandboxAluno> findByDataEvasaoIsNotNull();
}
