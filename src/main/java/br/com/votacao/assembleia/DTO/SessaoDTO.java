package br.com.votacao.assembleia.DTO;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessaoDTO {

	private String nome;
	private String local;
	private Date data;
	private String hora;
}
