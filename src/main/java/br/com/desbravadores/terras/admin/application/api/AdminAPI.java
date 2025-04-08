package br.com.desbravadores.terras.admin.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin")
public interface AdminAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AdminResponse criaAdmin(@RequestBody @Valid AdminRequest adminRequest);
}
