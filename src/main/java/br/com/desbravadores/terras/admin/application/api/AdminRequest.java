package br.com.desbravadores.terras.admin.application.api;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Value
public class AdminRequest {
    @Email
    private String email;
    @Size(min = 6)
    private String senha;
}
