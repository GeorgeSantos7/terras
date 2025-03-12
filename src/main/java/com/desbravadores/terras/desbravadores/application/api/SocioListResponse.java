package com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.desbravadores.terras.desbravadores.domain.Sexo;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

import lombok.Value;

@Value
public class SocioListResponse {
	private UUID idSocio;
	private String nome;
	private Sexo sexo;
	private Integer idade;
	private LocalDate dataDeNascimento;

	public static List<SocioListResponse> converte(List<SocioCT> socios) {
		return socios.stream()
				.map(SocioListResponse::new)
				.collect(Collectors.toList());
		
	
	}
	public SocioListResponse(SocioCT socio) {
		this.idSocio = socio.getIdSocio();
		this.nome = socio.getNome();
		this.sexo = socio.getSexo();
		this.idade = socio.getIdade();
		this.dataDeNascimento = socio.getDataDeNascimento();
	} 

}
