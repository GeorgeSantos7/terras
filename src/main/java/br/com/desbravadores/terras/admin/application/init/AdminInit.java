package br.com.desbravadores.terras.admin.application.init;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import br.com.desbravadores.terras.admin.application.repository.AdminRepository;
import br.com.desbravadores.terras.admin.application.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Log4j2
public class AdminInit {

    private final AdminService adminService;
    private final AdminRepository adminRepository;

    @Value("${admin.init.email}")
    private String email;

    @Value("${admin.init.senha}")
    private String senha;

    @PostConstruct
    public void init() {
        log.info("[start] AdminInit - inicialização");
        adminRepository.buscaPorEmail(email).ifPresentOrElse(
                admin -> log.info("Admin já existe com o e-mail: {}", email),
                () -> {
                    AdminRequest request = new AdminRequest(email, senha);
                    adminService.criaAdmin(request);
                    log.info("Admin criado com sucesso: {}", email);
                }
        );
        log.info("[end] AdminInit - inicialização");
    }
}
