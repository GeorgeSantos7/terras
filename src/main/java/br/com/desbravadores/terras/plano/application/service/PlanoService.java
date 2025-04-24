package br.com.desbravadores.terras.plano.application.service;

import br.com.desbravadores.terras.plano.application.api.PlanoRequest;
import br.com.desbravadores.terras.plano.application.api.PlanoResponse;
import br.com.desbravadores.terras.plano.application.api.PlanosListResponse;

import java.util.List;

public interface PlanoService {
    PlanoResponse criaNovoPlano(PlanoRequest novoPlano);
    List<PlanosListResponse> buscaPlanos();
}