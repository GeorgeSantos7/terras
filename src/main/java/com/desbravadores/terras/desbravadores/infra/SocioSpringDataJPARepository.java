package com.desbravadores.terras.desbravadores.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desbravadores.terras.desbravadores.domain.SocioCT;

public interface SocioSpringDataJPARepository extends MongoRepository<SocioCT, UUID> {

	SocioCT findByIdSocio(UUID idSocio);

}