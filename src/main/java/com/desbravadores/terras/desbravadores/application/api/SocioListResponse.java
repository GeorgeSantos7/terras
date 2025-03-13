package com.desbravadores.terras.desbravadores.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.desbravadores.terras.desbravadores.domain.Endereco;
import com.desbravadores.terras.desbravadores.domain.Sexo;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

import lombok.Value;

@Value
public class SocioListResponse {
	private UUID idSocio;
	private String nome;
	private String cpf;
	private Sexo sexo;
	private Integer idade;
	private String telefone;
	private Endereco endereco;

	public static List<SocioListResponse> converte(List<SocioCT> socios) {
		return socios.stream()
				.map(SocioListResponse::new)
				.collect(Collectors
						.toList());
	}

	public SocioListResponse(SocioCT socio) {
		this.idSocio = socio.getIdSocio();
		this.nome = socio.getNome();
		this.cpf = socio.getCpf();
		this.sexo = socio.getSexo();
		this.idade = socio.getIdade();
		this.telefone = socio.getTelefone();
		this.endereco = socio.getEndereco();
	}

}
