package com.desbravadores.terras.desbravadores.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.desbravadores.terras.desbravadores.application.api.SocioRequest;

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
public class SocioCT {
	@Id
	private UUID idSocio;
	@NotBlank
	private String nome;
	private Sexo sexo;
	@NotNull
	private Integer idade;
	@NotNull
	private LocalDate dataDeNascimento;
	private String telefone;
	private Endereco endereco;
	
	private LocalDateTime dataDeCadastro;
	private Boolean aceitaTermos;
	
	public SocioCT(SocioRequest novoDesbravador) {
		this.idSocio = UUID.randomUUID();
		this.nome = novoDesbravador.getNome();
		this.sexo = novoDesbravador.getSexo();
		this.idade = novoDesbravador.getIdade();
		this.dataDeNascimento = novoDesbravador.getDataDeNascimento();
		this.endereco = new Endereco(novoDesbravador.getEndereco());
	}
}