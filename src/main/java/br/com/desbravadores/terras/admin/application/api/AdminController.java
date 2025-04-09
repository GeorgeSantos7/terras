package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.application.service.AdminService;
import br.com.desbravadores.terras.socio.application.api.SocioDetalhadoResponse;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import br.com.desbravadores.terras.socio.application.service.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AdminController implements AdminAPI {
    private final AdminService adminService;
    private final SocioService socioService;

    @Override
    public AdminResponse criaAdmin(AdminRequest adminRequest) {
        log.info("[inicia] AdminController - criaAdmin");
        AdminResponse adminCriado = adminService.criaAdmin(adminRequest);
        log.info("[finaliza] AdminController - criaAdmin");
        return adminCriado;
    }

    @Override
    public SocioResponse adminCriaSocio(SocioRequest socioRequest) {
        log.info("[inicia] AdminController - adminCriaSocio");
        SocioResponse socioCriadoPeloAdmin = socioService.criaNovoSocio(socioRequest);
        log.info("[finaliza] AdminController - adminCriaSocio");
        return socioCriadoPeloAdmin;
    }

    @Override
    public SocioDetalhadoResponse adminBuscaSocioPorId(UUID idSocio) {
        log.info("[inicia] AdminController - adminBuscaSocioPorId");
        SocioDetalhadoResponse socio = socioService.buscaSocioPorId(idSocio);
        log.info("[finaliza] AdminController - adminBuscaSocioPorId");
        return socio;
    }
}
