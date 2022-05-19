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

import br.com.votacao.assembleia.DTO.PautaDTO;
import br.com.votacao.assembleia.model.Pauta;
import br.com.votacao.assembleia.service.PautaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/pauta")
public class PautaController {

	@Autowired
	private PautaService pautaService;
	
	
	@PostMapping
	@Operation(summary = "Salva uma pauta")
	public Pauta savePauta(@RequestBody Pauta pauta) {
		return pautaService.savePauta(pauta);
	}
	
	@GetMapping
	@Operation(summary = "Retorna todos as pautas cadastrados")
	public List<PautaDTO> getAllPauta() {
		return pautaService.getAllPautas();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Retorna uma pauta através de seu id")
	public Pauta getPautaById(@PathVariable Long id) {
		return pautaService.getPautaById(id);
	}
	
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Retorna pauta(s) pelo nome")
	public List<Pauta> getPautaByNome(@PathVariable String nome) {
		return pautaService.getPautaByNome(nome);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualiza os dados de uma pauta")
	public Pauta upDatePauta(@PathVariable Long id, @RequestBody Pauta pauta) {
		return pautaService.upDatePauta(id, pauta);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma pauta")
	public void deletePauta(@PathVariable Long id) {
		pautaService.deletePauta(id);
	}
}


