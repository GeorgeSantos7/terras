package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.admin.domain.Admin;
import br.com.desbravadores.terras.admin.domain.Role;
import lombok.Data;

@Data
public class AdminRequest {
    private String email;
    private String senha;
    private Role role = Role.ADMIN;

    public AdminRequest(String email, String senha, Role role) {
        this.email = email;
        this.senha = senha;
    }

    public Role getOutrosDados() {
        return role;
    }

    public Admin toAdmin() {
        return Admin.builder()
                .email(email)
                .senha(senha)
                .role(role)
                .build();
    }
}
