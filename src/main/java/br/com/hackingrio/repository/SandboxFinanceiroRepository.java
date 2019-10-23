package br.com.hackingrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackingrio.domain.SandboxFinanceiro;

public interface SandboxFinanceiroRepository extends JpaRepository<SandboxFinanceiro, Integer> {

	List<SandboxFinanceiro> findByPagamentoIsNull();

}
