package br.com.desbravadores.terras.socio.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.desbravadores.terras.socio.application.service.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

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

	@Override
	public SocioDetalhadoResponse detalhaSocioPorId(UUID idSocio) {
		log.info("[inicia] SocioController - detalhaSocioPorId");
		SocioDetalhadoResponse detalhaSocio = socioService.buscaSocioPorId(idSocio);
		log.info("[finaliza] SocioController - detalhaSocioPorId");
		return detalhaSocio;
	}

}