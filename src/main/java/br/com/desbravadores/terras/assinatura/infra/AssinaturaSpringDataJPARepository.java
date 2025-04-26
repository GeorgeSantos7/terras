package br.com.desbravadores.terras.assinatura.infra;

import br.com.desbravadores.terras.assinatura.domain.Assinatura;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface AssinaturaSpringDataJPARepository extends MongoRepository<Assinatura, UUID> {
    Optional<Assinatura> findByIdAssinatura(UUID idAssinatura);
}
