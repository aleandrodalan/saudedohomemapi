package br.com.loglab.exception;

@SuppressWarnings("serial")
public class SenhaInvalidaException extends RuntimeException {
	
	public SenhaInvalidaException() {
		super("Senha inválida");
	}
}