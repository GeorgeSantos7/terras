package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.domain.Admin;
import lombok.Value;

import java.util.UUID;
@Value
public class AdminResponse {
    private UUID id;

    public AdminResponse(Admin admin) {
        this.id = admin.getId();
    }
}
