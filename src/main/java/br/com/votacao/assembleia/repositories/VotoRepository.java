package br.com.votacao.assembleia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.votacao.assembleia.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{

}
