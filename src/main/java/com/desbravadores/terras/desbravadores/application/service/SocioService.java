package com.desbravadores.terras.desbravadores.application.service;

import java.util.UUID;

import com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import com.desbravadores.terras.desbravadores.application.api.SocioResponse;
import com.desbravadores.terras.desbravadores.domain.SocioCT;

public interface SocioService {

	SocioResponse criaNovoSocio(SocioRequest novoDesbravador);

	SocioCT buscaSocioPorId(UUID idSocio);

}