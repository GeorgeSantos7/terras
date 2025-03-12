package com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;

import com.desbravadores.terras.desbravadores.domain.Sexo;

import lombok.Value;
@Value
public class SocioRequest {
	private String nome;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;
	private String telefone;
	private EnderecoRequest endereco;
}