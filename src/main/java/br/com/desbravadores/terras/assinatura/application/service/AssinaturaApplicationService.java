package br.com.desbravadores.terras.assinatura.application.service;

import br.com.desbravadores.terras.assinatura.application.api.AssinaturaDetalhadoResponse;
import br.com.desbravadores.terras.assinatura.application.api.AssinaturaRequest;
import br.com.desbravadores.terras.assinatura.application.api.AssinaturaResponse;
import br.com.desbravadores.terras.assinatura.application.repository.AssinaturaRepository;
import br.com.desbravadores.terras.assinatura.domain.Assinatura;
import br.com.desbravadores.terras.socio.domain.enums.StatusAssinatura;
import br.com.desbravadores.terras.plano.application.repository.PlanoRepository;
import br.com.desbravadores.terras.plano.domain.Plano;
import br.com.desbravadores.terras.socio.application.repository.SocioRepository;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import br.com.desbravadores.terras.socio.domain.enums.Planos;
import br.com.desbravadores.terras.socio.domain.enums.StatusSocio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssinaturaApplicationService implements  AssinaturaService {
    private final AssinaturaRepository assinaturaRepository;
    private final PlanoRepository planoRepository;
    private final SocioRepository socioRepository;

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

    @Override
    public AssinaturaDetalhadoResponse buscaAssinaturaPorId(UUID idAssinatura) {
        log.info("[inicia] AssinaturaApplicationService - buscaAssinaturaPorId");
        Assinatura assinatura = assinaturaRepository.buscaAssinaturaPorId(idAssinatura)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Assinatura não encontrada!"));
        log.info("[finaliza] AssinaturaApplicationService - buscaAssinaturaPorId");
        return new AssinaturaDetalhadoResponse(assinatura);
    }

    @Override
    public void adicionaAssinaturaAoSocio(UUID idAssinatura, UUID idSocio) {
        log.info("[inicia] AssinaturaApplicationService - adicionaAssinaturaAoSocio");
        Assinatura assinatura = assinaturaRepository.buscaAssinaturaPorId(idAssinatura)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Assinatura não encontrada!"));

        SocioCT socio = socioRepository.buscaSocioPorId(idSocio);

        Plano plano = planoRepository.buscaPlanoPorId(assinatura.getIdPlano())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Plano não encontrado!"));

        // Atualiza o status do sócio
        socio.setStatus(StatusSocio.ATIVO);

        // Atualiza o plano do sócio
        socio.setPlano(Planos.valueOf(plano.getNomePlano().toUpperCase()));
        socio.setStatusAssinatura(StatusAssinatura.ATIVA);

        // Define o prazo de 1 mês para a assinatura
        assinatura.setSocio(socio);
        assinatura.setDataInicio(LocalDate.now());
        assinatura.setDataTermino(LocalDate.now().plusMonths(1));
        assinatura.setStatus(StatusAssinatura.ATIVA);

        // Salva as alterações
        socioRepository.salva(socio);
        log.info("Novo statusAssinatura: {}", socio.getStatusAssinatura());
        assinaturaRepository.salva(assinatura);

        log.info("[finaliza] AssinaturaApplicationService - adicionaAssinaturaAoSocio");
    }
}
