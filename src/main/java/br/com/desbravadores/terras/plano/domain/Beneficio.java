package br.com.desbravadores.terras.plano.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "descricao")
public class Beneficio {
	private String descricao;
    private Boolean exclusivo;
}