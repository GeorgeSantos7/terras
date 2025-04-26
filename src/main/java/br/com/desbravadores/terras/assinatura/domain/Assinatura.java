package br.com.desbravadores.terras.assinatura.domain;

import br.com.desbravadores.terras.assinatura.application.api.AssinaturaRequest;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import br.com.desbravadores.terras.socio.domain.enums.StatusAssinatura;
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

    @JsonCreator
    public Assinatura(AssinaturaRequest assinaturaRequest) {
        this.idAssinatura = UUID.randomUUID();
        this.idPlano = assinaturaRequest.getIdPlano();
        this.dataInicio = LocalDate.now();
        this.dataTermino = null;
    }

    public void setSocio(SocioCT socio) {
        this.socio = socio;
    }

    public void setDataInicio(LocalDate now) {
        this.dataInicio = now;
    }

    public void setDataTermino(LocalDate localDate) {
        this.dataTermino = localDate;

    }

    public void setStatus(StatusAssinatura statusAssinatura) {
        this.socio.setStatusAssinatura(statusAssinatura);
    }
}