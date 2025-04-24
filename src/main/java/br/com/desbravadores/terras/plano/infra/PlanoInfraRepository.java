package br.com.desbravadores.terras.plano.infra;

import br.com.desbravadores.terras.plano.application.api.PlanosListResponse;
import br.com.desbravadores.terras.plano.application.repository.PlanoRepository;
import br.com.desbravadores.terras.plano.domain.Plano;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class PlanoInfraRepository implements PlanoRepository {
    private final PlanoSpringDataJPARepository planoSpringDataJPARepository;

    @Override
    public Plano salva(Plano plano) {
        log.info("[inicia] PlanoInfraRepository - salva");
        Plano novoPlano = planoSpringDataJPARepository.save(plano);
        log.info("[finaliza] PlanoInfraRepository - salva");
        return novoPlano;
    }

    @Override
    public List<Plano> buscaPlanos() {
        log.info("[inicia] PlanoInfraRepository - buscaPlanos");
        List<Plano> planos = planoSpringDataJPARepository.findAll();
        log.info("[finaliza] PlanoInfraRepository - buscaPlanos");
        return planos;
    }
}
