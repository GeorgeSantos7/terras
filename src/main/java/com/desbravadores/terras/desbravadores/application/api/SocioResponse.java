package com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;
import java.util.UUID;

import com.desbravadores.terras.desbravadores.domain.Sexo;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

import lombok.Data;

@Data
public class SocioResponse {
	private UUID idDesbravador;
	private String nome;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;

	public SocioResponse(SocioCT desbravadores) {
		this.idDesbravador = desbravadores.getIdDesbravador();
		this.nome = desbravadores.getNome();
		this.sexo = desbravadores.getSexo();
		this.idade = desbravadores.getIdade();
		this.dataDeNascimento = desbravadores.getDataDeNascimento();
	}
}