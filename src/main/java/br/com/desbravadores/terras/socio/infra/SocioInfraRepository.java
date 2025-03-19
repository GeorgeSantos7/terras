package br.com.desbravadores.terras.socio.infra;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import br.com.desbravadores.terras.socio.application.repository.SocioRepository;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@RequiredArgsConstructor
@Log4j2
@EnableMongoRepositories
public class SocioInfraRepository implements SocioRepository {

	private final SocioSpringDataJPARepository socioSpringDataJPARepository;

	@Override
	public SocioCT salva(SocioCT socio) {
		log.info("[inicia] SocioInfraRepository - salva");
		SocioCT novoSocio = socioSpringDataJPARepository.save(socio);
		log.info("[finaliza] SocioInfraRepository - salva");
		return novoSocio;
	}

}