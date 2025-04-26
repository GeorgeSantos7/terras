package br.com.desbravadores.terras.assinatura.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class AssinaturaResponse {
    private UUID idAssinatura;

    public AssinaturaResponse(UUID idAssinatura) {
        this.idAssinatura = idAssinatura;
    }
}
