package br.com.hackingrio.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackingrio.domain.SandboxAluno;
import br.com.hackingrio.domain.SandboxBoletim;
import br.com.hackingrio.domain.SandboxFinanceiro;
import br.com.hackingrio.repository.SandboxAlunoRepository;
import br.com.hackingrio.repository.SandboxBoletimRepository;
import br.com.hackingrio.repository.SandboxFinanceiroRepository;

@Service
public class EtlBaseEvasaoService {

    private static final int POS_CELL_ID_ALUNO = 0;
    private static final int POS_CELL_SITUACAO_ALUNO = 1;
    private static final int POS_CELL_DATA_EVASAO_ALUNO = 2;
    private static final int POS_CELL_UNIDADE_ALUNO = 3;
    private static final int POS_CELL_HABILITACAO_ALUNO = 4;
    private static final int POS_CELL_TURNO_ALUNO = 5;
    private static final int POS_CELL_MODALIDADE_HABILITACAO_ALUNO = 6;
    private static final int POS_CELL_PERIODOS_CURSADOS_ALUNO = 7;
    private static final int POS_CELL_ORIGEM_FORMACAO_ALUNO = 8;
    private static final int POS_CELL_IDADE_ALUNO = 9;
    private static final int POS_CELL_SEXO_ALUNO = 10;
    private static final int POS_CELL_BAIRRO_ALUNO = 11;
    private static final int POS_CELL_CEP_ALUNO = 12;
    private static final int POS_CELL_CEP_UNIDADE_ALUNO = 13;

    private static final int POS_CELL_ID_ALUNO_BOLETIM = 0;
	private static final int POS_CELL_PERIODO_LETIVO_BOLETIM = 1;
	private static final int POS_CELL_LABEL_DISCIPLINA_ALUNO = 2;
	private static final int POS_CELL_DISCIPLINA_ALUNO = 3;
	private static final int POS_CELL_P1 = 4;
	private static final int POS_CELL_P2 = 5;
	private static final int POS_CELL_P3 = 6;
	private static final int POS_CELL_NOTA_P1 = 7;
	private static final int POS_CELL_NOTA_P2 = 8;
	private static final int POS_CELL_NOTA_P3 = 9;
	private static final int POS_CELL_MEDIA = 10;
	private static final int POS_CELL_FALTAS = 11;
	private static final int POS_CELL_SITUACAO = 12;

	private static final int POS_CELL_ID_ALUNO_FINANCEIRO = 0;
	private static final int POS_CELL_MES_REFERENCIA_FINANCEIRO = 1;
	private static final int POS_CELL_VENCIMENTO_FINANCEIRO = 2;
	private static final int POS_CELL_PAGAMENTO_FINANCEIRO = 3;
    
    @Autowired
	private SandboxAlunoRepository sandboxAlunoRepository;
    
	@Autowired
	private SandboxBoletimRepository sandboxBoletimRepository;

	@Autowired
	private SandboxFinanceiroRepository sandboxFinanceiroRepository;
	
	@Autowired
	private ScoringService scoringService;

	public void importarDadosEvasao(String pathArquivo) {
    	try {
            FileInputStream excelFile = new FileInputStream(new File(pathArquivo));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Row currentRow;
            
            Sheet sheetDadosAluno = workbook.getSheetAt(0);
            Iterator<Row> iteratorAluno = sheetDadosAluno.iterator();

            Sheet sheetDadosFinanceiro = workbook.getSheetAt(1);
            Iterator<Row> iteratorFinanceiro = sheetDadosFinanceiro.iterator();

            Sheet sheetDadosBoletim = workbook.getSheetAt(2);
            Iterator<Row> iteratorBoletim = sheetDadosBoletim.iterator();

            currentRow = iteratorAluno.next();
            importarDadosAluno(iteratorAluno, currentRow);

            currentRow = iteratorFinanceiro.next();
            importarDadosFinanceiro(iteratorFinanceiro, currentRow);

            currentRow = iteratorBoletim.next();
            importarDadosBoletim(iteratorBoletim, currentRow);

            workbook.close();
            
            calcularScoring();

    	} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	private void calcularScoring() {
		scoringService.identificarEvasor();
	}

	private void importarDadosFinanceiro(Iterator<Row> iterator, Row currentRow) {
		currentRow = iterator.next();
		
		while (iterator.hasNext()) {
			try {
			    SandboxFinanceiro sandbox = new SandboxFinanceiro();
			    sandbox.setIdAluno(currentRow.getCell(POS_CELL_ID_ALUNO_FINANCEIRO).getStringCellValue());
			    sandbox.setMesReferencia((currentRow.getCell(POS_CELL_MES_REFERENCIA_FINANCEIRO).getStringCellValue()));
			    sandbox.setVencimento((currentRow.getCell(POS_CELL_VENCIMENTO_FINANCEIRO).getDateCellValue()));
			    sandbox.setPagamento((currentRow.getCell(POS_CELL_PAGAMENTO_FINANCEIRO).getDateCellValue()));
			    sandboxFinanceiroRepository.save(sandbox);
			    
			    currentRow = iterator.next();
		    } catch (Exception e) {
		    	continue;
		    }
		}
	}

	private void importarDadosBoletim(Iterator<Row> iterator, Row currentRow) {
		currentRow = iterator.next();
		
		while (iterator.hasNext()) {
		    try {
				    SandboxBoletim sandbox = new SandboxBoletim();
				    sandbox.setIdAluno(currentRow.getCell(POS_CELL_ID_ALUNO_BOLETIM).getStringCellValue());
				    sandbox.setPeriodoLetivo((currentRow.getCell(POS_CELL_PERIODO_LETIVO_BOLETIM).getStringCellValue()));
				    sandbox.setLabelDisciplina((currentRow.getCell(POS_CELL_LABEL_DISCIPLINA_ALUNO).getStringCellValue()));
				    sandbox.setDisciplina((currentRow.getCell(POS_CELL_DISCIPLINA_ALUNO).getStringCellValue()));
				    sandbox.setP1((currentRow.getCell(POS_CELL_P1).getBooleanCellValue()));
				    sandbox.setP2((currentRow.getCell(POS_CELL_P2).getBooleanCellValue()));
				    sandbox.setP3((currentRow.getCell(POS_CELL_P3).getBooleanCellValue()));
				    sandbox.setNotaP1((currentRow.getCell(POS_CELL_NOTA_P1).getStringCellValue()));
				    sandbox.setNotaP2((currentRow.getCell(POS_CELL_NOTA_P2).getStringCellValue()));
				    sandbox.setNotaP3((currentRow.getCell(POS_CELL_NOTA_P3).getStringCellValue()));
				    sandbox.setMedia((currentRow.getCell(POS_CELL_MEDIA).getStringCellValue()));
				    sandbox.setMedia((currentRow.getCell(POS_CELL_FALTAS).getStringCellValue()));
				    sandbox.setMedia((currentRow.getCell(POS_CELL_SITUACAO).getStringCellValue()));
				    sandboxBoletimRepository.save(sandbox);
				    
				    currentRow = iterator.next();
		    } catch (Exception e) {
		    	continue;
		    }
		}
	}

	private void importarDadosAluno(Iterator<Row> iterator, Row currentRow) {
        currentRow = iterator.next();

		while (iterator.hasNext()) {
		    try {
				SandboxAluno sandbox = new SandboxAluno();
			    sandbox.setIdAluno(currentRow.getCell(POS_CELL_ID_ALUNO).getStringCellValue());
			    sandbox.setSituacao(currentRow.getCell(POS_CELL_SITUACAO_ALUNO).getStringCellValue());
		        try {
		        	sandbox.setDataEvasao(currentRow.getCell(POS_CELL_DATA_EVASAO_ALUNO).getDateCellValue());
		        } catch (Exception e) {}
			    sandbox.setUnidadeEnsino(currentRow.getCell(POS_CELL_UNIDADE_ALUNO).getStringCellValue());
			    sandbox.setHabilitacao(currentRow.getCell(POS_CELL_HABILITACAO_ALUNO).getStringCellValue());
			    sandbox.setTurno(currentRow.getCell(POS_CELL_TURNO_ALUNO).getStringCellValue());
			    sandbox.setModalidade(currentRow.getCell(POS_CELL_MODALIDADE_HABILITACAO_ALUNO).getStringCellValue());
			    sandbox.setQtdPeriodosCursados(currentRow.getCell(POS_CELL_PERIODOS_CURSADOS_ALUNO).getNumericCellValue());
			    sandbox.setFormacao(currentRow.getCell(POS_CELL_ORIGEM_FORMACAO_ALUNO).getStringCellValue());
			    sandbox.setIdade(currentRow.getCell(POS_CELL_IDADE_ALUNO).getNumericCellValue());
			    sandbox.setSexo(currentRow.getCell(POS_CELL_SEXO_ALUNO).getStringCellValue());
			    sandbox.setBairro(currentRow.getCell(POS_CELL_BAIRRO_ALUNO).getStringCellValue());
			    sandbox.setCep(currentRow.getCell(POS_CELL_CEP_ALUNO).getNumericCellValue());
			    sandbox.setCepUnidade(currentRow.getCell(POS_CELL_CEP_UNIDADE_ALUNO).getNumericCellValue());
			    sandboxAlunoRepository.save(sandbox);
			    
			    currentRow = iterator.next();
		    } catch (Exception e) {
		    	continue;
		    }
		}
	}	
}
