package com.desbravadores.terras.desbravadores.application.service;

import org.springframework.stereotype.Service;

import com.desbravadores.terras.desbravadores.application.api.DesbravadorRequest;
import com.desbravadores.terras.desbravadores.application.api.DesbravadorResponse;
import com.desbravadores.terras.desbravadores.application.repository.DesbravadorRepository;
import com.desbravadores.terras.desbravadores.domain.Desbravadores;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@RequiredArgsConstructor
@Log4j2
public class DesbravadorApplicationService implements DesbravadorService {

	private final DesbravadorRepository desbravadorRepository;

	@Override
	public DesbravadorResponse criaNovoDesbravador(DesbravadorRequest novoDesbravador) {
		log.info("[inicia] DesbravadorApplicationService - criaDesbravador");
		Desbravadores desbravadores = desbravadorRepository.salva(new Desbravadores(novoDesbravador));
		log.info("[finaliza] DesbravadorApplicationService - criaDesbravador");
		return new DesbravadorResponse(desbravadores);
	}

}