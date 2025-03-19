package br.com.desbravadores.terras.desbravadores.application.api;

import java.util.UUID;

import br.com.desbravadores.terras.desbravadores.domain.entity.SocioCT;
import lombok.Data;

@Data
public class SocioResponse {
	private UUID idSocio;
	
	public SocioResponse(SocioCT socio) {
		this.idSocio = socio.getIdSocio();
	}
}