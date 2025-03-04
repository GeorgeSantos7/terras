package com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;
import java.util.UUID;

import com.desbravadores.terras.desbravadores.domain.Desbravadores;
import com.desbravadores.terras.desbravadores.domain.Sexo;

import lombok.Data;

@Data
public class DesbravadorResponse {
	private UUID idDesbravador;
	private String nome;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;

	public DesbravadorResponse(Desbravadores desbravadores) {
		this.idDesbravador = desbravadores.getIdDesbravador();
		this.nome = desbravadores.getNome();
		this.sexo = desbravadores.getSexo();
		this.idade = desbravadores.getIdade();
		this.dataDeNascimento = desbravadores.getDataDeNascimento();
	}
}