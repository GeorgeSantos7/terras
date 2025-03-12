package com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.desbravadores.terras.desbravadores.domain.Sexo;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
@Value
public class SocioRequest {
	@NotBlank
	@CPF
	private String cpf;
	@NotBlank
	private String nome;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;
	@NotBlank
	private String telefone;
	private EnderecoRequest endereco;
}