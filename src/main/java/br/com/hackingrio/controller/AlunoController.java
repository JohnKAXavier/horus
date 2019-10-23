package br.com.hackingrio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hackingrio.domain.Aluno;
import br.com.hackingrio.service.AlunoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("aluno/cadastro");
		mv.addObject("aluno", new Aluno());
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("aluno/lista");
		mv.addObject("aluno", alunoService.searchAll());
		return mv;
	}	


	@PostMapping("/salvar")
	public String salvar(Aluno aluno, RedirectAttributes attr) {
		alunoService.save(aluno);
		attr.addFlashAttribute("sucess", "Aluno Inserido com sucesso.");
		return "redirect:/aluno/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) throws ObjectNotFoundException {
     model.addAttribute("aluno", alunoService.search(id));
		return "redirect:/aluno/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(Aluno aluno) throws ObjectNotFoundException {
		alunoService.edit(aluno);
		return "redirect:/aluno/cadastrar";
	}	

	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Integer cliente_id, RedirectAttributes attr) {
		alunoService.delete(cliente_id);
		attr.addFlashAttribute("Sucess", "Aluno Excluido da base.");
		return "redirect:/aluno/listar";
	}	
	
	
	/*
	 * @PostMapping("/salvar") public String salvarCliente(Cliente cliente) {
	 * clienteService.save(cliente); return "redirect:/cliente/cadastrar"; }
	 */

	/*
	 * @GetMapping("/deletar/{cliente_id}") public ModelAndView
	 * deletar(@PathVariable("cliente_id") Integer cliente_id) {
	 * clienteService.delete(cliente_id); return listar(); }
	 */

}
