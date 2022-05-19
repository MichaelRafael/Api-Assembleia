package br.com.votacao.assembleia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.assembleia.model.Voto;
import br.com.votacao.assembleia.repositories.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;
	
	
	public Voto saveVoto(Voto voto) {
		return votoRepository.save(voto);
	}
	
	public List<Voto> getAllVotos() {
		return votoRepository.findAll();
	}
	
	public Voto getVotoById(Long id) {
		return votoRepository.findById(id).get();
	}
	
	public void deleteVoto(Long id) {
		votoRepository.deleteById(id);
	}
}
