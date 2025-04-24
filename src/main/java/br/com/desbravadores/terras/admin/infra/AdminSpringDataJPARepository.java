package br.com.desbravadores.terras.admin.infra;

import br.com.desbravadores.terras.admin.domain.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminSpringDataJPARepository extends MongoRepository<Admin, UUID> {
    Optional<Admin> findByEmail(String email);
}
