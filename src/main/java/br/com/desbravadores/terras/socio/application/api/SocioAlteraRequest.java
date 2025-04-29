package br.com.desbravadores.terras.socio.application.api;

import br.com.desbravadores.terras.socio.domain.enums.Sexo;
import lombok.Value;

import java.time.LocalDate;

@Value
public class SocioAlteraRequest {
    private String nome;
    private Sexo sexo;
    private String telefone;
    private EnderecoRequest endereco;
    private LocalDate dataDeNascimento;
}
