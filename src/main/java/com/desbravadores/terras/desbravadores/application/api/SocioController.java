package com.desbravadores.terras.desbravadores.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.desbravadores.terras.desbravadores.application.service.SocioService;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

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

	@Override
	public SocioDetalhadoResponse getSocioAtravesId(UUID idSocio) {
		log.info("[inicia] SocioController - getSocioAtravesId");
		log.info ("[idSocio] {}", idSocio);
		SocioCT socio = desbravadorService.buscaSocioPorId(idSocio);
		log.info("[Finaliza] SocioController - getSocioAtravesId");
		return new SocioDetalhadoResponse(socio);
	}
}