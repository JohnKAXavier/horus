package br.com.hackingrio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackingrio.domain.Indicador;
import br.com.hackingrio.repository.IndicadorRepository;

@Service
public class IndicadorService {

	@Autowired
	IndicadorRepository indicadorRepository;
	
	public List<Indicador> buscarIndicadores() {
		return indicadorRepository.findAll();
	};
	
}
