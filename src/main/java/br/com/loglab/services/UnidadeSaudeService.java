package br.com.loglab.services;

import java.util.List;

import br.com.loglab.models.UnidadeSaude;
import net.sf.jasperreports.engine.JRException;

public interface UnidadeSaudeService {

	void salvar(UnidadeSaude unidadeSaude);
	
	void editar(UnidadeSaude unidadeSaude);
	
	List<UnidadeSaude> buscarTodos();
	
	UnidadeSaude buscarPorId(Long id);
	
	void excluir(Long id);
	
	List<UnidadeSaude> buscarPorNome(String nome);
	
	String exportarRelatorioParaPdf(final List<UnidadeSaude> unidades) throws JRException;
}