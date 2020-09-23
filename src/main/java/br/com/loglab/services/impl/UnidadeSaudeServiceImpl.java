package br.com.loglab.services.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.loglab.enums.OperacaoEnum;
import br.com.loglab.exception.RegraNegocioException;
import br.com.loglab.models.UnidadeSaude;
import br.com.loglab.repositories.UnidadeSaudeRepository;
import br.com.loglab.services.AuditoriaService;
import br.com.loglab.services.ProntuarioService;
import br.com.loglab.services.UnidadeSaudeService;
import net.sf.jasperreports.engine.JRException;

@Service
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
	
	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;
	
	@Autowired
	private ProntuarioService prontuarioService;
	
	@Autowired
	private AuditoriaService auditoriaService;

	@Autowired
	private JasperReportsServiceImpl jrService;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	public void salvar(UnidadeSaude unidadeSaude) {
		if (verificarUnidadeSaudeExiste(unidadeSaude, OperacaoEnum.INCLUSAO.name())) {
			throw new RegraNegocioException("Unidade de Saúde já está cadastrada");
		}
		
		unidadeSaudeRepository.save(unidadeSaude);
		auditoriaService.salvarLog(unidadeSaude, OperacaoEnum.INCLUSAO);
	}
	
	public void editar(UnidadeSaude unidadeSaude) {
		try {
			if (verificarUnidadeSaudeExiste(unidadeSaude, OperacaoEnum.ALTERACAO.name())) {
				throw new RegraNegocioException("Unidade de Saúde já está cadastrada");
			}
			
			unidadeSaudeRepository.save(unidadeSaude);
		} catch(Exception e) {
			throw new RegraNegocioException("Não foi possível editar unidade de saúde.");
		}

		auditoriaService.salvarLog(unidadeSaude, OperacaoEnum.ALTERACAO);			
	}
	
	public List<UnidadeSaude> buscarTodos() {
		return unidadeSaudeRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public UnidadeSaude buscarPorId(Long id) {
		return unidadeSaudeRepository.findById(id).get();
	}
	
	public void excluir(Long id) {
		if (prontuarioService.verificarPorIdSeExisteUnidadeSaude(id)) {
			throw new RegraNegocioException("Não é possível excluir Unidade de Saúde que esteja cadastrada em um ou mais prontuários.");
		}
		
		auditoriaService.salvarLog(unidadeSaudeRepository.findById(id), OperacaoEnum.EXCLUSAO);
		
		unidadeSaudeRepository.deleteById(id);
	}
	
	public List<UnidadeSaude> buscarPorNome(String nome) {
		return unidadeSaudeRepository.findByNomeIgnoreCaseContainingOrderByNome(nome);
	}

	private Boolean verificarUnidadeSaudeExiste(UnidadeSaude unidadeSaude, String operacao) {
		boolean resultado = false;
		
		int quantidadeUnidade = unidadeSaudeRepository
									.findByQuantUnidadeSaudeExistComMesmoNome(
											unidadeSaude.getNome(), 
											unidadeSaude.getEndereco().getCidade(),
											unidadeSaude.getEndereco().getUf())
									.size();
		
		if (operacao == OperacaoEnum.ALTERACAO.name()) {
			resultado = quantidadeUnidade > 1;
		} else {
			if (operacao == OperacaoEnum.INCLUSAO.name()) {
				resultado = quantidadeUnidade > 0;
			}
		}
		
		return resultado;
	}
	
	@Override
	public String exportarRelatorioParaPdf(List<UnidadeSaude> unidades) throws JRException {
		String nomeArquivo = "/unidades_saude.jrxml";
		File pathArquivo = new File("src/main/resources/relatorio");
		
		jrService.openReportByJasper(pathArquivo.getPath() + nomeArquivo, unidades);
		return pathArquivo.getPath() + "/prints/";
	}
}