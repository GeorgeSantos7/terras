package br.com.desbravadores.terras.socio.application.service;

import br.com.desbravadores.terras.credencial.application.service.CredencialService;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import br.com.desbravadores.terras.socio.application.repository.SocioRepository;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
@Log4j2
public class SocioApplicationService implements SocioService {
	private final CredencialService  credencialService;
	private final SocioRepository socioRepository;

	@Override
	public SocioResponse criaNovoSocio(SocioRequest novoSocio) {
		log.info("[inicia] SocioApplicationService - criaDesbravador");
		credencialService.criaCredencial(novoSocio.getEmail(), novoSocio.getSenha());
		SocioCT socioCT = socioRepository.salva(new SocioCT(novoSocio));
		log.info("[finaliza] SocioApplicationService - criaDesbravador");
		return new SocioResponse(socioCT);
	}

}