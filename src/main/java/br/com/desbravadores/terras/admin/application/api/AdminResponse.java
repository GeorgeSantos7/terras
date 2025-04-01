package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.domain.Admin;
import lombok.Data;

import java.util.UUID;

@Data
public class AdminResponse {
    private UUID idAdmin;

    public AdminResponse(Admin admin) {
        this.idAdmin = admin.getIdAdmin();
    }
}