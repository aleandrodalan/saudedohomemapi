package br.com.loglab.services.impl;

import java.net.InetAddress;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.loglab.enums.OperacaoEnum;
import br.com.loglab.models.Auditoria;
import br.com.loglab.repositories.AuditoriaRepository;
import br.com.loglab.services.AuditoriaService;
import br.com.loglab.services.UsuarioService;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

	@Autowired
	private AuditoriaRepository logRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	private String getUsernameLogado() {
		String username = "";
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		return username;
	}
	
	public void salvarLog(Object o, OperacaoEnum operacao) {
		Auditoria auditoria = new Auditoria();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonString =	mapper.writeValueAsString(o);
			
			auditoria.setLoginUsuario(getUsernameLogado());
			auditoria.setNomeUsuario(usuarioService.buscarExatoUsuarioPorLogin(getUsernameLogado()).getPessoa().getNome());
			auditoria.setDataAcesso(LocalDateTime.now());
			auditoria.setComputador(InetAddress.getLocalHost().getHostName());
			auditoria.setIp(InetAddress.getLocalHost().getHostAddress());
			auditoria.setOperacao(operacao);
			auditoria.setClasse(o.getClass().getName());
			auditoria.setJson(jsonString);

			salvar(auditoria);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void salvar(Auditoria auditoria) {
		logRepository.save(auditoria);
	}
}