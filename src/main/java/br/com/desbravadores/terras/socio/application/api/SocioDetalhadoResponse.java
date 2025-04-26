package br.com.desbravadores.terras.socio.application.api;

import br.com.desbravadores.terras.socio.domain.entity.Endereco;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import br.com.desbravadores.terras.socio.domain.enums.Planos;
import br.com.desbravadores.terras.socio.domain.enums.Sexo;
import br.com.desbravadores.terras.socio.domain.enums.StatusAssinatura;
import br.com.desbravadores.terras.socio.domain.enums.StatusSocio;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
@Log4j2
public class SocioDetalhadoResponse {
    private String cpf;
    private String nome;
    private String email;
    private Sexo sexo;
    private Integer idade;
    private LocalDate dataDeNascimento;
    private String telefone;
    private Planos plano;
    private Endereco endereco;
    private StatusSocio status;
    private StatusAssinatura statusAssinatura;
    private LocalDateTime dataDeCadastro;

    public SocioDetalhadoResponse(SocioCT socioCT) {
        this.cpf = socioCT.getCpf();
        this.nome = socioCT.getNome();
        this.email = socioCT.getEmail();
        this.sexo = socioCT.getSexo();
        this.idade = socioCT.getIdade();
        this.dataDeNascimento = socioCT.getDataDeNascimento();
        this.telefone = socioCT.getTelefone();
        this.plano = socioCT.getPlano();
        this.endereco = socioCT.getEndereco();
        this.status = StatusSocio.getStatusSocio(socioCT.getStatus());
        this.statusAssinatura = StatusAssinatura.getStatusAssinatura(socioCT.getStatusAssinatura());
        log.info("statusAssinatura convertido: {}", statusAssinatura);
        this.dataDeCadastro = socioCT.getDataDeCadastro();
    }
    public static List<SocioDetalhadoResponse> converte(List<SocioCT> socios) {
        return socios.stream()
                .map(SocioDetalhadoResponse::new)
                .collect(Collectors.toList());
    }
}