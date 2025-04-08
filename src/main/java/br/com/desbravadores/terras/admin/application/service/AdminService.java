package br.com.desbravadores.terras.admin.application.service;

import br.com.desbravadores.terras.admin.application.api.AdminRequest;
import br.com.desbravadores.terras.admin.application.api.AdminResponse;

public interface AdminService {
    AdminResponse criaAdmin(AdminRequest adminRequest);
}
