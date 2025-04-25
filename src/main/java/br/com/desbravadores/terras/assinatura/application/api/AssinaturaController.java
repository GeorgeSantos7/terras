package br.com.desbravadores.terras.assinatura.application.api;

import br.com.desbravadores.terras.assinatura.application.service.AssinaturaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AssinaturaController implements AssinaturaAPI {
    private final AssinaturaService assinaturaService;

    @Override
    public AssinaturaResponse criaAssinaturaAoSocio(AssinaturaRequest assinaturaRequest) {
        log.info("[inicia] AssinaturaController - adicionarAssinaturaAoSocio");
        AssinaturaResponse assinatura = assinaturaService.criaAssinatura(assinaturaRequest);
        log.info("[finaliza] AssinaturaController - adicionarAssinaturaAoSocio");
        return assinatura;
    }
}
