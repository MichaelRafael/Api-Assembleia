package br.com.votacao.assembleia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.votacao.assembleia.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{

	List<Associado> findByNomeContaining(String nome);
}
