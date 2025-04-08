package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.application.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AdminController implements AdminAPI {
    private final AdminService adminService;

    @Override
    public AdminResponse criaAdmin(AdminRequest adminRequest) {
        log.info("[inicia] AdminController - criaAdmin");
        AdminResponse adminCriado = adminService.criaAdmin(adminRequest);
        log.info("[finaliza] AdminController - criaAdmin");
        return adminCriado;
    }
}
