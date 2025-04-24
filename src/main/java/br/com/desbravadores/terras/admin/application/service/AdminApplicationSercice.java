package br.com.desbravadores.terras.admin.application.service;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import br.com.desbravadores.terras.admin.application.repository.AdminRepository;
import br.com.desbravadores.terras.credencial.application.service.CredencialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminApplicationSercice implements AdminService{
    private final CredencialService credencialService;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void criaAdmin(AdminRequest request) {
        log.info("[start] AdminService - criaAdmin");
        credencialService.criaCredencial(request.getEmail(), request.getSenha());
        adminRepository.salva(request.toAdmin());
        log.info("[end] AdminService - criaAdmin");
    }
}
