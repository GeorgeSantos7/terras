package br.com.desbravadores.terras.socio.application.repository;

import br.com.desbravadores.terras.socio.domain.entity.SocioCT;

import java.util.UUID;

public interface SocioRepository {
	SocioCT salva(SocioCT socio);
    SocioCT buscaSocioPorId(UUID idSocio);
}