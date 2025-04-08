package br.com.desbravadores.terras.admin.security;

import br.com.desbravadores.terras.admin.application.repository.AdminRepository;
import br.com.desbravadores.terras.admin.domain.Admin;
import br.com.desbravadores.terras.admin.infra.AdminSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminSpringDataJPARepository adminSpringDataJPARepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = (Admin) adminSpringDataJPARepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin não encontrado com email: " + email));

        return new User(
                admin.getEmail(),
                admin.getSenha(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + admin.getRole().name()))
        );
    }
}
