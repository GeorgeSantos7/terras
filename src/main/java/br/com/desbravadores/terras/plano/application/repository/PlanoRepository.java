package br.com.desbravadores.terras.plano.application.repository;

import br.com.desbravadores.terras.plano.application.api.PlanosListResponse;
import br.com.desbravadores.terras.plano.domain.Plano;

import java.util.List;

public interface PlanoRepository {
    Plano salva(Plano plano);
    List<Plano> buscaPlanos();
}
