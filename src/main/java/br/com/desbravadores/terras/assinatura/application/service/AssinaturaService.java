package br.com.desbravadores.terras.assinatura.application.service;

import br.com.desbravadores.terras.assinatura.application.api.AssinaturaDetalhadoResponse;
import br.com.desbravadores.terras.assinatura.application.api.AssinaturaRequest;
import br.com.desbravadores.terras.assinatura.application.api.AssinaturaResponse;

import java.util.UUID;

public interface AssinaturaService {
    AssinaturaResponse criaAssinatura(AssinaturaRequest assinaturaRequest);
    AssinaturaDetalhadoResponse buscaAssinaturaPorId(UUID idAssinatura);
    void adicionaAssinaturaAoSocio(UUID idAssinatura, UUID idSocio);
}