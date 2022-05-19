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

import br.com.votacao.assembleia.DTO.SessaoDTO;
import br.com.votacao.assembleia.model.Sessao;
import br.com.votacao.assembleia.service.SessaoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/sessao")
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;
	
	
	@PostMapping
	@Operation(summary = "Salva uma sessão")
	public Sessao saveSessao(@RequestBody Sessao sessao) {
		return sessaoService.saveSessao(sessao);
	}
	
	@GetMapping
	@Operation(summary = "Retorna todos as sessões cadastrados")
	public List<SessaoDTO> getAllSessao() {
		return sessaoService.getAllSessao();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Retorna uma sessão através de seu id")
	public Sessao getSessaoById(@PathVariable Long id) {
		return sessaoService.getSessaoById(id);
	}
	
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Retorna sessões pelo nome")
	public List<Sessao> getAllSessaoByNome(@PathVariable String nome) {
		return sessaoService.getSessaoByNome(nome);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualiza os dados de uma sessão")
	public Sessao upDateSessao(@PathVariable Long id, @RequestBody Sessao sessao) {
		return sessaoService.upDateSessao(id, sessao);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma sessão")
	public void deleteSessao(@PathVariable Long id) {
		sessaoService.deleteSessao(id);
	}
}


















