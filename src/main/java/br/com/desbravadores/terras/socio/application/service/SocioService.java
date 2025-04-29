package br.com.desbravadores.terras.socio.application.service;

import br.com.desbravadores.terras.socio.application.api.SocioAlteraRequest;
import br.com.desbravadores.terras.socio.application.api.SocioDetalhadoResponse;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;

import java.util.List;
import java.util.UUID;

public interface SocioService {
	SocioResponse criaNovoSocio(SocioRequest novoSocio);
	SocioDetalhadoResponse buscaSocioPorId(String usuario, UUID idSocio);
	SocioDetalhadoResponse adminBuscaSocioPorId(UUID idSocio);
    List<SocioDetalhadoResponse> buscaTodasSocios();
    void alteraSocioPorId(String usuario, UUID idSocio, SocioAlteraRequest socio);
	void adminAlteraSocioPorId(UUID idSocio, SocioAlteraRequest socio);
}