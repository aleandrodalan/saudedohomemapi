package br.com.loglab.services.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.loglab.enums.OperacaoEnum;
import br.com.loglab.exception.RegraNegocioException;
import br.com.loglab.models.Paciente;
import br.com.loglab.repositories.PacienteRepository;
import br.com.loglab.services.AuditoriaService;
import br.com.loglab.services.PacienteService;
import br.com.loglab.services.ProntuarioService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ProntuarioService prontuarioService;
	
	@Autowired
	private AuditoriaService auditoriaService;
	
	public void salvar(Paciente paciente) {
		if (verificarSeExistePaciente(paciente.getPessoa().getCpf(), OperacaoEnum.INCLUSAO.name())) {
			throw new RegraNegocioException("Paciente com este CPF já está cadastrado");
		}
		
		pacienteRepository.save(paciente);
		auditoriaService.salvarLog(paciente, OperacaoEnum.INCLUSAO);		
	}
	
	public void editar(Paciente paciente) {
		if (verificarSeExistePaciente(paciente.getPessoa().getCpf(), OperacaoEnum.ALTERACAO.name())) {
			throw new RegraNegocioException("Paciente com este CPF já está cadastrado");
		}
		
		try {
			pacienteRepository.save(paciente);
			auditoriaService.salvarLog(paciente, OperacaoEnum.ALTERACAO);			
		} catch(Exception e) {
			throw new RegraNegocioException("Não foi possível editar o Paciente");
		}
	}

	public void excluir(Long id) {
		if (prontuarioService.verificarPorIdSeExistePaciente(id))	
			throw new RegraNegocioException("Não é possível excluir paciente que esteja cadastrado em um ou mais prontuários.");

		auditoriaService.salvarLog(pacienteRepository.findById(id).get(), OperacaoEnum.EXCLUSAO);		
		pacienteRepository.deleteById(id);			
	}
	
	public int calcularIdade(LocalDate data) {
	    LocalDate dataInicio = LocalDate.of(data.getYear(), data.getMonth(), data.getDayOfMonth());
	    LocalDate dataAtual = LocalDate.now();
	    Period periodo = Period.between(dataInicio, dataAtual);
	 
	    return periodo.getYears();
	}
	
	public List<Paciente> buscarTodos() {
		return pacienteRepository.findAll(Sort.by(Sort.Direction.ASC, "pessoa.nome"));
	}
	
	@Override
	public Paciente buscarPorId(Long id) {
		return pacienteRepository
				.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Não foi possível encontrar o paciente.")); 
	}

	@Override
	public List<Paciente> buscarPorNome(String nome) {
		return pacienteRepository.findByPessoaNomeIgnoreCaseContainingOrderByPessoaNome(nome);
	}
	
	private Boolean verificarSeExistePaciente(String cpf, String operacao) {
		boolean resultado = false;
		
		int quantPaciente = pacienteRepository.findSizePacienteByCpf(cpf).size();
		
		if (operacao == OperacaoEnum.ALTERACAO.name()) {
			resultado = quantPaciente > 1;
		} else {
			if (operacao == OperacaoEnum.INCLUSAO.name()) {
				resultado = quantPaciente > 0;
			}
		}
		
		return resultado;
	}
}