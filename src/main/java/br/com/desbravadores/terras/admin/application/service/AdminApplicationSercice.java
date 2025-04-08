package br.com.desbravadores.terras.admin.application.service;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import br.com.desbravadores.terras.admin.application.api.AdminResponse;
import br.com.desbravadores.terras.admin.application.repository.AdminRepository;
import br.com.desbravadores.terras.admin.domain.Admin;
import br.com.desbravadores.terras.credencial.application.service.CredencialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminApplicationSercice implements AdminService{
    private final CredencialService credencialService;
    private final AdminRepository adminRepository;

    @Override
    public AdminResponse criaAdmin(AdminRequest adminRequest) {
        credencialService.criaCredencial(adminRequest.getEmail(), adminRequest.getSenha());
        Admin admin = adminRepository.salva(new Admin(adminRequest));
        return new AdminResponse(admin);
    }
}
