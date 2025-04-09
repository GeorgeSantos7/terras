package br.com.desbravadores.terras.socio.application.api;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.desbravadores.terras.plano.domain.Plano;
import org.hibernate.validator.constraints.br.CPF;

import br.com.desbravadores.terras.socio.domain.enums.Sexo;
import lombok.Value;
@Value
public class SocioRequest {
	@NotBlank
	@CPF
	private String cpf;
	@NotBlank
	private String nome;
	@Email
	private String email;
	@Size(min = 6)
	private String senha;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;
	@NotBlank
	private String telefone;
	private Plano plano;
	private EnderecoRequest endereco;
}