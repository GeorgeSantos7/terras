package br.com.desbravadores.terras.plano.application.repository;

import br.com.desbravadores.terras.plano.application.api.PlanosListResponse;
import br.com.desbravadores.terras.plano.domain.Plano;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanoRepository {
    Plano salva(Plano plano);
    List<Plano> buscaPlanos();
    Optional<Plano> buscaPlanoPorId(UUID idPlano);
}
