package br.com.desbravadores.terras.assinatura.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/public/v1/assinatura")
public interface AssinaturaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AssinaturaResponse criaAssinaturaAoSocio(@RequestBody @Valid AssinaturaRequest assinaturaRequest);

    @GetMapping(value = "/{idAssinatura}")
    @ResponseStatus(code = HttpStatus.OK)
    AssinaturaDetalhadoResponse buscaAssinaturaPorId(@PathVariable UUID idAssinatura);

    @PatchMapping(value = "/{idAssinatura}/socio/{idSocio}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void adicionaAssinaturaAoSocio(@PathVariable UUID idAssinatura, @PathVariable UUID idSocio);
}
