package br.com.desbravadores.terras.credencial.application.service;

import br.com.desbravadores.terras.credencial.application.repository.CredencialRepository;
import br.com.desbravadores.terras.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
	private final CredencialRepository credencialRepository;
	
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialSpringDataJpaService - buscaCredencial");
		Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
		log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencial");
		return credencial;
	}

	@Override
	public void criaCredencial(String email, String senha) {
		credencialRepository.salva(new Credencial(email, senha));
	}
}
