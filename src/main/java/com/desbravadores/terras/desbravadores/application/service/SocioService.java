package com.desbravadores.terras.desbravadores.application.service;

import com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import com.desbravadores.terras.desbravadores.application.api.SocioResponse;

public interface SocioService {

	SocioResponse criaNovoSocio(SocioRequest novoDesbravador);

}