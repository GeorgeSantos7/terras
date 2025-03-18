package br.com.desbravadores.terras.desbravadores.application.service;

import br.com.desbravadores.terras.desbravadores.application.api.SocioRequest;
import br.com.desbravadores.terras.desbravadores.application.api.SocioResponse;

public interface SocioService {

	SocioResponse criaNovoSocio(SocioRequest novoDesbravador);

}