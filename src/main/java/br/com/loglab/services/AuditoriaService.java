package br.com.loglab.services;

import br.com.loglab.enums.OperacaoEnum;

public interface AuditoriaService {

	void salvarLog(Object o, OperacaoEnum operacao);
}