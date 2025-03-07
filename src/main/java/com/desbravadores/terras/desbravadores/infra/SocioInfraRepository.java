package com.desbravadores.terras.desbravadores.infra;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.desbravadores.terras.desbravadores.application.repository.SocioRepository;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class SocioInfraRepository implements SocioRepository {

	private final SocioSpringDataJPARepository desbravadorSpringDataJPARepository;

	@Override
	public SocioCT salva(SocioCT desbravadores) {
		log.info("[inicia] DesbravadorInfraRepository - salva");
		SocioCT novoDesbravador = desbravadorSpringDataJPARepository.save(desbravadores);
		log.info("[finaliza] DesbravadorInfraRepository - salva");
		return novoDesbravador;
	}

}