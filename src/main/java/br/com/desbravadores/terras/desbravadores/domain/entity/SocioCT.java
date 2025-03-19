package br.com.desbravadores.terras.desbravadores.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import br.com.desbravadores.terras.desbravadores.domain.enums.Sexo;
import br.com.desbravadores.terras.desbravadores.domain.enums.StatusAssinatura;
import br.com.desbravadores.terras.desbravadores.domain.enums.StatusSocio;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "socio")
public class SocioCT {
	@Id
	private UUID idSocio;
	@CPF
	private String cpf;
	@NotBlank
	private String nome;
	@Email
	private String email;
	private Sexo sexo;
	@NotNull
	private Integer idade;
	@NotNull
	private LocalDate dataDeNascimento;
	private String telefone;
	private Endereco endereco;
	private StatusSocio status;
	private StatusAssinatura statusAssinatura;
	private LocalDateTime dataDeCadastro;
	private Boolean aceitaTermos;
	
	public SocioCT(SocioRequest novoSocio) {
		this.idSocio = UUID.randomUUID();
		this.cpf = novoSocio.getCpf();
		this.nome = novoSocio.getNome();
		this.email = novoSocio.getEmail();
		this.sexo = novoSocio.getSexo();
		this.idade = novoSocio.getIdade();
		this.dataDeNascimento = novoSocio.getDataDeNascimento();
		this.telefone = novoSocio.getTelefone();
		this.endereco = new Endereco(novoSocio.getEndereco());
		this.dataDeCadastro = LocalDateTime.now();
	}
}