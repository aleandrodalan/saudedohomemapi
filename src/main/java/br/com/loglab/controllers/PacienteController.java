package br.com.loglab.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.loglab.models.Paciente;
import br.com.loglab.services.PacienteService;

@Transactional
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Transactional(readOnly = true)	
	@GetMapping
	public List<Paciente> buscarTodos() {
		return pacienteService.buscarTodos();
	}
	
	@Transactional(readOnly = true)	
	@GetMapping("/nome/{nome}")
	public List<Paciente> buscarPorNome(@PathVariable("nome") String nome) {
		return pacienteService.buscarPorNome(nome);
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)	
	public Paciente salvar(@RequestBody @Valid Paciente paciente) {
		System.out.println(paciente);
		
		try {
			pacienteService.salvar(paciente);
		} catch(Exception e) {
			new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		return paciente;
	}
	
	@Transactional(readOnly = true)	
	@GetMapping("{id}")
	public Paciente preEditar(@PathVariable("id") Long id) {
		return pacienteService.buscarPorId(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	public void editar(@PathVariable("id") Long id, @RequestBody @Valid Paciente pacienteAtualizado) {
		Paciente paciente = pacienteService.buscarPorId(id);
		
		try {
			pacienteAtualizado.setId(paciente.getId());
			pacienteService.editar(pacienteAtualizado);
		} catch(Exception e) {
			new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());			
		}
	}	

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	public void excluir(@PathVariable("id") Long id) {
		try {
			pacienteService.excluir(id);
//		} catch(DataIntegrityViolationException e) {
		} catch(Exception e) {			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());			
		}
	}
}