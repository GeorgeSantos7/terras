package br.com.desbravadores.terras.assinatura.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/public/v1/assinatura")
public interface AssinaturaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AssinaturaResponse criaAssinaturaAoSocio(@RequestBody @Valid AssinaturaRequest assinaturaRequest);


}
