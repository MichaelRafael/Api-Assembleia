package br.com.votacao.assembleia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.assembleia.DTO.AssociadoDTO;
import br.com.votacao.assembleia.model.Associado;
import br.com.votacao.assembleia.repositories.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Associado saveAssociado(Associado associado) {
		return associadoRepository.save(associado);
	}
	
	public List<AssociadoDTO> getAllAssociados() {
		return associadoRepository.findAll().stream().map(this::toAssociadoDTO).collect(Collectors.toList());
	}
	
	public Associado getAssociadoById(Long id) {
		return associadoRepository.findById(id).get();
	}
	
	public List<Associado> getAssociadoByName(String nome) {
		return associadoRepository.findByNomeContaining(nome);
	}
	
	public Associado upDateAssociado(Long id, Associado associado) {
		associado.setId(id);
		return associadoRepository.save(associado);
	}
	
	public void deleteAssociado(Long id) {
		associadoRepository.deleteById(id);
	}
	
	public AssociadoDTO toAssociadoDTO(Associado associado) {
		return modelMapper.map(associado, AssociadoDTO.class);
	}
}
