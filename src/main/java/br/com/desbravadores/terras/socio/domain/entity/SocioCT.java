package br.com.desbravadores.terras.socio.domain.entity;

import br.com.desbravadores.terras.socio.application.api.SocioAlteraRequest;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.domain.enums.Planos;
import br.com.desbravadores.terras.socio.domain.enums.Sexo;
import br.com.desbravadores.terras.socio.domain.enums.StatusAssinatura;
import br.com.desbravadores.terras.socio.domain.enums.StatusSocio;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


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
	private Planos plano;
	private Endereco endereco;
	@Setter
    private StatusSocio status;
	@Setter
    @Field("statusAssinatura")
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
		this.plano = Planos.SEM_PLANO;
		this.endereco = new Endereco(novoSocio.getEndereco());
		this.dataDeCadastro = LocalDateTime.now();
	}

	public SocioCT(UUID idSocio) {
		this.idSocio = idSocio;
	}

    public void setPlano(Planos planos) {
		this.plano = planos;
	}

    public void atualiza(SocioAlteraRequest socio) {
		this.nome = socio.getNome();
		this.sexo = socio.getSexo();
		this.dataDeNascimento = socio.getDataDeNascimento();
		this.telefone = socio.getTelefone();
		this.endereco = new Endereco(socio.getEndereco());
    }
}