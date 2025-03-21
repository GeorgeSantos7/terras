package br.com.desbravadores.terras.plano.infra;

import br.com.desbravadores.terras.plano.domain.Plano;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PlanoSpringDataJPARepository extends MongoRepository<Plano, UUID> {
}
