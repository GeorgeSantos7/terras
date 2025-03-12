package com.desbravadores.terras.desbravadores.application.api;

import lombok.Value;
@Value
public class EnderecoRequest {
	private String logradouro;
	private String cep;
	private int numero;
	private String cidade;
}
