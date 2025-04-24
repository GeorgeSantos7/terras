package br.com.desbravadores.terras.plano.application.api;

import br.com.desbravadores.terras.plano.domain.Beneficio;
import br.com.desbravadores.terras.plano.domain.Plano;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PlanosListResponse {
    private UUID idPlano;
    private String nomePlano;
    private Double valorMensal;
    private List<Beneficio> beneficios;

    public PlanosListResponse(Plano plano) {
        this.idPlano = plano.getIdPlano();
        this.nomePlano = plano.getNomePlano();
        this.valorMensal = plano.getValorMensal();
        this.beneficios = plano.getBeneficios();
    }

    public static List<PlanosListResponse> converte(List<Plano> planos) {
        return planos.stream()
                .map(PlanosListResponse::new)
                .collect(Collectors.toList());
    }
}