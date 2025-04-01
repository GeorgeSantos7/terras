package br.com.desbravadores.terras.config.security.service;


import java.util.Optional;

import br.com.desbravadores.terras.admin.domain.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desbravadores.terras.credencial.application.repository.CredencialRepository;
import br.com.desbravadores.terras.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AutenticacaoSecurityService implements UserDetailsService {
    private final CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        log.info("[inicio] AutenticacaoSecurityService - buscando credencial pelo usuario");
        var credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
        if (credencial instanceof Admin) {
            log.info("Usuário autenticado como ADMIN");
        } else {
            log.info("Usuário autenticado como SOCIO");
        }
        log.info("[finaliza] AutenticacaoSecurityService - buscando credencial pelo usuario");
        return Optional.ofNullable(credencial).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Usuario informado!"));
    }
}
