package br.com.desbravadores.terras.plano.application.service;

import br.com.desbravadores.terras.plano.application.api.PlanoRequest;
import br.com.desbravadores.terras.plano.application.api.PlanoResponse;
import br.com.desbravadores.terras.plano.application.repository.PlanoRepository;
import br.com.desbravadores.terras.plano.domain.Plano;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlanoApplicationService implements PlanoService {

    private final PlanoRepository planoRepository;

    @Override
    public PlanoResponse criaNovoPlano(PlanoRequest novoPlano) {
        log.info("[inicia] PlanoApplicationService - criaNovoPlano");
        Plano plano = planoRepository.salva(new Plano(novoPlano));
        log.info("[finaliza] PlanoApplicationService - criaNovoPlano");
        return new PlanoResponse(plano);
    }
}
