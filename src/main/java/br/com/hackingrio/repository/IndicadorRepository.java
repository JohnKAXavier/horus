package br.com.hackingrio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackingrio.domain.Indicador;

public interface IndicadorRepository extends JpaRepository<Indicador, Integer>{

}
