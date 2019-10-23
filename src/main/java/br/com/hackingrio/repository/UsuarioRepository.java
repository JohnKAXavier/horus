package br.com.hackingrio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hackingrio.domain.Login;

@Repository
public interface UsuarioRepository extends JpaRepository<Login, Integer>  {

}
