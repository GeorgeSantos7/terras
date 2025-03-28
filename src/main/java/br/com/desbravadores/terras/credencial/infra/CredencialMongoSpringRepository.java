package br.com.desbravadores.terras.credencial.infra;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.desbravadores.terras.credencial.domain.Credencial;

public interface CredencialMongoSpringRepository extends MongoRepository<Credencial, String> {
	Optional<Credencial> findByUsuario(String usuario);
}
