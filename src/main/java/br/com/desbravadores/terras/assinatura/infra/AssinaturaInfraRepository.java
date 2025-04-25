package br.com.desbravadores.terras.assinatura.infra;

import br.com.desbravadores.terras.assinatura.application.repository.AssinaturaRepository;
import br.com.desbravadores.terras.assinatura.domain.Assinatura;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class AssinaturaInfraRepository implements AssinaturaRepository {
    private final AssinaturaSpringDataJPARepository assinaturaSpringDataJPARepository;

    @Override
    public Assinatura salva(Assinatura assinatura) {
        log.info("[inicia] AssinaturaInfraRepository - salva");
        Assinatura novaAssinatura = assinaturaSpringDataJPARepository.save(assinatura);
        log.info("[finaliza] AssinaturaInfraRepository - salva");
        return novaAssinatura;
    }
}
