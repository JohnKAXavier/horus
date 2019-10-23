package br.com.hackingrio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackingrio.domain.Indicador;
import br.com.hackingrio.domain.SandboxAluno;
import br.com.hackingrio.domain.SandboxBoletim;
import br.com.hackingrio.domain.SandboxFinanceiro;
import br.com.hackingrio.repository.IndicadorRepository;
import br.com.hackingrio.repository.SandboxAlunoRepository;
import br.com.hackingrio.repository.SandboxBoletimRepository;
import br.com.hackingrio.repository.SandboxFinanceiroRepository;
import br.com.hackingrio.vo.Severidade;

@Service
public class ScoringService {

	@Autowired
	SandboxAlunoRepository sandboxAlunoRepository;
	
	@Autowired
	SandboxFinanceiroRepository sandboxFinanceiroRepository;

	@Autowired
	SandboxBoletimRepository sandboxBoletimRepository;
	
	@Autowired
	IndicadorRepository indicadorRepository;

	public void identificarEvasor() {
		List<SandboxAluno> evasores = new ArrayList<SandboxAluno>();
		evasores = sandboxAlunoRepository.findByDataEvasaoIsNotNull();
		
		List<SandboxFinanceiro> inadimplentesCriticos = new ArrayList<SandboxFinanceiro>();
		inadimplentesCriticos = sandboxFinanceiroRepository.findByPagamentoIsNull();
		
		List<SandboxBoletim> ausentesCriticos = new ArrayList<SandboxBoletim>();
		ausentesCriticos = sandboxBoletimRepository.findByFaltasGreaterThan("10");
		
		List<SandboxBoletim> ausentes = new ArrayList<SandboxBoletim>();
		ausentesCriticos = sandboxBoletimRepository.findByFaltasBetween("10", "19.9");

		List<SandboxBoletim> ineficientesCriticos = new ArrayList<SandboxBoletim>();
		ineficientesCriticos = sandboxBoletimRepository.findByMediaLessThan("6");

		List<SandboxBoletim> ineficientes = new ArrayList<SandboxBoletim>();
		ineficientesCriticos = sandboxBoletimRepository.findByMediaBetween("6", "7.9");
		
		List<SandboxAluno> todos = sandboxAlunoRepository.findAll();

		int totalAlunos = todos.size();
		Map<String, Boolean> evazoresCriticos = totalizarEvasoresRiscoCritico(todos, evasores, inadimplentesCriticos, ausentesCriticos, ineficientesCriticos);
		Map<String, Boolean> evazoresMedios = totalizarEvasoresRiscoMedio(todos, ausentes, ineficientes);

		armazenaIndicadores(totalAlunos, evazoresCriticos, evazoresMedios);		
		
		System.out.println(evasores);
		System.out.println(inadimplentesCriticos);
		System.out.println(ausentesCriticos);
		System.out.println(ineficientesCriticos);
	}
	
	private void armazenaIndicadores(int totalAlunos, Map<String, Boolean> evazoresCriticos,
			Map<String, Boolean> evazoresMedios) {
		
		Indicador indicadorCritico = new Indicador();
		indicadorCritico.setSeveridade(Severidade.VERMELHO);
		indicadorCritico.setPercentualPreenchimento(evazoresCriticos.size() % totalAlunos);
		indicadorRepository.save(indicadorCritico);

		Indicador indicadorMedio = new Indicador();
		indicadorMedio.setSeveridade(Severidade.AMARELO);
		indicadorMedio.setPercentualPreenchimento(evazoresMedios.size() % totalAlunos);
		indicadorRepository.save(indicadorMedio);

		Indicador indicadorNormal = new Indicador();
		indicadorNormal.setSeveridade(Severidade.AMARELO);
		indicadorNormal.setPercentualPreenchimento((totalAlunos - evazoresMedios.size()) % totalAlunos);
		indicadorRepository.save(indicadorNormal);
	}

	private Map<String, Boolean> totalizarEvasoresRiscoMedio(List<SandboxAluno> todos, List<SandboxBoletim> ausentes, List<SandboxBoletim> ineficientes) {
		List<SandboxAluno> todosAlunos = sandboxAlunoRepository.findAll();
		Map<String, Boolean> totalEvasoresRiscoMedio = new HashMap<String, Boolean>();
		
		for (SandboxAluno aluno: todosAlunos) {
			totalEvasoresRiscoMedio.put(aluno.getIdAluno(), false);
		}
		
		for (SandboxBoletim ausente: ausentes) {
			totalEvasoresRiscoMedio.put(ausente.getIdAluno(), true);
		}
		
		for (SandboxBoletim ineficiente: ineficientes) {
			totalEvasoresRiscoMedio.put(ineficiente.getIdAluno(), true);
		}
		
		return totalEvasoresRiscoMedio;
	}

	private Map<String, Boolean> totalizarEvasoresRiscoCritico(List<SandboxAluno> todos, List<SandboxAluno> evasores, List<SandboxFinanceiro> inadimplentes,
			List<SandboxBoletim> ausentesCriticos, List<SandboxBoletim> ineficientesCriticos) {

		Map<String, Boolean> totalEvasoresRiscoMaximo = new HashMap<String, Boolean>();
		
		for (SandboxAluno aluno: todos) {
			totalEvasoresRiscoMaximo.put(aluno.getIdAluno(), false);
		}
		
		for (SandboxAluno evasor: evasores) {
			totalEvasoresRiscoMaximo.put(evasor.getIdAluno(), true);
		}
		
		for (SandboxBoletim ausente: ausentesCriticos) {
			totalEvasoresRiscoMaximo.put(ausente.getIdAluno(), true);
		}
		
		for (SandboxBoletim ineficiente: ineficientesCriticos) {
			totalEvasoresRiscoMaximo.put(ineficiente.getIdAluno(), true);
		}
		
		return totalEvasoresRiscoMaximo;
	}

	public void calcularScoreDificuldadeResolucao() {
	}
	
	
}
