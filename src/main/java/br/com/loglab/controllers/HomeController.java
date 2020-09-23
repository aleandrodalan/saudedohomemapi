package br.com.loglab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "layout";
	}

	@GetMapping("/lista-usuarios")
	public String listarUsuarios() {
		return "lista-usuarios";
	}
	
	@GetMapping("/dados-acesso")
	public String relatorioAcessos() {
		return "dados-acesso";
	}
}