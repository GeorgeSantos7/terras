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
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Plano> buscaPlanoPorId(UUID idPlano) {
        log.info("[inicia] PlanoInfraRepository - buscaPlanoPorId");
        Optional<Plano> plano = planoSpringDataJPARepository.findById(idPlano);
        log.info("[finaliza] PlanoInfraRepository - buscaPlanoPorId");
        return plano;
    }

    @Override
    public void deletaPlanoPorId(UUID idPlano) {
        log.info("[inicia] PlanoInfraRepository - deletaPlanoPorId");
        planoSpringDataJPARepository.deleteById(idPlano);
        log.info("[finaliza] PlanoInfraRepository - deletaPlanoPorId");
    }
}
