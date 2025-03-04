package com.desbravadores.terras.desbravadores.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desbravadores.terras.desbravadores.domain.Desbravadores;

public interface DesbravadorSpringDataJPARepository extends MongoRepository<Desbravadores, UUID> {

}
