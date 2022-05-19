package br.com.votacao.assembleia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.votacao.assembleia.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{

	List<Pauta> findByTemaContaining(String tema);
}
