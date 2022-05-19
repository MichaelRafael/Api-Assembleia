package br.com.votacao.assembleia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.votacao.assembleia.model.Voto;
import br.com.votacao.assembleia.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	private VotoService votoService;
	
	
	@PostMapping
	@Operation(summary = "Insere uma Voto")
	public Voto saveVoto(@RequestBody Voto voto) {
		return votoService.saveVoto(voto);
	}
	
	@GetMapping
	@Operation(summary = "Retorna todos os votos cadastrados")
	public List<Voto> getAllVotos() {
		return votoService.getAllVotos();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Retorna um voto através de seu id")
	public Voto getVotoById(@PathVariable Long id) {
		return votoService.getVotoById(id);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um voto")
	public void deleteVoto(@PathVariable Long id) {
		votoService.deleteVoto(id);
	}
	
}



















