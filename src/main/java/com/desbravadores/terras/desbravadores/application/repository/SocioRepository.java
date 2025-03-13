package com.desbravadores.terras.desbravadores.application.repository;

import java.util.List;

import com.desbravadores.terras.desbravadores.domain.SocioCT;

public interface SocioRepository {

	SocioCT salva(SocioCT desbravadores);
	
	List<SocioCT> buscaTodosSocios(); 

}