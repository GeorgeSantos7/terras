package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.application.service.AdminService;
import br.com.desbravadores.terras.autenticacao.domain.Token;
import br.com.desbravadores.terras.config.security.service.TokenService;
import br.com.desbravadores.terras.handler.APIException;
import br.com.desbravadores.terras.plano.application.api.PlanosListResponse;
import br.com.desbravadores.terras.plano.application.service.PlanoService;
import br.com.desbravadores.terras.plano.domain.Plano;
import br.com.desbravadores.terras.socio.application.api.SocioDetalhadoResponse;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import br.com.desbravadores.terras.socio.application.service.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AdminController implements AdminAPI {
    private final AdminService adminService;
    private final SocioService socioService;
    private final PlanoService planoService;
    private final TokenService tokenService;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SocioResponse adminCriaSocio(SocioRequest socioRequest) {
        log.info("[inicia] AdminController - adminCriaSocio");
        SocioResponse socioCriadoPeloAdmin = socioService.criaNovoSocio(socioRequest);
        log.info("[finaliza] AdminController - adminCriaSocio");
        return socioCriadoPeloAdmin;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SocioDetalhadoResponse adminBuscaSocioPorId(UUID idSocio) {
        log.info("[inicia] AdminController - adminBuscaSocioPorId");
        SocioDetalhadoResponse socio = socioService.adminBuscaSocioPorId(idSocio);
        log.info("[finaliza] AdminController - adminBuscaSocioPorId");
        return socio;
    }

    private String getUsuarioByTokenn(String token) {
        log.debug("[token] {}", token);
        String usuario = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        log.info("[usuario] {}", usuario);
        return usuario;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<SocioDetalhadoResponse> listaSocios() {
        log.info("[inicia] SocioController - listaSocios");
        List<SocioDetalhadoResponse> socio = socioService.buscaTodasSocios();
        log.info("[finaliza] SocioController - listaSocios");
        return socio;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<PlanosListResponse> buscaPlanos() {
        log.info("[inicia] AdminController - buscaPlanos");
        List<PlanosListResponse> planos = planoService.buscaPlanos();
        log.info("[finaliza] AdminController - buscaPlanos");
        return planos;
    }

}