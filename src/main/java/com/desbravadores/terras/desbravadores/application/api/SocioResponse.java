package com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;
import java.util.UUID;

import com.desbravadores.terras.desbravadores.domain.Endereco;
import com.desbravadores.terras.desbravadores.domain.Sexo;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

import lombok.Data;

@Data
public class SocioResponse {
	private UUID idSocio;
	private String cpf;
	private String nome;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;
	private String telefone;
	private Endereco endereco;

	public SocioResponse(SocioCT desbravadores) {
		this.idSocio = desbravadores.getIdSocio();
		this.cpf = desbravadores.getCpf();
		this.nome = desbravadores.getNome();
		this.sexo = desbravadores.getSexo();
		this.idade = desbravadores.getIdade();
		this.dataDeNascimento = desbravadores.getDataDeNascimento();
		this.telefone = desbravadores.getTelefone();
		this.endereco = desbravadores.getEndereco();
	}
}