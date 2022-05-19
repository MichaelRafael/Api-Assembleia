package br.com.votacao.assembleia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.votacao.assembleia.DTO.AssociadoDTO;
import br.com.votacao.assembleia.model.Associado;
import br.com.votacao.assembleia.service.AssociadoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	
	@PostMapping
	@Operation(summary = "Insere uma associado")
	public Associado saveAssociado(@RequestBody Associado associado) {
		return associadoService.saveAssociado(associado);
	}
	
	@GetMapping 
	@Operation(summary = "Retorna todos os associados cadastrados")
	public List<AssociadoDTO> getAllAssociados() {
		return associadoService.getAllAssociados();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Retorna um associado através de seu id")
	public Associado getAssociadoById(@PathVariable Long id) {
		return associadoService.getAssociadoById(id);
	}
	
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Retorna associado(s) pelo nome")
	public List<Associado> getAssociadoByNome(@PathVariable String nome) {
		return associadoService.getAssociadoByName(nome);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualiza os dados de um associado")
	public Associado upDateAssociado(@PathVariable Long id, @RequestBody Associado associado) {
		return associadoService.upDateAssociado(id, associado);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um associado")
	public void deleteAssociado(@PathVariable Long id) {
		associadoService.deleteAssociado(id);
	}
	
}

























