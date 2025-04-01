package br.com.desbravadores.terras.admin.domain;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import br.com.desbravadores.terras.credencial.domain.Credencial;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection = "admins")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "idAdmin")
public class Admin extends Credencial {
    @Id
    private UUID idAdmin;
    private String role = "ADMIN";


    public Admin(AdminRequest novoAdmin) {
        super(novoAdmin.getEmail(),novoAdmin.getSenha());
        this.idAdmin = UUID.randomUUID();
    }
}
