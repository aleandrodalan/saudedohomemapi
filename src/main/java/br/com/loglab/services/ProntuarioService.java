package br.com.loglab.services;

import java.util.List;

import br.com.loglab.models.Prontuario;

public interface ProntuarioService {

	void salvar(Prontuario prontuario);
	
	void alterar(Prontuario prontuario);
	
	void excluir(Long id);
	
	List<Prontuario> buscarTodosProntuarios();
	
	Prontuario buscarProntuarioPorId(Long id);
	
	List<Prontuario> buscarProntuariosPorNomePaciente(String nome);
	
	Boolean verificarPorIdSeExistePaciente(Long id);
	
	Boolean verificarPorIdSeExisteUnidadeSaude(Long id);
}