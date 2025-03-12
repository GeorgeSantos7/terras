package com.desbravadores.terras.desbravadores.application.service;

import java.util.List;

import com.desbravadores.terras.desbravadores.application.api.SocioListResponse;
import com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import com.desbravadores.terras.desbravadores.application.api.SocioResponse;

public interface SocioService {

	SocioResponse criaNovoSocio(SocioRequest novoDesbravador);

	List<SocioListResponse> buscaTodosSocios();

}