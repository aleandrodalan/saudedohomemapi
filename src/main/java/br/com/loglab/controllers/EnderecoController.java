package br.com.loglab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.loglab.models.Endereco;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("{cep}")
	public Endereco buscarEnderecoPorCep(@PathVariable String cep) {
		cep = cep.replace(".", "").replace("-", "");
		String uri = "https://viacep.com.br/ws/" + cep + "/json/";
		Endereco endereco = rest.getForObject(uri, Endereco.class);

		endereco.setCep(formatCep(cep));
		
		return endereco;
	}
	
	private String formatCep(String cep) {
		StringBuilder sb = new StringBuilder(cep);
        sb = sb.insert(2,".").insert(6, "-");

		return sb.toString();
	}
}
