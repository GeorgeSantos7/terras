package br.com.desbravadores.terras.plano.application.api;

import br.com.desbravadores.terras.plano.application.service.PlanoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PlanoController implements PlanoAPI {

    private final PlanoService planoService;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public PlanoResponse criaPlano(PlanoRequest novoPlano) {
        log.info("[inicia] PlanoController - criaPlano");
        PlanoResponse criaPlano = planoService.criaNovoPlano(novoPlano);
        log.info("[finaliza] PlanoController - criaPlano");
        return criaPlano;
    }

    @Override
    public List<PlanosListResponse> buscaPlanos() {
        log.info("[inicia] PlanoController - buscaPlanos");
        List<PlanosListResponse> planos = planoService.buscaPlanos();
        log.info("[finaliza] PlanoController - buscaPlanos");
        return planos;
    }
}