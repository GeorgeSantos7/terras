package br.com.desbravadores.terras.plano.application.service;

import br.com.desbravadores.terras.plano.application.api.PlanoRequest;
import br.com.desbravadores.terras.plano.application.api.PlanoResponse;

public interface PlanoService {
    PlanoResponse criaNovoPlano(PlanoRequest novoPlano);
}
