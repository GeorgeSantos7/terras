package br.com.desbravadores.terras.admin.infra;

import br.com.desbravadores.terras.admin.application.repository.AdminRepository;
import br.com.desbravadores.terras.admin.domain.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class AdminInfraRepository implements AdminRepository {
    private final AdminSpringDataJPARepository adminSpringDataJPARepository;

    @Override
    public Admin salva(Admin admin) {
        Admin adminSalva = adminSpringDataJPARepository.save(admin);
        return adminSalva;
    }

    @Override
    public Optional<Admin> buscaPorEmail(String email) {
        return adminSpringDataJPARepository.findByEmail(email);
    }
}
