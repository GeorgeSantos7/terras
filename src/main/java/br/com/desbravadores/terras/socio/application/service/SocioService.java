package br.com.desbravadores.terras.socio.application.service;

import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;

public interface SocioService {

	SocioResponse criaNovoSocio(SocioRequest novoSocio);

}