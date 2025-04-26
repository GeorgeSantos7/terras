package br.com.desbravadores.terras.assinatura.application.repository;

import br.com.desbravadores.terras.assinatura.domain.Assinatura;

import java.util.Optional;
import java.util.UUID;

public interface AssinaturaRepository {
    Assinatura salva(Assinatura assinatura);
    Optional<Assinatura> buscaAssinaturaPorId(UUID idAssinatura);
}
