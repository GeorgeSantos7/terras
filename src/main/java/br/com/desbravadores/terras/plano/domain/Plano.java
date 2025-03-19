package br.com.desbravadores.terras.plano.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPlano")
@Document(collection = "planos")
public class Plano {
	@Id
    private UUID idPlano;
    private String nomePlano;
    private Double valorMensal;
    private List<Beneficio> beneficios;
}