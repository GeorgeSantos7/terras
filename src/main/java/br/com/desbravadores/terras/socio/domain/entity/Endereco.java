package br.com.desbravadores.terras.socio.domain.entity;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import br.com.desbravadores.terras.socio.application.api.EnderecoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
	@Id
	private UUID idEndereco;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private int numero;
	@NotBlank
	private String cidade;

	public Endereco(EnderecoRequest enderecoRequest) {
		this.idEndereco = UUID.randomUUID();
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
	}
}