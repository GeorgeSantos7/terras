package br.com.desbravadores.terras.socio.application.service;

import br.com.desbravadores.terras.socio.application.api.AssinaturaResponse;
import br.com.desbravadores.terras.socio.application.api.SocioDetalhadoResponse;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;

import java.util.UUID;

public interface SocioService {
	SocioResponse criaNovoSocio(SocioRequest novoSocio);
	SocioDetalhadoResponse buscaSocioPorId(UUID idSocio);
    AssinaturaResponse buscaAssinaturaDoSocioPorId(UUID idSocio);
}