package br.com.desbravadores.terras.credencial.application.repository;

import br.com.desbravadores.terras.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial salva(Credencial credencial);
	Credencial buscaCredencialPorUsuario(String usuario);
}
