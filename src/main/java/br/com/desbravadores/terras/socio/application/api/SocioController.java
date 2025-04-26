package br.com.desbravadores.terras.socio.application.api;

import br.com.desbravadores.terras.config.security.service.TokenService;
import br.com.desbravadores.terras.handler.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desbravadores.terras.socio.application.service.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SocioController implements SocioAPI {

	private final SocioService socioService;
	private final TokenService tokenService;

	@Override
	public SocioResponse criaSocio(SocioRequest novoSocio) {
		log.info("[inicia] SocioController - criaSocio");
		SocioResponse socioCriado = socioService.criaNovoSocio(novoSocio);
		log.info("[finaliza] SocioController - criaSocio");
		return socioCriado;
	}


	@Override
	public SocioDetalhadoResponse detalhaSocioPorId( String token, UUID idSocio) {
		log.info("[inicia] SocioController - detalhaSocioPorId");
		String usuario = getUsuarioByToken(token);
		SocioDetalhadoResponse detalhaSocio = socioService.buscaSocioPorId(usuario, idSocio);
		log.info("[finaliza] SocioController - detalhaSocioPorId");
		return detalhaSocio;
	}

	@Override
	public List<SocioDetalhadoResponse> listaSocios() {
		log.info("[inicia] SocioController - listaSocios");
		List<SocioDetalhadoResponse> socio = socioService.buscaTodasSocios();
		log.info("[finaliza] SocioController - listaSocios");
		return socio;
	}

	private String getUsuarioByToken(String token) {
		log.debug("[token] {}", token);
		String usuario = tokenService.getUsuarioByBearerToken(token)
				.orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
		log.info("[usuario] {}", usuario);
		return usuario;
	}
}