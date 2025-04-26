package br.com.desbravadores.terras.socio.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.desbravadores.terras.socio.domain.entity.SocioCT;

public interface SocioSpringDataJPARepository extends MongoRepository<SocioCT, UUID> {
    Optional<SocioCT> findById(UUID idSocio);
}