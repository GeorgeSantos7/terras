package br.com.desbravadores.terras.admin.application.api;

import lombok.Data;

@Data
public class AdminRequest {
    private String email;
    private String senha;

    public AdminRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
