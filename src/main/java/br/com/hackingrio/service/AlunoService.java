package br.com.hackingrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackingrio.domain.Aluno;
import br.com.hackingrio.repository.AlunoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno search(final Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id " + id + ", Tipo!" + Aluno.class.getName()));
	}
	
	
	public List<Aluno> searchAll(){
		return alunoRepository.findAll();
	}
	
	
	public Aluno save (Aluno aluno) {
		return alunoRepository.save(aluno);
	}
		
	public List<Aluno> saveAll(List<Aluno> aluno){
		return alunoRepository.saveAll(aluno);
	}
	
	public Aluno edit(Aluno aluno) throws ObjectNotFoundException {
		Aluno alunoEdit = search(aluno.getId());
		
		alunoEdit.setId(aluno.getId());
		alunoEdit.setNome(aluno.getNome());
	
		
		return save(alunoEdit);
		
	}
	
	
	public void delete(Integer id) {
		alunoRepository.deleteById(id);
	}

}
