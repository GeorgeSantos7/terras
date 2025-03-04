package com.desbravadores.terras.desbravadores.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.desbravadores.terras.desbravadores.application.api.DesbravadorRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "desbravadores")
public class Desbravadores {
	@Id
	private UUID idDesbravador;
	@NotBlank
	private String nome;
	private Sexo sexo;
	@NotNull
	private Integer idade;
	@NotNull
	private LocalDate dataDeNascimento;
	private Classe classe;
	
	public Desbravadores(DesbravadorRequest novoDesbravador) {
		this.idDesbravador = UUID.randomUUID();
		this.nome = novoDesbravador.getNome();
		this.sexo = novoDesbravador.getSexo();
		this.idade = novoDesbravador.getIdade();
		this.dataDeNascimento = novoDesbravador.getDataDeNascimento();
	}
}