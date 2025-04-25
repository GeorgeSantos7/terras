package br.com.desbravadores.terras.assinatura.application.service;

import br.com.desbravadores.terras.assinatura.application.api.AssinaturaRequest;
import br.com.desbravadores.terras.assinatura.application.api.AssinaturaResponse;
import br.com.desbravadores.terras.assinatura.application.repository.AssinaturaRepository;
import br.com.desbravadores.terras.assinatura.domain.Assinatura;
import br.com.desbravadores.terras.plano.application.repository.PlanoRepository;
import br.com.desbravadores.terras.plano.domain.Plano;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssinaturaApplicationService implements  AssinaturaService {
    private final AssinaturaRepository assinaturaRepository;
    private final PlanoRepository planoRepository;

    @Override
    public AssinaturaResponse criaAssinatura(AssinaturaRequest assinaturaRequest) {
        log.info("[inicia] AssinaturaApplicationService - criaAssinatura");
        if (assinaturaRequest.getIdPlano() == null) {
            throw new IllegalArgumentException("O id do plano não pode ser nulo!");
        }

        planoRepository.buscaPlanoPorId(assinaturaRequest.getIdPlano())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Plano não encontrado!"));
        Assinatura assinatura = assinaturaRepository.salva(new Assinatura(assinaturaRequest));

        log.info("[finaliza] AssinaturaApplicationService - criaAssinatura");
        return new AssinaturaResponse(assinatura.getIdAssinatura());
    }
}
