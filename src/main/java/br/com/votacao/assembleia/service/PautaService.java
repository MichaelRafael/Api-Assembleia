package br.com.votacao.assembleia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.assembleia.DTO.PautaDTO;
import br.com.votacao.assembleia.model.Pauta;
import br.com.votacao.assembleia.repositories.PautaRepository;

@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pauta savePauta(Pauta pauta) {
		return pautaRepository.save(pauta);
	}
	
	public List<PautaDTO> getAllPautas() {
		return pautaRepository.findAll().stream().map(this::toPautaDTO).collect(Collectors.toList());
	}
	
	public Pauta getPautaById(Long id) {
		return pautaRepository.findById(id).get();
	}
	
	public List<Pauta> getPautaByNome(String nome) {
		return pautaRepository.findByTemaContaining(nome);
	}
	
	public Pauta upDatePauta(Long id, Pauta pauta) {
		pauta.setId(id);
		return pautaRepository.save(pauta);
	}
	
	public void deletePauta(Long id) {
		pautaRepository.deleteById(id);
	}
	
	public PautaDTO toPautaDTO(Pauta pauta) {
		return modelMapper.map(pauta, PautaDTO.class);
	}
}

















