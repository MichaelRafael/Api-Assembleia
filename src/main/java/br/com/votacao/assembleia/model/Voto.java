package br.com.votacao.assembleia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String votoValor;
	
	@OneToOne
	@JoinColumn(name = "id_associado")
	private Associado associado;
	
	@ManyToOne
	@JoinColumn(name = "id_sessao")
	private Sessao assembleia;
	
	@ManyToOne
	@JoinColumn(name = "id_pauta")
	private Pauta pauta;
	
}
