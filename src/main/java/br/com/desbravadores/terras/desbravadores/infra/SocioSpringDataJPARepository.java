package br.com.desbravadores.terras.desbravadores.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.desbravadores.terras.desbravadores.domain.entity.SocioCT;

public interface SocioSpringDataJPARepository extends MongoRepository<SocioCT, UUID> {

}