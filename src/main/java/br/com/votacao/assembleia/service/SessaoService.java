package br.com.votacao.assembleia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.assembleia.DTO.SessaoDTO;
import br.com.votacao.assembleia.model.Sessao;
import br.com.votacao.assembleia.repositories.SessaoRepository;

@Service
public class SessaoService {

	@Autowired
	public SessaoRepository sessaoRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	
	public Sessao saveSessao(Sessao sessao) {
		return sessaoRepository.save(sessao);
	}
	
	public List<SessaoDTO> getAllSessao() {
		return sessaoRepository.findAll().stream().map(this::toSessaoDTO).collect(Collectors.toList());
	}
	
	public Sessao getSessaoById(Long id) {
		return sessaoRepository.findById(id).get();
	}
	
	public List<Sessao> getSessaoByNome(String nome) {
		return sessaoRepository.findByNomeContaining(nome);
	}
	
	public Sessao upDateSessao(Long id, Sessao sessao) {
		sessao.setId(id);
		return sessaoRepository.save(sessao);
	}
	
	public void deleteSessao(Long id) {
		sessaoRepository.deleteById(id);;
	}
	
	public SessaoDTO toSessaoDTO(Sessao sessao) {
		return modelMapper.map(sessao, SessaoDTO.class);
	}
}
