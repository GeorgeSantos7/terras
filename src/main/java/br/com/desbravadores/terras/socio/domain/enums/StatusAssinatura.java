package br.com.desbravadores.terras.socio.domain.enums;

public enum StatusAssinatura {
	ATIVO, CANCELADO, NENHUM, ATIVA;

	public static StatusAssinatura getStatusAssinatura(StatusAssinatura status) {
		if (status == null) {
			return NENHUM;
		}
		return status;
	}

}