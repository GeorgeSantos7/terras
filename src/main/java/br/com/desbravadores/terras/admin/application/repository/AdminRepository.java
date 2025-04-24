package br.com.desbravadores.terras.admin.application.repository;

import br.com.desbravadores.terras.admin.domain.Admin;

import java.util.Optional;

public interface AdminRepository {
    Admin salva(Admin admin);
    Optional<Admin> buscaPorEmail(String email);
}
