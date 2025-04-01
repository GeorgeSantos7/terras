package br.com.desbravadores.terras.admin.application.service;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import br.com.desbravadores.terras.admin.application.api.AdminResponse;
import br.com.desbravadores.terras.admin.application.repository.AdminRespository;
import br.com.desbravadores.terras.admin.domain.Admin;
import br.com.desbravadores.terras.credencial.application.service.CredencialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminApplicationService implements AdminService{
    private final CredencialService credencialService;
    private final AdminRespository adminRespository;

    @Override
    public AdminResponse criaAdmin(AdminRequest novoAdmin) {
        log.info("[inicia] AdminApplicationService - criaAdmin");
        credencialService.criaCredencial(novoAdmin.getEmail(), novoAdmin.getSenha());
        Admin admin = adminRespository.salva(new Admin(novoAdmin));
        log.info("[finaliza] AdminApplicationService - criaAdmin");
        return new AdminResponse(admin);
    }
}
