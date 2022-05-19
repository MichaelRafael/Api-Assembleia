package br.com.votacao.assembleia.exeptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Campo {

	private String nome;
	private String mensagem;
}
