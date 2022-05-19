package br.com.votacao.assembleia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.votacao.assembleia.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long>{

	List<Sessao> findByNomeContaining(String nome);
}
