package br.com.desbravadores.terras.socio.domain.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import br.com.desbravadores.terras.socio.domain.enums.StatusAssinatura;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAssinatura")
public class Assinatura {
    @Id
    private String idAssinatura;
    @DBRef
    private Plano plano;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private StatusAssinatura status;
}