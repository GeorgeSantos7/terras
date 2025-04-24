package br.com.desbravadores.terras.admin.domain;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    private String email;
    private String senha;
    private Role role;

    public Admin(AdminRequest adminRequest) {
        this.role = Role.ADMIN;
    }
}
