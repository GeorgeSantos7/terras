package com.desbravadores.terras.desbravadores.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desbravadores.terras.desbravadores.application.api.SocioListResponse;
import com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import com.desbravadores.terras.desbravadores.application.api.SocioResponse;
import com.desbravadores.terras.desbravadores.application.repository.SocioRepository;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@RequiredArgsConstructor
@Log4j2
public class SocioApplicationService implements SocioService {

	private final SocioRepository desbravadorRepository;

	@Override
	public SocioResponse criaNovoSocio(SocioRequest novoSocio) {
		log.info("[inicia] DesbravadorApplicationService - criaDesbravador");
		SocioCT socioCT = desbravadorRepository.salva(new SocioCT(novoSocio));
		log.info("[finaliza] DesbravadorApplicationService - criaDesbravador");
		return new SocioResponse(socioCT);
	}

	@Override
	public List<SocioListResponse> buscaTodosSocios() {
		log.info("[inicia] SocioApplicationService - buscaTodosSocios");
		List<SocioCT> socios = desbravadorRepository.buscaTodosSocios();
		log.info("[finaliza] SocioApplicationService - buscaTodasPessoas");
		return SocioListResponse.converte(socios);
	} 

}