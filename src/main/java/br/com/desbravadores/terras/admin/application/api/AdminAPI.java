package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( "/admin")
public interface AdminAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AdminResponse criaAdmin(@RequestBody @Valid AdminRequest novoAdmin);

    @PostMapping("/socio")
    @ResponseStatus(code = HttpStatus.CREATED)
    SocioResponse criaSocio(@RequestBody @Valid SocioRequest socioRequest);
}
