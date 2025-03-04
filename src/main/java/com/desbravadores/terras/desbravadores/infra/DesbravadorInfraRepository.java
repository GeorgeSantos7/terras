package com.desbravadores.terras.desbravadores.infra;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.desbravadores.terras.desbravadores.application.repository.DesbravadorRepository;
import com.desbravadores.terras.desbravadores.domain.Desbravadores;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class DesbravadorInfraRepository implements DesbravadorRepository {

	private final DesbravadorSpringDataJPARepository desbravadorSpringDataJPARepository;

	@Override
	public Desbravadores salva(Desbravadores desbravadores) {
		log.info("[inicia] DesbravadorInfraRepository - salva");
		Desbravadores novoDesbravador = desbravadorSpringDataJPARepository.save(desbravadores);
		log.info("[finaliza] DesbravadorInfraRepository - salva");
		return novoDesbravador;
	}

}
