package br.com.desbravadores.terras.socio.application.api;

import br.com.desbravadores.terras.plano.domain.Beneficio;
import br.com.desbravadores.terras.socio.domain.entity.Assinatura;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class AssinaturaResponse {
    private String nomePlano;
    private Double valorMensal;
    private List<Beneficio> beneficio;
    private LocalDate dataInicio;

    public AssinaturaResponse(Assinatura assinatura) {
        this.nomePlano = assinatura.getPlano().getNomePlano();
        this.valorMensal = assinatura.getPlano().getValorMensal();
        this.dataInicio = assinatura.getDataInicio();
        this.beneficio = assinatura.getPlano().getBeneficios();

    }
}
