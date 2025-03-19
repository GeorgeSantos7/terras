package br.com.desbravadores.terras.desbravadores.application.service;

import org.springframework.stereotype.Service;

import br.com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import br.com.desbravadores.terras.desbravadores.application.api.SocioResponse;
import br.com.desbravadores.terras.desbravadores.application.repository.SocioRepository;
import br.com.desbravadores.terras.desbravadores.domain.entity.SocioCT;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@RequiredArgsConstructor
@Log4j2
public class SocioApplicationService implements SocioService {

	private final SocioRepository socioRepository;

	@Override
	public SocioResponse criaNovoSocio(SocioRequest novoSocio) {
		log.info("[inicia] SocioApplicationService - criaDesbravador");
		SocioCT socioCT = socioRepository.salva(new SocioCT(novoSocio));
		log.info("[finaliza] SocioApplicationService - criaDesbravador");
		return new SocioResponse(socioCT);
	}

}