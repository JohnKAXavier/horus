package br.com.hackingrio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackingrio.repository.UsuarioRepository;

@Service
public class UsuarioService  {

	@Autowired
	UsuarioRepository usuarioRepository;
	
}
