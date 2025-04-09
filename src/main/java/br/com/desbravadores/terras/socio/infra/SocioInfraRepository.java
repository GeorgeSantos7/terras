package br.com.desbravadores.terras.socio.infra;

import br.com.desbravadores.terras.handler.APIException;
import br.com.desbravadores.terras.socio.application.repository.SocioRepository;
import br.com.desbravadores.terras.socio.domain.entity.SocioCT;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

	@Override
	public SocioCT buscaSocioPorId(UUID idSocio) {
		log.info("[inicia] SocioInfraRepository buscaSocioPorId");
		SocioCT socioCT = (SocioCT) socioSpringDataJPARepository.findByIdSocio(idSocio)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Socio não encontrado!"));
		log.info("[finaliza] SocioInfraRepository buscaSocioPorId");
		return socioCT;
	}

}