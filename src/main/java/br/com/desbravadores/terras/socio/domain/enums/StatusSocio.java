package br.com.desbravadores.terras.socio.domain.enums;

public enum StatusSocio {
	ATIVO, INATIVO, INADIMPLENTE;

	public static StatusSocio getStatusSocio(StatusSocio status) {
		if (status == null) {
			return INATIVO;
		}
		switch (status) {
			case ATIVO:
				return ATIVO;
			case INADIMPLENTE:
				return INADIMPLENTE;
			default:
				return INATIVO;
		}
	}
}