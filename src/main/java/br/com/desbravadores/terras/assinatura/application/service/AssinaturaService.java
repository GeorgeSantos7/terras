package br.com.desbravadores.terras.assinatura.application.service;

import br.com.desbravadores.terras.assinatura.application.api.AssinaturaRequest;
import br.com.desbravadores.terras.assinatura.application.api.AssinaturaResponse;

public interface AssinaturaService {
    AssinaturaResponse criaAssinatura(AssinaturaRequest assinaturaRequest);
}