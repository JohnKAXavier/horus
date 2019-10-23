package br.com.hackingrio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.hackingrio.domain.Indicador;
import br.com.hackingrio.service.AlunoService;
import br.com.hackingrio.service.IndicadorService;
import br.com.hackingrio.vo.IndicadorVO;

@Controller
public class HomeController {
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	IndicadorService indicadorService;
	
	@GetMapping("/")
	public ModelAndView listaHomer() {
		ModelAndView mv = new ModelAndView("/home");
	
		List<IndicadorVO> indicadores = new ArrayList<IndicadorVO>();
		
		for (Indicador indicador: indicadorService.buscarIndicadores()) {
			indicadores.add(new IndicadorVO(indicador.getSeveridade() , indicador.getPercentualPreenchimento()));
		};
		
		mv.addObject("indicadores", indicadores);
		
		return mv;
	}	
	
	@GetMapping("/indicadores")
	public Model buscarIndicadores(String unidade, String modalidade, String Cusro, 
			String turno, String disciplina, Model model) {
		
		return model;
	}

}
	