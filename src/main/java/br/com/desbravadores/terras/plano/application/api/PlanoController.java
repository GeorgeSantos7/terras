package br.com.desbravadores.terras.plano.application.api;

import br.com.desbravadores.terras.plano.application.service.PlanoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PlanoController implements PlanoAPI {

    private final PlanoService planoService;

    @Override
    public PlanoResponse criaPlano(PlanoRequest novoPlano) {
        log.info("[inicia] PlanoController - criaPlano");
        PlanoResponse criaPlano = planoService.criaNovoPlano(novoPlano);
        log.info("[finaliza] PlanoController - criaPlano");
        return criaPlano;
    }
}