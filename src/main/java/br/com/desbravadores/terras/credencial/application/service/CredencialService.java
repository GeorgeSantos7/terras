package br.com.desbravadores.terras.credencial.application.service;

import br.com.desbravadores.terras.credencial.domain.Credencial;


public interface CredencialService {
	Credencial buscaCredencialPorUsuario(String usuario);
    void criaCredencial(String email, String senha);
}
