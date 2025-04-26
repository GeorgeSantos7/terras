package br.com.desbravadores.terras.assinatura.application.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.UUID;

@Value
public class AssinaturaRequest {
    private UUID idPlano;


    @JsonCreator
    public AssinaturaRequest(@JsonProperty("idPlano") UUID idPlano) {
        this.idPlano = idPlano;
    }
}
