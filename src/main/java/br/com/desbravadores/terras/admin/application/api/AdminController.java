package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.application.service.AdminService;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import br.com.desbravadores.terras.socio.application.service.SocioApplicationService;
import br.com.desbravadores.terras.socio.application.service.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AdminController implements AdminAPI{
    private final AdminService adminService;
    private final SocioService socioService;

    @Override
    public AdminResponse criaAdmin(AdminRequest novoAdmin) {
        log.info("[inicia] AdminController - criaAdmin");
        AdminResponse adminCriado = adminService.criaAdmin(novoAdmin);
        log.info("[finaliza] AdminController - criaAdmin");
        return adminCriado;
    }

    @Override
    public SocioResponse criaSocio(SocioRequest novoSocio) {
        log.info("[inicia] AdminController - criaSocio");
        SocioResponse socioCriado = socioService.criaNovoSocio(novoSocio);
        return socioCriado;
    }
}
