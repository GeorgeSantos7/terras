package br.com.desbravadores.terras.assinatura.application.api;

import br.com.desbravadores.terras.assinatura.domain.Assinatura;
import lombok.Value;

import java.util.UUID;

@Value
public class AssinaturaDetalhadoResponse {
    private UUID idAssinatura;
    private UUID idPlano;



    public AssinaturaDetalhadoResponse(Assinatura assinatura) {
        this.idAssinatura = assinatura.getIdAssinatura();
        this.idPlano = assinatura.getIdPlano();
    }
}
