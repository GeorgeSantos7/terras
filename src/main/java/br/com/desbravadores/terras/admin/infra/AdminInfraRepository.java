package br.com.desbravadores.terras.admin.infra;

import br.com.desbravadores.terras.admin.application.repository.AdminRespository;
import br.com.desbravadores.terras.admin.domain.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class AdminInfraRepository implements AdminRespository {
    private final AdminSpringDataJPARepository adminSpringDataJPARepository;

    @Override
    public Admin salva(Admin admin) {
        log.info("[inicia] AdminInfraRepository - salva");
        Admin adminSalva = adminSpringDataJPARepository.save(admin);
        log.info("[finaliza] AdminInfraRepository - salva");
        return adminSalva;
    }
}