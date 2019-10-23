package br.com.hackingrio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TurmaController {
	
	@GetMapping("/turmas")
	public String turmas() {
		return "/turmas";
	}
	
	
	
	 

}


