package br.com.desbravadores.terras.socio.application.api;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.com.desbravadores.terras.socio.domain.enums.Sexo;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
@Value
public class SocioRequest {
	@NotBlank
	@CPF
	private String cpf;
	@NotBlank
	private String nome;
	private String email;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;
	@NotBlank
	private String telefone;
	private EnderecoRequest endereco;
}