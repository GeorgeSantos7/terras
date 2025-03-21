package br.com.desbravadores.terras.plano.application.api;

import br.com.desbravadores.terras.plano.domain.Beneficio;
import lombok.Value;

import java.util.List;

@Value
public class PlanoRequest {
    private String nomePlano;
    private Double valorMensal;
    private List<Beneficio> beneficios;
}