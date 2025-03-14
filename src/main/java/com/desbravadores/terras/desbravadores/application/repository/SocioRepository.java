package com.desbravadores.terras.desbravadores.application.repository;

import java.util.UUID;

import com.desbravadores.terras.desbravadores.domain.SocioCT;

public interface SocioRepository {

	SocioCT salva(SocioCT desbravadores);

	SocioCT buscaSocioPorId(UUID idSocio);

}