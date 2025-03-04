package com.desbravadores.terras.desbravadores.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.desbravadores.terras.desbravadores.application.service.DesbravadorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class DesbravadorController implements DesbravadoresAPI {

	private final DesbravadorService desbravadorService;

	@Override
	public DesbravadorResponse criaDesbravador(DesbravadorRequest novoDesbravador) {
		log.info("[inicia] DesbravadorController - criaDesbravador");
		DesbravadorResponse desbravadorCriado = desbravadorService.criaNovoDesbravador(novoDesbravador);
		log.info("[finaliza] DesbravadorController - criaDesbravador");
		return desbravadorCriado;
	}

}
