package br.com.desbravadores.terras.assinatura.application.api;

import br.com.desbravadores.terras.assinatura.application.service.AssinaturaService;
import br.com.desbravadores.terras.config.security.service.TokenService;
import br.com.desbravadores.terras.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AssinaturaController implements AssinaturaAPI {
    private final AssinaturaService assinaturaService;
    private final TokenService tokenService;

    @Override
    public AssinaturaResponse criaAssinaturaAoSocio(AssinaturaRequest assinaturaRequest) {
        log.info("[inicia] AssinaturaController - adicionarAssinaturaAoSocio");
        AssinaturaResponse assinatura = assinaturaService.criaAssinatura(assinaturaRequest);
        log.info("[finaliza] AssinaturaController - adicionarAssinaturaAoSocio");
        return assinatura;
    }

    @Override
    public AssinaturaDetalhadoResponse buscaAssinaturaPorId(UUID idAssinatura) {
        log.info("[inicia] AssinaturaController - buscaAssinaturaPorId");
        AssinaturaDetalhadoResponse detalhaAssinatura = assinaturaService.buscaAssinaturaPorId(idAssinatura);
        log.info("[finaliza] AssinaturaController - buscaAssinaturaPorId");
        return detalhaAssinatura;
    }

    @Override
    public void adicionaAssinaturaAoSocio(UUID idAssinatura, UUID idSocio) {
        log.info("[inicia] AssinaturaController - adicionaAssinaturaAoSocio");
        assinaturaService.adicionaAssinaturaAoSocio(idAssinatura, idSocio);
        log.info("[finaliza] AssinaturaController - adicionaAssinaturaAoSocio");
    }
}
