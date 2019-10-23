package br.com.hackingrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackingrio.domain.SandboxBoletim;

public interface SandboxBoletimRepository extends JpaRepository<SandboxBoletim, Integer>{
	List<SandboxBoletim> findByFaltasGreaterThan(String faltas);
	List<SandboxBoletim> findByMediaGreaterThan(String string);
	List<SandboxBoletim> findByMediaLessThan(String string);
	List<SandboxBoletim> findByMediaBetween(String string, String string2);
	List<SandboxBoletim> findByFaltasBetween(String string, String string2);
}
