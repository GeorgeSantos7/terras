package br.com.desbravadores.terras.desbravadores.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.desbravadores.terras.desbravadores.application.service.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SocioController implements SocioAPI {

	private final SocioService socioService;

	@Override
	public SocioResponse criaSocio(SocioRequest novoSocio) {
		log.info("[inicia] SocioController - criaSocio");
		SocioResponse socioCriado = socioService.criaNovoSocio(novoSocio);
		log.info("[finaliza] SocioController - criaSocio");
		return socioCriado;
	}

}