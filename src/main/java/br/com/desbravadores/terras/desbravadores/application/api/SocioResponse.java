package br.com.desbravadores.terras.desbravadores.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.desbravadores.terras.desbravadores.domain.Endereco;
import br.com.desbravadores.terras.desbravadores.domain.Sexo;
import br.com.desbravadores.terras.desbravadores.domain.SocioCT;
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
	
	public SocioResponse(SocioCT socio) {
		this.idSocio = socio.getIdSocio();
		this.cpf = socio.getCpf();
		this.nome = socio.getNome();
		this.sexo = socio.getSexo();
		this.idade = socio.getIdade();
		this.dataDeNascimento = socio.getDataDeNascimento();
		this.telefone = socio.getTelefone();
		this.endereco = socio.getEndereco();
	}
}