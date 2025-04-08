package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin")
public interface AdminAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AdminResponse criaAdmin(@RequestBody @Valid AdminRequest adminRequest);

    @PostMapping("/socio")
    @ResponseStatus(HttpStatus.CREATED)
    SocioResponse adminCriaSocio(@RequestBody @Valid SocioRequest socioRequest);
}
