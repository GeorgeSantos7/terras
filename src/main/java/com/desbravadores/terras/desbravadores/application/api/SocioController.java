package com.desbravadores.terras.desbravadores.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.desbravadores.terras.desbravadores.application.service.SocioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SocioController implements SocioAPI {

	private final SocioService desbravadorService;

	@Override
	public SocioResponse criaSocio(SocioRequest novoSocio) {
		log.info("[inicia] DesbravadorController - criaDesbravador");
		SocioResponse socioCriado = desbravadorService.criaNovoSocio(novoSocio);
		log.info("[finaliza] DesbravadorController - criaDesbravador");
		return socioCriado;
	}

}