package br.com.desbravadores.terras.plano.application.api;

import br.com.desbravadores.terras.plano.domain.Plano;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import lombok.Data;

import java.util.UUID;
@Data
public class PlanoResponse {
    private UUID idPlano;

    public PlanoResponse(Plano plano){
        this.idPlano = plano.getIdPlano();
    }
}