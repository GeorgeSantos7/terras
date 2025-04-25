package br.com.desbravadores.terras.assinatura.domain;

import br.com.desbravadores.terras.assinatura.application.api.AssinaturaRequest;
import br.com.desbravadores.terras.plano.domain.Plano;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAssinatura")
public class Assinatura {
    @Id
    private UUID idAssinatura;
    private UUID idPlano;
    @DBRef
    private SocioCT socio;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private StatusAssinatura status;

    @JsonCreator
    public Assinatura(AssinaturaRequest assinaturaRequest) {
        this.idAssinatura = UUID.randomUUID();
        this.idPlano = assinaturaRequest.getIdPlano();
    }
}